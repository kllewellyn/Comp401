package tokens;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Say"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"Input", "Value"})
@EditablePropertyNames({"Input"})
public class Say extends Approach{

	public Say(String s)
	{
		super(s);
	}
}
