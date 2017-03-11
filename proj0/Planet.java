/**
 *
 */
public class Planet {

	/* The fields that describ the planet */
	public  double xxPos;  // Its current x position
	public  double yyPos;  // Its current y position
	public  double xxVel; // Its current velocity in the x direction
	public  double yyVel; // Its current velocity in the y direction
	public  double mass; // Its mass
	public  String imgFileName;  //The name of an image in the images directory that depicts the planet

	/**
	 * Constructor:
	 * construct planet with its positions, velocity,
	 * it mass and its img file name.
	 */
	public Planet(double xP, double yP, double xV,
              double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = "./images/" + img;
	}

	/**
	 * Constructor:
	 * constructor with a copy of another planet.
	 */
	public Planet(Planet p) {
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;
	}

	/**
	 * Calculate the distance between two planets.
	 * @param: p anther planet.
	 * @return: the distance between two planets
	 */
	public double calcDistance(Planet p) {

		return 
		Math.sqrt((xxPos - p.xxPos) * (xxPos - p.xxPos) + (yyPos - p.yyPos) * (yyPos - p.yyPos));
	}

	/**
	 * Calculate the force between two planets.
	 * @param: p - another pannets.
	 * @return the exerted force between two planet.
	 */
	public double calcForceExertedBy(Planet p) {
		// Get the distance between them.
		double distance = this.calcDistance(p);

		// The constant G
		final double G = 6.67e-11;

		return (G * mass * p.mass) / (distance * distance);
	}

	/**
	 * Calculate the force in the x-axis location.
	 * @param: p - another pannets.
	 * @return the x-axis force between two planet.
	 */
	public double calcForceExertedByX(Planet p) {
		// Get the distance between them
		double distance = this.calcDistance(p);

		final double COS = (p.xxPos - xxPos) / distance;

		return this.calcForceExertedBy(p) * COS;
	}

	/**
	 * Calculate the force in the x-axis location.
	 * @param: p - another pannets.
	 * @return the x-axis force between two planet.
	 */
	public double calcForceExertedByY(Planet p) {
		// Get the distance between them
		double distance = this.calcDistance(p);

		final double SIN = (p.yyPos - yyPos) / distance;

		return this.calcForceExertedBy(p) * SIN;
	}

	/**
	 * calculate the sum of the force in the x-axis.
	 * @param: planets - all the planets in the universe.
	 * @return: return the sum of the force in the x-axis. 
	 * 
	 * Hinit: we cannot apply calcForceExertedByX to themselves.
	 * because calcForceExertedBy will become infinite.
	 */
	public double calcNetForceExertedByX(Planet[] planets) {
		// Loop through all the planets to calculate the net force.
		double netForceX = 0.0;
		for (int i = 0; i < planets.length; i++) {
			if (this.equals(planets[i])) {
				continue;
			}
			netForceX += this.calcForceExertedByX(planets[i]);
		}

		return netForceX;
	}

	/**
	 * calculate the sum of the force in the x-axis.
	 * @param: planets - all the planets in the universe.
	 * @return: return the sum of the force in the x-axis. 
	 * 
	 * Hinit: we cannot apply calcForceExertedByX to themselves.
	 * because calcForceExertedBy will become infinite.
	 */
	public double calcNetForceExertedByY(Planet[] planets) {
		// Loop through all the planets to calculate the net force.
		double netForceY = 0.0;
		for (int i = 0; i < planets.length; i++) {
			if (this.equals(planets[i])) {
				continue;
			}			
			netForceY += this.calcForceExertedByY(planets[i]);
		}

		return netForceY;
	}

	/**
	 * Update the planet's velocity and position in a small period of time dt.
	 *
	 * @param: dt - a small period time the force apply to.
	 * @param: xForce - x-axis force that apply to the planet.
	 * @param: yForce - y-axis force that apply to the planet.
	 */
	public void update(double dt, double xForce, double yForce) {
		// Calculate the acceleration of x-axis and y-axis
		double xAcceleration = xForce / mass;
		double yAcceleration = yForce / mass;

		// Update the velocity
		xxVel = xxVel + xAcceleration * dt;
		yyVel = yyVel + yAcceleration * dt;

		// Update the position
		xxPos = xxPos + xxVel * dt;
		yyPos = yyPos + yyVel * dt;
	}

	public void draw() {
		StdDraw.picture(xxPos, yyPos, imgFileName);
	}


	// Debug methods
	public String toString() {
		return "X's position: " + xxPos + "\n" +
			 "Y's position: " + yyPos + "\n" + 
			 "X's velocity: " + xxVel + "\n" +
			 "Y's velocity: " + yyVel + "\n" + 
			 "mass: " + mass + "\n" +
			 "imgFileName: " + imgFileName + "\n";
	}
}
