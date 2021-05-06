package ie;

//import processing.core.PApplet;
//import ie.Visual;
//import ie.VisualException;

public class Starfield extends Visual
{
    Star [] stars = new Star[5000];

    Planet p;

    int which = 0;

    float z = width;

    float speed;

    public void settings()
    {
        size(1400, 900, P3D);
        
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
        loadAudio("inception.mp3");
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
        if(keyCode == 'Q')
        {
            getAudioPlayer().pause();
            setFrameSize(256);
            startMinim();
            loadAudio("1923.mp3");
            getAudioPlayer().play();
        }
        if(keyCode == 'W')
        {
            getAudioPlayer().pause();
            setFrameSize(256);
            startMinim();
            loadAudio("afterdawn.mp3");
            getAudioPlayer().play();
        }
        if(keyCode == 'E')
        {
            getAudioPlayer().pause();
            startMinim();
            loadAudio("waterfront.mp3");
            getAudioPlayer().play();
        }
        if(keyCode == 'R')
        {
            getAudioPlayer().pause();
            setFrameSize(256);
            startMinim();
            loadAudio("inception.mp3");
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
                    stars[i].update();
                    stars[i].show();
                }
                pushMatrix();
                p.render();
                popMatrix();
                camera(width/2, height/2, 700, mouseX, mouseY, 0, 0, 1, 0);
                break;
            }   
        }
    }
}