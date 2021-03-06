package mp.tokens;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Start"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"Input", "Value"})
@EditablePropertyNames({"Input"})
public class Start extends Approach{
	
	public Start(String s)
	{
		super(s);
	}

}
