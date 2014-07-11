package org.foam.cli.tools.report.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.JarURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import com.google.common.base.Preconditions;

/**
 * From
 * http://stackoverflow.com/questions/1386809/copy-directory-from-a-jar-file
 */
public class FileUtils {
	
	public static boolean copyFile(final File toCopy, final File destFile) {
		try {
			
			return FileUtils.copyStream(
					new FileInputStream(toCopy),
					new FileOutputStream(destFile));
			
		} catch (final FileNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}

	private static boolean copyFilesRecusively(final File srcFileOrDir, final File destDir) {
		
		Preconditions.checkArgument(srcFileOrDir.canRead());
		Preconditions.checkArgument(destDir.isDirectory());

		if ( ! srcFileOrDir.isDirectory() ) {
			// the source is a regular file
			final File dstFile = new File(destDir, srcFileOrDir.getName());
			return FileUtils.copyFile(srcFileOrDir, dstFile);
		} else {
			// the source is a directory
			final File newDestDir = new File(destDir, srcFileOrDir.getName());
			if ( ! newDestDir.exists() && ! newDestDir.mkdir() ) {
				return false;
			}
			for (final File child : srcFileOrDir.listFiles()) {
				if ( ! FileUtils.copyFilesRecusively(child, newDestDir)) {
					return false;
				}
			}
		}
		return true;
	}

	public static boolean copyJarResourcesRecursively(final File destDir,
			final JarURLConnection jarConnection) throws IOException {

		final JarFile jarFile = jarConnection.getJarFile();

		for (final Enumeration<JarEntry> e = jarFile.entries(); e
				.hasMoreElements();) {
			final JarEntry entry = e.nextElement();
			if (entry.getName().startsWith(jarConnection.getEntryName())) {
				final String filename = removeStart(entry.getName(), //
						jarConnection.getEntryName());

				final File f = new File(destDir, filename);
				if (!entry.isDirectory()) {
					final InputStream entryInputStream = jarFile
							.getInputStream(entry);
					if (!FileUtils.copyStream(entryInputStream, f)) {
						return false;
					}
					entryInputStream.close();
				} else {
					if (!FileUtils.ensureDirectoryExists(f)) {
						throw new IOException("Could not create directory: "
								+ f.getAbsolutePath());
					}
				}
			}
		}
		return true;
	}

	// from apache StringUtils
	public static String removeStart(String str, String remove) {
		if (isEmpty(str) || isEmpty(remove)) {
			return str;
		}
		if (str.startsWith(remove)) {
			return str.substring(remove.length());
		}
		return str;
	}

	public static boolean copyResourcesRecursively(
			final URL originUrl, final File destination) {
		try {
			final URLConnection urlConnection = originUrl.openConnection();
			if (urlConnection instanceof JarURLConnection) {
				return FileUtils.copyJarResourcesRecursively(destination,
						(JarURLConnection) urlConnection);
			} else {
				return FileUtils.copyFilesRecusively(
						new File(originUrl.getPath()), destination);
			}
		} catch (final IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	private static boolean copyStream(final InputStream is, final File f) {
		try {
			return FileUtils.copyStream(is, new FileOutputStream(f));
		} catch (final FileNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	private static boolean copyStream(final InputStream is, final OutputStream os) {
		try {
			final byte[] buf = new byte[4096];

			int len = 0;
			while ((len = is.read(buf)) > 0) {
				os.write(buf, 0, len);
			}
			return true;
		} catch (final IOException e) {
			e.printStackTrace();
		} finally {
			try {is.close();} catch(final IOException e) {}
			try {os.close();} catch(final IOException e) {}
		}
		return false;
	}

	private static boolean ensureDirectoryExists(final File f) {
		return f.exists() || f.mkdir();
	}

	// from apache StringUtils
	public static boolean isEmpty(CharSequence cs) {
		return cs == null || cs.length() == 0;
	}

	// copied from http://stackoverflow.com/questions/4582375/how-to-test-if-a-url-from-an-eclipse-bundle-is-a-directory
	public static void bundleCopy(final String dir, final String destination)
			throws IOException, URISyntaxException {

		final Bundle bundle = FrameworkUtil.getBundle(FileUtils.class);
		
		final Enumeration<URL> en = bundle.findEntries(dir, "*", true);
		while (en.hasMoreElements()) {
			final URL url = en.nextElement();
			final String pathFromBase = url.getPath().substring(dir.length() + 1);
			final String toFileName = destination + pathFromBase;
			final File toFile = new File(toFileName);

			if (pathFromBase.endsWith("/")) {
				// This is a directory - create it and recurse
				// Don't fail if directory exists
				toFile.mkdir();
			} else {
				// This is a file - copy it
				org.apache.commons.io.FileUtils.copyURLToFile(url, toFile);
			}
		}
	}
}
