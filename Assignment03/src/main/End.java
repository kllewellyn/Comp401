package main;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"End"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"Input", "Value"})
@EditablePropertyNames({"Input"})
public class End {

	private String input;
	
	public End(String s)
	{
		setInput(s);
		getInput();
	}
	
	public void setInput(String s)
	{
		input = s;
	}
	
	public String getInput()
	{
		return input;
	}
}
