/* 
  RobotEvent.java 
 */

package robot;

public class RobotEvent {

    public static final int EVENT_TYPE_UNKNOWN = 0;
    public static final int EVENT_TYPE_A = 1;
    public static final int EVENT_TYPE_B = 2;
    public static final int EVENT_TYPE_C = 3;
    public static final int EVENT_TYPE_D = 4;
    public static final int EVENT_TYPE_E = 5;

    private int eventType;
    private Object eventSource;

    public RobotEvent(Object source, int eType)
    {
	eventSource = source;

        if ((eType < EVENT_TYPE_A) && (eType > EVENT_TYPE_E))
	    eventType = EVENT_TYPE_UNKNOWN;
        else
            eventType = eType;
    }

    public String toString() 
    { 
        switch (eventType) {
	  case EVENT_TYPE_A:
	     return new String("Event Type A");
	  case EVENT_TYPE_B:
	     return new String("Event Type B");
	  case EVENT_TYPE_C:
	     return new String("Event Type C");
	  case EVENT_TYPE_D:
	     return new String("Event Type D");
	  case EVENT_TYPE_E:
	     return new String("Event Type E");
	  case EVENT_TYPE_UNKNOWN:
  	  default:
	     return new String("Unknown Event");
	}
             
    }

    Object getSource() { return eventSource; }
    


} /* RobotEvent */