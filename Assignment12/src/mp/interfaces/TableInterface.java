package mp.interfaces;

import java.util.ArrayList;


public interface TableInterface<V, K> {

	public void put(K key, V val);
	public V get (K key);
	public ArrayList<K> getKeys();
	public ArrayList<V> getValues();
}
