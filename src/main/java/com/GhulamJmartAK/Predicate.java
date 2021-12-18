package com.GhulamJmartAK;

/**
 * Class untuk menyimpan predicate dari parameter object dalam bentuk boolean
 * @param <T> generic untuk representasi saat passing
 * @author Ghulam Izzul Fuad
 */

public interface Predicate<T>{
    public abstract boolean predicate (T arg);
}
