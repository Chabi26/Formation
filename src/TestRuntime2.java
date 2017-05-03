import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



/**
 * Created by eve on 03/05/2017.
 */
public class TestRuntime2
{
	public static void main(String[] args)
	{
		try
		{
			String os = System.getProperty("os.name").toLowerCase();

			System.out.println("Platform is " + os + ".");

			Runtime runtime;
			Process p = null;

			if (os.indexOf("windows 9") > -1) {
				p = Runtime.getRuntime().exec("command.com /c set");
			} else if (os.indexOf("unix") > -1) {
				p = Runtime.getRuntime().exec("/bin/env");
			} else if ((os.indexOf("nt") > -1) || (os.indexOf("windows 2000") > -1)
				|| (os.indexOf("windows xp") > -1) || (os.indexOf("windows 2003") > -1) ) {
				p = Runtime.getRuntime().exec("cmd.exe /c set");
			} else if  (os.indexOf("unix") > -1) {
				p = Runtime.getRuntime().exec("/bin/env");
			} else if  ((os.indexOf("linux") > -1) || (os.indexOf("mac os x") > -1)) {
				p = Runtime.getRuntime().exec("/usr/bin/env");
			}

			if (p == null) {
				System.out.println(
					"Don't know how to read environment variables on this platform: " + os);
				return;
			}
			BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String str;
			while((str = in.readLine()) != null) {
				System.out.println(str);
			}
			in.close();
			p.waitFor();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}
}
