package mp.objects;

import java.beans.PropertyChangeEvent;

import mp.interfaces.AvatarInterface;
import mp.interfaces.BridgeSceneInterface;
import mp.interfaces.CommandInterface;
import mp.interfaces.CommandInterpreterInterface;
import mp.interfaces.PropertyListenerSupportInterface;
import mp.interfaces.ScannerBeanInterface;
import mp.interfaces.TableInterface;
import mp.interfaces.ValueInterface;
import mp.tokens.Move;
import mp.tokens.Parser;
import mp.tokens.Quote;
import mp.tokens.Say;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import util.annotations.Visible;
import util.misc.ThreadSupport;
import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
@PropertyNames({"BridgeScene", "ScannerBean", "Command", "Table", "Error"})
@EditablePropertyNames({"Command"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@Tags({"CommandInterpreter", "ErrorResilient"})
public class CommandInterpreter implements CommandInterpreterInterface{

	private Thread arthur, galahad, lancelot, robin;
	private BridgeSceneInterface bridgeScene;
	private ScannerBeanInterface scannerBean;
	private String command = "";
	private String error = "Invalid input entered: ";
	static int threadNumber = 0;
	private Animator arthurAnimator, galahadAnimator, lancelotAnimator, robinAnimator;
	
	
	PropertyListenerSupportInterface propertySupport = new PropertyListenerSupport();
	
	public CommandInterpreter(BridgeSceneInterface bs, ScannerBeanInterface sb)
	{
		bridgeScene = bs;
		scannerBean = sb;
		arthurAnimator = new Animator(bridgeScene.getArthur());
		galahadAnimator = new Animator(bridgeScene.getGalahad());
		lancelotAnimator = new Animator(bridgeScene.getLancelot());
		robinAnimator = new Animator(bridgeScene.getRobin());
	}
	
	public void setCommand(String s)
	{
		command = s;
		Parser newParser = new Parser(bridgeScene);
		newParser.setCommandText(command);
		Runnable test = newParser.getCommandObject();
		test.run();
	}
	
	public String getCommand(){return command;}
	@Visible(false)
	public String getError(){return error;}
	@Visible(false)
	public ScannerBeanInterface getScannerBean(){return scannerBean;}
	
	
	
	@Tags({"aSynchronousArthur"})
	public void aSynchronousArthur()
	{
		arthur = new Thread(new AnimatingCommand(arthurAnimator));
        arthur.start();
	}
	
	@Tags({"aSynchronousGalahad"})
	public void aSynchronousGalahad()
	{
		galahad = new Thread(new AnimatingCommand(galahadAnimator));
        galahad.start();
	}
	
	@Tags({"aSynchronousLancelot"})
	public void aSynchronousLancelot()
	{
		lancelot = new Thread(new AnimatingCommand(lancelotAnimator));
		lancelot.start();
	}
	
	@Tags({"aSynchronousRobin"})
	public void aSynchronousRobin()
	{
		robin = new Thread(new AnimatingCommand(robinAnimator));
        robin.start();
	}
	
	
}
