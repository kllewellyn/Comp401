package grail;

import mp.AngleInterface;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Visible;

@StructurePattern(StructurePatternNames.BEAN_PATTERN) 
public class Angle implements AngleInterface{

	Line leftLine;
	Line rightLine;
	Point initialPoint;
	int x, y;
	
	public Angle()
	{	
		setInitialPoint(200, 600);
		leftLine = new Line(initialPoint, 50, 75);
		rightLine = new Line(initialPoint, -50, 75);
		getLeftLine();
		getRightLine();
	}
	
	public Angle(int x, int y)
	{
		setInitialPoint(x, y);
		leftLine = new Line(initialPoint, 50, 75);
		rightLine = new Line(initialPoint, -50, 75);
	}
	
	public void setX(int newX)
	{
		x = newX;
	}
	
	public void setY(int newY)
	{
		y = newY;
	}
	@Visible(false)
	public int getX()
	{
		return x;
	}
	@Visible(false)
	public int getY()
	{
		return y;
	}
	public void setInitialPoint(int x, int y)
	{
		initialPoint = new Point(x, y);
	}
	@Visible(false)
	public Point getInitialPoint()
	{
		return initialPoint;
	}
	
	public Line getLeftLine()
	{
		return leftLine;
	}
	
	public Line getRightLine()
	{
		return rightLine;
	}
	
	public void move(int xMove, int yMove)
	{
		initialPoint.setX(xMove + initialPoint.getX());
		initialPoint.setY(yMove + initialPoint.getY());
		leftLine.setLocation(initialPoint);
		rightLine.setLocation(initialPoint);
	}
}
