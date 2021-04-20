package ie;
import processing.core.PApplet;

public class Starfield extends PApplet
{
    Star [] stars = new Star[400];

    public void settings()
    {
        size(500, 500);
        for(int i = 0; i < stars.length; i++)
        {
            stars[i] = new Star(this, 30, 30, 30, 30);
        }
    }
    
    public void draw()
    {
        background(0);
        translate(width/2, height/2);
        for(int i = 0; i < stars.length; i++)
        {
            stars[i].update();
            stars[i].show();
        }
    }
}