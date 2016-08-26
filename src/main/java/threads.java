
import java.text.Normalizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jakob
 */
public class threads
{

    public static class Thread1 extends Thread
    {
        public void run()
        {
        
            long sum =0;
            for(long i = 0; i< 1000000001; i++)
            {
                sum += i;
            }
            System.out.println("The sum of 1 through 1 billion is: "+sum);
        }
                
       

    }
    
    public static class Thread2 extends Thread
    {
        public void run()
        {
            for (int i = 0; i < 6; i++)
            {
                try
                {
                    System.out.println(i);                    
                    Thread2.sleep(2000);
                   
                }
                catch (InterruptedException ex)
                {
                    Logger.getLogger(threads.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
    }
    
    public static class Thread3 extends Thread
    {
        boolean finish = false;
        public void run()
        {
            int nr = 10;
            while(!finish)
            {
                System.out.println(nr);
                nr++;
                try
                {
                    Thread3.sleep(3000);
                }
                catch (InterruptedException ex)
                {
                    Logger.getLogger(threads.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    
    public static void main(String[] args)
    {
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();
        Thread3 t3 = new Thread3();
        
        
        t1.start();
        t2.start();
        t3.start();
        
        try
        {
            Thread.sleep(10000);
        }
        catch (InterruptedException ex)
        {
            Logger.getLogger(threads.class.getName()).log(Level.SEVERE, null, ex);
        }
        t3.finish=true;
    }
}
