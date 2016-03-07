package mp.tokens;

import mp.objects.NumberInterface;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Number"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"Input", "Value"})
@EditablePropertyNames({"Input"})
public class Number implements NumberInterface{

	private String input;
	private int value;
	
	public Number(String s)
	{
		setInput(s);
		getInput();
		getValue();
	}
	
	public void setInput(String s)
	{
		input = s;
		value = Integer.parseInt(s);
	}
	
	public String getInput()
	{
		return input;
	}
	
	public int getValue()
	{
		return value;
	}
}
