package main;

import java.util.ArrayList;

import mp.interfaces.BridgeSceneInterface;
import mp.interfaces.CommandInterpreterInterface;
import mp.interfaces.ScannerBeanInterface;
import mp.objects.BridgeScene;
import mp.objects.CommandInterpreter;
import mp.tokens.ScannerBean;
import util.misc.ThreadSupport;
import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;

public class Assignment7 {

	public static void main(String[] args) {
		
		BridgeSceneInterface test = new BridgeScene();
		OEFrame editor = ObjectEditor.edit(test);
		editor.setSize(1000, 1000);
		editor.refresh();
		ThreadSupport.sleep(3000);
		test.approach(test.getArthur());
		editor.refresh();
		ThreadSupport.sleep(3000);
		test.say("Who is it?");
		editor.refresh();
		ThreadSupport.sleep(3000);
		test.say("It is Arthur");
		editor.refresh();
		ThreadSupport.sleep(3000);
		test.say("You have passed");
		editor.refresh();
		ThreadSupport.sleep(3000);
		test.passed();
		editor.refresh();
		ThreadSupport.sleep(3000);
		
		ScannerBeanInterface test1 = new ScannerBean("");		
		OEFrame bean = ObjectEditor.edit(test1);
		bean.refresh();
		ThreadSupport.sleep(3000);
		test1.setInput("RotateLeftArm 5887    3 \" $#* \" define Call ");
		bean.refresh();
		ThreadSupport.sleep(3000);
		test1.setInput("mOvE coMManDiNterface \" *^&% \" Start thread ");
		bean.refresh();
		ThreadSupport.sleep(3000);
		test1.setInput("reDO rePeat rotaTERightarm 3 9 UNDO WAIT approach");
		bean.refresh();
		ThreadSupport.sleep(3000);
		
		CommandInterpreterInterface test2 = new CommandInterpreter(test, test1);
		OEFrame command = ObjectEditor.edit(test2);
		command.refresh();
		ThreadSupport.sleep(3000);
		test2.setCommand("move arthur 32 4 ");
		test2.command();
		command.refresh();
		bean.refresh();
		editor.refresh();
		ThreadSupport.sleep(3000);
		
		ArrayList<String> keys = test2.getTable().getKeys();
		for (int k = 0; k < keys.size(); k++)
		{
			System.out.println(keys.get(k));
		}
		
		ArrayList<Object> obj = test2.getTable().getValues();
		for(int p = 0; p < obj.size(); p ++)
		{
			System.out.println(obj.get(p));
		}
		
		test2.getTable().put("Kaylee", new Integer(16));
		System.out.println("Input: Kaylee, 16");
		System.out.println("Key: " + test2.getTable().getKeys().get(test2.getTable().getKeys().size() - 1) + " Value: "
															+ test2.getTable().get("Kaylee"));
		

	}
}