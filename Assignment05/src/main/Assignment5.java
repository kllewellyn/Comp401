package main;

import grail.BridgeScene;
import util.misc.ThreadSupport;
import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;

public class Assignment5 {

	public static void main(String[] args) {
		
		BridgeScene test = new BridgeScene();
		OEFrame editor = ObjectEditor.edit(test);
		editor.setSize(1000,1000);
		
		for(int i=0;i<100;i++){
			ThreadSupport.sleep(3000);
			if(i<50){
				test.move(10,0);
			}
			else{
				test.move(1,-2);
			}
			editor.refresh();
		}
	}
}