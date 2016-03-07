package mp.objects;

import mp.interfaces.AvatarInterface;
import util.annotations.Tags;
import util.misc.ThreadSupport;

@Tags({"Animator"})
public class Animator  {
	
	AvatarInterface avatar;
	

	public Animator(AvatarInterface a)
	{
		avatar = a;
	}
	
	
	public synchronized void animateAvatar()
	{
		avatar.move(10000, 0);
	}
	
	
}
