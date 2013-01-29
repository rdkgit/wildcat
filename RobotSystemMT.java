/*
  RobotSystemMT.java 
*/

/* robot subsystem that uses separate threads to process 
   each incoming event

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


    }

    public void eventReceived(RobotEvent e)
    {
        System.out.println("RobotSystem "+myNumber+" received event "+e);

        // create thread and run it for each event we receive

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

} /* RobotSystemMT */
