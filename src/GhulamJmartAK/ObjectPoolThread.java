package GhulamJmartAK;

import java.util.function.Function;
import java.util.Vector;


public class ObjectPoolThread<T> extends Thread {
    private boolean exitSignal;
    private Vector<T> objectPool;
    private Function<T, Boolean> routine;

    public ObjectPoolThread (String name, Function<T, Boolean>routine) {
        super(name);
        this.routine = routine;
    }

    public ObjectPoolThread (Function<T, Boolean> routine) {
        this.routine = routine;
    }

    public synchronized void add (T object) {
        objectPool.add(object);
    }

    public synchronized void exit () {
        exitSignal = true;
    }

    public void run () {
        exitSignal = false;

        boolean temporare;
        for (T each : objectPool) {
            temporare = routine.apply(each);
            if(each == null) {
                try {
                    routine.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (!temporare) {
                objectPool.add(each);
            }
            if(exitSignal) {
                break;
            }
        }

    }

    public int size () {
        return objectPool.size();
    }
}
