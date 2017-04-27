package lab14lib;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;

public class GeneratorDrawer {
	private Generator generator;

	public GeneratorDrawer(Generator generator) {
		this.generator = generator;
	}

	public void draw(int numSamples) {
		double[] xValues = new double[numSamples];
		double[] samples = new double[numSamples];
		for (int ii = 0; ii < numSamples; ii += 1) {
			xValues[ii] = ii;
			samples[ii] = generator.next();
		}

		// Create Chart
	    Chart chart = QuickChart.getChart("Generator Output", "X", "Y", "y(x)", xValues, samples);
	 
	    // Show it
	    new SwingWrapper(chart).displayChart();		
		
	}
}
