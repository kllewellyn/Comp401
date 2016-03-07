package main;

import util.misc.ThreadSupport;
import mp.interfaces.BridgeSceneInterface;
import mp.interfaces.ClearanceManager;
import mp.interfaces.CommandInterpreterInterface;
import mp.objects.AClearanceManager;
import mp.objects.BridgeScene;
import mp.objects.CommandInterpreter;
import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;

public class Assignment12 {

	public static void main(String[] args) {
		
		BridgeSceneInterface bridge = new BridgeScene();
		ClearanceManager clearance = new AClearanceManager();
		CommandInterpreterInterface commandI = new CommandInterpreter(bridge, clearance);
		
		OEFrame editor = ObjectEditor.edit(bridge);
		editor.setSize(1000, 1000);
		editor.setVisible(true);
		OEFrame manager = ObjectEditor.edit(commandI);
		manager.setSize(200,200);
		manager.setVisible(true);
		OEFrame clearancem = ObjectEditor.edit(clearance);
		clearancem.setSize(500, 500);
		clearancem.setVisible(true);
		ThreadSupport.sleep(100);
		
		commandI.waitingArthur();
		commandI.waitingGalahad();
		commandI.waitingLancelot();
		commandI.waitingRobin();
		
	//	ThreadSupport.sleep(3000);
		
	//	commandI.animateAll();
		
		
		
		
	}
	
	
}
