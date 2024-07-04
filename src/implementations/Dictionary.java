package implementations;

import java.util.ArrayList;

import exceptions.DuplicateKeyException;
import exceptions.KeyNotExistException;
import utilities.DictionaryADT;

public class Dictionary<K,V> implements DictionaryADT<K,V>
{
	// constant
	private static final int DEFAULT_SIZE = 10;
	
	// index indicates pairing, e.g. keys[1] is stored at values[1]
	private ArrayList<K> keys;
	private ArrayList<V> values;

	public Dictionary() {
		this.keys = new ArrayList<>(DEFAULT_SIZE);
		this.values = new ArrayList<>(DEFAULT_SIZE);
	}
	@Override
	public void insert(K key, V value) throws DuplicateKeyException {
		if (keys.contains(key)) {
				throw new DuplicateKeyException("Key " + key + " already exists.");
		}
		keys.add(key);
		values.add(value);
		
	}
	@Override
	public V removeByKey(K key) throws KeyNotExistException {
		int index = keys.indexOf(key);
		if (index == -1) {
			throw new KeyNotExistException("Key " + key + " does not exist.");
		}

		keys.remove(index);
		return values.remove(index);

	}
	@Override
	public void update(K key, V value) throws KeyNotExistException {
		int index = keys.indexOf(key);
		if (index == -1) {
			throw new KeyNotExistException("Key " + key + " does not exist.");
		}
		values.set(index, value);
		
	}
	@Override
	public V getByKey(K key) throws KeyNotExistException {
		int index = keys.indexOf(key);
		if (index == -1) {
			throw new KeyNotExistException("Key " + key + " does not exist.");
		}
		return values.get(index);

	}

}
