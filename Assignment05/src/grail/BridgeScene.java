package grail;

import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
@Tags({"BridgeScene"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"Arthur", "Galahad", "Guard", "Lancelot", "Robin"})
public class BridgeScene {

	Avatar arthur;
	Avatar galahad;
	Avatar guard;
	Avatar lancelot;
	Avatar robin;
	
	public BridgeScene()
	{
		arthur = new Avatar(100, 200, "Arthur", "arthur.jpg");
		galahad = new Avatar(300, 250, "Galahad", "galahad.jpg");
		guard = new Avatar(100, 500, "Guard", "guard.jpg");
		lancelot = new Avatar(500, 500, "Lancelot", "lancelot.jpg");
		robin = new Avatar(700, 300, "Robin", "robin.jpg");
	}

	public Avatar getArthur(){return arthur;}
	public Avatar getGalahad(){return galahad;}
	public Avatar getLancelot(){return lancelot;}
	public Avatar getGuard(){return guard;}
	public Avatar getRobin(){return robin;}
	public void move(int x, int y){
		arthur.move(x, y);
		galahad.move(x,  y);
		guard.move(x, y);
		lancelot.move(x, y);
		robin.move(x, y);
	}
	
	
}
