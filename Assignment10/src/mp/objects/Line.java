package mp.objects;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import mp.interfaces.LineInterface;
import mp.interfaces.PointInterface;
import mp.interfaces.PropertyListenerSupportInterface;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import util.annotations.Visible;
@StructurePattern(StructurePatternNames.LINE_PATTERN)
@Tags({"Line"})
@PropertyNames({"Width", "Height", "Location"})
@EditablePropertyNames({"Height", "Width", "Location"})
public class Line implements LineInterface{
    int width, height;
    PointInterface location;
    
    PropertyListenerSupportInterface propertySupport = new PropertyListenerSupport();
    
    public Line (Point initLocation, int initWidth, int initHeight) {
    	location = initLocation;
        width = initWidth;
        height = initHeight;    
    }
    
    @Visible(false)
    public PointInterface getLocation(){return location;}
    public void setLocation(PointInterface newLocation)
    {
    	PointInterface oldLoc = location;
    	location = newLocation;
    	propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "location", oldLoc, location));
    }
    public int getWidth() {return width;}
    public void setWidth(int newVal) {
    	int oldWidth = width;
    	width = newVal;
    	propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Width", oldWidth, width));}
    public int getHeight() {return height;}
    public void setHeight(int newHeight) 
    	{
    		int oldVal = height;
    		height = newHeight;
    		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Height", oldVal, height));
    	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		propertySupport.add(listener);
		listener.propertyChange(new PropertyChangeEvent(this, "Width", 0, getWidth()));
		listener.propertyChange(new PropertyChangeEvent(this, "Height", 0, getHeight()));
	
	}
}
