package mp.interfaces;

import java.util.ArrayList;


public interface TableInterface {

	public void put (String key, Object val);
	public Object get (String key);
	public ArrayList<String> getKeys();
	public ArrayList<Object> getValues();
}
