package db.test;

import db.Table;
import org.junit.Test;
import static org.junit.Assert.*;
import db.Column;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Joshua on 3/24/2017.
 */
public class TestTable {

    @Test
    public void testStringArrayConstruct() {
        String[] keys = {"Lastname int", "Firstname string", "TeamName float"};
        Table tb = new Table(keys);


    }
}
