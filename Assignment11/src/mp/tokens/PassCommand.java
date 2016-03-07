package mp.tokens;

import mp.interfaces.BridgeSceneInterface;
import util.annotations.Tags;

@Tags({"PassCommand"})
public class PassCommand implements Runnable{

	private BridgeSceneInterface bridgeScene;
	
	public PassCommand(BridgeSceneInterface bS)
	{
		bridgeScene = bS;
	}
	
	public void run()
	{
		bridgeScene.passed();
	}
}
