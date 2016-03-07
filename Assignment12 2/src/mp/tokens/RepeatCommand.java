package mp.tokens;

import util.annotations.Tags;

@Tags({"Repeat"})
public class RepeatCommand implements Runnable{
	
	Runnable repeatable;
	int count;
	
	public RepeatCommand(int c, Runnable r)
	{
		repeatable = r;
		count = c;
	}

	public void run()
	{
		int p = 0;
		while (p < count)
		{
			repeatable.run();
			p++;
		}
	}
	
	
}
