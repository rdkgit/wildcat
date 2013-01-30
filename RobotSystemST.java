/*
  RobotSystem.java 
*/

/* robot subsystem */

//package first;

public class RobotSystemST extends RobotSystem
                         implements Runnable,RobotEventListener
{
    public RobotSystemST(int anInt, RobotController c)
    {
	super(anInt,c);
    }

    public void eventReceived(RobotEvent e)
    {
        System.out.println("RobotSystemST "+myNumber+" received event "+e+" on thread "+Thread.currentThread().getId());
    }

    public void run()
    {
        System.out.println("RobotSystemST "+myNumber+" starting");

        // register to receive events
        aController.addEventListener(this);

        while (true) {
	    try { 
              Thread.sleep(100); 
            } catch (InterruptedException e) { }


        }

    }

} /* RobotSystemST */
