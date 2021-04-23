package ie;

import processing.core.PApplet;
import ie.Visual;
import ie.VisualException;

public class Starfield extends Visual
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

    public void setup()
    {
        startMinim();
        loadAudio("after dawn.mp3");
        getAudioPlayer().play();
    }
    
    public void draw()
    {
        calculateAverageAmplitude();
        try
        {
            calculateFFT();
        }
        catch(VisualException e)
        {
            e.printStackTrace();
        }
        calculateFrequencyBands();
        noCursor();
        //camera(mouseX*-1, mouseY*-1, 0, 0, 0, 0, 0, 1, 0);

        float[] bands = getSmoothedBands();
        
        for(int i = 0 ; i < bands.length ; i ++)
        {
            float h = bands[i];
            speed = map(h/10, 0, width, 0, 12);
        }
        
        background(0);
        
        translate(width/2, height/2);
        
        for(int i = 0; i < stars.length; i++)
        {
            stars[i].update();
            stars[i].show();
        }
    }
}