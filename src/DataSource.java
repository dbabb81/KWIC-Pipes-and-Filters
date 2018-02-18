import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

/**
 * This class reads input data from a text file.
 * 
 * @author Drew Johnson
 * @since 2-14-18
*/


public class DataSource 
{
    private BufferedReader in;
    Queue<String> dataInput;
    private String hold;
    
    public DataSource(Pipe pipe)
    {
        /*  Data is read into the system line by line
            and each line is added to a linked list.
        */
        try
        {
            in = new BufferedReader(new FileReader("/Users/drewjohnson/desktop/hey.txt"));
            dataInput = new LinkedList<>();
        
            while((hold = in.readLine()) != null)
            {
                if(hold.length() > 0)
                {
                    dataInput.add(hold);
                }
                
                else
                {
                    dataInput.add(" ");
                }
            }
            
            push(pipe);
        } 
        catch(FileNotFoundException ex1)
        {
            System.out.println(ex1);
            System.exit(1);
        }
        catch(IOException ex2)
        {
            System.out.println(ex2);
            System.exit(1);
        }
    }
    
    private void push(Pipe pipe)
    {
        /*  This transfers the data to a new linked list
            to be used by the next filter.
        */
        System.out.println("Source: Done.");
        pipe.pull(dataInput);
    }
}

