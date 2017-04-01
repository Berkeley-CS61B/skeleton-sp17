package synthesizer;

//Make sure this class is public
public class GuitarString {
    /** Constants. Do not change. In case you're curious, the keyword final means
     * the values cannot be changed at runtime. We'll discuss this and other topics
     * in lecture on Friday. */
    private static final int SR = 44100;      // Sampling Rate
    private static final double DECAY = .996; // energy decay factor

    /* Buffer for storing sound data. */
    private BoundedQueue<Double> buffer;

    /* Create a guitar string of the given frequency.  */
    public GuitarString(double frequency) {
        //       cast the result of this divsion operation into an int. For better
        //       accuracy, use the Math.round() function before casting.
        //       Your buffer should be initially filled with zeros.
        int capacity = (int) Math.round(SR / frequency);
        buffer = new ArrayRingBuffer<>(capacity);
    }


    /* Pluck the guitar string by replacing the buffer with white noise. */
    public void pluck() {
        // Dequeue everything in the buffer, and replace it with random numbers

        // Dequeue everything in the buffer
        while (!buffer.isEmpty()) {
            buffer.dequeue();
        }

        // Replace it with a random numbers
        while (!buffer.isFull()) {
            double r = Math.random() - 0.5;
            buffer.enqueue(r);
        }
    }

    /* Advance the simulation one time step by performing one iteration of
     * the Karplus-Strong algorithm. 
     */
    public void tic() {
        // Dequeue the front sample and enqueue a new sample that is
        double front = buffer.dequeue();
        double lastItem = DECAY * 0.5 * (front + buffer.peek());
        buffer.enqueue(lastItem);
    }

    /* Return the double at the front of the buffer. */
    public double sample() {
            return buffer.peek();
    }
}
