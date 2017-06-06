public class MazeSolver {
    
    private char[][] maze;
    private boolean animate; 


    public MazeSolver (String filename) {
	this(filename,false);
    }
    
    public MazeSolver (String filename, boolean animate) {
	this.animate = animate;
	board = new Maze (filename);
    }

    public void solve(){
	solve(1);
    }

    public void solve(int style){
	Frontier rest; 
	if (style == 0) {
	    rest = new StackFrontier();
	} if (style == 1) {
	    rest = new QueueFrontier();
	} else { 
	    rest = new PriorityQueueFrontier();
	}
	rest.add(maze.getStart());
	while (rest.hasNext()) {
	    Location current = rest.next();
	    maze.set(current.getRow(), current.getCol(), '.');
	    if (current.equals(maze.getEnd())) {

	    } 
	}
	

    } 




} 
