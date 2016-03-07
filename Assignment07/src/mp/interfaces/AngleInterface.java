package mp.interfaces;


public interface AngleInterface extends LocatableInterface {

	public PointInterface getInitialPoint();
	public LineInterface getLeftLine();
	public LineInterface getRightLine();
	public void move(int x, int y);
	
}
