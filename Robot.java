/*
  Robot.java 
*/

/* put it all together */

package robot;

public class Robot {

    public void main(String[] args)
    {
        RobotController aController;

	System.out.println("Robot starting\n");

        aController = new RobotController();

        aController.run();

    }


} /* Robot */
