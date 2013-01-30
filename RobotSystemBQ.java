/*
  RobotSystemBQ.java 
*/

/* robot subsystem that uses blocking queue for queing of events to 
   handle 
*/

//package first;

//import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;

public class RobotSystemBQ implements Runnable,RobotEventListener
{
    RobotController aController;
    int myNumber;
    BlockingQueue bQ;

    public RobotSystemBQ(int anInt, RobotController c)
    {
        myNumber = anInt;
	aController = c;

        // allocate blocking queue and initialize
        //bQ = new ArrayBlockingQueue(20);
        bQ = new BlockingQueue(20);

    }

    public void eventReceived(RobotEvent e)
    {
        //System.out.println("RobotSystemBQ "+myNumber+" received event "+e);

        // queue up the event in blocking queue
        try {
          bQ.put((Object)e);
        } 
        catch (InterruptedException iE) { }
        catch (NullPointerException npE) { }

    }

    public void run()
    {
        RobotEvent anEvent;

        System.out.println("RobotSystemBQ "+myNumber+" starting");

        // register to receive events
        aController.addEventListener(this);

        while (true) {

	    // wait on an event and then remove from queue
            try {
              anEvent = (RobotEvent)bQ.take();
            }
            catch (InterruptedException iE) { continue; }

            System.out.println("RobotSystemMQ "+myNumber+" retreived event "+anEvent+" off of the blocking queue, Q size is now "+bQ.size());

            try { Thread.sleep(500); } catch (InterruptedException iE) { }
        }

    }

} /* RobotSystemBQ */
