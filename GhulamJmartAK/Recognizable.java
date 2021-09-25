package GhulamJmartAK;


public class Recognizable
{
    public int id;

    /**
     * Constructor for objects of class Recognizable
     */
    protected Recognizable(int id)
    {
        // initialise instance variables
        this.id = id;
    }
    
    public boolean equals(Object recognizable) {
        return (recognizable instanceof Recognizable) && ((Recognizable) recognizable).id == id;
    }
    public boolean equals(Recognizable recognizable) {
        return recognizable.id == id;
    }
}
