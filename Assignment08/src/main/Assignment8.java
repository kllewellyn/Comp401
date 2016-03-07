package main;

import mp.interfaces.BridgeSceneInterface;
import mp.objects.BridgeScene;
import mp.objects.ConsoleSceneView;
import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;

public class Assignment8 {

	public static void main(String[] args) {
		BridgeSceneInterface scene = new BridgeScene();
//		ConsoleSceneView theMonitor = new ConsoleSceneView(scene);
		OEFrame editor = ObjectEditor.edit(scene);
		editor.setSize(1000, 1000);
		sleep(2000);
			scene.getArthur().move(scene.getArthur().getX() + 2, scene.getArthur().getY() + 2);
			scene.getArthur().setTheText("Hello");
			scene.getArthur().setText("Hello");
			sleep(2000);
	}
	
	public static void sleep(long interval) {
		try {
			Thread.sleep(interval);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
