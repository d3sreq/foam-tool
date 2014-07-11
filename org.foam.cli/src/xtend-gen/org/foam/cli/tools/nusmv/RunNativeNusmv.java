package org.foam.cli.tools.nusmv;

import aQute.bnd.annotation.component.Component;
import aQute.bnd.annotation.component.Reference;
import com.google.common.base.Objects;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.foam.cli.launcher.api.IExecutableTool;
import org.foam.transform.utils.nusmv.NusmvWrapper;
import org.osgi.service.log.LogService;

@Component
@SuppressWarnings("all")
public class RunNativeNusmv implements IExecutableTool {
  private NusmvWrapper nusmvWrapper;
  
  @Reference
  public void setNusmvWrapper(final NusmvWrapper nusmvWrapper) {
    this.nusmvWrapper = nusmvWrapper;
  }
  
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
      int _length = args.length;
      boolean _notEquals = (_length != 1);
      if (_notEquals) {
        throw new IllegalArgumentException("Input file expected as a single argument");
      }
      String _head = IterableExtensions.<String>head(((Iterable<String>)Conversions.doWrapArray(args)));
      final InputStream nusmvOut = this.nusmvWrapper.openNusmvProcess(_head);
      InputStreamReader _inputStreamReader = new InputStreamReader(nusmvOut);
      final BufferedReader reader = new BufferedReader(_inputStreamReader);
      String line = null;
      String _readLine = reader.readLine();
      String _line = line = _readLine;
      boolean _notEquals_1 = (!Objects.equal(_line, null));
      boolean _while = _notEquals_1;
      while (_while) {
        InputOutput.<String>println(line);
        String _readLine_1 = reader.readLine();
        String _line_1 = line = _readLine_1;
        boolean _notEquals_2 = (!Objects.equal(_line_1, null));
        _while = _notEquals_2;
      }
      this.nusmvWrapper.closeNusmvProcess();
      this.info("done");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public String getUsage() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Executes the NuSMV model checker directly.");
    _builder.newLine();
    _builder.append("(using the bundled executable binary file)");
    _builder.newLine();
    return _builder.toString();
  }
}
