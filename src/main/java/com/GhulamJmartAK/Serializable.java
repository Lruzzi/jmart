package com.GhulamJmartAK;


import java.util.HashMap;

public abstract class Serializable implements Comparable<Serializable>
{
    public final int id;
    private static HashMap<Class<?>, Integer> mapCounter = new HashMap<>();

    protected Serializable() {
        Integer counter = mapCounter.get(getClass());
        counter = counter == null ? 0 : counter + 1;
        mapCounter.put(getClass(), counter);
        this.id = counter;
    }

    public int compareTo(Serializable other) {
        return other.id/this.id;
    }

    public boolean equals(Object other) {
        if(!(other instanceof Serializable)){
            Serializable checked = (Serializable)other;
            if(checked.id == this.id){
                return true;
            }
        }
        return false;
    }
    public boolean equals(Serializable other) {
        return (other instanceof Serializable) && ((Serializable) other).id == id;
    }

    public static <T> int getClosingId(Class<T> clazz){
        return mapCounter.get(clazz);
    }

    public static <T> int setClosing(Class<T> clazz, int id){
        return mapCounter.put(clazz, id);
    }
}
