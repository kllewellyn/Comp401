package mp.interfaces;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public interface PropertyListenerSupportInterface {

	public int size();
	public PropertyChangeListener get (int index);
	public boolean isFull();
	public void add(PropertyChangeListener l);
	public void notifyAllListeners(PropertyChangeEvent event);
	public void remove(PropertyChangeListener element);
	public void remove(int startIndex);
	public void shiftUp(int startIndex);
	public int indexOf(PropertyChangeListener element);
	public boolean member(PropertyChangeListener element);
	public void clear();
	 
	 
}
