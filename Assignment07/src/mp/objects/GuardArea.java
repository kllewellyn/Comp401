package mp.objects;

import mp.interfaces.CircleInterface;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.Tags;
@Tags({"GuardArea"})
@PropertyNames({"GuardArea"})
@StructurePattern("Bean Pattern")
public class GuardArea {
	
	private CircleInterface guardArea;
	
	private final static int CIRCLE_X = 550, CIRCLE_Y = 250, CIRCLE_D = 110;
		
	public GuardArea()
	{
		guardArea = new Circle(CIRCLE_X, CIRCLE_Y, CIRCLE_D, CIRCLE_D);
	}
		
	public CircleInterface getGuardArea(){return guardArea;}
		
}
