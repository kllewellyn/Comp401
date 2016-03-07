package main;
import util.annotations.Tags;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.PropertyNames;
import util.annotations.EditablePropertyNames;

@Tags({"Word"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"Input", "Value"})
@EditablePropertyNames({"Input"})

public class Word implements WordInterface, ValueInterface{

	private String input;
	private String value;
	
	public Word(String s)
	{
		setWord(s);
		value = s.toLowerCase();
	}
	
	public void setWord(String s)
	{
		input = s;
	}
	
	public String getWord()
	{
		return input;
	}

	public String getStringValue() 
	{
		return value;
	}
	
	public int getIntValue()
	{
		return 0;
	}
	
}
