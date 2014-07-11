package org.foam.cli.tools.lts2nusmv;

import aQute.bnd.annotation.component.Component;
import aQute.bnd.annotation.component.Reference;
import com.google.common.collect.Lists;
import java.io.PrintWriter;
import java.util.Collections;
import joptsimple.ArgumentAcceptingOptionSpec;
import joptsimple.OptionParser;
import joptsimple.OptionSet;
import joptsimple.OptionSpecBuilder;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.foam.cli.launcher.api.IExecutableTool;
import org.foam.ctl.CtlPackage;
import org.foam.flowannotation.FlowannotationPackage;
import org.foam.ltl.LtlPackage;
import org.foam.lts.Automaton;
import org.foam.lts.LtsPackage;
import org.foam.propositionallogic.PropositionallogicPackage;
import org.foam.tadl.TadlPackage;
import org.foam.traceability.TraceabilityPackage;
import org.foam.transform.lts2nusmvlang.Lts2NuSMVLang;
import org.foam.transform.utils.logger.LogServiceExtension;
import org.foam.transform.utils.modeling.EmfCommons;
import org.foam.verification.VerificationPackage;
import org.osgi.service.log.LogService;

@Component
@SuppressWarnings("all")
public class LtsToNusmv implements IExecutableTool {
  @Extension
  private LogServiceExtension logServiceExtension;
  
  @Reference
  public void setLogService(final LogService logService) {
    LogServiceExtension _logServiceExtension = new LogServiceExtension(logService);
    this.logServiceExtension = _logServiceExtension;
  }
  
  public void execute(final String[] args) {
    try {
      final OptionParser optionParser = new OptionParser();
      OptionSpecBuilder _accepts = optionParser.accepts("i", "input lts file");
      ArgumentAcceptingOptionSpec<String> _withRequiredArg = _accepts.withRequiredArg();
      final ArgumentAcceptingOptionSpec<String> inputOption = _withRequiredArg.describedAs("input file with LTS model");
      OptionSpecBuilder _accepts_1 = optionParser.accepts("o", "output nusmv file");
      ArgumentAcceptingOptionSpec<String> _withOptionalArg = _accepts_1.withOptionalArg();
      final ArgumentAcceptingOptionSpec<String> outputOption = _withOptionalArg.describedAs("output file with NuSMV code");
      optionParser.acceptsAll(Collections.<String>unmodifiableList(Lists.<String>newArrayList("h", "?")), "show help");
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
      final String inputFileName = _xifexpression;
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
        StringConcatenation _builder = new StringConcatenation();
        _builder.append(inputFileName, "");
        _builder.append(".nusmv");
        _xifexpression_1 = _builder.toString();
      }
      final String outputFileName = _xifexpression_1;
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Initializing required meta-models");
      this.logServiceExtension.info(_builder_1);
      LtsPackage.eINSTANCE.eClass();
      TraceabilityPackage.eINSTANCE.eClass();
      FlowannotationPackage.eINSTANCE.eClass();
      VerificationPackage.eINSTANCE.eClass();
      TadlPackage.eINSTANCE.eClass();
      LtlPackage.eINSTANCE.eClass();
      CtlPackage.eINSTANCE.eClass();
      PropositionallogicPackage.eINSTANCE.eClass();
      EmfCommons.registerAsteriskInExtensionToFactory();
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("Reading the input LTS model from \"");
      _builder_2.append(inputFileName, "");
      _builder_2.append("\"");
      this.logServiceExtension.info(_builder_2);
      EObject _readModel = EmfCommons.readModel(inputFileName);
      final Automaton automaton = ((Automaton) _readModel);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("Validating input LTS model");
      this.logServiceExtension.info(_builder_3);
      EmfCommons.basicValidate(automaton);
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("Running the transformation");
      this.logServiceExtension.info(_builder_4);
      Lts2NuSMVLang _lts2NuSMVLang = new Lts2NuSMVLang();
      final String result = _lts2NuSMVLang.transform(automaton);
      StringConcatenation _builder_5 = new StringConcatenation();
      _builder_5.append("Writing the result NuSMV code to \"");
      _builder_5.append(outputFileName, "");
      _builder_5.append("\"");
      this.logServiceExtension.info(_builder_5);
      final PrintWriter pw = new PrintWriter(outputFileName);
      pw.print(result);
      pw.close();
      this.logServiceExtension.info("done");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public String getUsage() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Converts Labelled Transition System (LTS) stored");
    _builder.newLine();
    _builder.append("in an XMI file into input for the NuSMV model checker.");
    _builder.newLine();
    return _builder.toString();
  }
}
