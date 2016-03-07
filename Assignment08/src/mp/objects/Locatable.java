package mp.objects;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import mp.interfaces.LocatableInterface;
import mp.interfaces.PropertyListenerSupportInterface;
import util.annotations.Visible;

public class Locatable implements LocatableInterface{
	
	private int x, y;

	PropertyListenerSupportInterface propertySupport = new PropertyListenerSupport();
	
	public Locatable(int x1, int y1)
	{
		x = x1;
		y = y1;
	}
	
	public void setX(int newX)
	{
		int oldVal = x;
		x = newX;
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "X", oldVal, x));
	}
	
	public void setY(int newY)
	{
		int oldVal = y;
		y = newY;
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Y", oldVal, y));
	}
	@Visible(false)
	public int getX(){return x;}
	@Visible(false)
	public int getY(){return y;}
	
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.add(listener);  
		listener.propertyChange(new PropertyChangeEvent(this, "X", 0, getX()));
		listener.propertyChange(new PropertyChangeEvent(this, "Y", 0, getY()));
    }
    
	public int listenerCount() {
		return propertySupport.size();
		
	}

}
