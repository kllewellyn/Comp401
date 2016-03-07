package mp.interfaces;

import mp.objects.Avatar;

public interface BridgeSceneInterface {

	public Avatar getArthur();
	public Avatar getGalahad();
	public Avatar getLancelot();
	public Avatar getGuard();
	public Avatar getRobin();
	public void move(int x, int y);
}
