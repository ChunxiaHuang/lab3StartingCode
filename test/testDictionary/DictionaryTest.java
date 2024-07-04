package testDictionary;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import exceptions.DuplicateKeyException;
import exceptions.KeyNotExistException;
import implementations.Dictionary;

/**
 * This is the test class to test the methods in the Dictionary class
 * @author Chunxia Huang, Cankun Na
 */
public class DictionaryTest {

	private Dictionary<Integer, String> dic;
	
	/**
	 * @Before - will execute the method before each test
	 */
	@Before
	public void setUpBeforeClass() {
		dic = new Dictionary<>();
	}

	/**
	 * @After - will execute the method after each test      
	 * @throws Exception
	 */
	@After
	public void tearDownAfterClass() throws Exception
	{
		dic = null;
	}
	
	/**
	 * Test method for {@link DictionaryADT.Dictionary#insert()}.
	 * @throws DuplicateKeyException
	 * @throws KeyNotExistException
	 */
	@Test
	public void testInsert() throws DuplicateKeyException, KeyNotExistException {
		String expected = "one";
		dic.insert(1, "one");
		assertEquals(expected, dic.getByKey(1));
	}
	
	/**
	 * Test method for {@link DictionaryADT.Dictionary#insert()}.
	 */
	@Test
    public void testInsertDuplicateKey() {
        try {
        	dic.insert(1, "one");
        	dic.insert(1, "two"); 
        	fail("Insert did not throw DuplicateKeyException correctly.");
        }
        catch(DuplicateKeyException e) {
        }
    }
	
	/**
	 * Test method for {@link DictionaryADT.Dictionary#removeByKey()}.
	 * @throws DuplicateKeyException
	 * @throws KeyNotExistException
	 */
	@Test
	public void testRemoveByKey() throws DuplicateKeyException, KeyNotExistException {
		String expected = "one";
		dic.insert(1, "one");
		assertEquals(expected, dic.removeByKey(1));
	}
	
	/**
	 * Test method for {@link DictionaryADT.Dictionary#removeByKey()}.
	 */
	@Test
	public void testRemoveKeyNotExist() {
		try {
			dic.removeByKey(5);
			fail("RemoveByKey did not throw KeyNotExistException correctly.");
			
		} catch (KeyNotExistException e) {
			
		}
	}
	
	/**
	 * Test method for {@link DictionaryADT.Dictionary#update()}.
	 * @throws DuplicateKeyException
	 * @throws KeyNotExistException
	 */
	@Test
	public void testUpdate() throws DuplicateKeyException, KeyNotExistException {
		dic.insert(1, "one");
		dic.update(1, "two");
		assertEquals("two", dic.getByKey(1));
	}
	
	/**
	 * Test method for {@link DictionaryADT.Dictionary#update()}.
	 */
	@Test
	public void testUpdateKeyNotExist() {
		try {
			dic.update(5, "five");
			fail("Update did not throw KeyNotExistException correctly.");
			
		} catch (KeyNotExistException e) {
			
		}
	}
	
	/**
	 * Test method for {@link DictionaryADT.Dictionary#getByKey()}.
	 * @throws DuplicateKeyException
	 * @throws KeyNotExistException
	 */
	@Test
	public void testGetByKey() throws DuplicateKeyException, KeyNotExistException {
		dic.insert(1, "one");
		assertEquals("one", dic.getByKey(1));
	}
	
	/**
	 * Test method for {@link DictionaryADT.Dictionary#getByKey()}.
	 */
	@Test
	public void testGetByKeyNotExist() {
		try {
			dic.getByKey(5);
			fail("GetByKey did not throw KeyNotExistException correctly.");
			
		} catch (KeyNotExistException e) {
			
		}
	}
	
}
