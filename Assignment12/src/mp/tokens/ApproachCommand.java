package mp.tokens;

import mp.interfaces.AvatarInterface;
import mp.interfaces.BridgeSceneInterface;
import util.annotations.Tags;

@Tags({"ApproachCommand"})
public class ApproachCommand implements Runnable{

	BridgeSceneInterface bridgeScene;
	AvatarInterface avatar;
	
	public ApproachCommand(BridgeSceneInterface b, AvatarInterface a)
	{
		bridgeScene = b;
		avatar = a;
	}

	@Override
	public void run() {
		
		bridgeScene.approach(avatar);
		
	}
	
	
	
}
