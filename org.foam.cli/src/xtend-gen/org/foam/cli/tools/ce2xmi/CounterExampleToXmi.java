package org.foam.cli.tools.ce2xmi;

import aQute.bnd.annotation.component.Component;
import aQute.bnd.annotation.component.Reference;
import com.google.common.base.Charsets;
import com.google.common.io.Files;
import java.io.File;
import java.util.ArrayList;
import joptsimple.ArgumentAcceptingOptionSpec;
import joptsimple.OptionParser;
import joptsimple.OptionSet;
import joptsimple.OptionSpecBuilder;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.foam.cli.launcher.api.IExecutableTool;
import org.foam.cntex.CntexPackage;
import org.foam.cntex.CounterExample;
import org.foam.flowannotation.FlowannotationPackage;
import org.foam.lts.Automaton;
import org.foam.lts.LtsPackage;
import org.foam.tadl.TadlPackage;
import org.foam.traceability.TraceabilityPackage;
import org.foam.transform.cntexlang2cntex.CntexLang2Cntex;
import org.foam.transform.cntexlang2cntex.CntexStateResolver;
import org.foam.transform.utils.model.EmfCommons;
import org.foam.verification.VerificationPackage;
import org.osgi.service.log.LogService;

@Component
@SuppressWarnings("all")
public class CounterExampleToXmi implements IExecutableTool {
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
      OptionSpecBuilder _accepts = optionParser.accepts("i", "input file with NuSMV counter example in XML format");
      ArgumentAcceptingOptionSpec<String> _withRequiredArg = _accepts.withRequiredArg();
      final ArgumentAcceptingOptionSpec<String> inputCounterExampleOption = _withRequiredArg.describedAs("NuSMV XML counter example");
      OptionSpecBuilder _accepts_1 = optionParser.accepts("a", "input file with LTS automaton");
      ArgumentAcceptingOptionSpec<String> _withRequiredArg_1 = _accepts_1.withRequiredArg();
      final ArgumentAcceptingOptionSpec<String> inputLtsOption = _withRequiredArg_1.describedAs("input LTS");
      OptionSpecBuilder _accepts_2 = optionParser.accepts("o", "output file with FOAM counter example");
      ArgumentAcceptingOptionSpec<String> _withRequiredArg_2 = _accepts_2.withRequiredArg();
      final ArgumentAcceptingOptionSpec<String> outputOption = _withRequiredArg_2.describedAs("foam counter example file");
      ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList("h", "?");
      final OptionSpecBuilder helpOption = optionParser.acceptsAll(_newArrayList, "show help");
      final OptionSet options = optionParser.parse(args);
      boolean _has = options.has(helpOption);
      if (_has) {
        optionParser.printHelpOn(System.out);
        return;
      }
      String _xifexpression = null;
      boolean _and = false;
      boolean _has_1 = options.has(inputCounterExampleOption);
      if (!_has_1) {
        _and = false;
      } else {
        boolean _hasArgument = options.hasArgument(inputCounterExampleOption);
        _and = _hasArgument;
      }
      if (_and) {
        _xifexpression = inputCounterExampleOption.value(options);
      } else {
        optionParser.printHelpOn(System.out);
        return;
      }
      final String inputCounterExampleFileName = _xifexpression;
      String _xifexpression_1 = null;
      boolean _and_1 = false;
      boolean _has_2 = options.has(inputLtsOption);
      if (!_has_2) {
        _and_1 = false;
      } else {
        boolean _hasArgument_1 = options.hasArgument(inputLtsOption);
        _and_1 = _hasArgument_1;
      }
      if (_and_1) {
        _xifexpression_1 = inputLtsOption.value(options);
      } else {
        optionParser.printHelpOn(System.out);
        return;
      }
      final String inputLtsFileName = _xifexpression_1;
      String _xifexpression_2 = null;
      boolean _and_2 = false;
      boolean _has_3 = options.has(outputOption);
      if (!_has_3) {
        _and_2 = false;
      } else {
        boolean _hasArgument_2 = options.hasArgument(outputOption);
        _and_2 = _hasArgument_2;
      }
      if (_and_2) {
        _xifexpression_2 = outputOption.value(options);
      } else {
        optionParser.printHelpOn(System.out);
        return;
      }
      final String outputFileName = _xifexpression_2;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Initializing required meta-models");
      this.info(_builder);
      CntexPackage.eINSTANCE.eClass();
      FlowannotationPackage.eINSTANCE.eClass();
      LtsPackage.eINSTANCE.eClass();
      TadlPackage.eINSTANCE.eClass();
      TraceabilityPackage.eINSTANCE.eClass();
      VerificationPackage.eINSTANCE.eClass();
      EmfCommons.registerAsteriskInExtensionToFactory();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Reading input NuSMV counter example from file \"");
      _builder_1.append(inputCounterExampleFileName, "");
      _builder_1.append("\"");
      this.info(_builder_1);
      File _file = new File(inputCounterExampleFileName);
      final String inputText = Files.toString(_file, Charsets.UTF_8);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("Reading input LTS from file \"");
      _builder_2.append(inputLtsFileName, "");
      _builder_2.append("\"");
      this.info(_builder_2);
      EObject _readModel = EmfCommons.readModel(inputLtsFileName);
      final Automaton automaton = ((Automaton) _readModel);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("Validating input LTS");
      this.info(_builder_3);
      EmfCommons.basicValidate(automaton);
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("Running the transformation");
      this.info(_builder_4);
      final CntexLang2Cntex transformation = new CntexLang2Cntex();
      final CounterExample counterExample = transformation.transform(inputText);
      final CntexStateResolver resolver = new CntexStateResolver();
      resolver.transform(counterExample, automaton);
      StringConcatenation _builder_5 = new StringConcatenation();
      _builder_5.append("Writing the result FOAM countex example to \"");
      _builder_5.append(outputFileName, "");
      _builder_5.append("\"");
      this.info(_builder_5);
      EmfCommons.writeModel(counterExample, outputFileName);
      this.info("done");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public String getUsage() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Converts the counter example from NuSMV\'s internal format XMI.");
    _builder.newLine();
    return _builder.toString();
  }
}
