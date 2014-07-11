package org.foam.transform.utils.nusmv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

import aQute.bnd.annotation.component.Activate;
import aQute.bnd.annotation.component.Component;

@Component(provide = NusmvWrapper.class)
public class NusmvWrapper {

	private Process process = null;
	
	@Activate
	final public void activate(final Map<String,Object> props) {
		//System.out.println(props);
	}
	
	final public InputStream openNusmvProcess(final String inputFileName)
			throws IOException {

		if(process != null)
			throw new RuntimeException("Nusmv process already opened");
		
		process = Runtime.getRuntime()
				.exec(new String[] {
						"/home/vlx/Apps/NuSMV-zchaff-2.5.4-x86_64-unknown-linux-gnu/bin/NuSMV",
						inputFileName });

		// Printing error messages from NuSMV in a separate thread
		new Thread() {
			@Override
			public void run() {
				final BufferedReader reader = new BufferedReader(
						new InputStreamReader(process.getErrorStream()));

				try {
					String line;
					while ((line = reader.readLine()) != null) {
						System.err.println(line);
					}
				} catch (IOException e) {
					System.err.println(e.getMessage());
				} finally {
					try {
						reader.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		}.start();

		process.getOutputStream().close(); // STDIN of the NuSMV process will be
											// closed
		return process.getInputStream();
	}

	final public void closeNusmvProcess() throws IOException, InterruptedException {
		process.getInputStream().close();
		process.waitFor();
	}
}
