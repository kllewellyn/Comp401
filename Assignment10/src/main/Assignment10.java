package main;

import java.awt.Component;

import javax.swing.JFrame;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import mp.interfaces.BridgeSceneInterface;
import mp.interfaces.CommandInterpreterInterface;
import mp.interfaces.ScannerBeanInterface;
import mp.objects.BridgeScene;
import mp.objects.BridgeScenePainter;
import mp.objects.CommandInterpreter;
import mp.objects.ConsoleSceneView;
import mp.tokens.ScannerBean;
import util.misc.ThreadSupport;

public class Assignment10 {

	public static void main(String[] args) {

		
		BridgeSceneInterface test = new BridgeScene();
		BridgeScenePainter view = new BridgeScenePainter(test);
		ConsoleSceneView console = new ConsoleSceneView(test);
		
		JFrame frame = new JFrame("Bridge Scene");
		frame.add((Component)view);
		frame.setSize(1000, 1000); 
		frame.setVisible(true);
		test.approach(test.getArthur());
		ThreadSupport.sleep(2000);
		test.say("What is your quest: ");
		ThreadSupport.sleep(2000);
		test.say("to pass");
		ThreadSupport.sleep(2000);
		test.passed();
		
		ScannerBeanInterface scan = new ScannerBean("move Arthur 10 20");
		CommandInterpreterInterface commands = new CommandInterpreter(test, scan);
		ThreadSupport.sleep(2000);
		commands.aSynchronousArthur();
		commands.aSynchronousGalahad();
		commands.aSynchronousLancelot();
		commands.aSynchronousRobin();
		ThreadSupport.sleep(2000);
		
		
		
	}

}
