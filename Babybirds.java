/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hungrybirds;

/**
 *
 * @author yuchen
 */
import java.util.logging.Level;
import java.util.logging.Logger;
import static java.lang.Thread.sleep;

public class Babybirds extends Thread
{
    Monitor mon;
    public Babybirds (Monitor mon)
    {      
        this.mon = mon;
    }
    public void run() 
    {
        
        System.out.println("Bird: " + getName() + " has started.\n");
        while(true) 
        {
            try
            {
                mon.take(getName());
                sleep(1000);
            }
            catch (InterruptedException ex) {}
        }
    }
       
}

