package mp.interfaces;

public interface CommandInterpreterInterface {
	
	public void setCommand(String s);
	public void command();
	public String getCommand();
	public String getError();
	public TableInterface getTable();
	public ScannerBeanInterface getScannerBean();

}
