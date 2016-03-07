package mp.objects;

import java.beans.PropertyChangeEvent;

import mp.interfaces.BridgeSceneInterface;
import mp.interfaces.ClearanceManager;
import mp.interfaces.CommandInterpreterInterface;
import mp.interfaces.PropertyListenerSupportInterface;
import mp.interfaces.ScannerBeanInterface;
import mp.tokens.Parser;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import util.annotations.Visible;
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
	private ClearanceManager clearanceManager;
	
	PropertyListenerSupportInterface propertySupport = new PropertyListenerSupport();
	
	public CommandInterpreter(BridgeSceneInterface bs, ClearanceManager cM)
	{
		bridgeScene = bs;
		clearanceManager = cM;
	}
	
	public void setCommand(String s)
	{
		String old = getCommand();
		command = s;
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Command", old, command));
	}
	
	public void command()
	{
		Parser parse = new Parser(bridgeScene);
		parse.setCommandText(command);
		parse.getCommandObject().run();
		
	}
	
	public String getCommand(){return command;}
	@Visible(false)
	public String getError(){return error;}
	@Visible(false)
	public ScannerBeanInterface getScannerBean(){return scannerBean;}
	
	
	
	@Tags({"aSynchronousArthur"})
	public void aSynchronousArthur()
	{
		arthur = new Thread(new AnimatingCommand(bridgeScene.getArthur()));
		threadNumber++;
        arthur.setName("Arthur" + " " + threadNumber);
        arthur.start();
	}
	
	@Tags({"aSynchronousGalahad"})
	public void aSynchronousGalahad()
	{
		galahad = new Thread(new AnimatingCommand(bridgeScene.getGalahad()));
		threadNumber++;
        galahad.setName("Galahad" + " " + threadNumber);
        galahad.start();
	}
	
	@Tags({"aSynchronousLancelot"})
	public void aSynchronousLancelot()
	{
		lancelot = new Thread(new AnimatingCommand(bridgeScene.getLancelot()));
		threadNumber++;
        lancelot.setName("Lancelot" + " " + threadNumber);
        lancelot.start();
	}
	
	@Tags({"aSynchronousRobin"})
	public void aSynchronousRobin()
	{
		robin = new Thread(new AnimatingCommand(bridgeScene.getRobin()));
		threadNumber++;
        robin.setName("Robin" + " " + threadNumber);
        robin.start();
	}
	
	@Tags({"waitingArthur"})
	public void waitingArthur()
	{
		arthur = new Thread(new AnimatingCommand(bridgeScene.getArthur(), clearanceManager));
		arthur.start();
	}
	
	@Tags({"waitingGalahad"})
	public void waitingGalahad()
	{
		galahad = new Thread(new AnimatingCommand(bridgeScene.getGalahad(), clearanceManager));
		galahad.start();
	}
	
	@Tags({"waitingLancelot"})
	public void waitingLancelot()
	{
		lancelot = new Thread(new AnimatingCommand(bridgeScene.getLancelot(), clearanceManager));
		lancelot.start();
	}
	
	@Tags({"waitingRobin"})
	public void waitingRobin()
	{
		robin = new Thread(new AnimatingCommand(bridgeScene.getRobin(), clearanceManager));
		robin.start();
	}
	
	@Tags({"startAnimation"})
	public void animateAll()
	{
		clearanceManager.proceedAll();
	}
	
	
}
