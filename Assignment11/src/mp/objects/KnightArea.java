package mp.objects;


import java.beans.PropertyChangeListener;

import mp.interfaces.CircleInterface;
import mp.interfaces.KnightInterface;
import mp.interfaces.PropertyListenerSupportInterface;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.Tags;
@Tags({"KnightArea"})
@PropertyNames({"KnightArea"})
@StructurePattern("Bean Pattern")
public class KnightArea implements KnightInterface{

	private CircleInterface knightArea;
	
	PropertyListenerSupportInterface propertySupport = new PropertyListenerSupport();
	
	
	private final static int CIRCLE_X = 425, CIRCLE_Y = 250, CIRCLE_R = 110;
	
	public KnightArea()
	{
		knightArea = new Circle(CIRCLE_X, CIRCLE_Y, CIRCLE_R, CIRCLE_R);
	}
	
	public CircleInterface getKnightArea(){return knightArea;}
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		propertySupport.add(listener);
	}
	
}
