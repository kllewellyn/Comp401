package mp.objects;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import mp.interfaces.BridgeSceneInterface;

public class MenuController implements ActionListener{
	JMenuItem menu;
	BridgeSceneInterface aScene;
	
    public MenuController(JMenuItem aMenu, BridgeSceneInterface theScene) {
        menu = aMenu;
        aScene = theScene;
        menu.addActionListener(this);
    }

	public void setModel(BridgeSceneInterface newScene) {
		aScene = newScene;
	}

	public void actionPerformed(ActionEvent arg0) {
			aScene.move(0, -10);
	}

	public void processInput() {}

}