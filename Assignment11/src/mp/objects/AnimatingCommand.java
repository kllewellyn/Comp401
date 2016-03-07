package mp.objects;

import mp.interfaces.AvatarInterface;
import util.annotations.Tags;
import util.misc.ThreadSupport;

@Tags({"AnimatingCommand"})
public class AnimatingCommand implements Runnable{
	
	Animator animate;
	
	public AnimatingCommand(Animator a)
	{
		animate = a;
	}
	

	@Override
	public void run() {
	
		animate.animateAvatar();

	}
		
	}
