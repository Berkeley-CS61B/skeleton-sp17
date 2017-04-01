package db;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * the connection between command to call function.
 */
public abstract class Command {

    // Save the content of a commond.
    private String query;
    private String commandContents;

    // Various common constructs, simplifies parsing.
    private static final String REST  = "\\s*(.*)\\s*",
            COMMA = "\\s*,\\s*",
            AND   = "\\s+and\\s+";


    // Stage 1 syntax, contains the command name.
    private static final Pattern CREATE_CMD = Pattern.compile("create table " + REST),
            LOAD_CMD   = Pattern.compile("load " + REST),
            STORE_CMD  = Pattern.compile("store " + REST),
            DROP_CMD   = Pattern.compile("drop table " + REST),
            INSERT_CMD = Pattern.compile("insert into " + REST),
            PRINT_CMD  = Pattern.compile("print " + REST),
            SELECT_CMD = Pattern.compile("select " + REST),
            LS_CMD     = Pattern.compile("ls");

    // Stage 2 syntax, contains the clauses of commands.
    private static final Pattern CREATE_NEW  = Pattern.compile("(\\S+)\\s+\\(\\s*(\\S+\\s+\\S+\\s*" +
            "(?:,\\s*\\S+\\s+\\S+\\s*)*)\\)"),
            SELECT_CLS  = Pattern.compile("([^,]+?(?:,[^,]+?)*)\\s+from\\s+" +
                    "(\\S+\\s*(?:,\\s*\\S+\\s*)*)(?:\\s+where\\s+" +
                    "([\\w\\s+\\-*/'<>=!.]+?(?:\\s+and\\s+" +
                    "[\\w\\s+\\-*/'<>=!.]+?)*))?"),
            CREATE_SEL  = Pattern.compile("(\\S+)\\s+as select\\s+" +
                    SELECT_CLS.pattern()),
            INSERT_CLS  = Pattern.compile("(\\S+)\\s+values\\s+(.+?" +
                    "\\s*(?:,\\s*.+?\\s*)*)");

    /**
     * Evaluate the command to call a function.
     * @param query the commond user input.
     */
    public void eval(String query) {
        Matcher m;
        if ((m = CREATE_CMD.matcher(query)).matches()) {
            createTable(m.group(1));
        } else if ((m = LOAD_CMD.matcher(query)).matches()) {
            loadTable(m.group(1));
        } else if ((m = STORE_CMD.matcher(query)).matches()) {
            storeTable(m.group(1));
        } else if ((m = DROP_CMD.matcher(query)).matches()) {
            dropTable(m.group(1));
        } else if ((m = INSERT_CMD.matcher(query)).matches()) {
            insertRow(m.group(1));
        } else if ((m = PRINT_CMD.matcher(query)).matches()) {
            printTable(m.group(1));
        } else if ((m = SELECT_CMD.matcher(query)).matches()) {
            select(m.group(1));
        } else if ((m = LS_CMD.matcher(query)).matches()) {
            ls();
        } else {
            System.err.printf("Malformed query: %s\n", query);
        }
    }



    public void createTable(String expr) {
        Matcher m;
        if ((m = CREATE_NEW.matcher(expr)).matches()) {
            createNewTable(m.group(1), m.group(2).split(COMMA));
        } else if ((m = CREATE_SEL.matcher(expr)).matches()) {
            createSelectedTable(m.group(1), m.group(2), m.group(3), m.group(4));
        } else {
            // This time we set the commond content to nothing
            commandContents = "";

            System.err.printf("Malformed create: %s\n", expr);
        }
    }

    public abstract void ls();

    public abstract void createNewTable(String name, String[] cols);

    public abstract void createSelectedTable(String name, String exprs, String tables, String conds);
    public abstract void loadTable(String name);

    public abstract void storeTable(String name);

    public abstract void dropTable(String name);

    public void insertRow(String expr) {
        Matcher m = INSERT_CLS.matcher(expr);
        if (!m.matches()) {
            System.err.printf("Malformed insert: %s\n", expr);
            return;
        }

        Table table = new Table();
        Object[] objects = new Object[12];
        insertRowToTable(table, objects);
    }

    public abstract void insertRowToTable(Table table, Object[] rowValue);

    public abstract void printTable(String name);

    public void select(String expr) {
        Matcher m = SELECT_CLS.matcher(expr);
        if (!m.matches()) {
            System.err.printf("Malformed select: %s\n", expr);
            return;
        }

        selectWithCondtions(m.group(1), m.group(2), m.group(3));
    }

    public abstract void selectWithCondtions(String exprs, String tables, String conds);

    public String getCommandContents() {
        return commandContents;
    }

    public void setCommandContents(String contents) {
        commandContents = contents;
    }
}
