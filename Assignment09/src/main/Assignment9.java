package main;

import java.awt.Component;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

import mp.interfaces.BridgeSceneInterface;
import mp.interfaces.ScannerBeanInterface;
import mp.objects.BridgeScene;
import mp.objects.BridgeSceneController;
import mp.objects.BridgeScenePainter;
import mp.objects.CommandInterpreter;
import mp.objects.ConsoleSceneView;
import mp.objects.MenuController;
import mp.tokens.CommandInterpreterController;
import mp.tokens.ScannerBean;
import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;

public class Assignment9 {
	
	
	public static void main(String[] args) {
		BridgeSceneInterface test = new BridgeScene();
		BridgeScenePainter view = new BridgeScenePainter(test);
		
		
		JFrame frame = new JFrame("Bridge Scene");
		frame.add((Component)view);
		frame.setSize(1000, 1000); 
		frame.setVisible(true);
		test.getArthur().move(test.getArthur().getX() + 20, test.getArthur().getY() + 20);
		test.getArthur().setTheText("hello");
		test.getArthur().move(test.getArthur().getX() + 40, test.getArthur().getY() + 10);

		
//		OEFrame editor = ObjectEditor.edit(test);
//		editor.setSize(1000, 1000);
//		sleep(2000);
//			test.getArthur().move(test.getArthur().getX() + 2, test.getArthur().getY() + 2);
//			sleep(2000);
//			test.getArthur().setTheText("Hello");
//			sleep(2000);
//			test.getArthur().setText("Hello");
//			sleep(2000);
//			

		
		JFrame b = new JFrame("Right Marcher");
		JFrame m = new JFrame("Up Marcher");
		JMenuItem menu = new JMenuItem("Up Marcher");
		JButton button = new JButton("Right Marcher");
		b.add(button);
		m.add(menu);
		m.setSize(200, 100);
		m.setVisible(true);
		 b.setSize(100, 100);
		 b.setVisible(true);
		BridgeSceneController control = new BridgeSceneController(test, view, button); 
		control.setModel(test);
		MenuController mc = new MenuController(menu, test);
		control.setModel(test);
		
		
		ConsoleSceneView hello = new ConsoleSceneView(test);
		JFrame commander = new JFrame("CommandInterpreterController");
		ScannerBeanInterface scan = new ScannerBean("move Arthur 10 20 ");
		CommandInterpreter cI = new CommandInterpreter(test, scan);
		JTextField text = new JTextField();
		commander.setLayout(new GridLayout(2,1));
		commander.add(text);
		commander.setSize(150, 100);
		commander.setVisible(true);
		CommandInterpreterController commands = new CommandInterpreterController(text, cI);
		commands.setModel(cI);
	}
	

	public static void sleep(long interval) {
		try {
			Thread.sleep(interval);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
