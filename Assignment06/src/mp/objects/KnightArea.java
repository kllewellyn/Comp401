package mp.objects;

import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.Tags;
@Tags({"KnightArea"})
@PropertyNames({"KnightArea"})
@StructurePattern("Bean Pattern")
public class KnightArea {

	private Circle knightArea;
	
	public KnightArea()
	{
		knightArea = new Circle(425, 250, 110, 110);
	}
	
	public Circle getKnightArea(){return knightArea;}
	
}
