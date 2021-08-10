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
              while (i < 5) {
                     Planet p = allPlanets[i];
                     p.xxPos = in.readDouble();
                     p.yyPos = in.readDouble();
                     p.xxVel = in.readDouble();
                     p.yyVel = in.readDouble();
                     p.mass = in.readDouble();
                     p.imgFileName = in.readString();
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

		StdDraw.setScale(-radius, radius);
              StdDraw.enableDoubleBuffering();
              StdDraw.clear();
		StdDraw.picture(0, 0, imageToDraw);
              
              int i = 0;
              while (i < planets.length) {
                     planets[i].draw();
                     i += 1;
              }
              StdDraw.show();


       }





}