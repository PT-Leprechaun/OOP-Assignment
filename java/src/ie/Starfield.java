package ie;
import processing.core.PApplet;

public class Starfield extends PApplet
{
    Star [] stars = new Star[5000];

    float speed;

    public void settings()
    {
        size(800, 800, P3D);
        
        for(int i = 0; i < stars.length; i++)
        {
            stars[i] = new Star(this);
        }
    }
    
    public void draw()
    {
        noCursor();
        
        speed = map(mouseX, 0, width, 0, 20);
        
        background(0);
        
        translate(width/2, height/2);
        
        for(int i = 0; i < stars.length; i++)
        {
            stars[i].update();
            stars[i].show();
        }
    }
}