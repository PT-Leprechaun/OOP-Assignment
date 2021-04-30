package ie;

//import processing.core.PApplet;
//import ie.Visual;
//import ie.VisualException;

public class Starfield extends Visual
{
    Star [] stars = new Star[4000];

    Planet p;

    int which = 0;

    float z = width;

    float speed;

    public void settings()
    {
        size(900, 900, P3D);
        
        for(int i = 0; i < stars.length; i++)
        {
            stars[i] = new Star(this);
        }

        p = new Planet(this);

    }

    public void setup()
    {
        setFrameSize(256);
        startMinim();
        loadAudio("afterdawn.mp3");
        getAudioPlayer().play();
    }

    public void keyPressed()
    {
        if (keyCode >= '0' && keyCode <= '6') 
        {
            which = keyCode - '0';
        }
        if(key == ' ')
        {
            if (getAudioPlayer().isPlaying())
            {
                getAudioPlayer().pause();
            }
            else
            {
                getAudioPlayer().play();
            }
        }
        if(keyCode == ENTER)
        {
            getAudioPlayer().rewind();

            getAudioPlayer().play();
        }
 
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

        float[] bands = getSmoothedBands();
        
        for(int i = 0 ; i < bands.length ; i ++)
        {
            float h = bands[i];
            speed = map(h/10, 0, width, 0, 10);
        }
        
        background(0);

        // translate(width/10, height/10);

        // translate(mouseX,mouseY);
        
        switch(which)
        {
            case 0:
            {
                camera();
                translate(mouseX,mouseY);
                for(int i = 0; i < stars.length; i++)
                {
                    stars[i].update();
                    stars[i].show();
                }
                break;
                }
            case 1:
            {
                camera();
                translate(mouseX,mouseY);
                for(int i = 0; i < stars.length; i++)
                {
                    stars[i].update();
                    stars[i].show2();
                }
                break;
            }
            case 2:
            {
                translate(width/2 , height/2);
                for(int i = 0; i < stars.length; i++)
                {
                    stars[i].show();
                }
                pushMatrix();
                p.render();
                popMatrix();
                camera(0, 0, 500, mouseX, mouseY, 0, 0, 1, 0);
                // pushMatrix();
                // translate(width/2, height/2);
                // popMatrix();
                break;
            }   
        }
    }
}