package org.foam.cli.tools.report;

import aQute.bnd.annotation.component.Component;
import aQute.bnd.annotation.component.Reference;
import com.google.common.base.Charsets;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;
import com.google.common.io.Files;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import joptsimple.ArgumentAcceptingOptionSpec;
import joptsimple.OptionParser;
import joptsimple.OptionSet;
import joptsimple.OptionSpecBuilder;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.foam.annotation.AnnotationPackage;
import org.foam.cli.launcher.api.IExecutableTool;
import org.foam.cli.tools.report.SpecificationWrapper;
import org.foam.cli.tools.report.pages.ErrorPage;
import org.foam.cli.tools.report.pages.Menu;
import org.foam.cli.tools.report.pages.MenuCategory;
import org.foam.cli.tools.report.pages.MenuItem;
import org.foam.cli.tools.report.pages.OverviewPage;
import org.foam.cli.tools.report.pages.Page;
import org.foam.cli.tools.report.pages.TadlTemplatePage;
import org.foam.cli.tools.report.pages.UseCasePage;
import org.foam.cli.tools.report.utils.FileUtils;
import org.foam.cli.tools.report.utils.Utils;
import org.foam.cntex.CounterExample;
import org.foam.cntex.Specification;
import org.foam.cntex.Trace;
import org.foam.ctl.CtlPackage;
import org.foam.dot.DotPackage;
import org.foam.dot.Graph;
import org.foam.flowannotation.FlowannotationPackage;
import org.foam.ltl.LtlPackage;
import org.foam.lts.Automaton;
import org.foam.lts.LtsPackage;
import org.foam.propositionallogic.PropositionallogicPackage;
import org.foam.tadl.FormulaHolder;
import org.foam.tadl.Group;
import org.foam.tadl.TadlPackage;
import org.foam.tadl.Template;
import org.foam.traceability.TraceabilityPackage;
import org.foam.transform.cntexlang2cntex.CntexLang2Cntex;
import org.foam.transform.cntexlang2cntex.CntexStateResolver;
import org.foam.transform.cntexlang2cntex.SpecificationResolver;
import org.foam.transform.dot2dotlang.Dot2DotLang;
import org.foam.transform.lts2dot.Lts2Dot;
import org.foam.transform.lts2nusmvlang.Lts2NuSMVLang;
import org.foam.transform.tadllang2tadl.TadlLang2Tadl;
import org.foam.transform.ucm2lts.Ucm2LtsFacade;
import org.foam.transform.ucm2lts.Ucm2LtsOverviewGraph;
import org.foam.transform.ucm2ucm.UcmLang2UcmService;
import org.foam.transform.ucm2ucm.flowannotationresolver.FlowAnnotationResolver;
import org.foam.transform.ucm2ucm.tadlannotationresolver.TadlAnnotationResolver;
import org.foam.transform.utils.graphviz.GraphvizWrapper;
import org.foam.transform.utils.logger.LogServiceExtension;
import org.foam.transform.utils.modeling.EmfCommons;
import org.foam.transform.utils.nusmv.NusmvWrapper;
import org.foam.ucm.UcmPackage;
import org.foam.ucm.UseCase;
import org.foam.ucm.UseCaseModel;
import org.foam.verification.VerificationPackage;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.service.log.LogService;

@Component
@SuppressWarnings("all")
public class ReportApplication implements IExecutableTool {
  @Extension
  private LogServiceExtension logServiceExtension;
  
  @Reference
  public void setLogService(final LogService logService) {
    LogServiceExtension _logServiceExtension = new LogServiceExtension(logService);
    this.logServiceExtension = _logServiceExtension;
  }
  
  private NusmvWrapper nusmvWrapper;
  
  @Reference
  public void setNusmvWrapper(final NusmvWrapper nusmvWrapper) {
    this.nusmvWrapper = nusmvWrapper;
  }
  
  private GraphvizWrapper graphvizWrapper;
  
  @Reference
  public void setGraphvizWrapper(final GraphvizWrapper graphvizWrapper) {
    this.graphvizWrapper = graphvizWrapper;
  }
  
  private UcmLang2UcmService ucmLang2UcmService;
  
  @Reference
  public void setUcmLang2Ucm(final UcmLang2UcmService serviceRef) {
    this.ucmLang2UcmService = serviceRef;
  }
  
  public void execute(final String[] args) {
    try {
      final OptionParser optionParser = new OptionParser();
      OptionSpecBuilder _accepts = optionParser.accepts("i", "input dir");
      ArgumentAcceptingOptionSpec<String> _withRequiredArg = _accepts.withRequiredArg();
      final ArgumentAcceptingOptionSpec<String> inputOption = _withRequiredArg.describedAs("directory with textual use cases");
      OptionSpecBuilder _accepts_1 = optionParser.accepts("t", "tadl input dir");
      ArgumentAcceptingOptionSpec<String> _withRequiredArg_1 = _accepts_1.withRequiredArg();
      final ArgumentAcceptingOptionSpec<String> tadlOption = _withRequiredArg_1.describedAs("directory with textual tadl definitions");
      OptionSpecBuilder _accepts_2 = optionParser.accepts("o", "output dir");
      ArgumentAcceptingOptionSpec<String> _withOptionalArg = _accepts_2.withOptionalArg();
      final ArgumentAcceptingOptionSpec<String> outputOption = _withOptionalArg.describedAs("output directory for html report");
      ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList("h", "?");
      optionParser.acceptsAll(_newArrayList, "show help");
      final OptionSet options = optionParser.parse(args);
      String _xifexpression = null;
      boolean _and = false;
      boolean _has = options.has(inputOption);
      if (!_has) {
        _and = false;
      } else {
        boolean _hasArgument = options.hasArgument(inputOption);
        _and = _hasArgument;
      }
      if (_and) {
        _xifexpression = inputOption.value(options);
      } else {
        optionParser.printHelpOn(System.out);
        return;
      }
      final String inputDirName = _xifexpression;
      String _xifexpression_1 = null;
      boolean _and_1 = false;
      boolean _has_1 = options.has(tadlOption);
      if (!_has_1) {
        _and_1 = false;
      } else {
        boolean _hasArgument_1 = options.hasArgument(tadlOption);
        _and_1 = _hasArgument_1;
      }
      if (_and_1) {
        _xifexpression_1 = tadlOption.value(options);
      } else {
        optionParser.printHelpOn(System.out);
        return;
      }
      final String tadlDirName = _xifexpression_1;
      String _xifexpression_2 = null;
      boolean _and_2 = false;
      boolean _has_2 = options.has(outputOption);
      if (!_has_2) {
        _and_2 = false;
      } else {
        boolean _hasArgument_2 = options.hasArgument(outputOption);
        _and_2 = _hasArgument_2;
      }
      if (_and_2) {
        _xifexpression_2 = outputOption.value(options);
      } else {
        _xifexpression_2 = "report";
      }
      final String outputDirName = _xifexpression_2;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Model factories initialization");
      this.logServiceExtension.debug(_builder);
      this.init();
      final UseCaseModel useCaseModel = this.ucmlang2Ucm(inputDirName);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Validating input UseCaseModel (with resolved flow annotations)");
      this.logServiceExtension.debug(_builder_1);
      EmfCommons.basicValidate(useCaseModel);
      final List<Template> templates = this.tadlLang2Templates(tadlDirName);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("Validating input TADL templates");
      this.logServiceExtension.debug(_builder_2);
      final Consumer<Template> _function = new Consumer<Template>() {
        public void accept(final Template it) {
          EmfCommons.basicValidate(it);
        }
      };
      templates.forEach(_function);
      this.resolveTadlAnnotations(useCaseModel, templates);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("Validating UseCaseModel with resolved TADL annotations");
      this.logServiceExtension.debug(_builder_3);
      EmfCommons.basicValidate(useCaseModel);
      final Iterable<CounterExample> counterExamples = this.getCounterExamples(useCaseModel);
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("Merging errors from counter examples");
      this.logServiceExtension.debug(_builder_4);
      final Function1<CounterExample, EList<Specification>> _function_1 = new Function1<CounterExample, EList<Specification>>() {
        public EList<Specification> apply(final CounterExample it) {
          return it.getSpecifications();
        }
      };
      Iterable<EList<Specification>> _map = IterableExtensions.<CounterExample, EList<Specification>>map(counterExamples, _function_1);
      Iterable<Specification> _flatten = Iterables.<Specification>concat(_map);
      final Function1<Specification, Boolean> _function_2 = new Function1<Specification, Boolean>() {
        public Boolean apply(final Specification it) {
          Trace _trace = it.getTrace();
          return Boolean.valueOf((!Objects.equal(_trace, null)));
        }
      };
      Iterable<Specification> _filter = IterableExtensions.<Specification>filter(_flatten, _function_2);
      final Iterable<Specification> specifications = this.uniqueSpecifications(_filter);
      StringConcatenation _builder_5 = new StringConcatenation();
      _builder_5.append("Validating error specifications");
      this.logServiceExtension.debug(_builder_5);
      final Consumer<Specification> _function_3 = new Consumer<Specification>() {
        public void accept(final Specification it) {
          EmfCommons.basicValidate(it);
        }
      };
      specifications.forEach(_function_3);
      this.createReport(useCaseModel, templates, specifications, outputDirName);
      StringConcatenation _builder_6 = new StringConcatenation();
      _builder_6.append("Report generation done.");
      this.logServiceExtension.info(_builder_6);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public String getUsage() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Runs the whole FOAM workflow and generates an HTML report. ");
    _builder.newLine();
    return _builder.toString();
  }
  
  private Iterable<Specification> uniqueSpecifications(final Iterable<Specification> specifications) {
    Iterable<Specification> _xblockexpression = null;
    {
      final LinkedHashSet<SpecificationWrapper> set = new LinkedHashSet<SpecificationWrapper>();
      final Function1<Specification, SpecificationWrapper> _function = new Function1<Specification, SpecificationWrapper>() {
        public SpecificationWrapper apply(final Specification it) {
          return new SpecificationWrapper(it);
        }
      };
      Iterable<SpecificationWrapper> _map = IterableExtensions.<Specification, SpecificationWrapper>map(specifications, _function);
      Iterables.<SpecificationWrapper>addAll(set, _map);
      final Function1<SpecificationWrapper, Specification> _function_1 = new Function1<SpecificationWrapper, Specification>() {
        public Specification apply(final SpecificationWrapper it) {
          return it.getSpecification();
        }
      };
      _xblockexpression = IterableExtensions.<SpecificationWrapper, Specification>map(set, _function_1);
    }
    return _xblockexpression;
  }
  
  private void createReport(final UseCaseModel useCaseModel, final Iterable<Template> templates, final Iterable<Specification> specifications, final String outputDirName) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Writing the results");
    this.logServiceExtension.debug(_builder);
    this.copyWebFiles(outputDirName);
    final Menu menu = new Menu();
    final MenuCategory overviewCategory = new MenuCategory(null);
    List<MenuCategory> _categories = menu.getCategories();
    _categories.add(overviewCategory);
    final OverviewPage overviewPage = this.createOverviewPage(useCaseModel, menu, outputDirName);
    List<MenuItem> _menuItems = overviewCategory.getMenuItems();
    MenuItem _menuItem = new MenuItem("Overview", "../overview/overview.html", overviewPage);
    _menuItems.add(_menuItem);
    final MenuCategory primaryUseCasesCategory = new MenuCategory("Primary use cases");
    List<MenuCategory> _categories_1 = menu.getCategories();
    _categories_1.add(primaryUseCasesCategory);
    EList<UseCase> _useCases = useCaseModel.getUseCases();
    final Function1<UseCase, Boolean> _function = new Function1<UseCase, Boolean>() {
      public Boolean apply(final UseCase it) {
        return Boolean.valueOf(it.isPrimary());
      }
    };
    final Iterable<UseCase> primaryUseCases = IterableExtensions.<UseCase>filter(_useCases, _function);
    final Function1<UseCase, UseCasePage> _function_1 = new Function1<UseCase, UseCasePage>() {
      public UseCasePage apply(final UseCase it) {
        return ReportApplication.this.createUseCasePage(it, menu, outputDirName);
      }
    };
    final Iterable<UseCasePage> primaryUseCasesPages = IterableExtensions.<UseCase, UseCasePage>map(primaryUseCases, _function_1);
    List<MenuItem> _menuItems_1 = primaryUseCasesCategory.getMenuItems();
    final Function1<UseCasePage, MenuItem> _function_2 = new Function1<UseCasePage, MenuItem>() {
      public MenuItem apply(final UseCasePage it) {
        return ReportApplication.this.createUseCaseMenuItem(it, menu);
      }
    };
    Iterable<MenuItem> _map = IterableExtensions.<UseCasePage, MenuItem>map(primaryUseCasesPages, _function_2);
    Iterables.<MenuItem>addAll(_menuItems_1, _map);
    primaryUseCasesCategory.sort();
    final MenuCategory nonPrimaryUseCasesCategory = new MenuCategory("Non-primary use cases");
    List<MenuCategory> _categories_2 = menu.getCategories();
    _categories_2.add(nonPrimaryUseCasesCategory);
    EList<UseCase> _useCases_1 = useCaseModel.getUseCases();
    final Function1<UseCase, Boolean> _function_3 = new Function1<UseCase, Boolean>() {
      public Boolean apply(final UseCase it) {
        boolean _isPrimary = it.isPrimary();
        return Boolean.valueOf((!_isPrimary));
      }
    };
    final Iterable<UseCase> nonPrimaryUseCases = IterableExtensions.<UseCase>filter(_useCases_1, _function_3);
    final Function1<UseCase, UseCasePage> _function_4 = new Function1<UseCase, UseCasePage>() {
      public UseCasePage apply(final UseCase it) {
        return ReportApplication.this.createUseCasePage(it, menu, outputDirName);
      }
    };
    final Iterable<UseCasePage> nonPrimaryUseCasesPages = IterableExtensions.<UseCase, UseCasePage>map(nonPrimaryUseCases, _function_4);
    List<MenuItem> _menuItems_2 = nonPrimaryUseCasesCategory.getMenuItems();
    final Function1<UseCasePage, MenuItem> _function_5 = new Function1<UseCasePage, MenuItem>() {
      public MenuItem apply(final UseCasePage it) {
        return ReportApplication.this.createUseCaseMenuItem(it, menu);
      }
    };
    Iterable<MenuItem> _map_1 = IterableExtensions.<UseCasePage, MenuItem>map(nonPrimaryUseCasesPages, _function_5);
    Iterables.<MenuItem>addAll(_menuItems_2, _map_1);
    nonPrimaryUseCasesCategory.sort();
    final MenuCategory tadlCategory = new MenuCategory("TADL definitions");
    List<MenuCategory> _categories_3 = menu.getCategories();
    _categories_3.add(tadlCategory);
    final Function1<Template, TadlTemplatePage> _function_6 = new Function1<Template, TadlTemplatePage>() {
      public TadlTemplatePage apply(final Template it) {
        return ReportApplication.this.createTadlTemplatePage(it, menu);
      }
    };
    final Iterable<TadlTemplatePage> tadlPages = IterableExtensions.<Template, TadlTemplatePage>map(templates, _function_6);
    List<MenuItem> _menuItems_3 = tadlCategory.getMenuItems();
    final Function1<TadlTemplatePage, MenuItem> _function_7 = new Function1<TadlTemplatePage, MenuItem>() {
      public MenuItem apply(final TadlTemplatePage it) {
        return ReportApplication.this.createTadlPageMenuItem(it, menu);
      }
    };
    Iterable<MenuItem> _map_2 = IterableExtensions.<TadlTemplatePage, MenuItem>map(tadlPages, _function_7);
    Iterables.<MenuItem>addAll(_menuItems_3, _map_2);
    tadlCategory.sort();
    final MenuCategory errorsCategory = new MenuCategory("Errors");
    List<MenuCategory> _categories_4 = menu.getCategories();
    _categories_4.add(errorsCategory);
    final HashMap<Group, List<Specification>> group2Specification = this.partitionByGroup(specifications);
    final Function1<Specification, ErrorPage> _function_8 = new Function1<Specification, ErrorPage>() {
      public ErrorPage apply(final Specification it) {
        return ReportApplication.this.createErrorPage(it, menu, group2Specification);
      }
    };
    final Iterable<ErrorPage> errorPages = IterableExtensions.<Specification, ErrorPage>map(specifications, _function_8);
    List<MenuItem> _menuItems_4 = errorsCategory.getMenuItems();
    final Function1<ErrorPage, MenuItem> _function_9 = new Function1<ErrorPage, MenuItem>() {
      public MenuItem apply(final ErrorPage it) {
        return ReportApplication.this.createErrorPageMenuItem(it, menu);
      }
    };
    Iterable<MenuItem> _map_3 = IterableExtensions.<ErrorPage, MenuItem>map(errorPages, _function_9);
    Iterables.<MenuItem>addAll(_menuItems_4, _map_3);
    errorsCategory.sort();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Writing pages to disk");
    this.logServiceExtension.debug(_builder_1);
    List<MenuCategory> _categories_5 = menu.getCategories();
    final Function1<MenuCategory, List<MenuItem>> _function_10 = new Function1<MenuCategory, List<MenuItem>>() {
      public List<MenuItem> apply(final MenuCategory it) {
        return it.getMenuItems();
      }
    };
    List<List<MenuItem>> _map_4 = ListExtensions.<MenuCategory, List<MenuItem>>map(_categories_5, _function_10);
    Iterable<MenuItem> _flatten = Iterables.<MenuItem>concat(_map_4);
    final Consumer<MenuItem> _function_11 = new Consumer<MenuItem>() {
      public void accept(final MenuItem it) {
        Page _page = it.getPage();
        ReportApplication.this.writePage(_page, outputDirName);
      }
    };
    _flatten.forEach(_function_11);
  }
  
  private HashMap<Group, List<Specification>> partitionByGroup(final Iterable<Specification> specifications) {
    HashMap<Group, List<Specification>> _xblockexpression = null;
    {
      final HashMap<Group, List<Specification>> result = new HashMap<Group, List<Specification>>();
      for (final Specification specification : specifications) {
        {
          final Group group = Utils.getGroup(specification);
          boolean _containsKey = result.containsKey(group);
          boolean _not = (!_containsKey);
          if (_not) {
            ArrayList<Specification> _newArrayList = CollectionLiterals.<Specification>newArrayList();
            result.put(group, _newArrayList);
          }
          List<Specification> _get = result.get(group);
          _get.add(specification);
        }
      }
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
  
  private String getErrorPageOrderId(final Specification specification, final Map<Group, List<Specification>> partitionByGroup) {
    Group _group = Utils.getGroup(specification);
    final List<Specification> list = partitionByGroup.get(_group);
    int _size = list.size();
    boolean _equals = (_size == 1);
    if (_equals) {
      return "";
    } else {
      int _indexOf = list.indexOf(specification);
      int _plus = (_indexOf + 1);
      return Integer.valueOf(_plus).toString();
    }
  }
  
  private OverviewPage createOverviewPage(final UseCaseModel useCaseModel, final Menu menu, final String outputDirName) {
    try {
      OverviewPage _xblockexpression = null;
      {
        Ucm2LtsOverviewGraph _ucm2LtsOverviewGraph = new Ucm2LtsOverviewGraph();
        final Automaton automaton = _ucm2LtsOverviewGraph.transform(useCaseModel);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Validating overview LTS");
        this.logServiceExtension.debug(_builder);
        EmfCommons.basicValidate(automaton);
        Class<? extends ReportApplication> _class = this.getClass();
        Bundle _bundle = FrameworkUtil.getBundle(_class);
        URL _resource = _bundle.getResource("/report/dot/OverviewGraphTemplate.xmi");
        final InputStream overviewGraphTemplate = _resource.openStream();
        EObject _readModel = EmfCommons.readModel(overviewGraphTemplate);
        final Graph initGraph = ((Graph) _readModel);
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("Validating init overview DOT graph");
        this.logServiceExtension.debug(_builder_1);
        EmfCommons.basicValidate(initGraph);
        Lts2Dot _lts2Dot = new Lts2Dot();
        final Graph dotGraph = _lts2Dot.transformOverview(automaton, initGraph);
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("Validating overview DOT graph");
        this.logServiceExtension.debug(_builder_2);
        EmfCommons.basicValidate(dotGraph);
        final String image = this.createImageAndImageMap(dotGraph, outputDirName, "overview");
        _xblockexpression = new OverviewPage(menu, image);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private UseCasePage createUseCasePage(final UseCase useCase, final Menu menu, final String outputDirName) {
    try {
      UseCasePage _xblockexpression = null;
      {
        final Automaton automaton = Ucm2LtsFacade.transformSingleUseCaseForPage(useCase);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Validating ");
        String _id = useCase.getId();
        _builder.append(_id, "");
        _builder.append(" LTS");
        this.logServiceExtension.debug(_builder);
        EmfCommons.basicValidate(automaton);
        Class<? extends ReportApplication> _class = this.getClass();
        Bundle _bundle = FrameworkUtil.getBundle(_class);
        URL _resource = _bundle.getResource("/report/dot/GraphTemplate.xmi");
        final InputStream graphTemplate = _resource.openStream();
        EObject _readModel = EmfCommons.readModel(graphTemplate);
        final Graph initGraph = ((Graph) _readModel);
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("Validating init DOT graph");
        this.logServiceExtension.debug(_builder_1);
        EmfCommons.basicValidate(initGraph);
        Lts2Dot _lts2Dot = new Lts2Dot();
        final Graph dotGraph = _lts2Dot.transformSingleUseCase(automaton, initGraph);
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("Validating DOT graph");
        this.logServiceExtension.debug(_builder_2);
        EmfCommons.basicValidate(dotGraph);
        String _id_1 = useCase.getId();
        final String imageFileName = this.createImageAndImageMap(dotGraph, outputDirName, _id_1);
        _xblockexpression = new UseCasePage(useCase, menu, imageFileName);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private TadlTemplatePage createTadlTemplatePage(final Template template, final Menu menu) {
    return new TadlTemplatePage(menu, template);
  }
  
  private ErrorPage createErrorPage(final Specification specification, final Menu menu, final Map<Group, List<Specification>> group2Specifications) {
    ErrorPage _xblockexpression = null;
    {
      final String orderId = this.getErrorPageOrderId(specification, group2Specifications);
      _xblockexpression = new ErrorPage(menu, specification, orderId);
    }
    return _xblockexpression;
  }
  
  private MenuItem createErrorPageMenuItem(final ErrorPage errorPage, final Menu menu) {
    MenuItem _xblockexpression = null;
    {
      final String id = errorPage.getId();
      final String orderId = errorPage.getOrderId();
      Group _group = errorPage.getGroup();
      final String qualifier = _group.getQualifier();
      StringConcatenation _builder = new StringConcatenation();
      String _joinedVars = errorPage.joinedVars();
      _builder.append(_joinedVars, "");
      _builder.append(" ");
      _builder.append(qualifier, "");
      {
        boolean _isEmpty = orderId.isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
          _builder.append(" ");
          _builder.append(orderId, "");
        }
      }
      final String menuText = _builder.toString();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("../");
      _builder_1.append(id, "");
      _builder_1.append("/");
      _builder_1.append(id, "");
      _builder_1.append(".html");
      _xblockexpression = new MenuItem(menuText, _builder_1, errorPage);
    }
    return _xblockexpression;
  }
  
  private MenuItem createUseCaseMenuItem(final UseCasePage useCasePage, final Menu menu) {
    MenuItem _xblockexpression = null;
    {
      UseCase _useCase = useCasePage.getUseCase();
      final String id = _useCase.getId();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(id, "");
      _builder.append(" ");
      UseCase _useCase_1 = useCasePage.getUseCase();
      String _name = _useCase_1.getName();
      _builder.append(_name, "");
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("../");
      _builder_1.append(id, "");
      _builder_1.append("/");
      _builder_1.append(id, "");
      _builder_1.append(".html");
      _xblockexpression = new MenuItem(_builder, _builder_1, useCasePage);
    }
    return _xblockexpression;
  }
  
  private MenuItem createTadlPageMenuItem(final TadlTemplatePage tadlTemplatePage, final Menu menu) {
    MenuItem _xblockexpression = null;
    {
      final String id = tadlTemplatePage.getId();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("../");
      _builder.append(id, "");
      _builder.append("/");
      _builder.append(id, "");
      _builder.append(".html");
      _xblockexpression = new MenuItem(id, _builder, tadlTemplatePage);
    }
    return _xblockexpression;
  }
  
  private String createImageAndImageMap(final Graph graph, final String outputDirName, final String outputFileName) {
    try {
      File _file = new File(outputDirName);
      final File imageDir = new File(_file, outputFileName);
      imageDir.mkdir();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(imageDir, "");
      _builder.append("/");
      _builder.append(outputFileName, "");
      final String fullOutputFileWithoutExtension = _builder.toString();
      Dot2DotLang _dot2DotLang = new Dot2DotLang();
      final CharSequence dotContent = _dot2DotLang.transform(graph);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append(fullOutputFileWithoutExtension, "");
      _builder_1.append(".dot");
      final String dotFileName = _builder_1.toString();
      File _file_1 = new File(dotFileName);
      Files.write(dotContent, _file_1, Charsets.UTF_8);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append(outputFileName, "");
      _builder_2.append(".svg");
      final String imageFileName = _builder_2.toString();
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append(fullOutputFileWithoutExtension, "");
      _builder_3.append(".svg");
      final String fullImageFileName = _builder_3.toString();
      final ArrayList<String> dotCommand = CollectionLiterals.<String>newArrayList("dot", 
        "-Tsvg", "-o", fullImageFileName, dotFileName);
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("Creating svg image with dot: \"");
      String _join = IterableExtensions.join(dotCommand, " ");
      _builder_4.append(_join, "");
      _builder_4.append("\"");
      this.logServiceExtension.info(_builder_4);
      this.graphvizWrapper.runGraphviz(dotCommand);
      return imageFileName;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private void writePage(final Page page, final String outputDirName) {
    try {
      File _file = new File(outputDirName);
      String _id = page.getId();
      final File pageDir = new File(_file, _id);
      pageDir.mkdir();
      StringConcatenation _builder = new StringConcatenation();
      String _id_1 = page.getId();
      _builder.append(_id_1, "");
      _builder.append(".html");
      final File pageFile = new File(pageDir, _builder.toString());
      CharSequence _content = page.content();
      Files.write(_content, pageFile, Charsets.UTF_8);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private void init() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Initializing required meta-models");
    this.logServiceExtension.debug(_builder);
    AnnotationPackage.eINSTANCE.eClass();
    DotPackage.eINSTANCE.eClass();
    PropositionallogicPackage.eINSTANCE.eClass();
    LtlPackage.eINSTANCE.eClass();
    CtlPackage.eINSTANCE.eClass();
    LtsPackage.eINSTANCE.eClass();
    TadlPackage.eINSTANCE.eClass();
    FlowannotationPackage.eINSTANCE.eClass();
    UcmPackage.eINSTANCE.eClass();
    TraceabilityPackage.eINSTANCE.eClass();
    VerificationPackage.eINSTANCE.eClass();
    EmfCommons.registerAsteriskInExtensionToFactory();
  }
  
  private Iterable<CounterExample> getCounterExamples(final UseCaseModel useCaseModel) {
    EList<UseCase> _useCases = useCaseModel.getUseCases();
    final Function1<UseCase, Boolean> _function = new Function1<UseCase, Boolean>() {
      public Boolean apply(final UseCase it) {
        return Boolean.valueOf(it.isPrimary());
      }
    };
    Iterable<UseCase> _filter = IterableExtensions.<UseCase>filter(_useCases, _function);
    final Function1<UseCase, CounterExample> _function_1 = new Function1<UseCase, CounterExample>() {
      public CounterExample apply(final UseCase useCase) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("transforming ");
        String _id = useCase.getId();
        _builder.append(_id, "");
        _builder.append(" to LTS");
        ReportApplication.this.logServiceExtension.debug(_builder);
        final Automaton automaton = Ucm2LtsFacade.transformSingleUseCase(useCaseModel, useCase);
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("transforming LTS to NuSMV code");
        ReportApplication.this.logServiceExtension.debug(_builder_1);
        final ArrayList<Pair<FormulaHolder, Group>> holderGroupList = CollectionLiterals.<Pair<FormulaHolder, Group>>newArrayList();
        Lts2NuSMVLang _lts2NuSMVLang = new Lts2NuSMVLang();
        final String code = _lts2NuSMVLang.transform(automaton, holderGroupList);
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("running NuSMV verification");
        ReportApplication.this.logServiceExtension.debug(_builder_2);
        String[] _runNusmvCode = ReportApplication.this.nusmvWrapper.runNusmvCode(code);
        final String cntexCode = IterableExtensions.join(((Iterable<?>)Conversions.doWrapArray(_runNusmvCode)), "\n");
        StringConcatenation _builder_3 = new StringConcatenation();
        _builder_3.append("parsing counter example code to CounterExample");
        ReportApplication.this.logServiceExtension.debug(_builder_3);
        CntexLang2Cntex _cntexLang2Cntex = new CntexLang2Cntex();
        final CounterExample counterExample = _cntexLang2Cntex.transform(cntexCode);
        CntexStateResolver _cntexStateResolver = new CntexStateResolver();
        _cntexStateResolver.transform(counterExample, automaton);
        EList<Specification> _specifications = counterExample.getSpecifications();
        int _size = _specifications.size();
        int _size_1 = holderGroupList.size();
        boolean _equals = (_size == _size_1);
        Preconditions.checkState(_equals);
        SpecificationResolver _specificationResolver = new SpecificationResolver();
        _specificationResolver.transform(counterExample, holderGroupList);
        return counterExample;
      }
    };
    return IterableExtensions.<UseCase, CounterExample>map(_filter, _function_1);
  }
  
  private UseCaseModel ucmlang2Ucm(final String inputDirName) {
    UseCaseModel _xblockexpression = null;
    {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Reading use case files from the directory \"");
      _builder.append(inputDirName, "");
      _builder.append("\"");
      this.logServiceExtension.info(_builder);
      final List<String> texts = this.readTexts(inputDirName);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Running the transformation");
      this.logServiceExtension.debug(_builder_1);
      final UseCaseModel useCaseModel = this.ucmLang2UcmService.transform(texts);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("Resolving FLOW annotations");
      this.logServiceExtension.debug(_builder_2);
      FlowAnnotationResolver _flowAnnotationResolver = new FlowAnnotationResolver();
      _flowAnnotationResolver.resolveAnnotations(useCaseModel);
      _xblockexpression = useCaseModel;
    }
    return _xblockexpression;
  }
  
  private List<Template> tadlLang2Templates(final String tadlDirName) {
    final TadlLang2Tadl tadlLang2Tadl = new TadlLang2Tadl();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Reading TADL definitions from file \"");
    _builder.append(tadlDirName, "");
    _builder.append("\" and parsing");
    this.logServiceExtension.info(_builder);
    final List<String> texts = this.readTexts(tadlDirName);
    final Function1<String, Template> _function = new Function1<String, Template>() {
      public Template apply(final String it) {
        return tadlLang2Tadl.parse(it);
      }
    };
    final List<Template> templates = ListExtensions.<String, Template>map(texts, _function);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("TADL files resolved");
    this.logServiceExtension.debug(_builder_1);
    return templates;
  }
  
  private void resolveTadlAnnotations(final UseCaseModel useCaseModel, final List<Template> templates) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Resolving TADL annotations");
    this.logServiceExtension.debug(_builder);
    TadlAnnotationResolver _tadlAnnotationResolver = new TadlAnnotationResolver();
    _tadlAnnotationResolver.resolveAnnotations(useCaseModel, templates);
  }
  
  private void copyWebFiles(final String outputDir) {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Copying template web files to output directory ");
      _builder.append(outputDir, "");
      this.logServiceExtension.info(_builder);
      FileUtils.bundleCopy("report/web", outputDir);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Gets String content of each file in the given directory
   */
  private List<String> readTexts(final String inputDir) {
    List<String> _xblockexpression = null;
    {
      final File dir = new File(inputDir);
      File[] _listFiles = dir.listFiles();
      final Function1<File, String> _function = new Function1<File, String>() {
        public String apply(final File it) {
          try {
            return Files.toString(it, Charsets.UTF_8);
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        }
      };
      _xblockexpression = ListExtensions.<File, String>map(((List<File>)Conversions.doWrapArray(_listFiles)), _function);
    }
    return _xblockexpression;
  }
}
