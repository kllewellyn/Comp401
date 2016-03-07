


public class Bean {

	private static String inputLine;
	
	public static void setInput(String s)
	{
		inputLine = s;
		NumberAndWordScanner.Scan(inputLine);
	}
	
	public static void getInput(String s)
	{
		System.out.println(inputLine);
	}
}
