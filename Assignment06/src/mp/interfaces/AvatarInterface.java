package mp.interfaces;

import mp.objects.Angle;
import mp.objects.ImageShape;
import mp.objects.Line;
import mp.objects.StringShape;

public interface AvatarInterface extends AngleInterface{
	
	public void setX(int newX);
	public void setY(int newY);
	public void setName(String newName);
	public void setImageFileName(String newImageFileName);
	public int getX();
	public int getY();
	public String getName();
	public String getImageFileName();
	public Line getNeck();
	public Line getBody();
	public Angle getFeet();
	public Angle getArms();
	public StringShape getNameShape();
	public ImageShape getHead();
	public void moveNeck(int newX, int newY);
	public void moveBody(int newX, int newY);
	public void moveFeet(int newX, int newY);
	public void moveArms(int newX, int newY);
	public void moveHead(int newX, int newY);
	public void moveNameShape(int newX, int newY);
	public void move(int newX, int newY);
}
