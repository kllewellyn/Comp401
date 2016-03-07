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
@Tags({"Table", "Generics"})
public class Table<V, K> implements TableInterface<V, K>{

	ArrayList<K> keys;
	ArrayList<V> values;
	
	public Table()
	{
		keys = new ArrayList<K>();
		values = new ArrayList<V>();
	}
	
	public void put(K key, V value)
	{
		if(keys.indexOf(key) == -1 && key != null && value != null)
		{
			keys.add(key);
			values.add(value);
		}
	}
	
	public V get(K key)
	{
		if(keys.contains(key))
		{
			int locate = keys.indexOf(key);
			return values.get(locate);
		}
		return null;
	}
	
	public ArrayList<V> getValues()
	{
		return values;
	}
	
	public ArrayList<K> getKeys()
	{
		return keys;
	}


}
