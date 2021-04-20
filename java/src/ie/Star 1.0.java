package ie;

import processing.core.PApplet;

public class Star extends Starfield
{
    Starfield starfield;
    public float x;
    public float y;
    public float z;
    float pz;
    float px;
    float py;

    public Star(Starfield starfield, float x, float y, float z, float pz) {
        this.starfield = starfield;
        this.x = x;
        this.y = y;
        this.z = z;
        this.pz = pz;
    }

    public void star()
    {
        x = starfield.random(-starfield.width, starfield.width);
        y = starfield.random(-starfield.height, starfield.height);
        z = starfield.random(starfield.width);
    }

    
    public void update(){
        z = z - 10;
        
        if(z < 1)
        {
            z = starfield.width;
            x = starfield.random(-starfield.width, starfield.width);
            y = starfield.random(-starfield.height, starfield.height);
        }
    }
    
    public void show()
    {
        starfield.fill(255);
        starfield.noStroke();
        
        float sx = PApplet.map(x / z, 0, 1, 11, starfield.width);
        float sy = PApplet.map(y / z, 0, 1, 11, starfield.height);
        
        float r = PApplet.map(z, 0, starfield.width, 16, 0);
        
        starfield.ellipse(sx, sy, r, r);

        float px = PApplet.map(x / pz, 0, 1, 0, starfield.width);
        float py = PApplet.map(y / pz, 0, 1, 11, starfield.height);

        starfield.stroke(255);
        starfield.line(px, py, sx, sy);

        px = x;
        py = y;
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
}