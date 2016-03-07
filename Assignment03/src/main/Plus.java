package main;
import util.annotations.Tags;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.PropertyNames;
import util.annotations.EditablePropertyNames;

@Tags({"Plus"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"Input", "Value"})
@EditablePropertyNames({"Input"})
public class Plus implements TokenInterface{

	private String input;
	
	public Plus(String s)
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
		System.out.println(input);
		return input;
	}
}
