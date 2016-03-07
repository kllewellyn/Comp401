package mp.objects;

import mp.interfaces.LocatableInterface;
import util.annotations.Visible;

public class Locatable implements LocatableInterface{
	
	private int x, y;
	
	public Locatable(int x1, int y1)
	{
		x = x1;
		y = y1;
	}
	
	public void setX(int newX)
	{
		x = newX;
	}
	
	public void setY(int newY)
	{
		y = newY;
	}
	@Visible(false)
	public int getX(){return x;}
	@Visible(false)
	public int getY(){return y;}

}
