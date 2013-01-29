/*
  RobotSystemBQ.java 
*/

/* robot subsystem that uses blocking queue for queing of events to 
   handle 
*/

//package first;

public class RobotSystemBQ implements Runnable,RobotEventListener
{
    RobotController aController;
    int myNumber;

    public RobotSystemBQ(int anInt, RobotController c)
    {
        myNumber = anInt;
	aController = c;

        // allocate blocking queue and initialize
    }

    public void eventReceived(RobotEvent e)
    {
        System.out.println("RobotSystem "+myNumber+" received event "+e);
        // queue up the event in blocking queue
    }

    public void run()
    {
        System.out.println("RobotSystem "+myNumber+" starting");

        // register to receive events
        aController.addEventListener(this);

        while (true) {

	    // wait on an event and then remove from queue


        }

    }

} /* RobotSystemBQ */
