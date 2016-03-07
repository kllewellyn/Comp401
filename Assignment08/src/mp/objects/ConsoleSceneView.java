package mp.objects;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import util.annotations.Tags;
import mp.interfaces.BridgeSceneInterface;
import mp.interfaces.PropertyListenerSupportInterface;
@Tags({"ConsoleSceneView"})
public class ConsoleSceneView implements PropertyChangeListener {

	BridgeSceneInterface bridgeScene;
	
	public ConsoleSceneView(BridgeSceneInterface bs)
	{
		bridgeScene = bs;
		bridgeScene.getArthur().addPropertyChangeListener(this);
		bridgeScene.getGalahad().addPropertyChangeListener(this);
		bridgeScene.getLancelot().addPropertyChangeListener(this);
		bridgeScene.getGuard().addPropertyChangeListener(this);
		bridgeScene.getRobin().addPropertyChangeListener(this);
	}
	
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		System.out.println(evt);
		
	}

}
