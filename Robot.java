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

        if (args.length < 1) {
	    System.out.println("Usage: java Robot -mt|-bq|-st");
            System.exit(-1);
        }

	System.out.println("Robot starting on thread "+Thread.currentThread().getId());

        aController = new RobotController();

        r1 = r2 = null;

        if (args[0].equals("-mt")) {
 	   r1 = (RobotSystem) new RobotSystemMT(1,aController);
           r2 = (RobotSystem) new RobotSystemMT(2,aController);
        }
        if (args[0].equals("-st")) {
 	   r1 = (RobotSystem) new RobotSystemST(1,aController);
           r2 = (RobotSystem) new RobotSystemST(2,aController);
        }
        if (args[0].equals("-bq")) {
 	   r1 = (RobotSystem) new RobotSystemBQ(1,aController);
           r2 = (RobotSystem) new RobotSystemBQ(2,aController);
        }

        if ((r1 == null) || (r2 == null)) {
	    System.out.println("Usage: java Robot -mt|-bq|-st");
            System.exit(-1);
	}

        new Thread(r2).start();
        new Thread(r1).start();

        new Thread(aController).start();
    }


} /* Robot */
