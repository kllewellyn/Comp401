package main;

import mp.objects.Avatar;
import mp.objects.BridgeScene;
import tokens.ScannerBean;
import util.misc.ThreadSupport;
import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;

public class Assignment6 {

	public static void main(String[] args) {
		
		BridgeScene test = new BridgeScene();
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
		
		
//		ScannerBean test1 = new ScannerBean("say 5 8 procEEdAll { SleEp } ");		
//		OEFrame bean = ObjectEditor.edit(test1);
//		bean.refresh();
//		ThreadSupport.sleep(3000);
//		test1.setInput("RotateLeftArm 5    3 \" $#* \" define Call ");
//		bean.refresh();
//		ThreadSupport.sleep(3000);
//		test1.setInput("mOvE coMManDiNterface \" *^&% \" Start thread ");
//		bean.refresh();
//		ThreadSupport.sleep(3000);
//		test1.setInput("reDO rePeat rotaTERightarm 3 9 UNDO WAIT approach");
//		bean.refresh();
//		ThreadSupport.sleep(3000);

		

	}
}