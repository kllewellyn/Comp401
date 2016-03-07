package mp.interfaces;


import java.beans.PropertyChangeListener;

import mp.objects.GuardArea;
import mp.objects.KnightArea;
import util.models.PropertyListenerRegisterer;

public interface BridgeSceneInterface extends PropertyChangeListener, PropertyListenerRegisterer{

	public AvatarInterface getArthur();
	public AvatarInterface getGalahad();
	public AvatarInterface getLancelot();
	public AvatarInterface getGuard();
	public AvatarInterface getRobin();
	public GorgeInterface getGorge();
	public KnightArea getKnightArea();
	public GuardArea getGuardArea();
	public boolean getOccupied();
	public boolean getKnightTurn();
	public AvatarInterface getWho();
	public void approach(AvatarInterface a);
	public void say(String s);
	public void passed();
	public void failed();
	public void move(int x, int y);

}
