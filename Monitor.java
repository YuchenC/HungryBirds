/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hungrybirds;

//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;

public class Monitor 
{
    private int worms = 10;
    private boolean needrefil = false;
    //final Lock lock = new ReentrantLock();
    
    public synchronized void take(String babyid) throws InterruptedException
    {
        while (needrefil) 
        {
            try { wait();} // this.wait()
            catch (InterruptedException e) {}
        }
        
        //lock.lock();
        if (needrefil == false)
        {
            if (worms == 0) 
            {
                needrefil = true;
                notifyAll(); // this.notifyAll()
            }
            else
            {
                System.out.println("Bird " + babyid + " eats worm " + worms);
                worms--;
            }  
        }
        //lock.unlock();
        
    }
    
    public synchronized void put(int worms) throws InterruptedException
    {
        while (!needrefil) 
        {
            try { wait(); } // this.wait()
            catch (InterruptedException e) { }
        }
        
        //lock.lock();
        this.worms = worms;
        needrefil = false;
        notify(); // this.notify()
        System.out.println("##########################worms refil = " + worms);
        //lock.unlock();
    }
}

