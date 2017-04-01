package db.test;
import db.Database;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 * Created by Joshua on 3/24/2017.
 */
public class TestDataBase {

    @Test
    public void testls() {
        Database db = new Database();
        db.ls();
        String lsContent = "";
        assertEquals(db.transact("ls"), lsContent);
    }

    @Test
    public void TestCreateNewTable() {
        Database db = new Database();
        String[] cols = {"Lastname int", "Firstname float", "TeamName string"};
        db.createNewTable("fans", cols);
        db.ls();
        String lsContent = "fans";
        assertEquals(db.transact("ls"), lsContent);
    }

}
