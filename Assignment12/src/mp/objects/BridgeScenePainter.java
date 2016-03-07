package mp.objects;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import mp.interfaces.AngleInterface;
import mp.interfaces.BridgeSceneInterface;
import mp.interfaces.CircleInterface;
import mp.interfaces.ImageShapeInterface;
import mp.interfaces.KnightInterface;
import mp.interfaces.LineInterface;
import mp.interfaces.StringShapeInterface;
import util.annotations.Tags;
import util.models.PropertyListenerRegisterer;


@Tags({"InheritingBridgeScenePainter"})
public class BridgeScenePainter extends Component implements PropertyChangeListener {
	
	BridgeSceneInterface bridgeScene;
    BasicStroke dotted = new BasicStroke(5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 
            5f, new float[] {2f}, 0f);
    
    public BridgeScenePainter(BridgeSceneInterface theScene){
    	setFocusable(true);
    	bridgeScene = theScene;
    	bridgeScene.getArthur().getFeet().addPropertyChangeListener(this);
    	bridgeScene.getArthur().getHead().addPropertyChangeListener(this);
    	bridgeScene.getArthur().getArms().addPropertyChangeListener(this);
    	bridgeScene.getArthur().getTheText().addPropertyChangeListener(this);
    	bridgeScene.getArthur().getBody().addPropertyChangeListener(this);
    	bridgeScene.getArthur().getNeck().addPropertyChangeListener(this);
    	
    	bridgeScene.getLancelot().getHead().addPropertyChangeListener(this);
    	bridgeScene.getLancelot().getFeet().addPropertyChangeListener(this);
    	bridgeScene.getLancelot().getArms().addPropertyChangeListener(this);
    	bridgeScene.getLancelot().getTheText().addPropertyChangeListener(this);
    	bridgeScene.getLancelot().getBody().addPropertyChangeListener(this);
    	bridgeScene.getLancelot().getNeck().addPropertyChangeListener(this);
    	
    	bridgeScene.getRobin().getFeet().addPropertyChangeListener(this);
    	bridgeScene.getRobin().getHead().addPropertyChangeListener(this);
    	bridgeScene.getRobin().getArms().addPropertyChangeListener(this);
    	bridgeScene.getRobin().getTheText().addPropertyChangeListener(this);
    	bridgeScene.getRobin().getBody().addPropertyChangeListener(this);
    	bridgeScene.getRobin().getNeck().addPropertyChangeListener(this);
    	
    	bridgeScene.getGuard().getFeet().addPropertyChangeListener(this);
    	bridgeScene.getGuard().getHead().addPropertyChangeListener(this);
    	bridgeScene.getGuard().getArms().addPropertyChangeListener(this);
    	bridgeScene.getGuard().getTheText().addPropertyChangeListener(this);
    	bridgeScene.getGuard().getBody().addPropertyChangeListener(this);
    	bridgeScene.getGuard().getNeck().addPropertyChangeListener(this);
    	
    	bridgeScene.getGalahad().getFeet().addPropertyChangeListener(this);
    	bridgeScene.getGalahad().getHead().addPropertyChangeListener(this);
    	bridgeScene.getGalahad().getArms().addPropertyChangeListener(this);
    	bridgeScene.getGalahad().getTheText().addPropertyChangeListener(this);
    	bridgeScene.getGalahad().getBody().addPropertyChangeListener(this);
    	bridgeScene.getGalahad().getNeck().addPropertyChangeListener(this);
    }
   

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(dotted);
        g.setColor(Color.BLACK);     
        draw(g2, bridgeScene);
    }
    
    public void draw(Graphics2D g, BridgeSceneInterface scene) {
    	draw(g, scene.getKnightArea());
    	draw(g, scene.getGuardArea().getGuardArea());
    	draw(g, scene.getGorge().getBridgeBottom());
    	draw(g, scene.getGorge().getBridgeTop());
    	draw(g, scene.getGorge().getLeftGorge());
    	draw(g, scene.getGorge().getRightGorge());
    	
    	draw(g, scene.getArthur().getFeet());
    	draw(g, scene.getArthur().getHead());
    	draw(g, scene.getArthur().getArms());
    	draw(g, scene.getArthur().getTheText());
    	draw(g, scene.getArthur().getBody());
    	draw(g, scene.getArthur().getNeck());
    	
    	draw(g, scene.getGalahad().getFeet());
    	draw(g, scene.getGalahad().getHead());
    	draw(g, scene.getGalahad().getArms());
    	draw(g, scene.getGalahad().getTheText());
    	draw(g, scene.getGalahad().getBody());
    	draw(g, scene.getGalahad().getNeck());
    	
    	draw(g, scene.getLancelot().getFeet());
    	draw(g, scene.getLancelot().getHead());
    	draw(g, scene.getLancelot().getArms());
    	draw(g, scene.getLancelot().getTheText());
    	draw(g, scene.getLancelot().getBody());
    	draw(g, scene.getLancelot().getNeck());
    	
    	draw(g, scene.getGuard().getFeet());
    	draw(g, scene.getGuard().getHead());
    	draw(g, scene.getGuard().getArms());
    	draw(g, scene.getGuard().getTheText());
    	draw(g, scene.getGuard().getBody());
    	draw(g, scene.getGuard().getNeck());
    	
    	draw(g, scene.getRobin().getFeet());
    	draw(g, scene.getRobin().getHead());
    	draw(g, scene.getRobin().getArms());
    	draw(g, scene.getRobin().getTheText());
    	draw(g, scene.getRobin().getBody());
    	draw(g, scene.getRobin().getNeck());
    	
        
    }
    
    public void draw(Graphics2D g, KnightInterface circ)
    {
    	int w = circ.getKnightArea().getWidth();
    	g.drawOval(circ.getKnightArea().getX(), circ.getKnightArea().getY(), w, w);
    }
    
    public void draw(Graphics g, LineInterface line)
    {
    	g.drawLine(line.getLocation().getX(), line.getLocation().getY(), 
    			line.getLocation().getX() + line.getWidth(), line.getLocation().getY() + line.getHeight());
    }
    
    public void draw(Graphics2D g, CircleInterface circ)
    {
    	int w = circ.getWidth();
    	g.drawOval(circ.getX(), circ.getY(), w, w);
    }

    public void draw(Graphics g, StringShapeInterface aLabel) {
        String s = aLabel.getText();
        g.drawString(s, aLabel.getX(), aLabel.getY());      
    }
    
    public void draw(Graphics2D g, ImageShapeInterface anImage) {
        Image img = Toolkit.getDefaultToolkit().getImage(anImage.getImageFileName());
        g.drawImage(img, anImage.getX(), anImage.getY(), this);     
    }
    
    public void draw(Graphics g, AngleInterface angle){
    	g.drawLine(angle.getLeftLine().getLocation().getX(), angle.getLeftLine().getLocation().getY(),
    			angle.getLeftLine().getLocation().getX() - angle.getLeftLine().getWidth(), 
    			angle.getLeftLine().getLocation().getY() + angle.getLeftLine().getHeight());
    	g.drawLine(angle.getRightLine().getLocation().getX(), angle.getRightLine().getLocation().getY(), 
    			angle.getRightLine().getLocation().getX() + angle.getWidth(), 
    			angle.getRightLine().getLocation().getY() + angle.getHeight());
    }
	
	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		repaint();
	}
	
	public void register (PropertyListenerRegisterer aPropertyChangeRegister){
		aPropertyChangeRegister.addPropertyChangeListener(this);        
	}

}
