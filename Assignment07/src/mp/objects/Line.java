package mp.objects;
import mp.interfaces.LineInterface;
import mp.interfaces.PointInterface;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import util.annotations.Visible;
@StructurePattern(StructurePatternNames.LINE_PATTERN)
@Tags({"Line"})
@PropertyNames({"Width", "Height", "Location"})
@EditablePropertyNames({"Height", "Width", "Location"})
public class Line implements LineInterface{
    int width, height;
    PointInterface location;
    
    public Line (Point initLocation, int initWidth, int initHeight) {
    	location = initLocation;
        width = initWidth;
        height = initHeight;    
    }
    
    @Visible(false)
    public PointInterface getLocation(){return location;}
    public void setLocation(PointInterface newLocation){location = newLocation;}
    public int getWidth() {return width;}
    public void setWidth(int newVal) {width = newVal;}
    public int getHeight() {return height;}
    public void setHeight(int newHeight) {height = newHeight;}
}
