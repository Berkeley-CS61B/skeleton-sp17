package p2.codeSamples;
import edu.princeton.cs.introcs.In;

public class InDemo {
	/** Demo to showcase how to import In and set up
	 *  run configurations. To do this, go to run ->
     *  edit configurations, and make sure the working
     *  directory is set equal to the directory that
     *  contains this file. When properly set up, this
     *  code will print itself out. If you're using the
     *  command line to compile and run your program,
     *  you don't need to worry about this setting up
     *  your working directory. However, running this
     *  program will be tricky. Post to Piazza if you
     *  can't figure it out.
	 */
	public static void main(String[] args) {
		In in = new In("InDemo.java");
		System.out.println(in.readAll());
	}
}	
