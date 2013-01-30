/*
  RobotController.java
*/

/* Example class that monitors some piece of hardware and generates
   events 

   For JavaME, we will have to convert the list/array/iterator to 
   a datastructure provided by that platform */

//package first;

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
	RobotEvent anEvent = new RobotEvent(this,1+(aGenerator.nextInt(5)));
        Iterator anIterator = listeners.iterator();

        System.out.println("Controller firing event "+anEvent);

        while (anIterator.hasNext()) {
	    ((RobotEventListener)anIterator.next()).eventReceived(anEvent);
        }

    }

    public void run()
    {

        System.out.println("RobotController starting on thread "+Thread.currentThread().getId());

        while (true) {

	  try {
            Thread.sleep(1500);
          } catch (InterruptedException e) { }

          //System.out.println("Robot controller doing its thing");

          fireRobotEvent();           

	}

    }

} /* RobotController.java */
