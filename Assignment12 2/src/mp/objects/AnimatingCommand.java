package mp.objects;

import mp.interfaces.AvatarInterface;
import mp.interfaces.ClearanceManager;
import util.annotations.Tags;

@Tags({"AnimatingCommand"})
public class AnimatingCommand implements Runnable{
	
	Animator animate;
	ClearanceManager clearanceManager;
	
	public AnimatingCommand(AvatarInterface a)
	{
		animate = new Animator(a);
	}
	
	public AnimatingCommand(AvatarInterface a, ClearanceManager cM)
	{
		animate = new Animator(a);
		clearanceManager = cM;
	}
	

	@Override
	public void run() {
		try{
			clearanceManager.waitForProceed();
		}
			catch(NullPointerException e)
		{
			
		}
		animate.animateAvatar();
	}
		
	}
