package GhulamJmartAK;


public abstract class Recognizable implements Comparable <Recognizable>
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

    public static int setClosingID(Class<Recognizable>clazz, int id){
        if(Class.class.isAssignableFrom(Recognizable.class)){
            return 0;
        }
        else{
            return 1;
        }
    }

    public static int getClosingID(Class<Recognizable>clazz) {
        if(Class.class.isAssignableFrom(Recognizable.class)){
            return 0;
        }
        else{
            return 1;
        }
    }

    public boolean equals(Object recognizable) {
        return (recognizable instanceof Recognizable) && ((Recognizable) recognizable).id == id;
    }
    public boolean equals(Recognizable recognizable) {
        return recognizable.id == id;
    }

    @Override
    public int compareTo(Recognizable other) {
        if (id == other.id){
            return 1;
        }
        else{
            return 0;
        }
    }
}
