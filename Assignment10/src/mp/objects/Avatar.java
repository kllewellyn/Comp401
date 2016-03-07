package mp.objects;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import mp.interfaces.AngleInterface;
import mp.interfaces.AvatarInterface;
import mp.interfaces.ImageShapeInterface;
import mp.interfaces.LineInterface;
import mp.interfaces.PropertyListenerSupportInterface;
import mp.interfaces.StringShapeInterface;
import util.annotations.IsCompositeShape;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import util.annotations.Visible;

@Tags({"Avatar"})
@IsCompositeShape(true)
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"X", "Y", "Body", "Neck", "Feet", "Arms", "Text", "Head", "ImageH", "ImageW", "TheText", "ImageFileName"})
public class Avatar extends Locatable implements AvatarInterface{
	
	int imageH, imageW;
	String text, initImageFileName;
	LineInterface theNeck, theBody;
	AngleInterface theFeet, theArms;
	StringShapeInterface theText;
	ImageShapeInterface theHead;
	
	PropertyListenerSupportInterface propertySupport = new PropertyListenerSupport();
	
	private final static int NOARGS_X = 100, NOARGS_Y = 400, NECK_Y = 75, NECK_H = 25, ZERO_W = 0, BODY_Y = 50, BODY_H = 100,
			ANGLE_Y = 50, ANGLE_H = 50, ANGLE_W = 75, STRING_Y = 85, IMAGE_Y = 75, DIVISOR = 2;
	
	public Avatar()
	{
		super(NOARGS_X, NOARGS_Y);
		text = "defaultGuard";
		initImageFileName = "guard.jpg";
		Icon image = new ImageIcon(initImageFileName);
		imageH = image.getIconHeight();
		imageW = image.getIconWidth();
		theNeck = new Line(new Point(getX(), getY()-NECK_Y), ZERO_W, NECK_H);
		theBody = new Line(new Point(getX(), getY()-BODY_Y), ZERO_W, BODY_H);
		theFeet = new Angle(getX(), getY()+ANGLE_Y, ANGLE_W, ANGLE_H);
		theArms = new Angle(getX(), getY()-ANGLE_Y, ANGLE_W, ANGLE_H);
		theText = new StringShape(text, getX() - imageW/DIVISOR, getY()- imageH - STRING_Y);
		theHead = new ImageShape(initImageFileName, getX() - (imageW/DIVISOR), getY() - IMAGE_Y - imageH, imageH, imageW);
	}
	
	public Avatar(int x, int y, String textInput, String imageFileName)
	{
		super(x, y);
		text = textInput;
		initImageFileName = imageFileName;
		Icon image = new ImageIcon(initImageFileName);
		imageH = image.getIconHeight();
		imageW = image.getIconWidth();
		theNeck = new Line(new Point(getX(), getY()-NECK_Y), ZERO_W, NECK_H);
		theBody = new Line(new Point(getX(), getY()-BODY_Y), ZERO_W, BODY_H);
		theFeet = new Angle(getX(), getY()+ANGLE_Y, ANGLE_W, ANGLE_H);
		theArms = new Angle(getX(), getY()-ANGLE_Y, ANGLE_W, ANGLE_H);
		theText = new StringShape(text, getX() - imageW/DIVISOR, getY()- imageH - STRING_Y);
		theHead = new ImageShape(initImageFileName, getX() - (imageW/DIVISOR), getY() - IMAGE_Y - imageH, imageH, imageW);
	}
		
	public void setText(String newText){
		String oldVal = text;
		text = newText;
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Text", oldVal, text));
		}
	
	public void setImageFileName(String newImageFileName){initImageFileName = newImageFileName;}
	@Visible(false)
	public String getText(){return text;}
	@Visible(false)
	public String getImageFileName(){return initImageFileName;}
	@Visible(false)
	public int getImageH(){return imageH;}
	@Visible(false)
	public int getImageW(){return imageW;}
	public LineInterface getNeck(){return theNeck;}
	public LineInterface getBody(){return theBody;}
	public AngleInterface getFeet(){return theFeet;}
	public AngleInterface getArms(){return theArms;}
	public void setTheText(String s)
		{
			StringShapeInterface temp = theText;
			theText.setText(s);
			propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "TheText", temp, theText));
		}
	public StringShapeInterface getTheText(){return theText;}
	public ImageShapeInterface getHead(){return theHead;}
		
	
	public void moveNeck(int newX, int newY)
	{
		theNeck.setLocation(new Point(theNeck.getLocation().getX() + newX, theNeck.getLocation().getY() + newY));
	}
	public void moveBody(int newX, int newY)
	{
		theBody.setLocation(new Point(theBody.getLocation().getX() + newX, theBody.getLocation().getY() + newY));
	}
	
	public void moveFeet(int newX, int newY)
	{
		theFeet.move(newX, newY);
	}
	
	public void moveArms(int newX, int newY)
	{
		theArms.move(newX, newY);
	}
	
	public void moveHead(int newX, int newY)
	{
		ImageShapeInterface oldHead = theHead;
		theHead.setX(theHead.getX()+newX);
		theHead.setY(theHead.getY()+newY);
			propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Head", oldHead, theHead));
	}
	public void moveNameShape(int newX, int newY)
	{
		theText.setX(theText.getX()+newX);
			propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "X", theText.getX(), newX + theText.getX()));
		theText.setY(theText.getY()+newY);
			propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Y", theText.getY(), theText.getY() + newY));
	}
	
	public void move(int newX, int newY)
	{
		setX(getX()+newX);
		setY(getY()+newY);
		moveNeck(newX, newY);
		moveBody(newX, newY);
		moveFeet(newX, newY);
		moveArms(newX, newY);
		moveHead(newX, newY);
		moveNameShape(newX, newY);
	}
	
	 @Override
	    public void addPropertyChangeListener(PropertyChangeListener listener) {
	        propertySupport.add(listener);  
			listener.propertyChange(new PropertyChangeEvent(this, "Head", 0, getHead()));
			listener.propertyChange(new PropertyChangeEvent(this, "TheText", 0, getTheText()));
			listener.propertyChange(new PropertyChangeEvent(this, "Text", 0, getText()));
	    }
	
}
