/*
  Robot.java 
*/

/* put it all together */

//package first;

public class Robot {

    public static void main(String[] args)
    {
        RobotController aController;
        RobotSystem r1, r2;

	System.out.println("Robot starting\n");

        aController = new RobotController();

        r1 = new RobotSystem(1,aController);
        r2 = new RobotSystem(2,aController);

        new Thread(r2).start();
        new Thread(r1).start();

        new Thread(aController).start();
    }


} /* Robot */
