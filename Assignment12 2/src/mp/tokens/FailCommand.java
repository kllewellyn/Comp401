package mp.tokens;

import mp.interfaces.BridgeSceneInterface;
import util.annotations.Tags;

@Tags({"FailCommand"})
public class FailCommand implements Runnable{

	private BridgeSceneInterface bridgeScene;
	
	public FailCommand(BridgeSceneInterface b)
	{
		bridgeScene = b;
	}
	
	public void run()
	{
		bridgeScene.failed();
	}
}
