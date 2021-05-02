package ie;

import processing.core.PApplet;

public class Planet extends Visual {

    Starfield starfield;

    public Planet(Starfield starfield) 
    {
        this.starfield = starfield;
    }

    float radius = 200;

    float smoothedBoxSize = 0;

    float rotLeft = 0;

    float rotRight = 0;

    public void setup()
    {
        starfield.startMinim();
        starfield.loadAudio("afterdawn.mp3");
    }

    public void render()
    {
        starfield.calculateAverageAmplitude();
        try
        {
            starfield.calculateFFT();
        }
        catch(VisualException e)
        {
            e.printStackTrace();
        }
        starfield.calculateFrequencyBands();
        //starfield.noFill();
        //starfield.stroke(map(getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
        // starfield.camera(mouseX*-1, mouseY*-1, 600, 0, 0, 0, 0, 1, 0);
        //translate(0, 0, -250);

        rotLeft += starfield.getAmplitude() / 6.0f;

        rotRight -= starfield.getAmplitude() / 6.0f;

        float[] bands = starfield.getSmoothedBands();

        starfield.noFill();

        starfield.rotateY(rotLeft);
        for(int i = 0 ; i < bands.length ; i ++)
        {
            // starfield.noFill();
            float theta = PApplet.map(i, 0, bands.length, 0, TWO_PI);

            //stroke(map(i, 0, bands.length, 0, 255), 255, 255);
            starfield.colorMode(HSB);
            // starfield.stroke(0,0,255);
            float h = bands[i];
            float x = sin(theta) * (radius * 0.8f);
            float z = cos(theta) * (radius * 0.8f);

            starfield.pushMatrix();
            starfield.stroke(0,0,255);
            // starfield.noFill();
            starfield.translate(x, -5, z);
            starfield.rotateX(theta);
            starfield.sphere(7);
            starfield.popMatrix();

            starfield.pushMatrix();
            //stroke(0, 0, 255);
            // starfield.noFill();
            starfield.stroke(PApplet.map(i, 0, bands.length, 0, 255), 255, 255);
            starfield.sphere(h / 90);
            starfield.popMatrix();
        }
        starfield.rotateX(rotRight);
        for(int i = 0 ; i < bands.length ; i ++)
        {
            // starfield.noFill();
            float theta = PApplet.map(i, 0, bands.length, 0, TWO_PI);

            starfield.stroke(map(i, 0, bands.length, 0, 255), 255, 255);
            //stroke(0,0,255);
            //float h = bands[i];
            float x = sin(theta) * (radius * 0.8f);
            float z = cos(theta) * (radius * 0.8f);
            
            starfield.pushMatrix();

            starfield.translate(-x , x , -z);
            starfield.sphere(7);

            starfield.popMatrix();
        }
        for(int i = 0 ; i < bands.length ; i ++)
        {
            // starfield.noFill();
            float theta = PApplet.map(i, 0, bands.length, 0, TWO_PI);

            starfield.stroke(map(i, 0, bands.length, 0, 255), 255, 255);
            //stroke(0,0,255);
            float x = sin(theta) * (radius * 0.8f);
            float z = cos(theta) * (radius * 0.8f);
            starfield.pushMatrix();
            
            //starfield.noFill();

            starfield.translate(x , x , -z);
            starfield.sphere(7);


            starfield.popMatrix();
            
        }
        // starfield.noFill();

    }
    float angle = 0;
}