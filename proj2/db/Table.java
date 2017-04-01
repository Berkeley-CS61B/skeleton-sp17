package db;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by Joshua Xiao on 2017/3/22.
 *
 * Represent a single table saved in the whole database
 * system.
 */
public class Table {
    // table: save the content of a single table.
    private Map<String, Column> table;
    private int columnSize;
    /**
     * Create a empty table with all the columns.
     * @param cols all column names
     */
    public Table(String[] cols) {
        // Create a empty empty
        table = new TreeMap<>();

        // For each col, we first need to extract the type of the column.
        // then we need to put it to the table
        for (String col : cols) {
            // Extract the column type
            String colType = col.split("\\s")[1];

            // Check for valid type, only allow String, int float, (with case sensitive)
            checkTypeError(colType);

            // Add col to map.
            if (colType.equals("string")) {
                table.put(col, new Column<String>());
            } else if (colType.equals("int")) {
                table.put(col, new Column<Integer>());
            } else {
                table.put(col, new Column<Float>());
            }
        }

        // Cache the column size
        columnSize = 0;
    }

    public Table() {
        table = new TreeMap<>();

        // cache size
        columnSize = 0;
    }

    /**
     * We only allow String, int, float, with case sensitive
     *
     * @param type type needed to check for valid.
     */
    private void checkTypeError(String type) {
        if (!(type.equals("string") || type.equals("int") || type.equals("float"))) {
            System.err.printf("ERROR:%s is incorrect.", type);
        }
    }

    /**
     * Return the table content in a CSV style
     * @return string of a CSV style.
     */
    public String tableInfo() {
        // Get the keys in CSV style
        String info = "";
        // Add the items of the column to the string

        // return string
        return null;
    }

    /**
     * Insert table a single pair
     * to the table.
     */
    public void insertInto() {

    }


    //===================Add method just for test======================
    public Set<String> cols() {
        return table.keySet();
    }

}
