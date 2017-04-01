package db;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Joshua Xiao on 2017/3/22.
 *
 * This the implementation of data base system and the domain specific language,
 * We Use a Map to save all the tables. There are six commands you would
 * like to use to manage you data:
 *
 * (1). insert values to the table.
 * (2). create a new table.
 * (3). load a table from a file with the postfix .tbl.
 * (5). store a table to a file with the postfic .tbl.
 * (6). select columns from various tables to a new table.
 * (7). ls, we can list all the tables' names.
 * For more use, see the command guide tutorials.
 */
public class Database extends Command {

    // tables: used to save all the tables
    // we add to current data base system
    private Map<String, Table> tables;

    /**
     * Create a empty database.
     */
    public Database() {
        // Create a empty database
        tables = new HashMap<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Database database = (Database) o;

        return tables != null ? tables.equals(database.tables) : database.tables == null;
    }

    @Override
    public int hashCode() {
        return tables != null ? tables.hashCode() : 0;
    }

    public String transact(String query) {
        eval(query);
        return getCommandContents();
    }

    /**
     * List all the tables' name in current database.
     */
    @Override
    public void ls() {
        // Get the all the keys using method keySet()
        Set<String> keys = tables.keySet();
        String keyString;  // String format of all tables

        // Empty set, do nothing
        if (keys.isEmpty()) {
            keyString = new String();
        } else {
            // noempty set, convert keySet to a beatiful string
            keyString = new String("All tables:\n");
            for (String key : keys) {
                keyString += (key + "\n");
            }
        }

        // Using setCommandContents to set the content to the string
        setCommandContents(keyString);
    }

    /**
     * Create a empty table with columns' name
     *
     * If we create a table that already exist in the database,
     * we'll get an error.
     * @param name the empty table name
     * @param cols an array contains all the columns name.
     */
    @Override
    public void createNewTable(String name, String[] cols) {
        // Error message checking, create a table that already exist.
        if (tables.containsKey(name)) {
            System.err.printf("ERROR:%s already exist in the database", name);
        }

        // Add a table to the current database.
        // table has only the keys, column is empty.

        // Create a table with name and cols
        Table table = new Table(cols);

        // Add this table to the database
        tables.put(name, table);

        // Set the command content is empty
        setCommandContents("");
    }

    @Override
    public void createSelectedTable(String name, String exprs, String tables, String conds) {
        setCommandContents("In Database class, we use create selected table command");
    }

    @Override
    public void loadTable(String name) {
        setCommandContents("In Database class, we use load table command");
    }

    @Override
    public void storeTable(String name) {
        setCommandContents("In Database class, we use store table command");
    }

    @Override
    public void dropTable(String name) {
        setCommandContents("In Database class, we use drop table command");
    }

    @Override
    public void insertRowToTable(Table table, Object[] rowValue) {
        setCommandContents("In Database class, we use insert row to table command");
    }

    /**
     * Print the table inside of database,
     *
     * If the table is not in the database, print an error.
     * @param name
     */
    @Override
    public void printTable(String name) {
        // Error checking
        if (!tables.containsKey(name)) {
            System.out.printf("Error: %s is not in the database", name);
            setCommandContents("");
        }

        // Get the table using table name
        Table table = tables.get(name);

        // Call the function in the Table class printTable
        String tableContent = table.tableInfo();

        // Set the commond content.
        setCommandContents(tableContent);
    }

    @Override
    public void selectWithCondtions(String exprs, String tables, String conds) {
        setCommandContents("In Database class, we use select command");
    }
}
