import.java.util.*;

public class QueueFrontier implements Frontier{
    private LinkedList<Location> queue;


    private add(Location loc) {
	queue.add(loc);
    } 

    private Location next() {
	Location temp = queue.getFirst();
	queue.removeFirst();
	return temp;

    }
    


}
