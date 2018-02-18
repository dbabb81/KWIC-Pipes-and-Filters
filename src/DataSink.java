import java.util.LinkedList;
import java.util.Queue;


/**
 * This class outputs the mutated data for the user to see.
 * 
 * @author Drew Johnson
 * @since 2-14-18
 */

public class DataSink 
{
    private Queue<String> data;
    private int size;
    
    public DataSink(Pipe pipe)
    {
        data = new LinkedList<>();
        this.data = pipe.push();
        size = data.size();
        write();
    }
    
    private void write()
    {
        /*  Prints either the rotated or alphabetized data
            (or both) to standard output.
        */
        System.out.printf("Preparing to print...\n\n");
        
        data.forEach((s) -> {
            System.out.println(s);
        });
        System.out.printf("\n");
    }
}

