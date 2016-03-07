package mp.tokens;

import mp.interfaces.AvatarInterface;
import mp.interfaces.BridgeSceneInterface;
import mp.interfaces.CommandInterface;
import mp.interfaces.ScannerBeanInterface;
import mp.interfaces.TableInterface;
import mp.interfaces.ValueInterface;
import mp.objects.CommandList;
import mp.objects.MoveCommand;
import mp.objects.NumberInterface;
import mp.objects.SayCommand;
import mp.objects.Table;
import util.annotations.Tags;
import util.annotations.Visible;


@Tags({"Parser"})
public class Parser {

	private BridgeSceneInterface bridgeScene;
	private String commandText, error;
	private ScannerBeanInterface scannerBean;
	private TableInterface<Object, String> table = new Table<Object, String>();
	static int threadNumber = 0;
	private int index = 0;
	CommandInterface[] newTokens;
	CommandList commandList;
	
	private final static int ONE = 1, TWO = 2, THREE = 3;
	
	public Parser(BridgeSceneInterface b)
	{
		bridgeScene = b;
		table.put("arthur", bridgeScene.getArthur());
		table.put("galahad", bridgeScene.getGalahad());
		table.put("lancelot", bridgeScene.getLancelot());
		table.put("guard", bridgeScene.getGuard());
		table.put("robin", bridgeScene.getRobin());
		error = "Invalid input entered: ";
	}

	public void setCommandText(String s)
	{
		commandText = s;
		index = 0;
	}
	
	public String getCommandText(){return commandText;}
	
	@Tags({"ParseCommand"})
	public void parseCommand()
	{
		scannerBean = new ScannerBean(getCommandText());
		newTokens = scannerBean.getTokens();
		while(index < newTokens.length)
		{
		if(newTokens[index] instanceof Say)
		{
			if(newTokens[index+ONE] instanceof Quote)
			{
				 commandList.add(parseSay());
				 parseCommand();
			}
			else
			{
				error += ((ValueInterface) newTokens[index+ONE]).getValue();
				index += 1;
				parseCommand();
				System.out.println(error);
			}
		}
		else if (newTokens[index] instanceof Move)
		{
			if (table.get(((ValueInterface) newTokens[index+ONE]).getValue()) != null)
			{
				if(newTokens[index+TWO] instanceof NumberInterface && newTokens[index+THREE] instanceof NumberInterface)
				{
					commandList.add(parseMove());
					parseCommand();
				}
				else if(newTokens[index+TWO] instanceof Number == false)
					{
						error += newTokens[index+TWO].getInput();
						System.out.println(error);
					}
				else
				{
					error += newTokens[index+THREE].getInput();
					System.out.println(error);
				}		
			}
			else
			{
				error += newTokens[index+THREE].getInput();
				System.out.println(error);
			}
		}
		else if (newTokens[index] instanceof Approach)
		{
			commandList.add(parseApproach());
			parseCommand();
		}
		
		else if (newTokens[index] instanceof Pass)
		{
			commandList.add(parsePass());
			parseCommand();
		}
		else if (newTokens[index] instanceof Fail)
		{
			commandList.add(parseFail());
			parseCommand();
		}
//		else if (newTokens[index] instanceof Repeat)
//		{
//			commandList.add(parseRepeat());
//			parseCommand();
//		}
		else
		{
			System.out.println(error);
		}
		}
	}
	
	@Tags({"ParseApproach"})
	public Runnable parseApproach()
	{
		Runnable approach = new ApproachCommand(bridgeScene, (AvatarInterface)table.get((((ValueInterface) newTokens[index+ONE]).getValue())));
		index += 1;
		return approach;
	}
	
	@Tags({"ParsePass"})
	public Runnable parsePass()
	{
		Runnable pass = new PassCommand(bridgeScene);
		index += 1;
		return pass;
	}
	
	@Tags({"ParseFail"})
	public Runnable parseFail()
	{
		Runnable fail = new FailCommand(bridgeScene);
		index += 1;
		return fail;
	}
	
//	@Tags({"ParseCommandList"})
//	public Runnable parseCommandList()
//	{
//		 commandList.parseCommand();
//		return commandList;
//	}
//	
//	@Tags({"Repeat"})
//	public Runnable parseRepeat()
//	{
//		Runnable repeat = new RepeatCommand(((ValueInterface) newTokens[index]).getValue());
//		return repeat;
//	}
	
	@Visible(false)
	public TableInterface<Object, String> getTable(){return table;}
	
	@Tags({"ParseSay"})
	public Runnable parseSay()
	{
		SayCommand say = new SayCommand(bridgeScene, ((ValueInterface) newTokens[index+ONE]).getValue());
		index += 1;
		return say;
	}
	
	@Tags({"ParseMove"})
	public Runnable parseMove()
	{
		MoveCommand move = new MoveCommand((AvatarInterface)table.get((((ValueInterface) newTokens[index+ONE]).getValue())),
				((NumberInterface)newTokens[index+TWO]).getValue(), 
				((NumberInterface)newTokens[index+THREE]).getValue());
		index += 3;
		return move;
	}
}
