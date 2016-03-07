package mp.objects;

import mp.interfaces.BoundedShapeInterface;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import util.annotations.Visible;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@Tags({"BoundedShape"})
@PropertyNames({"X", "Y", "Height", "Width"})
@EditablePropertyNames({"X", "Y", "Height", "Width"})
public class BoundedShape extends Locatable implements BoundedShapeInterface{
	
	private int height, width;
	
	public BoundedShape(int x1, int y1, int h, int w)
	{
		super(x1, y1);
		height = h;
		width = w;
	}
	
	public void setWidth(int newWidth)
	{
		width = newWidth;
	}
	
	public void setHeight(int newHeight)
	{
		height = newHeight;
	}
	@Visible(false)
	public int getWidth(){return width;}
	@Visible(false)
	public int getHeight(){return height;}

}
