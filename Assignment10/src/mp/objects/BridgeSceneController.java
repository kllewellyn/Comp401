package mp.objects;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import mp.interfaces.BridgeSceneInterface;
import util.annotations.Tags;

@Tags({"BridgeSceneController"})
public class BridgeSceneController implements ActionListener, MouseListener, KeyListener{
	JButton button;
	BridgeSceneInterface aScene;
	BridgeScenePainter aView;
	private int x, y;
	
	private final static int ARTHUR_X = 100, ARTHUR_Y = 200, GALAHAD_X = 270, GALAHAD_Y = 250,
			LANCELOT_X = 100, LANCELOT_Y = 500, ROBIN_X = 200, ROBIN_Y = 600;
	
	  public BridgeSceneController (BridgeSceneInterface newScene, BridgeScenePainter newView, JButton b) {
		  	button = b;
	    	aScene = newScene;
	    	aView = newView;
	    	aView.addMouseListener(this);
	    	aView.addKeyListener(this);
	    	button.addActionListener(this);
	    }  
	  public void setModel(BridgeSceneInterface newScene) {
			aScene = newScene;
		}

		public void actionPerformed(ActionEvent arg0) {
				aScene.move(10, 0);
		}


	    public void mouseClicked(MouseEvent e) {
	    	x = e.getX();
	    	y = e.getY();
	    }    
	    public void mouseEntered(MouseEvent e) {}
	    public void mouseExited(MouseEvent e) {}
	    public void mousePressed(MouseEvent e) {}
	    public void mouseReleased(MouseEvent e) {}  

	    public void processInput() {}
		public void keyTyped(KeyEvent e) {
			System.out.println("Mouse x: " + x);
			System.out.println("Mouse y: " + y);
			if(e.getKeyChar() == 'a')
			{
				aScene.getArthur().move(x - aScene.getArthur().getX(), y - aScene.getArthur().getY());
			}
			if(e.getKeyChar() == 'g')
			{
				aScene.getGalahad().move(x - aScene.getGalahad().getX(), y - aScene.getGalahad().getY());
			}
			if(e.getKeyChar() == 'l')
			{
				aScene.getLancelot().move(x - aScene.getLancelot().getX(), y - aScene.getLancelot().getY());
			}
			if(e.getKeyChar() == 'r')
			{
				aScene.getRobin().move(x - aScene.getRobin().getX(), y - aScene.getRobin().getY());
			}
			if(e.getKeyChar() == 'o')
			{
				aScene.getArthur().move(ARTHUR_X - aScene.getArthur().getX(), ARTHUR_Y - aScene.getArthur().getY());
				aScene.getGalahad().move((GALAHAD_X - aScene.getGalahad().getX()), (GALAHAD_Y - aScene.getGalahad().getY()));
				aScene.getLancelot().move((LANCELOT_X - aScene.getLancelot().getX()), (LANCELOT_Y - aScene.getLancelot().getY()));
				aScene.getRobin().move((ROBIN_X - aScene.getRobin().getX()), (ROBIN_Y - aScene.getRobin().getY()));
			}
		}

		public void keyPressed(KeyEvent e) {
		}

		public void keyReleased(KeyEvent e) {}

}
