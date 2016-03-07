package mp.objects;

import mp.interfaces.AvatarInterface;
import util.annotations.Tags;
import util.misc.ThreadSupport;

@Tags({"MoveCommand"})
public class MoveCommand implements Runnable {

	AvatarInterface avatar;
	private int x, y;
	private int animationStep;
	private int animationPauseTime;
	
	public MoveCommand(AvatarInterface newAvatar, int newX, int newY)
	{
		avatar = newAvatar;
		x = newX;
		y = newY;
	}
	
	
	@Override
	public void run() {
		avatar.move(x, y);
        }
	

}
