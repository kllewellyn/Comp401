package mp.interfaces;

public interface AvatarInterface extends LocatableInterface{
	
	public void setText(String newText);
	public void setImageFileName(String newImageFileName);
	public String getText();
	public String getImageFileName();
	public int getImageH();
	public int getImageW();
	public LineInterface getNeck();
	public LineInterface getBody();
	public AngleInterface getFeet();
	public AngleInterface getArms();
	public void setTheText(String s);
	public StringShapeInterface getTheText();
	public ImageShapeInterface getHead();
	public void moveNeck(int newX, int newY);
	public void moveBody(int newX, int newY);
	public void moveFeet(int newX, int newY);
	public void moveArms(int newX, int newY);
	public void moveHead(int newX, int newY);
	public void moveNameShape(int newX, int newY);
	public void move(int newX, int newY);
	
}
