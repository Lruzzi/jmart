package GhulamJmartAK;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Algorithm {
    private Algorithm(){}

    public static <T> List<T> collect(T[] array , T value){
        final Iterator<T>it = Arrays.stream(array).iterator();
        return collect(it, value);
    }
    public static <T> List<T> collect(Iterable<T>iterable , T value){
        final Iterable<T>e = (Iterable<T>) iterable.iterator();
        return collect(e, value);
    }
    public static <T> List<T> collect(Iterator<T>iterator , T value){
        final Predicate<T> predicate = value::equals;
        return collect(iterator, value);
    }
    public static <T> List<T> collect(T[] array, Predicate<T> pred){
        final Iterator<T> itArray = Arrays.stream(array).iterator();
        return collect(itArray, pred);
    }

    /*public static <T> List<T> collect(Iterable<T> iterable, Predicate<T> pred)
    {
    }*/

    public static <T> List<T> collect(Iterator<T>iterator, Predicate<T> pred) {
        int count = 0;
        while(iterator.hasNext()){
            count++;
        }
        final Predicate<T> predicate = pred::equals;
        return collect(iterator, pred);
    }

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

    public static <T extends Comparable<? super T>> T max(T[] array) {
        int maxx = 0;
        T max = null;
        for (T t : array) {
            if (t.hashCode() > maxx) {
                maxx = t.hashCode();
                max = t;
            }
        }
        return max;
    }

    public static <T extends Comparable<? super T>> T max(Iterable<T>iterable){
        Iterator<T> iterator = iterable.iterator();
        int maxx = 0;
        T max = null;
        if (iterator.hashCode() > maxx){
            maxx = iterator.hashCode();
            max = (T) iterator;
        }
        return max;
    }

    public static <T extends Comparable<? super T>> T max(Iterator<T>iterator) {
        int maxx = 0;
        T max = null;
        while(iterator.hasNext()){
            if(iterator.next().hashCode() > maxx){
                maxx = iterator.next().hashCode();
                max = (T) iterator;
            }
        }
        return max;
    }

    public static <T extends Comparable<?super T>> T max (T first, T second, Comparator<? super T>comparator){
        int res = ((Comparable<T>) first).compareTo(second);
        return res == -1 ? second : first;
    }

    /*public static <T extends Comparable<?super T>> T max (T[]array, Comparator<? super T>comparator){
        
    }*/

    /*public static <T extends Comparable<?super T>> T max(Iterable<T> iterable, Comparator<? super T> comparator){

    }/*

    /*public static <T extends Comparable<?super T>> T max(Iterator<T> iterator, Comparator<?super T> comparator){

    }*/

    public static <T extends Comparable<? super T>> T min(T first, T second) {
        if(first.compareTo(second)<0){
            return first;
        }else{
            return second;
        }
    }

    public static <T extends Comparable<? super T>> T min(T[] array) {
        int minn = 0;
        T min = null;
        for (T t : array) {
            if (t.hashCode() < minn) {
                minn = t.hashCode();
                min = t;
            }
        }
        return min;
    }

    public static <T extends Comparable<? super T>> T min(Iterable<T>iterable){
        Iterator<T> iterator = iterable.iterator();
        int minn = 0;
        T min = null;
        if (iterator.hashCode() > minn){
            minn = iterator.hashCode();
            min = (T) iterator;
        }
        return min;
    }

    public static <T extends Comparable<? super T>> T min(Iterator<T>iterator) {
        int minn = 0;
        T min = null;
        while(iterator.hasNext()){
            if(iterator.next().hashCode() > minn){
                minn = iterator.next().hashCode();
                min = (T) iterator;
            }
        }
        return min;
    }

    public static <T extends Comparable<?super T>> T min (T first, T second, Comparator<? super T>comparator){
        int res = ((Comparable<T>) first).compareTo(second);
        return res == -1 ? second : first;
    }

       /*public static <T extends Comparable<?super T>> T min (T[]array, Comparator<? super T>comparator){
        
    }*/

    /*public static <T extends Comparable<?super T>> T min(Iterable<T> iterable, Comparator<? super T> comparator){

    }/*

    /*public static <T extends Comparable<?super T>> T min(Iterator<T> iterator, Comparator<?super T> comparator){

    }*/
}
