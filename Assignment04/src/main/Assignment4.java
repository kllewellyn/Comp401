package main;

import util.misc.ThreadSupport;
import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
public class Assignment4 {

	public static void main(String[] args) {
		BeanScanner test1 = new BeanScanner("say 5 8 procEEdAll { SleEp } ");
		OEFrame editor = ObjectEditor.edit(test1);		
		editor.refresh();
		ThreadSupport.sleep(3000);
		test1.setInput("RotateLeftArm 5    3 \" $#* \" define Call ");
		editor.refresh();
		ThreadSupport.sleep(3000);
		test1.setInput("mOvE coMManDiNterface \" *^&% \" Start thread ");
		editor.refresh();
		ThreadSupport.sleep(3000);
		test1.setInput("reDO rePeat rotaTERightarm 3 9 UNDO WAIT Approach ");
		editor.refresh();
		ThreadSupport.sleep(3000);
	}

}
