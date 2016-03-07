package mp.tokens;

import mp.interfaces.ValueInterface;
import util.annotations.Tags;


@Tags({"TokenAbstract"})
public abstract class Token implements ValueInterface{

	private String input;
	private String value;
	
	public Token(String s)
	{
		setInput(s);
		getInput();
		getValue();
	}
	
	public void setInput(String s)
	{
		input = s;
		value = s.toLowerCase();
	}
	
	public String getInput()
	{
		return input;
	}
	
	public String getValue()
	{
		return value;
	}
	
	
}
