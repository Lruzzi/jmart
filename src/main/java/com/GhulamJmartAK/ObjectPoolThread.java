package com.GhulamJmartAK;

import java.util.function.Function;
import java.util.Vector;


public class ObjectPoolThread<T> extends Thread
{
    private boolean exitSignal = false;
    private Vector<T> objectPool;
    Function<T, Boolean> routine;

    public ObjectPoolThread(String s, Function<T, Boolean> routine)
    {
        this.routine = routine;
    }

    public synchronized void add (T object)
    {
        objectPool.add(object);
    }

    public synchronized void exit()
    {
        exitSignal = true;
    }

    public void run ()
    {
        exitSignal = false;

        for(int i = 0; i < this.size(); i++)
        {
            T object = objectPool.get(i);
            boolean temp = routine.apply(object);
            if(!temp) this.objectPool.add(object);
            while(this.objectPool == null)
            {
                try{
                    routine.wait();
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
            if(exitSignal)
            {
                break;
            }
        }

    }

    public int size()
    {
        return objectPool.size();
    }
}
