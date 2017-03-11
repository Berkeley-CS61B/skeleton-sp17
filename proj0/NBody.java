public class NBody {

	/**
	 * Return the radius of the universe.
	 * @param: path - the path of the file that save the info about the universe.
	 * @return: the radius of the universe.
	 */
	public static double readRadius(String path) {
		// Create a In object source to read all the source to it.
		In source = new In(path);

		// The radius
		double radius = 0.0;

		// Read the radius from the file.
		if (source.exists() == true) {
			// Skip the first line about the numbers of the planets.
			source.readLine();

			// Get the radius.
			radius = Double.parseDouble(source.readLine());

			// close the file.
			source.close();
		}

		return radius;
	}

	/**
	 * Read all the planets from the file.
	 * @param: path - the path of the file that save the info about the universe.
	 * @return: An array of Planets create by the file. 
	 */
	public static Planet[] readPlanets(String path) {
		// Create a In object source to read all the source to it.
		In source = new In(path);

		// Read the radius from the file.
		if (!source.exists()) {
			return null;
		}

        final int PLANETS_AMOUNTS = Integer.parseInt(source.readLine());

        // Skip the second line about the radius of the planets.
        source.readLine();

        // The return array that contains all the Planets.
        Planet[] planets = new Planet[PLANETS_AMOUNTS];

        // Use a for loop to read all planets
        for (int i = 0; i < PLANETS_AMOUNTS; i++) {
            double xPos = source.readDouble();
            double yPos = source.readDouble();
            double xVel = source.readDouble();
            double yVel = source.readDouble();
            double mass = source.readDouble();
            String imgFileName = source.readString();

            planets[i] = new Planet(xPos, yPos, xVel, yVel, mass, imgFileName);
        }

        // close the file.
        source.close();

		return planets;
	}

	public static void main(String[] args) {
	    // Collect all needed input
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(filename); // Read universe radius.
        Planet[] allPlanets =  readPlanets(filename); // Read all the planets.

         // Debug:
        /*

        System.out.println("Debug...\n" + radius);
        System.out.println();

       
        for (int i = 0; i < allPlanets.length; i++) {
        	System.out.println(allPlanets[i].toString());
        	System.out.println();
        }
        */


        // Drawing the Background
        StdDraw.setXscale(-radius / 2, radius / 2);
		StdDraw.setYscale(-radius / 2, radius / 2); 
        StdDraw.picture(0, 0,
        		 "./images/starfield.jpg", radius, radius);

        // Draw all the planets
        for (int i = 0; i < allPlanets.length; i++) {
        	allPlanets[i].draw();
        }

        double time = 0.0;
        while (time < T) {
        	// Store the force of each monent.
        	double[] xForces = new double[allPlanets.length];
        	double[] yForces = new double[allPlanets.length];
        	for (int i = 0; i < allPlanets.length; i++) {
        		xForces[i] = allPlanets[i].calcNetForceExertedByX(allPlanets);
        		yForces[i] = allPlanets[i].calcNetForceExertedByY(allPlanets);

        	}

        	// Update all planets' state.
        	for (int i = 0; i < allPlanets.length; i++) {
        		allPlanets[i].update(dt, xForces[i], yForces[i]);
        	}

        	// Draw the background img
        	StdDraw.picture(0, 0,
        		 "./images/starfield.jpg", radius, radius);  

        	// Draw all the planets.
        	for (int i = 0; i < allPlanets.length; i++) {
        		allPlanets[i].draw();
        	}      

        	// copy offscreen buffer to onscreen, pause 10 ms
            StdDraw.show(10);


            time += dt;

        }

        // Play the audio
        StdAudio.play("./audio/2001.mid");

        // Print out the universe
        StdOut.printf("%d\n", allPlanets.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < allPlanets.length; i++) {
			StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
   			allPlanets[i].xxPos, allPlanets[i].yyPos, allPlanets[i].xxVel, allPlanets[i].yyVel, allPlanets[i].mass, allPlanets[i].imgFileName);	
}	
    }

}
