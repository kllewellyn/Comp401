package mp.objects;
import mp.interfaces.PointInterface;
import util.annotations.Explanation;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
@StructurePattern(StructurePatternNames.POINT_PATTERN)
@Explanation("Uses Cartesian representation.")
public class Point extends Locatable implements PointInterface {	

	public Point(int theX, int theY) {
		super(theX, theY);
	}
}
