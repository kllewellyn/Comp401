package mp.objects;

import mp.interfaces.BridgeSceneInterface;
import util.annotations.Tags;

@Tags({"SayCommand"})
public class SayCommand implements Runnable{

	BridgeSceneInterface bridgeScene;
	String say;
	
	public SayCommand(BridgeSceneInterface newScene, String command)
	{
		bridgeScene = newScene;
		say = command;
	}
	
	@Override
	public void run() {
		bridgeScene.say(say);
	}

}
