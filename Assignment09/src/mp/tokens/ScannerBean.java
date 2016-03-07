package mp.tokens;

import mp.interfaces.CommandInterface;
import mp.interfaces.ScannerBeanInterface;
import mp.objects.NumberInterface;
import util.annotations.StructurePattern;
import util.annotations.Tags;

@StructurePattern("Bean Pattern")
@Tags("Scanner Bean")
public class ScannerBean implements ScannerBeanInterface{

	private String input;
	private CommandInterface[] tokens;
	
	
	public ScannerBean(String s)
	{
		setInput(s);
	}
	
	public void setInput(String s)
	{
		input = s;
		CommandInterface[] storeTokens = new CommandInterface[s.length()];
		
		String temp = "";
		int counter = 0;
		for (int k = 1; k <= input.length(); k++)
		{
			if (Character.isLetter(input.charAt(k-1)))
			{
					temp += input.substring(k-1, k);
			}
			
			else if (Character.isDigit(input.charAt(k-1)))
			{
				if (input.charAt(k-1) != '0' && temp.equals(""))
				{
					temp += input.substring(k-1,  k);
				}
				else if(!temp.equals(""))
				{
					temp+= input.substring(k-1, k);
				}
			}
		
			else if (input.charAt(k-1) == '{')
			{
				temp += input.substring(k-1, k);
				CommandInterface startTok = new Start(temp);
				storeTokens[counter] = startTok;
				counter++;
				temp = "";
			}
			
			else if (input.charAt(k-1) == '}')
			{
				CommandInterface endTok = new End(input.substring(k-1, k));
				storeTokens[counter] = endTok;
				counter++;
			}
			
			else if (input.charAt(k-1) == '+')
			{
				CommandInterface plusTok = new Plus(input.substring(k-1, k));
				storeTokens[counter] = plusTok;
				counter++;
			}
			
			else if (input.charAt(k-1) == '-')
			{
				CommandInterface minusTok = new Minus(input.substring(k-1, k));
				storeTokens[counter] = minusTok;
				counter++;
			}
			
			else if (input.charAt(k-1) == '"')
			{
				temp += input.substring(k-1, k);
				if (!temp.equals("") && temp.length() > 1)
				{
					CommandInterface quoteTok = new Quote(temp);
					storeTokens[counter] = quoteTok;
					counter++;
					temp = "";
				}
			}
			
			else if (!temp.equals("") && temp.charAt(0) == '"')
			{
					temp += input.substring(k-1, k);
			}
			
			else if ((!temp.equals("") && input.charAt(k-1) == ' '))
			{
				if (Character.isDigit(temp.charAt(0)))
				{
					NumberInterface numToken = new Number(temp);
					storeTokens[counter] = numToken;
					counter++;
					temp = "";
				}
				else{
					String tempTest = temp.toLowerCase();
					switch (tempTest){
						case "move": CommandInterface moveCom = new Move(temp);
							storeTokens[counter] = moveCom;
							counter++;
							temp = "";
							break;
						case "call": CommandInterface callCom = new Call(temp);
							storeTokens[counter] = callCom;
							counter++;
							temp = "";
							break;
						case "define": CommandInterface defineCom = new Define(temp);
							storeTokens[counter] = defineCom;
							counter++;
							temp = "";
							break;
						case "proceedall": CommandInterface proceedCom = new ProceedAll(temp);
							storeTokens[counter] = proceedCom;
							counter++;
							temp = "";
							break;
						case "redo": CommandInterface redoCom = new Redo(temp);
							storeTokens[counter] = redoCom;
							counter++;
							temp = "";
							break;
						case "repeat": CommandInterface repeatCom = new Repeat(temp);
							storeTokens[counter] = repeatCom;
							counter++;
							temp = "";
							break;
						case "rotateleftarm": CommandInterface rotateLeftArmCom = new RotateLeftArm(temp);
							storeTokens[counter] = rotateLeftArmCom;
							counter++;
							temp = "";
							break;
						case "rotaterightarm": CommandInterface rotateRightArmCom = new RotateRightArm(temp);
							storeTokens[counter] = rotateRightArmCom;
							counter++;
							temp = "";
							break;
						case "say": CommandInterface sayCom = new Say(temp);
							storeTokens[counter] = sayCom;
							counter++;
							temp = "";
							break;
						case "sleep": CommandInterface sleepCom = new Sleep(temp);
							storeTokens[counter] = sleepCom;
							counter++;
							temp = "";
							break;
						case "thread": CommandInterface threadCom = new Thread(temp);
							storeTokens[counter] = threadCom;
							counter++;
							temp = "";
							break;
						case "undo": CommandInterface undoCom = new Undo(temp);
							storeTokens[counter] = undoCom;
							counter++;
							temp = "";
							break;
						case "wait": CommandInterface waitCom = new Wait(temp);
							storeTokens[counter] = waitCom;
							counter++;
							temp = "";
							break;
						case "approach": CommandInterface approachCom = new Approach(temp);
							storeTokens[counter] = approachCom;
							counter++;
							temp = "";
							break;
						default:
							CommandInterface miscToken = new Word(temp);
							storeTokens[counter] = miscToken;
							counter++;
							temp = "";
						}	
					}
			}
				
		}
		tokens = new CommandInterface[counter];
		for (int i = 0; i < counter; i++)
		{
			tokens[i] = storeTokens[i];
		}
	}
	
	public String getInput()
	{
		return input;
	}

	public CommandInterface[] getTokens()
	{
		return tokens;
	}
}
