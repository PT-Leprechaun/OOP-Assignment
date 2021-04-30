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
        translate(mouseX,mouseY);
        
        switch(which)
        {
                case 0:
                {
                    for(int i = 0; i < stars.length; i++)
                    {
                        stars[i].update();
                        stars[i].show();
                    }
                    break;
                }
                case 1:
                {
                    for(int i = 0; i < stars.length; i++)
                    {
                        stars[i].update();
                        stars[i].show2();
                    }
                    break;
                }
                case 2:
                {
                    for(int i = 0; i < stars.length; i++)
                    {
                        stars[i].show();
                    }
                    p.render();
                }
                break;
        }
    }
}