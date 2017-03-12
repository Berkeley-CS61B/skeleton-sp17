import java.util.DoubleSummaryStatistics;

public class NBody {

    public static double readRadius(String f) {
        In in = new In(f);
        int num_planet = in.readInt();
        double radius = in.readDouble();
        return radius;
    }

    public static Planet[] readPlanets(String f) {
        In in = new In(f);
        int num_planet = in.readInt();
        double radius = in.readDouble();
        Planet[] planet_list = new Planet[num_planet];
        int index = 0;
        while (index < num_planet) {
            double x_pos = in.readDouble();
            double y_pos = in.readDouble();
            double x_vel = in.readDouble();
            double y_vel = in.readDouble();
            double mass = in.readDouble();
            String img = in.readString();
            planet_list[index] = new Planet(x_pos, y_pos, x_vel, y_vel, mass, img);
            index ++;
        }
        return planet_list;
    }

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println ("you must provide 3 arguments: ");
        }
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String file_name = args[2];
        double radius = readRadius(file_name);
        Planet[] planet_lst = readPlanets(file_name);

        StdDraw.setScale(-radius, radius);
        String universe = "images/starfield.jpg";


        for (double time = 0.0; time <= T; time += dt) {
            int num_planet = planet_lst.length;
            double[] xForce = new double[num_planet];
            double[] yForce = new double[num_planet];
            StdDraw.clear();
            StdDraw.picture(0.0, 0.0, universe);
            for (int index = 0; index < num_planet; index ++) {
                Planet p = planet_lst[index];
                double x_netf = p.calcNetForceExertedByX(planet_lst);
                double y_netf = p.calcNetForceExertedByY(planet_lst);
                xForce[index] = x_netf;
                yForce[index] = y_netf;
                p.update(dt, x_netf, y_netf);

                p.draw();

            }
            StdDraw.show(10);
        }

    }
}


