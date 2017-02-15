import java.util.*;
    
public class KnightBoard {

    private int[][] board;
    private ArrayList<Point> moves; 
    private int n;
    private static final int[] xShift = { 2, 1, -1, -2, -2, -1, 1, 2 };
    private static final int[] yShift = { 1, 2, 2, 1, -1, -2, -2, -1 };

    
    public KnightBoard (int rows, int cols) {
	board = new int[rows][cols];
	moves = new ArrayList<Point> ();
	clear();
	n = rows * cols;
	
    }

    public void clear() {
	for (int r = 0; r < board.length; r ++) {
	    for (int c = 0; c < board[r].length; c ++) {
		board[r][c] = 0;
	
	    }
	}
    }

    // returns the number of empty squares adjacent to a given square 
    public int degree (int row, int col) {
	int counter = 0; 
	for (int i = 0; i < xShift.length; i ++) {
	    if (isSafe (row + xShift[i], col +  yShift[i])) {
		if (board[row + xShift[i]][col + yShift[i]] == 0) {
		    counter ++; 		    
		}
	    } 
	}       
	return counter; 
    } 
    

    public void degreeSort () {
	for (int i = 1; i < moves.size(); i ++) {
	    Point temp = moves.get(i);
	    int tempdegree = temp.getDegree();     
	    int x = i - 1;
	    for (; x > -1  && tempdegree < moves.get(x).getDegree(); x --) { 
		moves.set(x + 1, moves.get(x)); 		    
	    }
	    moves.set(x + 1, temp);
	}
    }
    public void possMoves (int row, int col) { 
	moves.clear();
	for (int i = 0; i < xShift.length; i ++) {
	    if (isSafe (row + xShift[i], col + yShift[i])) {
		moves.add(new Point( row + xShift[i], col + yShift[i], degree(row + xShift[i], col + yShift[i]))); 
	    } 
	}
	degreeSort();
	
    }
	
    public boolean isSafe (int row, int col) {
	int numrows = board.length;
	int numcols = board[0].length; 
	if (row < numrows && row >= 0 && col < numcols && col >= 0 &&
	    board[row][col] == 0) {
	    return true;
	}
	return false; 
    }

    
    public void solve () {
	for (int r = 0; r < board.length; r ++) {
	    for (int c = 0; c < board[r].length; c ++) {	
		if (solvehelp(r, c, 1)) {
		    return;
		}
	    }
	}

    }

    
    public boolean solvehelp (int row, int col, int counter) {
	board[row][col] = counter;
	if (counter >= n) {
	    return true;	
	}
	possMoves(row,col);
	for (int i = 0; i < moves.size() ; i ++) {
	    Point move = moves.get(i);
	    board[row][col] = counter;
	    // System.out.println (board[row][col]);
	    if (solvehelp (move.getX(), move.getY(), counter + 1)) {
		return true; 
	    } else {
		board[row][col] = 0;		
	    }
	    // return false;
	}
       
	
	return false; 
    }

    public String toString () {
	String str = "";
	for (int r = 0; r < board.length; r ++) {
	    for (int c =0; c < board[r].length; c ++) {
		if (board[r][c] < 10) {
		    str += " ";
		}
		str = str + board[r][c] + " "; 
	    }
	    str += "\n"; 
	}
	return str; 
    }

    public static void main (String[] args) {
	KnightBoard a = new KnightBoard (8,8);
        a.solve();
	System.out.println (a);
    } 
    
}

class Point {

    private int  x, y, degree;
    
    // Constructors
    public Point (int x, int y, int degree) {
	this.x = x;
	this.y = y;
	this.degree = degree; 
    }

    public Point () {
	this(0,0,0);
    }

    // Accessor Methods
    public int getX () {
	return x;
    }
    public int getY () {
	return y;
    }

    public int getDegree() {
	return degree;
    }
	

    // Mutator Methods
    public void changeX (int x) {
	this.x = x;
    }
    public void changeY (int y) {
	this.y = y;
    }

    public void changeDegree (int degree) {
	this.degree = degree;
    }

    // Distance Method

    public double distance (Point other) {
	return Math.sqrt(Math.pow(other.x - x,2) + Math.pow(other.y - y,2));
    }

    // toString Method

    public String toString() {
	return "(" + x  + "," + y  + ")";
    } 
    
}


