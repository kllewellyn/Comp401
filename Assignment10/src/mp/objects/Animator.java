package mp.objects;

import mp.interfaces.AvatarInterface;
import util.annotations.Tags;
import util.misc.ThreadSupport;

@Tags({"Animator"})
public class Animator {
	
	AvatarInterface avatar;
	

	public Animator(AvatarInterface a)
	{
		animateAvatar(a);
	}
	
	
	public void animateAvatar(AvatarInterface a)
	{
		avatar = a;
			avatar.move(50, 0);
	}
	
	
}
