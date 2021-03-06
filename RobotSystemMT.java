/*
  RobotSystemMT.java 
*/

/* robot subsystem that uses separate threads to process 
   each incoming event

*/

//package first;

public class RobotSystemMT extends RobotSystem
                           implements Runnable,RobotEventListener
{
    public RobotSystemMT(int anInt, RobotController c)
    {
	super(anInt,c);
    }

    public void eventReceived(RobotEvent e)
    {
        final RobotEvent eF = e;

        Runnable privateEventReceived = new Runnable() {
 	   public void run() {         
             System.out.println("RobotSystemMT "+myNumber+" recvd event "+eF+
                                " on thread "+Thread.currentThread().getId());
           }

	}; /* private threaded event receiver */

        // create thread and run it for each event we receive
        new Thread(privateEventReceived).start();

    } /* eventReceived */

    public void run()
    {
        System.out.println("RobotSystemMT "+myNumber+" starting thread "+
			   Thread.currentThread().getId());

        // register to receive events
        aController.addEventListener(this);

        while (true) {
          try { Thread.sleep(500); } catch (InterruptedException iE) { }

        }

    }

} /* RobotSystemMT */
