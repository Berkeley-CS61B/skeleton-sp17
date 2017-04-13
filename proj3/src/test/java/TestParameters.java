import java.io.Serializable;
import java.util.Map;
import java.util.List;
import java.util.LinkedList;

/**
 * TestParameters fully describes the inputs and expected outputs for test cases.
 * After being generated (test-case autogeneration code not shown in this file),
 * this information is serialized for testing.
 * @author Kevin Lin
 */
public class TestParameters implements Serializable {
    private static final long serialVersionUID = -8734762013028607322L;
    Map<String, Double> rasterParams;
    Map<String, Double> routeParams;
    Map<String, Object> rasterResult;
    LinkedList<Long> routeResult;
    String prefixSearchParam;
    String actualSearchParam;
    List<Map<String, Object>> actualSearchResult;
    List<String> autocompleteResults;
}
