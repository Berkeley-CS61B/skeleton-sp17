public class Planet {
    double xxPos;
    double yyPos;
    double xxVel;
    double yyVel;
    double mass;
    String imgFileName;
    double G = 6.67e-11;


    public Planet (double xP, double yP, double xV, double yV,
                   double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet (Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;

    }

    public  double calcDistance(Planet p) {
        double r_square = java.lang.Math.pow((p.xxPos - xxPos), 2)
                + java.lang.Math.pow((p.yyPos - yyPos), 2);
        return java.lang.Math.pow(r_square, 0.5);
    }

    public double calcForceExertedBy(Planet p) {
        double dist_square = java.lang.Math.pow(this.calcDistance(p), 2);
        double force = G * mass * p.mass / dist_square;
        return force;

    }

    public double calcForceExertedByX(Planet p) {
        double force = this.calcForceExertedBy(p);
        double dist = this.calcDistance(p);
        return force * (p.xxPos - xxPos) / dist;
    }

    public double calcForceExertedByY(Planet p) {
        double force = this.calcForceExertedBy(p);
        double dist = this.calcDistance(p);
        return force * (p.yyPos - yyPos) / dist;
    }

    public boolean equals(Planet p) {
        return((xxPos == p.xxPos) && (yyPos == p.yyPos));
    }

    public double calcNetForceExertedByX(Planet[] allp) {
        double net_force_x = 0;
        for (int i = 0; i < allp.length; i++) {
            if (this.equals(allp[i])) {
                net_force_x += 0;
            } else {
                double force_x = this.calcForceExertedByX(allp[i]);
                net_force_x += force_x;
            }
        } return net_force_x;
    }

    public double calcNetForceExertedByY(Planet[] allp) {
        double net_force_y = 0;
        for (int i = 0; i < allp.length; i++) {
            if (this.equals(allp[i])) {
                net_force_y += 0;
            } else {
                double force_y = this.calcForceExertedByY(allp[i]);
                net_force_y += force_y;
            }
        } return net_force_y;
    }

    public void update(double time, double f_x, double f_y) {
        double a_x = f_x / mass;
        double a_y = f_y / mass;
        xxVel += time * a_x;
        yyVel += time * a_y;
        xxPos += time * xxVel;
        yyPos += time * yyVel;
    }

    public void draw() {
        String path = "images/";
        StdDraw.picture(xxPos, yyPos, path + imgFileName);
    }




}
