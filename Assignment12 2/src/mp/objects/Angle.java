package mp.objects;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import mp.interfaces.AngleInterface;
import mp.interfaces.LineInterface;
import mp.interfaces.PointInterface;
import mp.interfaces.PropertyListenerSupportInterface;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import util.annotations.Visible;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@Tags({"Angle"})
@PropertyNames({"X", "Y", "Width", "Height", "LeftLine", "RightLine", "InitialPoint"})
@EditablePropertyNames({"X", "Y", "Width", "Height"})
public class Angle extends BoundedShape implements AngleInterface{

	LineInterface leftLine;
	LineInterface rightLine;
	PointInterface initialPoint;
	
	PropertyListenerSupportInterface propertySupport = new PropertyListenerSupport();

	private static final int NOARGS_X = 200, NOARGS_Y = 600, NOARGS_W = 50, NOARGS_H = 75;
	
	public Angle()
	{
		super(NOARGS_X, NOARGS_Y, NOARGS_W, NOARGS_H);
		initialPoint = new Point(NOARGS_X, NOARGS_Y);
		leftLine = new Line((Point) initialPoint, getWidth(), getHeight());
		rightLine = new Line((Point) initialPoint, -getWidth(), getHeight());
		getLeftLine();
		getRightLine();
	}
	
	public Angle(int x, int y, int w, int h)
	{
		super(x, y, w, h);
		initialPoint = new Point(x, y);
		leftLine = new Line((Point)initialPoint, getWidth(), getHeight());
		rightLine = new Line((Point)initialPoint, -getWidth(), getHeight());
	}
	
	@Visible(false)
	public PointInterface getInitialPoint()
	{
		return initialPoint;
	}
	
	public LineInterface getLeftLine()
	{
		return leftLine;
	}
	
	public LineInterface getRightLine()
	{
		return rightLine;
	}
	
	public void move(int xMove, int yMove)
	{
		initialPoint.setX(xMove + initialPoint.getX());
				propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "X", initialPoint.getX(), xMove + initialPoint.getX()));
		initialPoint.setY(yMove + initialPoint.getY());
				propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Y", initialPoint.getY(), yMove + initialPoint.getY()));
		leftLine.setLocation((Point)initialPoint);
		rightLine.setLocation((Point)initialPoint);
	}
	
	  @Override
	    public void addPropertyChangeListener(PropertyChangeListener listener) {
	        propertySupport.add(listener); 
	  }
}
