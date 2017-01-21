public class Planet {
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;

	public Planet(double xP, double yP, double xV, double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Planet(Planet p) {
		this.xxPos = p.xxPos;
		this.yyPos = p.yyPos;
		this.xxVel = p.xxVel;
		this.yyVel = p.yyVel;
		this.mass = p.mass;
		this.imgFileName = p.imgFileName;
	}

	public double calcDistance(Planet p) {
		double dx = xxPos - p.xxPos;
		double dy = yyPos - p.yyPos;

		return Math.sqrt(dx*dx + dy*dy);
	}

	public double calcForceExertedBy(Planet p) {
		double r = calcDistance(p);
		double r2 = r*r;
		return 6.67E-11 * mass * p.mass / r2;
	}

	public double calcForceExertedByX(Planet p) {
		double f = calcForceExertedBy(p);
		return f * (p.xxPos - xxPos) / calcDistance(p);
	}

	public double calcForceExertedByY(Planet p) {
		double f = calcForceExertedBy(p);
		return f * (p.yyPos - yyPos) / calcDistance(p);
	}

	public double calcNetForceExertedByX(Planet[] planets) {
		double xForce = 0;
		for (Planet p : planets) {
			if (!p.equals(this)) {
				xForce += calcForceExertedByX(p);
			}
		}
		return xForce;
	}

	public double calcNetForceExertedByY(Planet[] planets) {
		double yForce = 0;
		for (Planet p : planets) {
			if (!p.equals(this)) {
				yForce += calcForceExertedByY(p);
			}
		}
		return yForce;
	}

	public void update(double dt, double fX, double fY) {
		double aX = fX / mass;
		double aY = fY / mass;
		xxVel = xxVel + aX * dt;
		yyVel = yyVel + aY * dt;
		xxPos = xxPos + xxVel * dt;
		yyPos = yyPos + yyVel * dt;
	}

	public void draw() {
		StdDraw.picture(xxPos, yyPos, "./images/" + imgFileName);
	}

}
