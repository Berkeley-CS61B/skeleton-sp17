/**
 * Created by Xiao Shi on 2017/3/15.
 */

import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDeque1B {


    @Test
    public void check() {

        StudentArrayDeque<Integer> sadl = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> adsl = new ArrayDequeSolution<>();
        OperationSequence op_lst = new OperationSequence();

        while (true) {
            double random_select = StdRandom.uniform();
            int i = StdRandom.uniform(100);
            if (random_select < 0.25) {
                //System.out.println("add first " + i);
                sadl.addFirst(i);
                adsl.addFirst(i);
                DequeOperation d_op = new DequeOperation("addFirst", i);
                op_lst.addOperation(d_op);
            } else if (random_select >= 0.25 && random_select < 0.5) {
                //System.out.println("add last " + i);
                sadl.addLast(i);
                adsl.addLast(i);
                DequeOperation d_op = new DequeOperation("addLast", i);
                op_lst.addOperation(d_op);
            } else if (random_select >= 0.75) {
                DequeOperation d_op = new DequeOperation("removeFirst");
                op_lst.addOperation(d_op);
                assertEquals(op_lst.toString(), sadl.removeFirst(), adsl.removeFirst());
            } else {
                DequeOperation d_op = new DequeOperation("removeLast");
                op_lst.addOperation(d_op);
                assertEquals(op_lst.toString(), sadl.removeLast(), adsl.removeLast());
            }

        }
    }
}
