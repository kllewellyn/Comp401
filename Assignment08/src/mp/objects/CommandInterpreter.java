package mp.objects;

import mp.interfaces.AvatarInterface;
import mp.interfaces.BridgeSceneInterface;
import mp.interfaces.CommandInterface;
import mp.interfaces.CommandInterpreterInterface;
import mp.interfaces.ScannerBeanInterface;
import mp.interfaces.TableInterface;
import mp.interfaces.ValueInterface;
import mp.tokens.Minus;
import mp.tokens.Move;
import mp.tokens.Plus;
import mp.tokens.Quote;
import mp.tokens.Say;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import util.annotations.Visible;
@PropertyNames({"BridgeScene", "ScannerBean", "Command", "Table", "Error"})
@EditablePropertyNames({"Command"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@Tags({"CommandInterpreter", "ErrorResilient"})
public class CommandInterpreter implements CommandInterpreterInterface{

	private TableInterface table = new Table();
	private BridgeSceneInterface bridgeScene;
	private ScannerBeanInterface scannerBean;
	private String command = "";
	private String error = "Invalid input entered: ";
	
	private final static int TOKEN_INSTANCE_ZERO = 0, TOKEN_INSTANCE_ONE = 1, TOKEN_INSTANCE_TWO = 2, TOKEN_INSTANCE_THREE = 3;
	
	public CommandInterpreter(BridgeSceneInterface bs, ScannerBeanInterface sb)
	{
		bridgeScene = bs;
		scannerBean = sb;
		table.put("arthur", bridgeScene.getArthur());
		table.put("galahad", bridgeScene.getGalahad());
		table.put("lancelot", bridgeScene.getLancelot());
		table.put("guard", bridgeScene.getGuard());
		table.put("robin", bridgeScene.getRobin());
	}
	
	public void setCommand(String s)
	{
		command = s;
		scannerBean.setInput(command);
	}
	
	public void command()
	{
		CommandInterface[] newTokens = scannerBean.getTokens();
		
		if(newTokens[TOKEN_INSTANCE_ZERO] instanceof Say)
		{
			if(newTokens[TOKEN_INSTANCE_ONE] instanceof Quote)
			{
				bridgeScene.say(newTokens[TOKEN_INSTANCE_ONE].getInput());
			}
			else
			{
				System.out.println(error);
				System.out.println(newTokens[TOKEN_INSTANCE_ONE].getInput());
			}
		}
		else if (newTokens[TOKEN_INSTANCE_ZERO] instanceof Move)
		{
			if (table.get(((ValueInterface) newTokens[TOKEN_INSTANCE_ONE]).getValue()) != null)
			{
				if(newTokens[TOKEN_INSTANCE_TWO] instanceof NumberInterface && newTokens[TOKEN_INSTANCE_THREE] instanceof NumberInterface)
				{
					int moveX = ((NumberInterface)newTokens[TOKEN_INSTANCE_TWO]).getValue();
					int moveY = ((NumberInterface)newTokens[TOKEN_INSTANCE_THREE]).getValue();
					((AvatarInterface)table.get(((ValueInterface)newTokens[TOKEN_INSTANCE_ONE]).getValue())).move(moveX, moveY);
				}
				else if(newTokens[TOKEN_INSTANCE_TWO] instanceof Number == false)
					{
						System.out.println(error);
						System.out.println(newTokens[TOKEN_INSTANCE_TWO].getInput());
					}
				else
				{
					System.out.println(error);
					System.out.println(newTokens[TOKEN_INSTANCE_THREE].getInput());
				}		
			}
			else
			{
				System.out.println(error);
				System.out.println(newTokens[TOKEN_INSTANCE_ONE].getInput());
			}
		}
		else
		{
			System.out.println(error);
		}
	}
	
	public String getCommand(){return command;}
	@Visible(false)
	public String getError(){return error;}
	@Visible(false)
	public TableInterface getTable(){return table;}
	@Visible(false)
	public ScannerBeanInterface getScannerBean(){return scannerBean;}
	
	
	
}
