package GhulamJmartAK;

import java.util.*;

public class Algorithm {
    private Algorithm(){}
    public static <T> int count (T[] array, T value){
        Iterator<T> iterator = Arrays.stream(array).iterator();
        return count(iterator, value);
    }
    public static <T> int count (Iterable<T> iterable, T value){
        Predicate<T> pred = value::equals;
        return count(iterable, pred);
    }
    public static <T> int count (Iterator<T> iterator, T value){
        Predicate<T> pred = value::equals;
        return count(iterator, pred);
    }
    public static <T> int count (T[] array, Predicate<T> pred){
        Iterator<T> iterator = Arrays.stream(array).iterator();
        return count(iterator, pred);
    }
    public static <T> int count (Iterable<T> iterable, Predicate<T> pred){
        return count(iterable.iterator(), pred);
    }
    public static <T> int count (Iterator<T> iterator, Predicate<T> pred){
        int counter = 0;
        while(iterator.hasNext()){
            if(pred.predicate(iterator.next())){
                counter++;
            }
        }
        return counter;
    }

    public static <T> boolean exists(T[] array, T value) {
        Predicate<T> pred = value::equals;
        return exists(array, pred);
    }
    public static <T> boolean exists(Iterable<T> iterable, T value){
        Predicate<T> pred = value::equals;
        return exists(iterable, pred);
    }
    public static <T> boolean exists(Iterator<T> iterator, T value){
        Predicate<T> pred = value::equals;
        return exists(iterator, pred);
    }
    public static <T> boolean exists(T[] array, Predicate<T> pred){
        Iterator<T> iterator = Arrays.stream(array).iterator();
        return exists(iterator, pred);
    }
    public static <T> boolean exists(Iterable<T> iterable, Predicate<T> pred){
        return exists(iterable.iterator(), pred);
    }
    public static <T> boolean exists(Iterator<T> iterator, Predicate<T> pred){
        return find(iterator, pred) != null ? true : false;
    }


    public static <T> T find(T[] array, T value) {
        Predicate<T> pred = value::equals;
        return find(array, pred);
    }
    public static <T> T find(Iterable<T> iterable, T value) {
        final Iterator <T> iterator = iterable.iterator();
        return find(iterator, value);
    }
    public static <T> T find(Iterator<T> iterator, T value) {
        Predicate<T> pred = value::equals;
        return find(iterator, pred);
    }
    public static <T> T find(T[] array, Predicate<T> pred) {
        Iterator<T> iterator = Arrays.stream(array).iterator();
        return find(iterator, pred);
    }
    public static <T> T find(Iterable<T> iterable, Predicate<T> pred) {
        final Iterator <T> iterator = iterable.iterator();
        return find(iterator, pred);
    }
    public static <T> T find(Iterator<T> iterator, Predicate<T> pred) {
        while(iterator.hasNext()){
            T object = iterator.next();
            if(pred.predicate(object)) {
                return object;
            }
        }
        return null;
    }

    public static <T extends Comparable<? super T>> T max(T first, T second) {
        if(first.compareTo(second)<0){
            return second;
        }else{
            return first;
        }
    }
    public static <T extends Comparable<? super T>> T min(T first, T second) {
        if(first.compareTo(second)<0){
            return first;
        }else{
            return second;
        }
    }
}