/**
 * This program implements the KWIC system
 * using a pipes and filters architecture.
 * 
 * 
 * @author drew johnson/david babb
 * @since 2-14-18
 * 
 */
public class Main 
{
    private static Pipe pipe;
    private static DataSource source;
    private static RotateFilter rFilter;
    private static AlphabetizeFilter aFilter;
    private static DataSink sink;
    private static long tStart;
    private static long tEnd;
    
    public static void main(String [] args)
    {
        tStart = System.nanoTime();
        pipe = new Pipe();
        source = new DataSource(pipe);
        rFilter = new RotateFilter(pipe);
        //sink = new DataSink(pipe);
        aFilter = new AlphabetizeFilter(pipe);
        sink = new DataSink(pipe);
        tEnd = System.nanoTime();
        
        System.out.print("Finished in: ");
        System.out.print((tEnd - tStart) / 1e9);
        System.out.println(" seconds.");
    }
}
