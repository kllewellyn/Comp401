package mp.objects;

import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.Tags;
@Tags({"GuardArea"})
@PropertyNames({"GuardArea"})
@StructurePattern("Bean Pattern")
public class GuardArea {
	
	private Circle guardArea;
		
	public GuardArea()
	{
		guardArea = new Circle(550, 250, 110, 110);
	}
		
	public Circle getGuardArea(){return guardArea;}
		
}
