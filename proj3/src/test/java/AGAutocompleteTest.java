import org.junit.Test;

import java.util.List;
import java.util.LinkedHashSet;
import java.util.Map;

import static org.junit.Assert.*;

public class AGAutocompleteTest extends AGMapTest {
    /**
     * Test Autocomplete for each prefix, comparing the sets of outputs against each other.
     * @throws Exception
     */
    @Test
    public void testGetLocationsByPrefix() throws Exception {
        for (TestParameters p : params) {
            List<String> studentAutocompleteResult =
                    MapServer.getLocationsByPrefix(p.prefixSearchParam);
            LinkedHashSet<String> studentSet = new LinkedHashSet<>(studentAutocompleteResult);
            LinkedHashSet<String> solutionSet = new LinkedHashSet<>(p.autocompleteResults);

            assertEquals("Autocompletion results differ for prefix " + p.prefixSearchParam,
                    solutionSet, studentSet);
        }
    }

    /**
     * Test location search by full search string, comparing the output lists against each other
     * element by element; note that we assume the most reasonable construction of each of these
     * lists, that is, that they are in order of the locations as they appear in the OSM file.
     * @throws Exception
     */
    @Test
    public void testGetLocations() throws Exception {
        for (TestParameters p : params) {
            List<Map<String, Object>> studentSearchResult =
                    MapServer.getLocations(p.actualSearchParam);
            assertEquals("Search results differ for search term: " + p.actualSearchParam,
                    p.actualSearchResult, studentSearchResult);
        }
    }
}
