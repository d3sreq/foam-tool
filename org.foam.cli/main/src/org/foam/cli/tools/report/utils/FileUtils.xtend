package org.foam.cli.tools.report.utils

import com.google.common.base.Preconditions
import java.io.File
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream
import java.net.JarURLConnection
import java.net.URL
import org.osgi.framework.FrameworkUtil

/**
 * Inspired by
 * http://stackoverflow.com/questions/1386809/copy-directory-from-a-jar-file
 * @author Viliam Simko
 */
public class FileUtils {
	
	@Deprecated
	def static boolean copyFile(File toCopy, File destFile) {
		try {
			
			return FileUtils.copyStream(
					new FileInputStream(toCopy),
					new FileOutputStream(destFile))
			
		} catch (FileNotFoundException e) {
			e.printStackTrace
		}
		return false
	}

	@Deprecated
	def private static boolean copyFilesRecusively(File srcFileOrDir, File destDir) {
		
		Preconditions.checkArgument(srcFileOrDir.canRead)
		Preconditions.checkArgument(destDir.isDirectory)

		if ( ! srcFileOrDir.isDirectory ) {
			// the source is a regular file
			val dstFile = new File(destDir, srcFileOrDir.name)
			return FileUtils.copyFile(srcFileOrDir, dstFile)
		} else {
			// the source is a directory
			val newDestDir = new File(destDir, srcFileOrDir.name)
			if ( ! newDestDir.exists && ! newDestDir.mkdir ) {
				return false
			}
			for (File child : srcFileOrDir.listFiles) {
				if ( ! FileUtils.copyFilesRecusively(child, newDestDir)) {
					return false
				}
			}
		}
		return true
	}

	@Deprecated
	def static boolean copyJarResourcesRecursively(File destDir,
			JarURLConnection jarConnection) throws IOException {

		val jarFile = jarConnection.jarFile

		for (val e = jarFile.entries; e.hasMoreElements;) {
			val entry = e.nextElement
			if (entry.name.startsWith(jarConnection.entryName)) {
				val filename = removeStart(entry.name, jarConnection.entryName)

				val f = new File(destDir, filename)
				if (!entry.isDirectory) {
					val entryInputStream = jarFile.getInputStream(entry)
					if (!FileUtils.copyStream(entryInputStream, f)) {
						return false
					}
					entryInputStream.close
				} else {
					if (!FileUtils.ensureDirectoryExists(f)) {
						throw new IOException('''Could not create directory: «f.absolutePath»''')
					}
				}
			}
		}
		return true
	}

	/**
	 * From Apache StringUtils.
	 */
	@Deprecated
	def final static String removeStart(String str, String remove) {
		if (isEmpty(str) || isEmpty(remove)) {
			return str
		}
		if (str.startsWith(remove)) {
			return str.substring(remove.length)
		}
		return str
	}

	@Deprecated
	def static boolean copyResourcesRecursively(URL originUrl, File destination) {
		try {
			val urlConnection = originUrl.openConnection
			if (urlConnection instanceof JarURLConnection) {
				return FileUtils.copyJarResourcesRecursively(destination, urlConnection)
			} else {
				return FileUtils.copyFilesRecusively(new File(originUrl.path), destination)
			}
		} catch (IOException e) {
			e.printStackTrace
		}
		return false
	}

	def private static boolean copyStream(InputStream is, File f) {
		try {
			return FileUtils.copyStream(is, new FileOutputStream(f))
		} catch (FileNotFoundException e) {
			e.printStackTrace
		}
		return false
	}
	
	def private static boolean copyStream(InputStream is, OutputStream os) {
		try {
			val buf = newByteArrayOfSize(4096)

			var len = 0
			while ((len = is.read(buf)) > 0) {
				os.write(buf, 0, len)
			}
			return true
		} catch (IOException e) {
			e.printStackTrace
		} finally {
			try {is.close} catch(IOException e) {}
			try {os.close} catch(IOException e) {}
		}
		return false
	}

	@Deprecated
	def private static boolean ensureDirectoryExists(File f) {
		return f.exists || f.mkdir
	}

	/**
	 * From Apache StringUtils.
	 */
	@Deprecated
	def public static boolean isEmpty(CharSequence cs) {
		return cs == null || cs.length == 0
	}

	/**
	 * Inspired by http://stackoverflow.com/questions/4582375/how-to-test-if-a-url-from-an-eclipse-bundle-is-a-directory
	 */
	def public static void bundleCopy(String sourceDirName, String destDirName) {

		Preconditions.checkArgument( ! sourceDirName.empty )
		Preconditions.checkArgument( ! destDirName.empty )

		val destDir = new File(destDirName)
		
		// we need to create the output directory first because copyStream() needs it
		if( ! destDir.exists ) {
			destDir.mkdir
		}
		
		Preconditions.checkArgument( destDir.isDirectory )
		
		val bundle = FrameworkUtil.getBundle(FileUtils)
		
		val en = bundle.findEntries(sourceDirName, "*", true)
		while (en.hasMoreElements) {
			val url = en.nextElement
			val pathFromBase = url.path.substring(sourceDirName.length + 1)
			val destFileName = destDirName + pathFromBase
			val destFile = new File(destFileName)

			if (pathFromBase.endsWith("/")) {
				// This is a directory - create it and recurse
				// Don't fail if directory exists
				destFile.mkdir
			} else {
				copyStream(url.openStream, destFile);
			}
		}
	}
}
