package mp.objects;


import mp.interfaces.GorgeInterface;
import mp.interfaces.LineInterface;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.Tags;
@Tags({"Gorge"})
@StructurePattern("Bean Pattern")
@PropertyNames({"LeftGorge", "RightGorge", "BridgeTop", "BridgeBottom"})
public class Gorge implements GorgeInterface{
	
	private LineInterface leftGorge, rightGorge, bridgeTop, bridgeBottom;
	
	private final static int TOP_LEFT_X = 675, TOP_Y = 0, TOP_RIGHT_X = 875, GORGE_H = 1000, GORGE_W = 0,
			BRIDGE_X = 675, BRIDGE_TOP = 250, BRIDGE_BOTTOM = 350, BRIDGE_W = 200, BRIDGE_H = 0;
	
	public Gorge()
	{
		leftGorge = new Line(new Point(TOP_LEFT_X, TOP_Y), GORGE_W, GORGE_H);
		rightGorge = new Line(new Point(TOP_RIGHT_X, TOP_Y), GORGE_W, GORGE_H);
		bridgeTop = new Line(new Point(BRIDGE_X, BRIDGE_TOP), BRIDGE_W, BRIDGE_H);
		bridgeBottom = new Line(new Point(BRIDGE_X, BRIDGE_BOTTOM), BRIDGE_W, BRIDGE_H);	
	}
	
	public LineInterface getLeftGorge(){return leftGorge;}
	public LineInterface getRightGorge(){return rightGorge;}
	public LineInterface getBridgeTop(){return bridgeTop;}
	public LineInterface getBridgeBottom(){return bridgeBottom;}

	
}
