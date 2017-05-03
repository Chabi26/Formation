/**
 * Created by eve on 03/05/2017.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TestRuntime3 {

	public TestRuntime3() {
		try {

			Runtime runtime = Runtime.getRuntime();
			Process proc = runtime.exec("/usr/bin/env");

			TestRuntime3.AfficheFlux afficheFlux =
				new AfficheFlux(proc.getInputStream());

			afficheFlux.start();

			int exitVal = proc.waitFor();
			System.out.println("exitVal = " + exitVal);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new TestRuntime3();
	}

	private class AfficheFlux extends Thread {
		InputStream is;

		AfficheFlux(InputStream is) {
			this.is = is;
		}

		public void run() {
			try {
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				String line = null;
				while ((line = br.readLine()) != null)
					System.out.println(line);
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}
}