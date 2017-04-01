package db;
import java.util.ArrayList;
/**
 * Created by Joshua on 2017/3/22.
 *
 * Represent a single column in a table.
 */
public class Column<Type> {
    // A single column in a table.
    private ArrayList<Type> column;

    /**
     * Create a empty column.
     */
    public Column() {
        column = new ArrayList<>();
    }

    /**
     * Get the item in ith position.
     * @param i item's position
     * @return the item in ith position
     */
    public Type get(int i) {
        return column.get(i);
    }

    /**
     * Get the size of the column.
     * @return the size of the column
     */
    public int size() {
        return column.size();
    }
}
