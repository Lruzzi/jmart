package GhulamJmartAK;

import java.util.*;

public class Algorithm {
    private Algorithm(){}

    public static <T> int count(T[] array, T value) {
        int counter = 0;
        for(T e : array)
        {
            counter++;
        }
        return counter;
    }

    public static <T> int count(Iterable<T> iterable, T value) {
        int counter = 0;
        for(T e : iterable)
        {
            counter++;
        }
        return counter;
    }


    public static <T> int count(Iterator<T> iterator, T value) {
        int counter = 0;

        if (iterator.hasNext())
        {
            counter++;
        }
        return counter;
    }

    @SuppressWarnings("unlikely-arg-type")
    public static <T> int count(T[] array, Predicate<T> pred) {
        if (pred.equals(false))
        {
            return 0;
        }

        int counter = 0;
        for(T e : array)
        {
            counter++;
        }
        return counter;
    }

    @SuppressWarnings("unlikely-arg-type")
    public static <T> int count(Iterable<T> iterable, Predicate<T> pred) {
        if (pred.equals(false))
        {
            return 0;
        }

        int counter = 0;
        for(T e : iterable)
        {
            counter++;
        }
        return counter;
    }

    @SuppressWarnings("unlikely-arg-type")
    public static <T> int count(Iterator<T> iterator, Predicate<T> pred) {
        if (pred.equals(false))
        {
            return 0;
        }

        int counter = 0;

        if (iterator.hasNext())
        {
            counter++;
        }
        return counter;
    }

    public static <T> boolean exists(T[] array, T value) {
        for(T e : array)
        {
            if(e.equals(value)) {
                return true;
            }
        }
        return false;
    }

    public static <T> boolean exists(Iterable<T> iterable, T value) {
        for(T e : iterable)
        {
            if(e.equals(value)) {
                return true;
            }
        }
        return false;
    }

    public static <T> boolean exists(Iterator<T> iterator, T value) {
        while(iterator.hasNext())
        {
            if(iterator.next().equals(value)) {
                return true;
            }
        }
        return false;
    }

    public static <T> boolean exists(T[] array, Predicate<T> pred) {
        for(T e : array)
        {
            if(e.equals(pred)) {
                return true;
            }
        }
        return false;
    }

    public static <T> boolean exists(Iterable<T> iterable, Predicate<T> pred) {
        for(T e : iterable)
        {
            if(e.equals(pred)) {
                return true;
            }
        }
        return false;
    }

    public static <T> boolean exists(Iterator<T> iterator, Predicate<T> pred) {
        while(iterator.hasNext())
        {
            if(iterator.next().equals(pred)) {
                return true;
            }
        }
        return false;
    }

    public static <T> T find(T[] array, T value) {
        for (T a : array){
            if(a.equals(value)){
                return a;
            }
        }
        return null;
    }
    public static <T> T find(Iterable<T> iterable, T value) {
        for (T a : iterable){
            if(a.equals(value)){
                return a;
            }
        }
        return null;
    }
    public static <T> T find(Iterator<T> iterator, T value) {
        while (iterator.hasNext()){
            if(iterator.next().equals(value)){
                return iterator.next();
            }
        }
        return null;
    }
    public static <T> T find(T[] array, Predicate<T> pred) {
        for (T a : array){
            if(a.equals(pred)){
                return a;
            }
        }
        return null;
    }
    public static <T> T find(Iterable<T> iterable, Predicate<T> pred) {
        for (T a : iterable){
            if(a.equals(pred)){
                return a;
            }
        }
        return null;
    }
    public static <T> T find(Iterator<T> iterator, Predicate<T> pred) {
        while (iterator.hasNext()){
            if(iterator.next().equals(pred)){
                return iterator.next();
            }
        }
        return null;
    }

    public static <T> T max(T first, T second) {
        if(first.hashCode()>second.hashCode()){
            return first;
        }else {
            return second;
        }
    }
    public static <T> T min(T first, T second) {
        if(first.hashCode()>second.hashCode()){
            return second;
        }else {
            return first;
        }
    }
}
