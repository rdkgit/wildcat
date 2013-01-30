/* 
  BlockingQueue.java
  Borrowed from 
  
http://stackoverflow.com/questions/10329896/implementing-a-blocking-queue-in-javame-how-to-optimize-it

*/

import java.util.Vector;

public class BlockingQueue 
{    
    private Vector queue;

    public BlockingQueue(int limit)
    {
        queue = new Vector(limit);
    }

    public synchronized void put(Object o) throws InterruptedException
    {
        queue.addElement(o);
        notifyAll();

    } /* put */

    public synchronized Object take() throws InterruptedException
    {
        Object ret = null;
    
         while (queue.isEmpty()) {
           try {
                wait();
           } catch (InterruptedException e) {}
         }

         ret = queue.elementAt(0);
         queue.removeElementAt(0);

         return ret;

    } /* take */

    public synchronized int size() { return queue.size(); }

} /* BlockingQueue */