package main;

import util.annotations.Tags;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.PropertyNames;
import util.annotations.EditablePropertyNames;

@Tags({"Number"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"Input", "Value"})
@EditablePropertyNames({"Input"})

public class Number implements NumberInterface, ValueInterface {

	private String input;
	private int value;
	
	public Number(String s)
	{
		setNum(s);
		getNum();
		value = Integer.parseInt(s);
		getIntValue();
	}
	
	public void setNum(String s)
	{
		input = s;
	}
	
	public String getNum()
	{
		System.out.println(input);
		return input;
	}
	
	public int getIntValue() {
		System.out.println(value);
		return value;
	}

	@Override
	public int getIntValue(int k) {
		// TODO Auto-generated method stub
		return re;
	}

	@Override
	public String getStringValue(String s) {
		// TODO Auto-generated method stub
		return null;
	}
}
