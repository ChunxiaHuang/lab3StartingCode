package utilities;

import exceptions.DuplicateKeyException;
import exceptions.KeyNotExistException;

/**
* DictionaryADT.java
*
* @author Chunxia Huang, Cankun Na
* @version major.minor revision number starting at 1.0
* 
* Class Definition: This interface represents the public contract for the
* implementation of Dictionary for the DictionaryADT Lab. 
*/

public interface DictionaryADT<K,V>
{
	 /**
     * Insert a pair of data into the dictionary
     * pre-condition: The key is not present
     * post-condition: A new pair data will be added to the dictionary
     * @param key	the key of the new pair 
     * @param value 	the value of the new pair
	 * @throws DuplicateKeyException is thrown if the key is duplicate
     */
    public void insert(K key, V value) throws DuplicateKeyException;
    
	 /**
     * Remove a pair in the dictionary based on the key
     * pre-condition: The key is present in the dictionary
     * post-condition: The key and the value pair will be removed
     * @param key 	the key whose dictionary pair will be removed
     * @return the value of whose key being removed
     * @throws KeyNotExistException is thrown if the key does not exist
     */
    public V removeByKey(K key) throws KeyNotExistException;
    
	 /**
     * Update the value of an existing key
     * pre-condition: The key is existing in the dictionary
     * post-condition: The value of the existing key will be updated
     * @param key 	the key existing in the dictionary
     * @param value 	the new value for the key
	 * @throws KeyNotExistException is thrown if the key does not exist
     */
    public void update(K key, V value) throws KeyNotExistException;
    
	 /**
     * Look the value based on the key
     * pre-condition: The key is present in the dictionary
     * post-condition: The value is displayed
     * @param key	the key existing in the dictionary
     * @return the value of the key
	 * @throws KeyNotExistException is thrown if the key does not exist 
     */
    public V getByKey(K key) throws KeyNotExistException;
}
