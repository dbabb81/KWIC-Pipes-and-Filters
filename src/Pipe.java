import java.util.LinkedList;
import java.util.Queue;

/**
 * This class passes data between different filters.
 * 
 * @author drewjohnson
 * @since 2-14-18
 */

      
public class Pipe 
{
    private Queue<String> data;
    
    public Pipe()
    {
        this.data = new LinkedList();
    }
    
    public void pull(Queue<String> data)
    {
        //  Transfers data to the next linked list.
        this.data = new LinkedList<>(data);
    }
    
    public Queue<String> push()
    {
        //  Sends data to the next filter.
        return this.data;
    }
}
