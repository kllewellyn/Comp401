package mp.interfaces;


import util.models.PropertyListenerRegisterer;

public interface LocatableInterface extends PropertyListenerRegisterer{

	public void setX(int x);
	public void setY(int y);
	public int getX();
	public int getY();
	
}
