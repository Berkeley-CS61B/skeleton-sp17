package p2.codeSamples;
import org.junit.Test;
import static org.junit.Assert.*;

/** This class showcases how you can test private methods
 *  without making them public! The key trick is to make
 *  a nested private class that contains your tests.
 *  If you're running from the command line, you'll need
 *  to add a main method as described in lab3b.
 *
 *  To run the tests, you might need to right click
 *  on the TestTheOuterClassPrivateMethods class down
 *  below!
 */
public class NestedTestClasses {
	private int value;

	public NestedTestClasses(int v) {
		value = v;
	}

	private void square() {
		value = value * value;
	}

	private void accumulate(int x) {
		value = x + value;
	}

	private int value() {
		return value;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NestedTestClasses that = (NestedTestClasses) o;

        return value == that.value;
    }

    @Override
    public int hashCode() {
        return value;
    }

    public static class TestTheOuterClassPrivateMethods {
		@Test
		public void testSquare() {
			NestedTestClasses x = new NestedTestClasses(10);
			x.square();
			assertEquals(100, x.value());
		}

		@Test
		public void testPlus() {
			NestedTestClasses x = new NestedTestClasses(20);
			x.accumulate(10);
			assertEquals(30, x.value());
		}

        @Test
        public void testValueEquals() {
            NestedTestClasses x = new NestedTestClasses(20);
            x.accumulate(10);
            NestedTestClasses y = new NestedTestClasses(30);
            assertEquals(y, x);
        }
	}
} 