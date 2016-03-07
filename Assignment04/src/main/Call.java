package main;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Call"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@EditablePropertyNames("Value")
@PropertyNames({"Value", "Input"})
public class Call implements CommandInterface {
	
	private String input;
	private String value;
	
	public Call(String s)
	{
		setInput(s);
		getInput();
		getValue();
	}
	
	public void setInput(String s)
	{
		input = s;
		value = input.toLowerCase();
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
