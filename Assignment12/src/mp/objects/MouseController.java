package mp.objects;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import mp.interfaces.BridgeSceneInterface;

public class MouseController implements MouseListener {
	
	BridgeSceneInterface aScene;
	ConsoleSceneView aView;
	private int x, y;
	
	public MouseController(BridgeSceneInterface newScene, ConsoleSceneView newView)
	{
		aScene = newScene;
    	aView = newView;
    	aView.addMouseListener(this);
	}
	public void mouseClicked(MouseEvent e) {
		x = e.getX();
		y = e.getY();		
	}    
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {} 
}
