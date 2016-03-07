package mp.objects;
import mp.interfaces.ImageShapeInterface;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;


@StructurePattern(StructurePatternNames.IMAGE_PATTERN)
@PropertyNames({"X", "Y", "Height", "Width", "ImageFileName"})
public class ImageShape extends BoundedShape implements ImageShapeInterface {
	 String imageFileName;
	 
     public ImageShape (String initImageFileName, int initX, int initY, int initHeight, int initWidth) {	
    	super(initX, initY, initHeight, initWidth);
    	imageFileName = initImageFileName;
     }          
   
    public String getImageFileName() {return imageFileName;}  
    public void setImageFileName(String newVal) {imageFileName = newVal ;}     

}
