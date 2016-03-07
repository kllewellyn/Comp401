package mp.objects;

import mp.interfaces.AvatarInterface;
import util.annotations.Tags;

@Tags({"AnimatingCommand"})
public class AnimatingCommand implements Runnable{
	
	Animator animate;
	AvatarInterface avatar;
	
	public AnimatingCommand(AvatarInterface a)
	{
		animate = new Animator(a);
		avatar = a;
	}
	

	@Override
	public void run() {
		
		animate.animateAvatar(avatar);
	}
		
	}
