package mp.objects;
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

	public StringShape(String initText, int initX, int initY) {
		super(initX, initY);
		text = initText;
	}
	public String getText() {return text;}
	public void setText(String newVal) {text = newVal;}

}
