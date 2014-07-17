package org.foam.cli.launcher;

import aQute.bnd.annotation.component.Component;
import aQute.bnd.annotation.component.Reference;
import com.google.common.base.Objects;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.foam.cli.launcher.api.IExecutableTool;
import org.foam.transform.utils.logger.LogServiceExtension;
import org.osgi.service.log.LogService;

@Component(immediate = true, provide = LauncherComponent.class, properties = { "osgi.command.scope:String=foam", "osgi.command.function:String=run" })
@SuppressWarnings("all")
public class LauncherComponent {
  @Extension
  private LogServiceExtension logServiceExtension;
  
  @Reference
  public void setLogService(final LogService logService) {
    LogServiceExtension _logServiceExtension = new LogServiceExtension(logService);
    this.logServiceExtension = _logServiceExtension;
  }
  
  private final ConcurrentHashMap<String, IExecutableTool> toolMap = new ConcurrentHashMap<String, IExecutableTool>();
  
  @Reference(multiple = true, optional = true, dynamic = true)
  public void addTool(final IExecutableTool tool) {
    Class<? extends IExecutableTool> _class = tool.getClass();
    final String toolName = _class.getSimpleName();
    final IExecutableTool previousItem = this.toolMap.putIfAbsent(toolName, tool);
    boolean _notEquals = (!Objects.equal(previousItem, null));
    if (_notEquals) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("The tool \'");
      _builder.append(toolName, "");
      _builder.append("\' has already been registered.");
      this.logServiceExtension.debug(_builder);
    }
  }
  
  public void removeTool(final IExecutableTool tool) {
    Class<? extends IExecutableTool> _class = tool.getClass();
    final String toolName = _class.getSimpleName();
    this.toolMap.remove(toolName);
  }
  
  private CharSequence showtools() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Available tools are:");
    _builder.newLine();
    {
      ConcurrentHashMap.KeySetView<String, IExecutableTool> _keySet = this.toolMap.keySet();
      for(final String toolName : _keySet) {
        _builder.append(" ");
        _builder.append("- ");
        _builder.append(toolName, " ");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public void run(final String[] args) {
    boolean _isEmpty = ((List<String>)Conversions.doWrapArray(args)).isEmpty();
    if (_isEmpty) {
      InputOutput.<String>println("No tool specified");
      CharSequence _showtools = this.showtools();
      InputOutput.<CharSequence>println(_showtools);
      return;
    }
    final String toolName = args[0];
    final Iterable<String> toolArgs = IterableExtensions.<String>tail(((Iterable<String>)Conversions.doWrapArray(args)));
    final IExecutableTool toolInstance = this.toolMap.get(toolName);
    boolean _equals = Objects.equal(toolInstance, null);
    if (_equals) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Unknown tool specified: ");
      _builder.append(toolName, "");
      InputOutput.<String>println(_builder.toString());
      CharSequence _showtools_1 = this.showtools();
      InputOutput.<CharSequence>println(_showtools_1);
      return;
    }
    toolInstance.execute(((String[])Conversions.unwrapArray(toolArgs, String.class)));
  }
}
