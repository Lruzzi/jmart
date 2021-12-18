package com.GhulamJmartAK;

/**
 * Class untuk melakukan pairing antara parameter satu dan dua
 * @author Ghulam Izzul Fuad
 * @param <T> first parameter
 * @param <U> second parameter
 */
public class Pair <T,U>{
    public T first;
    public U second;

    public Pair(){}

    public Pair(T first, U second){
        this.first = first;
        this.second = second;
    }
}
