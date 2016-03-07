package mp.objects;

import java.util.ArrayList;

import mp.interfaces.TableInterface;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
@StructurePattern(StructurePatternNames.MAP_PATTERN)
@PropertyNames({"Keys", "Values"})
@Tags({"Table"})
public class Table implements TableInterface{

	ArrayList<String> keys;
	ArrayList<Object> values;
	
	public Table()
	{
		keys = new ArrayList<String>();
		values = new ArrayList<Object>();
	}
	
	public void put(String key, Object value)
	{
		if(keys.indexOf(key) == -1 && key != null && value != null)
		{
			keys.add(key);
			values.add(value);
		}
	}
	
	public Object get(String key)
	{
		if(keys.contains(key))
		{
			int locate = keys.indexOf(key);
			return values.get(locate);
		}
		return null;
	}
	
	public ArrayList<Object> getValues()
	{
		return values;
	}
	
	public ArrayList<String> getKeys()
	{
		return keys;
	}
}
