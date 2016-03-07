package mp.objects;


import mp.interfaces.CircleInterface;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
@Tags({"Circle"})
@PropertyNames({"X", "Y", "Height", "Width"})
@StructurePattern(StructurePatternNames.OVAL_PATTERN)
@EditablePropertyNames({"X", "Y", "Height", "Width"})
public class Circle extends BoundedShape implements CircleInterface{

	
	public Circle(int a, int b, int h, int w)
	{
		super(a, b, h, w);
	}

	
}
