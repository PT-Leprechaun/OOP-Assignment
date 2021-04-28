package ie;

public class loop extends Starfield
{
    Starfield Starfield;

    public loop(Starfield starfield) 
    {
        Starfield = starfield;
    }

    void pool()
    {
        for(int i = 0; i < stars.length; i++)
        {
            stars[i] = new Star(this);
        }
        for(int i = 0; i < stars.length; i++)
        {
            stars[i].update();
            stars[i].show();
        }
    }
    
}
