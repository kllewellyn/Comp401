package mp.objects;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import mp.interfaces.AvatarInterface;
import mp.interfaces.BridgeSceneInterface;
import mp.interfaces.GorgeInterface;
import mp.interfaces.PropertyListenerSupportInterface;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import util.annotations.Visible;
@Tags({"BridgeScene"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"Arthur", "Galahad", "Guard", "Lancelot", "Robin", "Gorge", "KnightArea", "GuardArea", "KnightTurn", "Occupied", "Who"})
public class BridgeScene implements BridgeSceneInterface{

	private AvatarInterface arthur, galahad, guard, lancelot, robin;
	private KnightArea knightArea;
	private GuardArea guardArea;
	private Gorge gorge;
	private boolean occupied;
	private AvatarInterface who;
	private boolean knightTurn;
	
	private final static int ARTHUR_X = 100, ARTHUR_Y = 200, GALAHAD_X = 270, GALAHAD_Y = 250, GUARD_X = 605, GUARD_Y = 185,
			LANCELOT_X = 100, LANCELOT_Y = 500, ROBIN_X = 200, ROBIN_Y = 600, APPROACH_X =  380, APPROACH_Y = 0, PASSED_X = 500,
			PASSED_Y = 400, FAILED_X = 350, FAILED_Y = 400;
	
	PropertyListenerSupportInterface propertySupport = new PropertyListenerSupport();
	
	public BridgeScene()
	{
		arthur = new Avatar(ARTHUR_X, ARTHUR_Y, "", "arthur.jpg");
		galahad = new Avatar(GALAHAD_X, GALAHAD_Y, "", "galahad.jpg");
		guard = new Avatar(GUARD_X, GUARD_Y, "", "guard.jpg");
		lancelot = new Avatar(LANCELOT_X, LANCELOT_Y, "", "lancelot.jpg");
		robin = new Avatar(ROBIN_X, ROBIN_Y, "", "robin.jpg");
		occupied = false;
		gorge = new Gorge();
		knightTurn = false;
		knightArea = new KnightArea();
		guardArea = new GuardArea();
		
	}

	public AvatarInterface getArthur(){return arthur;}
	public AvatarInterface getGalahad(){return galahad;}
	public AvatarInterface getLancelot(){return lancelot;}
	public AvatarInterface getGuard(){return guard;}
	public AvatarInterface getRobin(){return robin;}
	public GorgeInterface getGorge(){return gorge;}
	public KnightArea getKnightArea(){return knightArea;}
	public GuardArea getGuardArea(){return guardArea;}
	@Visible(false)
	public boolean getOccupied(){return occupied;}
	@Visible(false)
	public boolean getKnightTurn(){return knightTurn;}
	@Visible(false)
	public AvatarInterface getWho(){return who;}
	public void move(int x, int y){
		arthur.move(x, y);
		galahad.move(x,  y);
		guard.move(x, y);
		lancelot.move(x, y);
		robin.move(x, y);
	}
	
	public void approach(AvatarInterface a)
	{
		if (occupied==false)
		{
			a.move(APPROACH_X, APPROACH_Y);
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
			who.move(PASSED_X, (int)(PASSED_Y*Math.random()));
			occupied = false;
			who.setTheText("");
			guard.setTheText("");
		}
	}
	
	public void failed()
	{
		if (getOccupied() && !knightTurn)
		{
			who.move(FAILED_X, (int)(FAILED_Y*Math.random()));
			occupied = false;
			who.setTheText("");
			guard.setTheText("");
		}
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		propertySupport.add(listener);
	}

	
}
