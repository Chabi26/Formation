/**
 * Created by eve on 03/05/2017.
 */
public class TestRuntime1
{
	public static void main(String[] args)
	{
		Runtime runtime = Runtime.getRuntime();
		System.out.println("Mémoire totale = "+runtime.totalMemory());
		System.out.println("Mémoire libre = "+runtime.freeMemory());
	}
}
