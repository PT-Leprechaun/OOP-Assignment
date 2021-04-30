package ie;

import processing.core.PApplet;

public class Planet extends Starfield {

    Starfield starfield;

    public Planet(Starfield starfield) {

        this.starfield = starfield;

    }

    float radius = 130;

    float smoothedBoxSize = 0;

    float rotLeft = 0;

    float rotRight = 0;

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

        float[] bands = starfield.getSmoothedBands();

        rotLeft += starfield.getAmplitude() / 2.0f;

        rotRight -= starfield.getAmplitude() / 6.0f;

        starfield.rotateY(rotLeft);
        for(int i = 0 ; i < bands.length ; i ++)
        {

            float theta = PApplet.map(i, 0,bands.length, 0, TWO_PI);
            float h = bands[i];
            float x = PApplet.sin(theta) * (radius * 1.3f);
            float z = PApplet.cos(theta) * (radius * 1.3f);

            starfield.pushMatrix();
            starfield.stroke(0,0,255);
            starfield.translate(x, -5, z);
            starfield.rotateX(theta);
            starfield.sphere(7);
            starfield.popMatrix();

            starfield.pushMatrix();
            starfield.colorMode(HSB);
            starfield.stroke(PApplet.map(i, 0, bands.length, 0, 255), 255, 255);
            starfield.sphere(h / 55);
            starfield.popMatrix();
        }
        starfield.rotateX(rotRight);
        for(int i = 0 ; i < bands.length ; i ++)
        {
            float theta = PApplet.map(i, 0, bands.length, 0, TWO_PI);

            starfield.stroke(PApplet.map(i, 0, bands.length, 0, 255), 255, 255);
            float x = PApplet.sin(theta) * (radius * 1.3f);
            float z = PApplet.cos(theta) * (radius * 1.3f);
            starfield.pushMatrix();
            starfield.noFill();

            starfield.translate(-x , x , -z);

            starfield.sphere(7);

            starfield.popMatrix();
        }
        for(int i = 0 ; i < bands.length ; i ++)
        {
            float theta = PApplet.map(i, 0, bands.length, 0, TWO_PI);

            starfield.stroke(map(i, 0, bands.length, 0, 255), 255, 255);
            float x = PApplet.sin(theta) * (radius * 1.3f);
            float z = PApplet.cos(theta) * (radius * 1.3f);
            starfield.pushMatrix();
            
            starfield.noFill();

            starfield.translate(x , x , -z);
            starfield.sphere(7);

            starfield.popMatrix();
            
        }
    }
}