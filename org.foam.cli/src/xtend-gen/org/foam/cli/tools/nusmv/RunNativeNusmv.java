package org.foam.cli.tools.nusmv;

import aQute.bnd.annotation.component.Component;
import aQute.bnd.annotation.component.Reference;
import com.google.common.base.Preconditions;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.foam.cli.launcher.api.IExecutableTool;
import org.foam.transform.utils.logger.LogServiceExtension;
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
  
  @Extension
  private LogServiceExtension logServiceExtension;
  
  @Reference
  public void setLogService(final LogService logService) {
    LogServiceExtension _logServiceExtension = new LogServiceExtension(logService);
    this.logServiceExtension = _logServiceExtension;
  }
  
  public void execute(final String[] args) {
    int _length = args.length;
    boolean _equals = (_length == 1);
    Preconditions.checkArgument(_equals, "Input file expected as a single argument");
    String _head = IterableExtensions.<String>head(((Iterable<String>)Conversions.doWrapArray(args)));
    List<String> _runNusmvFile = this.nusmvWrapper.runNusmvFile(_head);
    final Consumer<String> _function = new Consumer<String>() {
      public void accept(final String it) {
        InputOutput.<String>println(it);
      }
    };
    _runNusmvFile.forEach(_function);
    this.logServiceExtension.info("done");
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
