package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(5);
        arb.enqueue(1);
        arb.enqueue(1);
        arb.enqueue(1);
        arb.enqueue(1);
        arb.enqueue(1);


    }

    @Test
    public void testDequeue() {
        System.out.println("------Test dequeue method---------");
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(4);
        arb.enqueue(11);
        assertEquals(arb.dequeue(), new Integer(11));
        arb.enqueue(12);
        arb.enqueue(13);
        arb.enqueue(14);
        arb.enqueue(15);
        arb.dequeue();

        System.out.print("----------dequeue method passed.-----");

        for (int i: arb) {
            System.out.print(i + " ");
        }


    }

    @Test
    public void testConstructor() {
        BoundedQueue<Integer> arb = new ArrayRingBuffer<>(6);
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
