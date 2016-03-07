package mp.objects;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import mp.interfaces.PropertyListenerSupportInterface;
import mp.interfaces.StringShapeInterface;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
@StructurePattern(StructurePatternNames.STRING_PATTERN)
@Tags({"StringShape"})
@PropertyNames({"X", "Y", "Text"})
public class StringShape extends Point implements StringShapeInterface {
	private String text;

	PropertyListenerSupportInterface propertySupport = new PropertyListenerSupport();
	
	public StringShape(String initText, int initX, int initY) {
		super(initX, initY);
		text = initText;
	}
	public String getText() {return text;}
	public void setText(String newVal) {
		String oldVal = text;
		text = newVal;
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Text", oldVal, text));
		
	}

	@Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.add(listener);  
		listener.propertyChange(new PropertyChangeEvent(this, "Text", 0, getText()));
    }
}
