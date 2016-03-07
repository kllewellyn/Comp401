package grail;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import util.annotations.IsCompositeShape;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import util.annotations.Visible;

@Tags({"Avatar"})
@IsCompositeShape(true)
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
public class Avatar {
	
	int locX, locY, imageH, imageW;
	String name, initImageFileName;
	Line theNeck, theBody;
	Angle theFeet, theArms;
	StringShape theName;
	ImageShape theHead;
	
	public Avatar()
	{
		locX = 100;
		locY = 400;
		name = "defaultGuard";
		initImageFileName = "guard.jpg";
		Icon image = new ImageIcon(initImageFileName);
		imageH = image.getIconHeight();
		imageW = image.getIconWidth();
		theNeck = new Line(new Point(locX, locY-75), 0, 25);
		theBody = new Line(new Point(locX, locY-50), 0, 100);
		theFeet = new Angle(locX, locY+50);
		theArms = new Angle(locX, locY-50);
		theName = new StringShape(name, locX - imageW/2, locY- imageH - 85);
		theHead = new ImageShape(initImageFileName, locX - (imageW/2), locY - 75 - imageH, imageH, imageW);
	}
	
	public Avatar(int x, int y, String nameInput, String imageFileName)
	{
		locX = x;
		locY = y;
		name = nameInput;
		initImageFileName = imageFileName;
		Icon image = new ImageIcon(initImageFileName);
		imageH = image.getIconHeight();
		imageW = image.getIconWidth();
		theNeck = new Line(new Point(locX, locY-75), 0, 25);
		theBody = new Line(new Point(locX, locY-50), 0, 100);
		theFeet = new Angle(locX, locY+50);
		theArms = new Angle(locX, locY-50);
		theName = new StringShape(name, locX - imageW/2, locY- imageH - 85);
		theHead = new ImageShape(initImageFileName, locX - (imageW/2), locY - 75 - imageH, imageH, imageW);
	}
		
	public void setX(int newX){locX = newX;}
	public void setY(int newY){locY = newY;}
	public void setName(String newName){name = newName;}
	public void setImageFileName(String newImageFileName){initImageFileName = newImageFileName;}
	@Visible(false)
	public int getX(){return locX;}
	@Visible(false)
	public int getY(){return locY;}
	@Visible(false)
	public String getName(){return name;}
	@Visible(false)
	public String getImageFileName(){return initImageFileName;}
	public Line getNeck(){return theNeck;}
	public Line getBody(){return theBody;}
	public Angle getFeet(){return theFeet;}
	public Angle getArms(){return theArms;}
	public StringShape getNameShape(){return theName;}
	public ImageShape getHead(){return theHead;}
		
	
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
		theHead.setX(theHead.getX()+newX);
		theHead.setY(theHead.getY()+newY);
	}
	public void moveNameShape(int newX, int newY)
	{
		theName.setX(theName.getX()+newX);
		theName.setY(theName.getY()+newY);
	}
	
	public void move(int newX, int newY)
	{
		moveNeck(newX, newY);
		moveBody(newX, newY);
		moveFeet(newX, newY);
		moveArms(newX, newY);
		moveHead(newX, newY);
		moveNameShape(newX, newY);
	}
	
}
