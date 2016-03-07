package mp.objects;

import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
@Tags({"Circle"})
@PropertyNames({"X", "Y", "Height", "Width"})
@StructurePattern(StructurePatternNames.OVAL_PATTERN)
public class Circle {

	private int height, width, x, y;
	
	public Circle(int a, int b, int h, int w)
	{
		height = h;
		width = w;
		x = a;
		y = b;
	}
	
	public int getHeight(){return height;}
	public int getWidth(){return width;}
	public int getX(){return x;}
	public int getY(){return y;}
	
}
