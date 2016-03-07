package mp.objects;

import java.awt.List;
import java.util.ArrayList;

import mp.interfaces.CommanderInterface;
import util.annotations.Tags;

@Tags({"CommandList"})
public class CommandList implements CommanderInterface{

	ArrayList<Runnable> commandList = new ArrayList<Runnable>();
	
	public CommandList()
	{
		
	}
	
	
	@Tags({"Add"})
	public void add(Runnable r)
	{
		commandList.add(r);
	}
	
	public void run()
	{
		for (int i = 0; i < commandList.size(); i++)
		{
			commandList.get(i).run();
		}
	}
	
	
}
