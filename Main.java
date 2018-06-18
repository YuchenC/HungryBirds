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
public class Main 
{
    public static void main(String[] args) throws InterruptedException 
    {
        Monitor mon = new Monitor();
        
        System.out.print("Give an integer: ");
        java.util.Scanner in = new java.util.Scanner(System.in);
        int numberOfBirds = in.nextInt();
        System.out.println("number of birds = " + numberOfBirds);
        
        for(int i=1; i< numberOfBirds + 1; i++) 
        {
            Babybirds bird = new Babybirds(mon);
            bird.start();
        }
       
        while(true) 
        {
            int value = (int) (Math.random () * 14 +1);
            mon.put(value);   
        }
    }
}
