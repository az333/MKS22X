public class Location implements Comparable<Location> {
    private int row, col;
    private int distToGoal, distToStart;
    private boolean aStar;
    private Location previous;

    public Location(int r, int c, Location prev , int start, int goal, boolean aStar) {
	row = r;
	col = c;
	previous = prev;
	distToStart = start;
	distToGoal = goal;
	this.aStar = aStar; 

    }

    public int compareTo (Location other) {
	if (aStar) {
	    return (distToStart + distToGoal) - (other.distToStart + other.distToGoal);
	} else {
	    return distToGoal - other.distToGoal; 
	}
    } 

    public int getRow () {
	return row;
    }

    public int getCol() {
	return col; 
    } 



}
