package mp.objects;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import mp.interfaces.BoundedShapeInterface;
import mp.interfaces.PropertyListenerSupportInterface;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import util.annotations.Visible;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@Tags({"BoundedShape"})
@PropertyNames({"X", "Y", "Height", "Width"})
@EditablePropertyNames({"X", "Y", "Height", "Width"})
public class BoundedShape extends Locatable implements BoundedShapeInterface{
	
	private int height, width;
	
	PropertyListenerSupportInterface propertySupport = new PropertyListenerSupport();
	
	public BoundedShape(int x1, int y1, int h, int w)
	{
		super(x1, y1);
		height = h;
		width = w;
	}
	
	public void setWidth(int newWidth)
	{
		int oldWidth = width;
		width = newWidth;
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Width", oldWidth, width));
	}
	
	public void setHeight(int newHeight)
	{
		int oldHeight = height;
		height = newHeight;
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Height", oldHeight, height));
	}
	@Visible(false)
	public int getWidth(){return width;}
	@Visible(false)
	public int getHeight(){return height;}

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.add(listener);  
		listener.propertyChange(new PropertyChangeEvent(this, "Width", 0, getWidth()));
		listener.propertyChange(new PropertyChangeEvent(this, "Height", 0, getHeight()));
    }
	public int listenerCount() {
		return propertySupport.size();
	}
}
