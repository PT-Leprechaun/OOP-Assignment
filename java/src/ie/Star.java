package ie;

import processing.core.PApplet;
//import ie.Visual;
//import ie.VisualException;

public class Star extends Starfield
{
    Starfield starfield;
    public float x;
    public float y;
    public float z;
    public int color;
    float pz;
    float px;
    float py;

    public Star(Starfield starfield) {

        this.starfield = starfield;

        color = starfield.color(starfield.random(1, 255), starfield.random(1, 255), starfield.random(1, 255));

        x = starfield.random(-starfield.width, starfield.width);
        y = starfield.random(-starfield.height, starfield.height);
        z = starfield.random(starfield.width);
        
        pz = z;

    }
    
    public void update()
    {
        z = z - starfield.speed;
        
        if(z < 1)
        {
            z = starfield.width;
            x = starfield.random(-starfield.width, starfield.width);
            y = starfield.random(-starfield.height, starfield.height);

            color = starfield.color(starfield.random(1, 255), starfield.random(1, 255), starfield.random(1, 255));

            pz = z;
        }
    }
    
    
    public void show()
    {
        //float i;
        starfield.colorMode(RGB);
        starfield.fill(color);
        starfield.noStroke();
        
        float sx = PApplet.map(x / z, 0, 1, 0, starfield.width);
        float sy = PApplet.map(y / z, 0, 1, 0, starfield.height);
        
        float r = PApplet.map(z, 0, starfield.width, 4, 0);
        
        //starfield.stroke(random(255), random(255), random(255));
        starfield.ellipse(sx, sy, r, r);

        float px = PApplet.map(x / pz, 0, 1, 0, starfield.width);
        float py = PApplet.map(y / pz, 0, 1, 0, starfield.height);

        starfield.stroke(color);
        starfield.strokeWeight(r);
        starfield.line(px, py, sx, sy);

        pz = z;
        px = x;
        py = y;

    }
    public void show2()
    {
        starfield.colorMode(RGB);
        starfield.fill(color);
        starfield.noStroke();

        float sx = PApplet.map(x / z, 0, 1, 0, starfield.width);
        float sy = PApplet.map(y / z, 0, 1, 0, starfield.height);
        
        float r = PApplet.map(z, 0, starfield.width, 4, 0);
        
        //starfield.stroke(random(255), random(255), random(255));
        starfield.ellipse(sx, sy, r, r);

        float px = PApplet.map(x / pz, 0, 1, 0, starfield.width);
        float py = PApplet.map(y / pz, 0, 1, 0, starfield.height);

        starfield.stroke(color);
        starfield.strokeWeight(r);
        starfield.line(px, py, sx, sy);

        px = x;
        py = y;
    }

    public void show3()
    {

    }
    public Starfield getStarfield() {
        return starfield;
    }

    public void setStarfield(Starfield starfield) {
        this.starfield = starfield;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public float getPz() {
        return pz;
    }

    public void setPz(float pz) {
        this.pz = pz;
    }

    public float getPy() {
        return py;
    }

    public void setPy(float py) {
        this.py = py;
    }

    public float getPx() {
        return px;
    }

    public void setPx(float px) {
        this.px = px;
    }


}