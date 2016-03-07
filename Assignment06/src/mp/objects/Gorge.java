package mp.objects;

import util.annotations.StructurePattern;

@StructurePattern("Bean Pattern")
public class Gorge {
	
	private Line leftGorge, rightGorge, bridgeTop, bridgeBottom;
	
	public Gorge()
	{
		leftGorge = new Line(new Point(675, 0), 0, 1000);
		rightGorge = new Line(new Point(875, 0), 0, 1000);
		bridgeTop = new Line(new Point(675, 250), 200, 0);
		bridgeBottom = new Line(new Point(675, 350), 200, 0);	
	}
	
	public Line getLeftGorge(){return leftGorge;}
	public Line getRightGorge(){return rightGorge;}
	public Line getBridgeTop(){return bridgeTop;}
	public Line getBridgeBottom(){return bridgeBottom;}
	
}
