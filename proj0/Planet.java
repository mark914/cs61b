public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public static double G = 6.67E-11;
/**grativity constant */
    public Planet(double xP, double yP, double xV,double yV, double m, String img){
            this.xxPos = xP;
            this.yyPos = yP;
            this.xxVel = xV;
            this.yyVel = yV;
            this.mass = m;
            this.imgFileName = img;
    }

    public Planet(Planet p){
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }
/**calculate the distance with planet p. */
    public double calcDistance(Planet p) {
        double res;
        double distan_x = p.xxPos - this.xxPos;
        double distan_y = p.yyPos - this.xxPos;
        distan_x = distan_x*distan_x;
        distan_y = distan_y*distan_y;
        res = Math.sqrt(distan_x + distan_y);
        return res;
    }
/**calculate the force exerted by planet p. */
    public double calcForceExertedBy(Planet p) {
        double f;
        double distan = calcDistance(p);
        f = G*this.mass*p.mass/(distan*distan);
        return f;
    }

    public double calcForceExertedByX(Planet p) {
        double fx;
        double f = calcForceExertedBy(p);
        double dx = p.xxPos - this.xxPos;
        double distan = calcDistance(p);
        fx = f*dx/distan;
        return fx;
    }


    public double calcForceExertedByY(Planet p) {
        double fy;
        double f = calcForceExertedBy(p);
        double dy = p.yyPos - this.yyPos;
        double distan = calcDistance(p);
        fy = f*dy/distan;
        return fy;
    }

    public void update(double dt,double fX,double fY) {
        double aX = fX/this.mass;
        double aY = fY/this.mass;
        this.xxVel += aX*dt;
        this.yyVel += aY*dt;
        this.xxPos += this.xxVel*dt;
        this.yyPos += this.yyVel*dt;
    }

    public void draw() {
        String fileName = "images/"+this.imgFileName;
        StdDraw.picture(this.xxPos, this.yyPos, fileName);	

    }
    


}
