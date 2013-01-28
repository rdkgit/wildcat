/*
  RobotController.java
*/

/* Example class that monitors some piece of hardware and generates
   events 

   For JavaME, we will have to convert the list/array/iterator to 
   a datastructure provided by that platform */

package robot;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
 
import java.util.Random;

public class RobotController implements Runnable {

    private List listeners;
    private Random aGenerator;

    public RobotController()
    {
        listeners = new ArrayList();
        aGenerator = new Random();
    }

    public synchronized void addEventListener(RobotEventListener l)  
    { 
	listeners.add(l);
    }

    public synchronized void removeEventListener(RobotEventListener l)
    {
        listeners.remove(l);
    }

    public synchronized void fireRobotEvent()
    {
	RobotEvent anEvent = new RobotEvent(this,aGenerator.nextInt() % 6);

        System.out.println("Controller firing event "+anEvent);

    }

    public void run()
    {

        while (true) {

	  try {
            Thread.sleep(1000);
          } catch (InterruptedException e) { }

          System.out.println("Robot controller doing its thing");

          fireRobotEvent();           

	}

    }

} /* RobotController.java */