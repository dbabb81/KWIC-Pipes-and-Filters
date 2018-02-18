import java.util.LinkedList;
import java.util.Queue;

/** 
 * This class rotates the elements in a string.
 * 
 * @author Drew Johnson
 * @since 2-14-18
 */

public class RotateFilter 
{
    private final Queue<String> data;
    private final Queue<String> mutatedData;
    private String hold;
    private String [] holdArr;
    private final Pipe pipe;
    private final int size;
    
    public RotateFilter(Pipe pipe)
    {
        mutatedData = new LinkedList<>();
        this.data = pipe.push();
        size = data.size();
        this.pipe = pipe;
        buildData();
    }
    
    public void buildData()
    {
        /*  This creates the new rotated list and passes
            it to the next filter.
        */
        for(int i = 0; i < size; i++)
        {
            mutatedData.add(data.peek());
            holdArr = data.remove().split(" ");
            
            for(int j = 0; j < holdArr.length - 1; j++)
            {
                hold = rotate(holdArr);
                mutatedData.add(hold);
            }
        }
        
        push(pipe);
        
    }
    
    private String rotate(String [] holdArr)
    {
        //  Used by the buildData function to generate the rotations.
        int i;
        
        String holder = holdArr[0];
        
        for(i = 0; i < holdArr.length - 1; i++)
        {
            holdArr[i] = holdArr[i + 1];
        }
        
        holdArr[i] = holder;
        
        holder = String.join(" ", holdArr);
        
        return holder;
       
    }
    
    private void push(Pipe pipe)
    {
        /*  This transfers the data to a new linked list
            to be used by the next filter.
        */
        System.out.printf("Rotate Filter: Done\n");
        pipe.pull(mutatedData);
    }
}

