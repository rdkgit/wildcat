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

    }

    public void run()
    {

    }

} /* RobotSystem */
