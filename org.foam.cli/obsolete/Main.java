package cli.nusmv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		
		if(args.length != 1) {
			System.err.println("Wrong argument");
			System.exit(1);
		}
		
		final String inputFileName = args[0];
		final Process process = Runtime.getRuntime().exec(new String[]{
			"/home/vlx/Apps/NuSMV-zchaff-2.5.4-x86_64-unknown-linux-gnu/bin/NuSMV",
			inputFileName
		});
		
		// Printing error messages from NuSMV in a separate thread
		new Thread() {
			@Override
			public void run() {
				final BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
				
				try {
					String line;
					while((line = reader.readLine()) != null) {
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
		
		process.getOutputStream().close(); // STDIN of the NuSMV process will be closed
		final InputStream procout = process.getInputStream();
		
		final BufferedReader reader = new BufferedReader(new InputStreamReader(procout));
		
		String line;
		while((line = reader.readLine()) != null) {
			System.out.println(line);
		}
		
		reader.close();
		process.waitFor();
	}

}
