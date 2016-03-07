package mp.objects;

import java.awt.Component;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import mp.interfaces.BridgeSceneInterface;
import util.annotations.Tags;
@Tags({"ConsoleSceneView"})
public class ConsoleSceneView extends Component implements PropertyChangeListener {

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
		
		
	}

}
