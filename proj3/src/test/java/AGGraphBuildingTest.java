import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.HashSet;

/**
 * Basic sanity check for your GraphDB construction. This test simply tests a small number of
 * hard coded queries, but if you get them right, your GraphDB class is probably correct.
 */
public class AGGraphBuildingTest {
    private GraphDB graph;
    public static final String OSM_DB_PATH = "berkeley.osm";


    /**
     * Initializes the student GraphDB.
     * Reads in the serialized <code>List</code> of TestParameters.
     * You should not need to modify this code. If you do, then the Autograder
     * may not work with your code.
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        graph = new GraphDB(OSM_DB_PATH);
    }

    @Test
    public void testNodeCount() {
        Iterable<Long> ids = graph.vertices();
        int numberOfNodes = countIterableItems(ids);
        assertFalse("Good progress, but you have not yet implemented the clean operation.",
                numberOfNodes == 130462);
        assertFalse("Make sure you're clearing any temporary way objects when you find that"
                + " your current way is invalid!", numberOfNodes == 123686);
        assertFalse("Make sure you're using endElement to clear out any temporary way objects, your"
                + " graph likely includes nodes corresponding to buildings, though your bug may be"
                + " something else entirely.", numberOfNodes > 40000 && numberOfNodes < 50000);
        assertTrue("Your graph should have 28654 nodes after cleaning. Consider removing the call"
                + " to clean and seeing if you get 130462 nodes as expected as a sanity check on"
                + "  your results before calling clean.", numberOfNodes == 28654);
    }

    @Test
    public void testAdjacent() {
        long v = 3347105714L;
        HashSet<Long> expected = new HashSet<>();
        HashSet<Long> actual = new HashSet<>();
        expected.add(1026001234L);
        expected.add(2291835223L);

        for (long neighbor : graph.adjacent(v)) {
            actual.add(neighbor);
        }
        assertEquals(expected, actual);
    }

    @Test
    public void testLonAndLat() {
        long v = 1790732915L;
        assertEquals(-122.2891056, graph.lon(v), 0.00001);
        assertEquals(37.8885798, graph.lat(v), 0.00001);
    }

    @Test
    public void testDistance() {
        long v = 1790732915L;
        long w = 374609585L;
        assertEquals(0.09785029113589572, graph.distance(v, w), 0.00001);
    }

    @Test
    public void testClosest() {
        double lon = -122.2892;
        double lat = 37.8885;
        assertEquals(1790732915L, graph.closest(lon, lat));
    }

    private <Item> int countIterableItems(Iterable<Item> it) {
        int N = 0;
        for (Item x : it) {
            N += 1;
        }
        return N;
    }
}
