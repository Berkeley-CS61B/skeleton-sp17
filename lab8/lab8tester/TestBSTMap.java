package lab8tester;
import static org.junit.Assert.*;
import org.junit.Test;
import lab8.BSTMap;

import java.util.HashSet;
import java.util.Set;

/** Tests by Brendan Hu, Spring 2015, revised for 2016 by Josh Hug */
public class TestBSTMap {

	@Test
    public void sanityGenericsTest() {
    	try {
    		BSTMap<String, String> a = new BSTMap<String, String>();
	    	BSTMap<String, Integer> b = new BSTMap<String, Integer>();
	    	BSTMap<Integer, String> c = new BSTMap<Integer, String>();
	    	BSTMap<Boolean, Integer> e = new BSTMap<Boolean, Integer>();
	    } catch (Exception e) { 
	    	fail();
	    }
    }

    //assumes put/size/containsKey/get/printInOrder work
	@Test
    public void sanityClearTest() {
    	BSTMap<String, Integer> b = new BSTMap<String, Integer>();
        for (int i = 0; i < 455; i++) {
            b.put("hi" + i, 1);
            //make sure put is working via containsKey and get
            assertTrue( null != b.get("hi" + i)
                        && b.containsKey("hi" + i)); 
        }

        b.printInOrder();

        b.clear();
        assertEquals(0, b.size());
        for (int i = 0; i < 455; i++) {
            assertTrue(null == b.get("hi" + i) && !b.containsKey("hi" + i));
        }
    }

    // assumes put works
    @Test
    public void sanityContainsKeyTest() {
    	BSTMap<String, Integer> b = new BSTMap<String, Integer>();
        assertFalse(b.containsKey("waterYouDoingHere"));
        b.put("waterYouDoingHere", 0);
        assertTrue(b.containsKey("waterYouDoingHere"));
    }

    // assumes put works
    @Test
    public void sanityGetTest() {
    	BSTMap<String, Integer> b = new BSTMap<String, Integer>();
        assertEquals(null,b.get("starChild"));
        b.put("starChild", 5);
        assertNotEquals(null,b.get("starChild"));
        b.put("KISS", 5);
        assertNotEquals(null,b.get("KISS"));
        assertNotEquals(null,b.get("starChild"));
    }

    // assumes put works
    @Test
    public void sanitySizeTest() {
    	BSTMap<String, Integer> b = new BSTMap<String, Integer>();
        assertEquals(0, b.size());
        b.put("hi", 1);
        assertEquals(1, b.size());
        for (int i = 0; i < 455; i++)
            b.put("hi" + i, 1);
        assertEquals(456, b.size());
    }

    //assumes get/containskey work
    @Test
    public void sanityPutTest() {
    	BSTMap<String, Integer> b = new BSTMap<String, Integer>();
        b.put("hi", 1);
        assertTrue(b.containsKey("hi") && b.get("hi") != null);
    }

    // assume min/deleteMin work
    @Test
    public void TestMinDeleteMin() {
        BSTMap<String, Integer> b = new BSTMap<String, Integer>();
        b.put("a", 1);
        b.put("b", 1);
        b.put("c", 1);
        b.put("d", 1);

        BSTMap<String, Integer> c = new BSTMap<String, Integer>();
        c.put("b", 1);
        c.put("c", 1);
        c.put("d", 1);

        assertEquals("a", b.min());
        b.deleteMin();

    }

    // assume remove work
    @Test
    public void TestRemove() {
        BSTMap<String, Integer> b = new BSTMap<String, Integer>();
        b.put("a", 1);
        b.put("b", 1);
        b.put("c", 1);
        b.put("d", 1);

        b.remove("a");
        b.remove("b");
        b.remove("c");
        b.remove("d");

        assertEquals(0, b.size());
    }

    // Assume keySet work
    @Test
    public void TestKeySet() {
        BSTMap<String, Integer> b = new BSTMap<String, Integer>();
        b.put("a", 1);
        b.put("b", 1);
        b.put("c", 1);
        b.put("d", 1);

        Set<String> keys = b.keySet();

        Set<String> keysExpected = new HashSet<>();
        keysExpected.add("a");
        keysExpected.add("b");
        keysExpected.add("c");
        keysExpected.add("d");

        assertEquals(keysExpected, keys);

    }


    public static void main(String[] args) {
        jh61b.junit.TestRunner.runTests(TestBSTMap.class);
    }
}