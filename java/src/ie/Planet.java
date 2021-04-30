package ie;

public class Planet extends Visual {


    public Planet(Starfield starfield) 
    {
        
    }

    public void keyPressed()
    {
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

    public void setup()
    {
        colorMode(HSB);
        //noCursor();
        
        setFrameSize(256);

        startMinim();
        loadAudio("after dawn.mp3");
        getAudioPlayer().play();
        //background(0);
        //startListening(); 
        
    }

    float radius = 200;

    float smoothedBoxSize = 0;

    float rotLeft = 0;

    float rotRight = 0;


    public void render()
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
        background(0);
        noFill();
        stroke(255);
        stroke(map(getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
        camera(mouseX*-1, mouseY*-1, 600, 0, 0, 0, 0, 1, 0);
        //camera(-250, -250, -mouseX, -mouseY, 0, 0, 0, 1, 0);
        //translate(0, 0, -250);

        rotLeft += getAmplitude() / 2.0f;

        rotRight -= getAmplitude() / 7.0f;

        float[] bands = getSmoothedBands();

        rotateY(rotLeft);
        for(int i = 0 ; i < bands.length ; i ++)
        {
            float theta = map(i, 0, bands.length, 0, TWO_PI);

            //stroke(map(i, 0, bands.length, 0, 255), 255, 255);
            stroke(0,0,255);
            float h = bands[i];
            float x = sin(theta) * (radius * 1.3f);
            float z = cos(theta) * (radius * 1.3f);

            pushMatrix();
            fill(255,255,255);
            translate(x, 0, z);
            rotateX(theta);
            sphere(10);
            popMatrix();

            pushMatrix();
            //stroke(0, 0, 255);
            colorMode(HSB);
            stroke(map(i, 0, bands.length, 0, 255), 255, 255);
            noFill();
            sphere(h / 50);
            popMatrix();
        }
        rotateX(rotRight);
        for(int i = 0 ; i < bands.length ; i ++)
        {

            float theta = map(i, 0, bands.length, 0, TWO_PI);

            stroke(map(i, 0, bands.length, 0, 255), 255, 255);
            //stroke(0,0,255);
            //float h = bands[i];
            float x = sin(theta) * (radius * 1.3f);
            float z = cos(theta) * (radius * 1.3f);
            pushMatrix();
            noFill();

            translate(-x , x , -z);
            

            sphere(10);

            popMatrix();
        }
        for(int i = 0 ; i < bands.length ; i ++)
        {
            
            
            float theta = map(i, 0, bands.length, 0, TWO_PI);

            stroke(map(i, 0, bands.length, 0, 255), 255, 255);
            //stroke(0,0,255);
            float x = sin(theta) * (radius * 1.3f);
            float z = cos(theta) * (radius * 1.3f);
            pushMatrix();
            
            noFill();

            translate(x , x , -z);
            sphere(10);


            popMatrix();
            
        }
        
    

    }
    float angle = 0;

}