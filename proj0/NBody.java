public class NBody {
       public static double readRadius(String path) {
                In in = new In(path);
                int n = in.readInt();
                double radius = in.readDouble();
                return radius;

       } 


       

       public static Planet[] readPlanets(String filePath) {
              In in = new In(filePath);
              int n = in.readInt();
              Planet[] allPlanets = new Planet[n];
              double radius = in.readDouble();
              int i = 0;
              while (i < n) {  
                     double xxPos = in.readDouble();
			double yyPos = in.readDouble();
			double xxVal = in.readDouble();
			double yyVal = in.readDouble();
			double mass = in.readDouble();
			String img = in.readString();
			Planet b = new Planet(xxPos, yyPos, xxVal, yyVal, mass, img);
                     allPlanets[i] = b;
                     i += 1;
              }
              return allPlanets;
       }

       


       public static void main(String[] args) {
              double T = Double.parseDouble(args[0]);
              double dt = Double.parseDouble(args[1]);
              String filename = args[2];
              double radius = NBody.readRadius(filename);
              Planet[] planets =NBody.readPlanets(filename);
              int num = planets.length;
              String imageToDraw = "images/starfield.jpg";
              /**draw the initial location */
		StdDraw.setScale(-radius, radius);
              StdDraw.clear();
		StdDraw.picture(0, 0, imageToDraw);
		for (Planet p :planets) {
		        p.draw();
              }
              StdDraw.show();
              /**Creating an Animation. */
              double t = 0;
              while (t <= T) {
                     double[] xForces = new double[num];
                     double[] yForces = new double[num];
                     /**calculate the net force for each planet. */
                     for (int i=0; i<num; i+=1) {
                            for (int j=0; j<num; j+=1){
                                   if (j == i) {
                                          continue;
                                   }
                                   xForces[i] += planets[i].calcForceExertedByX(planets[j]);
                                   yForces[i] += planets[i].calcForceExertedByY(planets[j]);
                            }

                     }
                     
                     for (int i=0; i<num; i+=1) {
                            planets[i].update(dt, xForces[i], yForces[i]);
                     }
		       StdDraw.enableDoubleBuffering();
                     StdDraw.picture(0, 0, imageToDraw);
		       for (Planet p :planets) {
		               p.draw();
                     }
                     StdDraw.show();
			StdDraw.pause(10);
                     t += dt;



              }
              StdOut.printf("%d\n", planets.length);
              StdOut.printf("%.2e\n", radius);
              for (int i = 0; i < planets.length; i++) {
              StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
              planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
              planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
}



       }




}