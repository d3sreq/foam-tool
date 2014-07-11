package org.foam.cli.tools.renderlts;

import aQute.bnd.annotation.component.Component;
import aQute.bnd.annotation.component.Reference;
import com.google.common.base.Charsets;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.io.Files;
import java.io.File;
import java.util.Collections;
import java.util.List;
import joptsimple.ArgumentAcceptingOptionSpec;
import joptsimple.OptionParser;
import joptsimple.OptionSet;
import joptsimple.OptionSpecBuilder;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.foam.cli.launcher.api.IExecutableTool;
import org.foam.dot.DotPackage;
import org.foam.dot.Graph;
import org.foam.flowannotation.FlowannotationPackage;
import org.foam.lts.Automaton;
import org.foam.lts.LtsPackage;
import org.foam.tadl.TadlPackage;
import org.foam.traceability.TraceabilityPackage;
import org.foam.transform.dot2dotlang.Dot2DotLang;
import org.foam.transform.lts2dot.Lts2Dot;
import org.foam.transform.utils.graphviz.GraphvizUtils;
import org.foam.transform.utils.modeling.EmfCommons;
import org.foam.verification.VerificationPackage;
import org.osgi.service.log.LogService;

@Component(enabled = false)
@Deprecated
@SuppressWarnings("all")
public class RenderLTS implements IExecutableTool {
  private final static String XMI_OverviewGraphTemplate = "org/foam/cli/tools/renderlts/OverviewGraphTemplate.xmi";
  
  private final static String XMI_GraphTemplate = "org/foam/cli/tools/renderlts/GraphTemplate.xmi";
  
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
      OptionSpecBuilder _accepts = optionParser.accepts("i", "input file with lts");
      ArgumentAcceptingOptionSpec<String> _withRequiredArg = _accepts.withRequiredArg();
      final ArgumentAcceptingOptionSpec<String> inputLtsOption = _withRequiredArg.describedAs("lts file");
      OptionSpecBuilder _accepts_1 = optionParser.accepts("o", "output dot file");
      ArgumentAcceptingOptionSpec<String> _withRequiredArg_1 = _accepts_1.withRequiredArg();
      final ArgumentAcceptingOptionSpec<String> outputOption = _withRequiredArg_1.describedAs("dot file");
      final OptionSpecBuilder overviewOption = optionParser.accepts("w", "overview option");
      final OptionSpecBuilder pdfOption = optionParser.accepts("pdf", "also generate a PDF file");
      final OptionSpecBuilder pngOption = optionParser.accepts("png", "also generate a PNG file");
      final OptionSpecBuilder cmapxOption = optionParser.accepts("cmapx", "also generate an HTML image map");
      final OptionSpecBuilder htmlOption = optionParser.accepts("html", "also generate HTML with PNG + image map");
      final OptionSpecBuilder helpOption = optionParser.acceptsAll(Collections.<String>unmodifiableList(Lists.<String>newArrayList("h", "?")), "show help");
      final OptionSet options = optionParser.parse(args);
      boolean _has = options.has(helpOption);
      if (_has) {
        optionParser.printHelpOn(System.out);
        return;
      }
      String _xifexpression = null;
      boolean _and = false;
      boolean _has_1 = options.has(inputLtsOption);
      if (!_has_1) {
        _and = false;
      } else {
        boolean _hasArgument = options.hasArgument(inputLtsOption);
        _and = _hasArgument;
      }
      if (_and) {
        _xifexpression = inputLtsOption.value(options);
      } else {
        optionParser.printHelpOn(System.out);
        return;
      }
      final String inputLtsFileName = _xifexpression;
      String _xifexpression_1 = null;
      boolean _and_1 = false;
      boolean _has_2 = options.has(outputOption);
      if (!_has_2) {
        _and_1 = false;
      } else {
        boolean _hasArgument_1 = options.hasArgument(outputOption);
        _and_1 = _hasArgument_1;
      }
      if (_and_1) {
        _xifexpression_1 = outputOption.value(options);
      } else {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append(inputLtsFileName, "");
        _builder.append("output.dot");
        _xifexpression_1 = _builder.toString();
      }
      final String outputFileName = _xifexpression_1;
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Initializing required meta-models");
      this.info(_builder_1);
      DotPackage.eINSTANCE.eClass();
      LtsPackage.eINSTANCE.eClass();
      TraceabilityPackage.eINSTANCE.eClass();
      FlowannotationPackage.eINSTANCE.eClass();
      VerificationPackage.eINSTANCE.eClass();
      TadlPackage.eINSTANCE.eClass();
      EmfCommons.registerAsteriskInExtensionToFactory();
      final ResourceSetImpl resourceSet = new ResourceSetImpl();
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("Reading input LTS from file \"");
      _builder_2.append(inputLtsFileName, "");
      _builder_2.append("\"");
      this.info(_builder_2);
      EObject _readModel = EmfCommons.readModel(inputLtsFileName, resourceSet);
      final Automaton automaton = ((Automaton) _readModel);
      final boolean isOverview = options.has(overviewOption);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("Reading configuration graph template from \"conf/GraphTemplate.xmi\"");
      this.info(_builder_3);
      String _xifexpression_2 = null;
      if (isOverview) {
        _xifexpression_2 = RenderLTS.XMI_OverviewGraphTemplate;
      } else {
        _xifexpression_2 = RenderLTS.XMI_GraphTemplate;
      }
      EObject _readModel_1 = EmfCommons.readModel(_xifexpression_2);
      final Graph initGraph = ((Graph) _readModel_1);
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("Validating input LTS");
      this.info(_builder_4);
      EmfCommons.basicValidate(automaton);
      StringConcatenation _builder_5 = new StringConcatenation();
      _builder_5.append("Validating configuration graph template");
      this.info(_builder_5);
      EmfCommons.basicValidate(initGraph);
      StringConcatenation _builder_6 = new StringConcatenation();
      _builder_6.append("Running the transformation");
      this.info(_builder_6);
      final Lts2Dot lts2dot = new Lts2Dot();
      Graph _xifexpression_3 = null;
      if (isOverview) {
        _xifexpression_3 = lts2dot.transformOverview(automaton, initGraph);
      } else {
        _xifexpression_3 = lts2dot.transform(automaton, initGraph);
      }
      final Graph graph = _xifexpression_3;
      final Dot2DotLang dot2Text = new Dot2DotLang();
      final CharSequence text = dot2Text.transform(graph);
      StringConcatenation _builder_7 = new StringConcatenation();
      _builder_7.append("Writing the result DOT code to \"");
      _builder_7.append(outputFileName, "");
      _builder_7.append("\"");
      this.info(_builder_7);
      File _file = new File(outputFileName);
      Files.write(text, _file, Charsets.UTF_8);
      final List<String> dotCommand = Collections.<String>unmodifiableList(Lists.<String>newArrayList());
      boolean _has_3 = options.has(pdfOption);
      if (_has_3) {
        StringConcatenation _builder_8 = new StringConcatenation();
        _builder_8.append(outputFileName, "");
        _builder_8.append(".pdf");
        Iterables.<String>addAll(dotCommand, Collections.<String>unmodifiableList(Lists.<String>newArrayList("-Tpdf", "-o", _builder_8.toString())));
      }
      boolean _or = false;
      boolean _has_4 = options.has(pngOption);
      if (_has_4) {
        _or = true;
      } else {
        boolean _has_5 = options.has(htmlOption);
        _or = _has_5;
      }
      if (_or) {
        StringConcatenation _builder_9 = new StringConcatenation();
        _builder_9.append(outputFileName, "");
        _builder_9.append(".png");
        Iterables.<String>addAll(dotCommand, Collections.<String>unmodifiableList(Lists.<String>newArrayList("-Tpng", "-o", _builder_9.toString())));
      }
      boolean _or_1 = false;
      boolean _has_6 = options.has(cmapxOption);
      if (_has_6) {
        _or_1 = true;
      } else {
        boolean _has_7 = options.has(htmlOption);
        _or_1 = _has_7;
      }
      if (_or_1) {
        StringConcatenation _builder_10 = new StringConcatenation();
        _builder_10.append(outputFileName, "");
        _builder_10.append(".cmapx");
        Iterables.<String>addAll(dotCommand, Collections.<String>unmodifiableList(Lists.<String>newArrayList("-Tcmapx", "-o", _builder_10.toString())));
      }
      boolean _isEmpty = dotCommand.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        GraphvizUtils.checkGraphvizVersion();
        dotCommand.add(0, "dot");
        dotCommand.add(outputFileName);
        StringConcatenation _builder_11 = new StringConcatenation();
        _builder_11.append("Running Graphviz DOT tool: ");
        String _join = IterableExtensions.join(dotCommand, " ");
        _builder_11.append(_join, "");
        this.info(_builder_11);
        Runtime _runtime = Runtime.getRuntime();
        Process _exec = _runtime.exec(((String[])Conversions.unwrapArray(dotCommand, String.class)));
        _exec.waitFor();
      }
      boolean _has_8 = options.has(htmlOption);
      if (_has_8) {
        StringConcatenation _builder_12 = new StringConcatenation();
        _builder_12.append("Writing HTML to \"");
        _builder_12.append(outputFileName, "");
        _builder_12.append(".html\"");
        this.info(_builder_12);
        StringConcatenation _builder_13 = new StringConcatenation();
        _builder_13.append(outputFileName, "");
        _builder_13.append(".cmapx");
        File _file_1 = new File(_builder_13.toString());
        List<String> _readLines = Files.readLines(_file_1, Charsets.UTF_8);
        final String imageMapContent = IterableExtensions.join(_readLines, "\n");
        StringConcatenation _builder_14 = new StringConcatenation();
        _builder_14.append("<html>");
        _builder_14.newLine();
        _builder_14.append("<body>");
        _builder_14.newLine();
        _builder_14.append("<img src=\"");
        _builder_14.append(outputFileName, "");
        _builder_14.append(".png\" ismap=\"ismap\" usemap=\"#mygraph\"/>");
        _builder_14.newLineIfNotEmpty();
        _builder_14.append(imageMapContent, "");
        _builder_14.newLineIfNotEmpty();
        _builder_14.append("</body>");
        _builder_14.newLine();
        _builder_14.append("</html>");
        _builder_14.newLine();
        StringConcatenation _builder_15 = new StringConcatenation();
        _builder_15.append(outputFileName, "");
        _builder_15.append(".html");
        File _file_2 = new File(_builder_15.toString());
        Files.write(_builder_14, _file_2, Charsets.UTF_8);
      }
      this.info("done");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public String getUsage() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Converts a Labelled Transition System (LTS) stored in an XMI");
    _builder.newLine();
    _builder.append("file into input format for the Graphviz DOT tool.");
    _builder.newLine();
    return _builder.toString();
  }
}
