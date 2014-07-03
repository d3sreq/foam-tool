package org.foam.cli.tools.ucm2lts;

import aQute.bnd.annotation.component.Component;
import aQute.bnd.annotation.component.Reference;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import joptsimple.ArgumentAcceptingOptionSpec;
import joptsimple.OptionParser;
import joptsimple.OptionSet;
import joptsimple.OptionSpecBuilder;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.foam.cli.launcher.api.IExecutableTool;
import org.foam.flowannotation.FlowannotationPackage;
import org.foam.lts.Automaton;
import org.foam.lts.LtsPackage;
import org.foam.propositionallogic.PropositionallogicPackage;
import org.foam.tadl.TadlPackage;
import org.foam.traceability.TraceabilityPackage;
import org.foam.transform.ucm2lts.Ucm2LtsFacade;
import org.foam.transform.ucm2lts.Ucm2LtsOverviewGraph;
import org.foam.transform.utils.model.EmfCommons;
import org.foam.ucm.UcmPackage;
import org.foam.ucm.UseCase;
import org.foam.ucm.UseCaseModel;
import org.osgi.service.log.LogService;

@Component
@SuppressWarnings("all")
public class Ucm2Lts implements IExecutableTool {
  private LogService logService;
  
  @Reference
  public void setLogService(final LogService logService) {
    this.logService = logService;
  }
  
  public void info(final CharSequence message) {
    String _string = message.toString();
    this.logService.log(LogService.LOG_INFO, _string);
  }
  
  public void debug(final CharSequence message) {
    String _string = message.toString();
    this.logService.log(LogService.LOG_DEBUG, _string);
  }
  
  public void execute(final String[] args) {
    try {
      final OptionParser optionParser = new OptionParser();
      OptionSpecBuilder _accepts = optionParser.accepts("i", "input file");
      ArgumentAcceptingOptionSpec<String> _withRequiredArg = _accepts.withRequiredArg();
      final ArgumentAcceptingOptionSpec<String> inputOption = _withRequiredArg.describedAs("input file with use case model");
      OptionSpecBuilder _accepts_1 = optionParser.accepts("o", "output file");
      ArgumentAcceptingOptionSpec<String> _withOptionalArg = _accepts_1.withOptionalArg();
      final ArgumentAcceptingOptionSpec<String> outputOption = _withOptionalArg.describedAs("output file with LTS model");
      OptionSpecBuilder _accepts_2 = optionParser.accepts("s", "single use case mode");
      ArgumentAcceptingOptionSpec<String> _withRequiredArg_1 = _accepts_2.withRequiredArg();
      final ArgumentAcceptingOptionSpec<String> singleUseCaseOption = _withRequiredArg_1.describedAs("ID of the use case");
      OptionSpecBuilder _accepts_3 = optionParser.accepts("sp", "single use case for page mode");
      ArgumentAcceptingOptionSpec<String> _withRequiredArg_2 = _accepts_3.withRequiredArg();
      final ArgumentAcceptingOptionSpec<String> singleUseCaseForPageOption = _withRequiredArg_2.describedAs("ID of the use case");
      final OptionSpecBuilder overviewOption = optionParser.accepts("w", "overview mode");
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
      final String inputFile = _xifexpression;
      String _xifexpression_1 = null;
      boolean _and_1 = false;
      boolean _has_1 = options.has(outputOption);
      if (!_has_1) {
        _and_1 = false;
      } else {
        boolean _hasArgument_1 = options.hasArgument(outputOption);
        _and_1 = _hasArgument_1;
      }
      if (_and_1) {
        _xifexpression_1 = outputOption.value(options);
      } else {
        _xifexpression_1 = "ltsModel.lts";
      }
      final String outputFile = _xifexpression_1;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Initializing required meta-models");
      this.info(_builder);
      UcmPackage.eINSTANCE.eClass();
      FlowannotationPackage.eINSTANCE.eClass();
      TraceabilityPackage.eINSTANCE.eClass();
      LtsPackage.eINSTANCE.eClass();
      PropositionallogicPackage.eINSTANCE.eClass();
      TadlPackage.eINSTANCE.eClass();
      EmfCommons.registerAsteriskInExtensionToFactory();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Reading the input use-case model");
      this.info(_builder_1);
      EObject _readModel = EmfCommons.readModel(inputFile);
      final UseCaseModel useCaseModel = ((UseCaseModel) _readModel);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("Validating input use-case model");
      this.info(_builder_2);
      EmfCommons.basicValidate(useCaseModel);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("Running the transformation");
      this.info(_builder_3);
      Automaton _xifexpression_2 = null;
      boolean _has_2 = options.has(overviewOption);
      if (_has_2) {
        _xifexpression_2 = this.transformOverview(useCaseModel);
      } else {
        Automaton _xifexpression_3 = null;
        boolean _has_3 = options.has(singleUseCaseOption);
        if (_has_3) {
          Automaton _xblockexpression = null;
          {
            String _xifexpression_4 = null;
            boolean _hasArgument_2 = options.hasArgument(singleUseCaseOption);
            if (_hasArgument_2) {
              _xifexpression_4 = singleUseCaseOption.value(options);
            } else {
              optionParser.printHelpOn(System.out);
              return;
            }
            final String ucId = _xifexpression_4;
            EList<UseCase> _useCases = useCaseModel.getUseCases();
            final Function1<UseCase, Boolean> _function = new Function1<UseCase, Boolean>() {
              public Boolean apply(final UseCase it) {
                boolean _and = false;
                String _id = it.getId();
                boolean _equals = Objects.equal(_id, ucId);
                if (!_equals) {
                  _and = false;
                } else {
                  boolean _isPrimary = it.isPrimary();
                  _and = _isPrimary;
                }
                return Boolean.valueOf(_and);
              }
            };
            UseCase _findFirst = IterableExtensions.<UseCase>findFirst(_useCases, _function);
            StringConcatenation _builder_4 = new StringConcatenation();
            _builder_4.append("Use case ");
            _builder_4.append(ucId, "");
            _builder_4.append(" not found in primary use cases");
            final UseCase uc = Preconditions.<UseCase>checkNotNull(_findFirst, _builder_4);
            _xblockexpression = Ucm2LtsFacade.transformSingleUseCase(useCaseModel, uc);
          }
          _xifexpression_3 = _xblockexpression;
        } else {
          Automaton _xifexpression_4 = null;
          boolean _has_4 = options.has(singleUseCaseForPageOption);
          if (_has_4) {
            Automaton _xblockexpression_1 = null;
            {
              String _xifexpression_5 = null;
              boolean _hasArgument_2 = options.hasArgument(singleUseCaseForPageOption);
              if (_hasArgument_2) {
                _xifexpression_5 = singleUseCaseForPageOption.value(options);
              } else {
                optionParser.printHelpOn(System.out);
                return;
              }
              final String ucId = _xifexpression_5;
              EList<UseCase> _useCases = useCaseModel.getUseCases();
              final Function1<UseCase, Boolean> _function = new Function1<UseCase, Boolean>() {
                public Boolean apply(final UseCase it) {
                  boolean _and = false;
                  String _id = it.getId();
                  boolean _equals = Objects.equal(_id, ucId);
                  if (!_equals) {
                    _and = false;
                  } else {
                    boolean _isPrimary = it.isPrimary();
                    _and = _isPrimary;
                  }
                  return Boolean.valueOf(_and);
                }
              };
              UseCase _findFirst = IterableExtensions.<UseCase>findFirst(_useCases, _function);
              StringConcatenation _builder_4 = new StringConcatenation();
              _builder_4.append("Use case ");
              _builder_4.append(ucId, "");
              _builder_4.append(" not found in primary use cases");
              final UseCase uc = Preconditions.<UseCase>checkNotNull(_findFirst, _builder_4);
              _xblockexpression_1 = Ucm2LtsFacade.transformSingleUseCaseForPage(uc);
            }
            _xifexpression_4 = _xblockexpression_1;
          } else {
            _xifexpression_4 = Ucm2LtsFacade.transformAllUseCases(useCaseModel);
          }
          _xifexpression_3 = _xifexpression_4;
        }
        _xifexpression_2 = _xifexpression_3;
      }
      final Automaton automaton = _xifexpression_2;
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("Writing the LTS representation to \"");
      _builder_4.append(outputFile, "");
      _builder_4.append("\"");
      this.info(_builder_4);
      EmfCommons.writeModel(automaton, outputFile);
      this.info("done");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private Automaton transformOverview(final UseCaseModel useCaseModel) {
    Ucm2LtsOverviewGraph _ucm2LtsOverviewGraph = new Ucm2LtsOverviewGraph();
    return _ucm2LtsOverviewGraph.transform(useCaseModel);
  }
  
  public String getUsage() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Converts an input use-case model (XMI) into an LTS model (XMI).");
    _builder.newLine();
    return _builder.toString();
  }
}
