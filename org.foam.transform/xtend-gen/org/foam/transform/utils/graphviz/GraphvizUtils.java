package org.foam.transform.utils.graphviz;

import com.google.common.base.Objects;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.foam.transform.utils.graphviz.GraphvizNotFoundException;

@SuppressWarnings("all")
public class GraphvizUtils {
  public static String checkGraphvizVersion() {
    try {
      String _xblockexpression = null;
      {
        Runtime _runtime = Runtime.getRuntime();
        ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList("dot", "-V");
        final Process process = _runtime.exec(((String[]) ((String[])Conversions.unwrapArray(_newArrayList, String.class))));
        final InputStream procstdout = process.getErrorStream();
        InputStreamReader _inputStreamReader = new InputStreamReader(procstdout);
        final BufferedReader reader = new BufferedReader(_inputStreamReader);
        final String version = reader.readLine();
        reader.close();
        process.destroy();
        boolean _or = false;
        boolean _equals = Objects.equal(version, null);
        if (_equals) {
          _or = true;
        } else {
          boolean _contains = version.contains("graphviz version");
          boolean _not = (!_contains);
          _or = _not;
        }
        if (_or) {
          throw new GraphvizNotFoundException("Grapviz version not found");
        }
        _xblockexpression = version;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static void runGraphviz(final List<String> dotCommand) {
    try {
      Runtime _runtime = Runtime.getRuntime();
      Process _exec = _runtime.exec(((String[]) ((String[])Conversions.unwrapArray(dotCommand, String.class))));
      _exec.waitFor();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
