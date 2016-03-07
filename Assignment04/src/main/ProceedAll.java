package main;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"ProceedAll"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"Input", "Value"})
@EditablePropertyNames({"Input"})
public class ProceedAll implements CommandInterface, ValueInterface{

	private String input;
	private String value;
	
	public ProceedAll(String s)
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
