package mp.objects;

import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import util.annotations.Visible;
@Tags({"BridgeScene"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"Arthur", "Galahad", "Guard", "Lancelot", "Robin", "Gorge", "KnightArea", "GuardArea", "KnightTurn", "Occupied", "Who"})
public class BridgeScene {

	private Avatar arthur;
	private Avatar galahad;
	private Avatar guard;
	private Avatar lancelot;
	private Avatar robin;
	private Gorge gorge;
	private KnightArea knightArea;
	private GuardArea guardArea;
	private boolean occupied;
	private Avatar who;
	private boolean knightTurn;
	
	public BridgeScene()
	{
		arthur = new Avatar(100, 200, "", "arthur.jpg");
		galahad = new Avatar(270, 250, "", "galahad.jpg");
		guard = new Avatar(605, 185, "", "guard.jpg");
		lancelot = new Avatar(100, 500, "", "lancelot.jpg");
		robin = new Avatar(200, 600, "", "robin.jpg");
		occupied = false;
		gorge = new Gorge();
		knightTurn = false;
		knightArea = new KnightArea();
		guardArea = new GuardArea();
	}

	public Avatar getArthur(){return arthur;}
	public Avatar getGalahad(){return galahad;}
	public Avatar getLancelot(){return lancelot;}
	public Avatar getGuard(){return guard;}
	public Avatar getRobin(){return robin;}
	public Gorge getGorge(){return gorge;}
	public KnightArea getKnightArea(){return knightArea;}
	public GuardArea getGuardArea(){return guardArea;}
	public boolean getOccupied(){return occupied;}
	public boolean getKnightTurn(){return knightTurn;}
	@Visible(false)
	public Avatar getWho(){return who;}
	public void move(int x, int y){
		arthur.move(x, y);
		galahad.move(x,  y);
		guard.move(x, y);
		lancelot.move(x, y);
		robin.move(x, y);
	}
	
	public void approach(Avatar a)
	{
		if (occupied==false)
		{
			a.move(380, 0);
			occupied = true;
			who = a;
		}
	}
	
	public void say(String s)
	{
		if (occupied && !knightTurn)
		{
			guard.setTheText(s);
			knightTurn = true;
			guard.getTheText();
		}
		else if (occupied && knightTurn)
		{
			who.setTheText(s);
			knightTurn = false;
			who.getTheText();
		}
	}
	
	public void passed()
	{
		if(getOccupied() && knightTurn == true)
		{
			who.move(500, 200);
			occupied = false;
			who.setTheText("");
			guard.setTheText("");
		}
		
	}
	
	public void failed()
	{
		if (getOccupied() && !knightTurn)
		{
			who.move(400, 300);
			occupied = false;
			who.setTheText("");
			guard.setTheText("");
		}
	}

	
}
