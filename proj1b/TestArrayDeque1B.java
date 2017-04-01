/**
 * Created by Joshua on 2017/3/12.
 */
import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDeque1B {

    /** Randomly test the method from StudentArrayDeque,
     * Compare the result with the ArrayDequeSolution,
     * until they disgree with each other in the input.
     */
    @Test
    public void randomTestMethods() {
        ArrayDequeSolution<Integer> solution = new ArrayDequeSolution<>();
        StudentArrayDeque<Integer> student = new StudentArrayDeque<>();

        // Operation message
        OperationSequence operations = new OperationSequence();

        int i = 0;
        while (true) {
            double randomNumberBetween0and1 = StdRandom.uniform();

            if (randomNumberBetween0and1 < 0.25) {
                // Call addFirst method for each two Deque
                solution.addFirst(i);
                student.addFirst(i);

                // Add operation
                operations.addOperation(new DequeOperation("addFirst", i));

                // Check if these two mothed have same content.
                assertStudentSolutionEqual(operations.toString(), solution, student);
            } else if (randomNumberBetween0and1 < 0.5) {
                // Call addLast method for each two Deque
                solution.addLast(i);
                student.addLast(i);

                // Add operation
                operations.addOperation(new DequeOperation("addLast", i));

                // Check if these two mothed have same content.
                assertStudentSolutionEqual(operations.toString(), solution, student);
            } else if (randomNumberBetween0and1 < 0.75) {
                // Call removeLast method for each two Deque
                Integer stu = student.removeLast();
                Integer sol = solution.removeLast();

                // Add operation
                operations.addOperation(new DequeOperation("removeLast"));

                // Check if these two mothed have same content.
                assertEquals(operations.toString(), sol, stu);
                assertStudentSolutionEqual(operations.toString(), solution, student);
            } else {
                // Call removeLast method for each two Deque
                Integer stu = student.removeFirst();
                Integer sol = solution.removeFirst();

                // Add operation
                operations.addOperation(new DequeOperation("removeFirst"));

                // Check if these two mothed have same content.
                assertEquals(operations.toString(), sol, stu);
                assertStudentSolutionEqual(operations.toString(), solution, student);
            }
        }

    }

    private void assertStudentSolutionEqual(String operations, ArrayDequeSolution<Integer> solution,
                                            StudentArrayDeque<Integer> student) {
        for (int i = 0; i < solution.size(); i += 1) {
            assertEquals(operations, solution.get(i), student.get(i));
        }
    }
}
