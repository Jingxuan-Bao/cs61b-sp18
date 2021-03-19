public class Planet {
  double xxPos; //current x possition//
  double yyPos; //current y position//
  double xxVel; //current velocity in the x direction//
  double yyVel; //current velocity in the y direction//
  double mass; //mass//
  String imgFileName; //The name of the image//
  private static final double G = 6.67 * 1e-11;

  public Planet (double xP, double yP, double xV, double yV, double m, String img) {
    xxPos = xP;
    yyPos = yP;
    xxVel = xV;
    yyVel = yV;
    mass= m;
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

  public double calcDistance (Planet p) {
    double x_distance = p.xxPos - this.xxPos ;
    double y_distance = p.yyPos - this.yyPos;
    double distance = Math.sqrt(x_distance*x_distance + y_distance*y_distance);
    return distance;
  }

  public double calcForceExertedBy (Planet p) {
    double r = this.calcDistance(p);
    double force = G * this.mass * p.mass / (r*r);
    return force;
  }

  public double calcForceExertedByX (Planet p) {
    double r = this.calcDistance(p);
    double dx = p.xxPos - this.xxPos;
    double force = this.calcForceExertedBy(p);
    double Byx = force * dx / r;
    return Byx;
  }

  public double calcForceExertedByY (Planet p) {
    double r = this.calcDistance(p);
    double dy = p.yyPos - this.yyPos;
    double force = this.calcForceExertedBy(p);
    double Byy = force * dy / r;
    return Byy;
  }

  public boolean equals (Planet p) {
    if (this.xxPos == p.xxPos && this.yyPos == p.yyPos && this.xxVel == p.xxVel &&
        this.mass == p.mass && this.yyVel == p.yyVel && this.imgFileName == p.imgFileName) {
          return true;
        }
    else {
      return false;
    }
  }

  public double calcNetForceExertedByX (Planet[] planets) {
    double fnetx = 0.0;
    for (Planet p : planets) {
      if (this.equals(p)) {
        continue;
      }
      else {
        fnetx += calcForceExertedByX(p);
      }
    }
    return fnetx;
  }

  public double calcNetForceExertedByY (Planet[] planets) {
    double fnety = 0.0;
    for (Planet p : planets) {
      if (this.equals(p)) {
        continue;
      }
      else {
        fnety += calcForceExertedByY(p);
      }
    }
    return fnety;
  }

  public void update (double dt, double fx, double fy) {
    double ax = fx / this.mass;
    double ay = fy / this.mass;
    this.xxVel += ax * dt;
    this.yyVel += ay * dt;
    this.xxPos += this.xxVel * dt;
    this.yyPos += this.yyVel * dt;
  }

  public void draw() {
    StdDraw.picture(this.xxPos, this.yyPos, "./images/" + this.imgFileName);
  }

}
