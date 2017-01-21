public class NBody {

	public static Planet[] readPlanets(String filename) {
		In in = new In(filename);
		int numPlanets = in.readInt();
		double dummy = in.readDouble();
		Planet[] allPlanets = new Planet[numPlanets];
		for (int i = 0; i < numPlanets; i += 1) {
			double xxPos = in.readDouble();
			double yyPos = in.readDouble();
			double xxVel = in.readDouble();
			double yyVel = in.readDouble();
			double mass = in.readDouble();
			String imgFileName = in.readString();
			allPlanets[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
		}

		return allPlanets;
	}

	public static double readRadius(String filename) {
		In in = new In(filename);
		int dummy = in.readInt();
		return in.readDouble();
	}

	public static void main(String[] args) {
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];

		double radius = readRadius(filename);
		Planet[] planets = readPlanets(filename);

        int numPlanets = planets.length;
        double[] xForces = new double[numPlanets];
        double[] yForces = new double[numPlanets];

		StdDraw.setScale(-radius, radius);
		StdDraw.picture(0, 0, "./images/starfield.jpg");
		for (Planet p : planets) {
			p.draw();
		}

		double t = 0;
		while (t < T) {
			StdDraw.picture(0, 0, "./images/starfield.jpg");
			for (int i = 0; i < numPlanets; i+= 1) {
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
				yForces[i] = planets[i].calcNetForceExertedByY(planets);
			}

			for (int i = 0; i < numPlanets; i+= 1) {
				planets[i].update(dt, xForces[i], yForces[i]);
				planets[i].draw();
            }
			t = t + dt;
			StdDraw.show(10);
		}

		StdOut.printf("%d\n", planets.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < planets.length; i++) {
			StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
           		planets[i].xxPos, planets[i].yyPos, planets[i].xxVel, planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
		}

	}
}
