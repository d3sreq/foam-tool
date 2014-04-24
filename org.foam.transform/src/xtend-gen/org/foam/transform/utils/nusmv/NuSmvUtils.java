package org.foam.transform.utils.nusmv;

import com.google.common.base.Charsets;
import com.google.common.base.Objects;
import com.google.common.io.CharStreams;
import com.google.common.io.Files;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.foam.transform.utils.nusmv.NuSmvNotFoundException;

@SuppressWarnings("all")
public class NuSmvUtils {
  private final static Pattern nusmvVersionPattern = Pattern.compile(".*NuSMV (\\S+).*");
  
  public static String checkNuSmvVersion() {
    try {
      String _xblockexpression = null;
      {
        final ProcessBuilder builder = new ProcessBuilder("nusmv", "-h");
        builder.redirectErrorStream(true);
        final Process process = builder.start();
        InputStream _inputStream = process.getInputStream();
        InputStreamReader _inputStreamReader = new InputStreamReader(_inputStream);
        final BufferedReader reader = new BufferedReader(_inputStreamReader);
        final String line = reader.readLine();
        final Matcher matcher = NuSmvUtils.nusmvVersionPattern.matcher(line);
        reader.close();
        process.destroy();
        boolean _or = false;
        boolean _equals = Objects.equal(line, null);
        if (_equals) {
          _or = true;
        } else {
          boolean _matches = matcher.matches();
          boolean _not = (!_matches);
          _or = _not;
        }
        if (_or) {
          throw new NuSmvNotFoundException("NuSMV version not found");
        }
        _xblockexpression = matcher.group(1);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static String runNuSMV(final CharSequence nusmvCode) {
    try {
      String _xblockexpression = null;
      {
        final File tempFile = File.createTempFile("nusmv-file", "");
        Files.write(nusmvCode, tempFile, Charsets.UTF_8);
        String _absolutePath = tempFile.getAbsolutePath();
        final ProcessBuilder builder = new ProcessBuilder("nusmv", _absolutePath);
        builder.redirectErrorStream(true);
        final Process process = builder.start();
        InputStream _inputStream = process.getInputStream();
        InputStreamReader _inputStreamReader = new InputStreamReader(_inputStream);
        final BufferedReader reader = new BufferedReader(_inputStreamReader);
        String _string = CharStreams.toString(reader);
        final String result = _string.replaceAll("\nWARNING \\*\\*\\*", "***");
        reader.close();
        process.destroy();
        _xblockexpression = result;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
