/*
  RobotSystem.java 
*/

/* robot subsystem */

//package first;

public class RobotSystem implements Runnable,RobotEventListener
{
    RobotController aController;
    int myNumber;

    public RobotSystem(int anInt, RobotController c)
    {
        myNumber = anInt;
	aController = c;
    }

    public void eventReceived(RobotEvent e)
    {
        System.out.println("RobotSystem "+myNumber+" received event "+e+" on thread "+Thread.currentThread().getId());
    }

    public void run()
    {
        System.out.println("RobotSystem "+myNumber+" starting");

        // register to receive events
        aController.addEventListener(this);

        while (true) {
	    try { 
              Thread.sleep(100); 
            } catch (InterruptedException e) { }


        }

    }

} /* RobotSystem */
