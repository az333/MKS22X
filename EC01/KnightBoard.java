import java.util.*;
    
public class KnightBoard {

    private int[][] board;
    private ArrayList<Point> moves; 
    private static final int[] xShift = {-2, -2, -1, -1,  1, 1,  2, 2 };
    private static final int[] yShift = {-1,  1, -2,  2, -2, 2, -1, 1 };

    
    public KnightBoard (int rows, int cols) {
	board = new int[rows][cols];
	moves = new ArrayList<Point> ();
	clear();
	
    }

    //clears the board 
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
  

    // puts all of the possible moves in an array and calls degreeSort();
    public void possMoves (int row, int col) { 
	moves.clear();
	Point origin = new Point(board.length / 2, board[0].length / 2 ); 
	for (int i = 0; i < xShift.length; i ++) {
	    if (isSafe (row + xShift[i], col + yShift[i])) {
		double distance = origin.distance(new Point(row + xShift[i], col + yShift[i]));
		moves.add(new Point( row + xShift[i], col + yShift[i], degree(row + xShift[i], col + yShift[i]), distance)); 
	    } 
	}
	Collections.sort(moves);
    }
	
    public boolean isSafe (int row, int col) {
	int numrows = board.length;
	int numcols = board[0].length; 
	return (row < numrows && row >= 0 && col < numcols && col >= 0 &&
		board[row][col] == 0);

    }

    public void solveFast() {
	solve();
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
	int n = board.length * board[0].length;
	board[row][col] = counter;
	if (counter >= n) {
	    return true;	
	}

	possMoves(row,col);
	for (int i = 0; i < moves.size() ; i ++) {
	    Point move = moves.get(i);
	    board[row][col] = counter;
	    if (solvehelp (move.getX(), move.getY(), counter + 1)) {
		return true; 
	    }
	}

	board[row][col] = 0;		
	
	return false; 
    }

    public String toString () {
	String str = "";
	for (int r = 0; r < board.length; r ++) {
	    for (int c =0; c < board[r].length; c ++) {
		if (board[r][c] < 10) {
		    str += "    ";
		} else if (board[r][c] < 100) {
		    str += "   "; 
		} else if (board[r][c] < 1000) {
		    str += "  ";
		} else if (board[r][c] < 10000) {
		    str += " ";
		}
		str = str + board[r][c] + " "; 
	    }
	    str += "\n"; 
	}
	return str; 
    }



    public static void main (String[] args) {
	/*
	if (args.length == 0 ) {
	    for (int i = 0; i < 120 ; i ++) {

		KnightBoard a = new KnightBoard (i,i);
		
		long startTime = System.nanoTime();

		a.solve();

		long endTime = System.nanoTime();

		try { 

		    Thread.sleep(3);
		} catch (InterruptedException e) {
		    // Thread. currentThread().interrupt();

		}

		System.out.println("That took " + ((endTime - startTime) / 1000000.) + " milliseconds");
	    
		System.out.println ("Board Size: " + i  + " x " + i + "\n" + a + "\n\n\n\n\n\n");
	   
	    }
	}
	else {

	    int x = Integer.parseInt(args[0]);
	    int y = Integer.parseInt(args[1]);
	    
	    KnightBoard b = new KnightBoard (x,y);

	    long startTime = System.nanoTime();

	    b.solve();

	    long endTime = System.nanoTime();

	    
	    System.out.println("That took " + ((endTime - startTime) / 1000000.) + " milliseconds");
	    
	    System.out.println ("Board Size: " + x + " x " + y + "\n\n\n\n\n\n");
	    
	}
	*/
    } 
    
}

class Point implements Comparable<Point> {
    private int  x, y, degree;
    private double distance;
    
    // Constructors
    public Point (int x, int y, int degree, double distance) {
	this.x = x;
	this.y = y;
	this.degree = degree;
	this.distance = distance;
    }

    public Point (int x, int y) {
	this (x, y, 0, 0);
    }
  
    public int getX () {return x;}
    
    public int getY () {return y;}

    public int getDegree() {return degree;}

    public double getDistance() {return distance;}
    
    public void changeX (int x) {this.x = x;}
    
    public void changeY (int y) {this.y = y;}
    
    public void changeDegree (int degree) {this.degree = degree;}

    public double distance (Point other){
	return Math.sqrt(Math.pow(other.x - x,2.) + Math.pow(other.y - y,2.));
    }

    public int compareTo(Point other) {
	if (degree == other.getDegree()) {

	    return Double.compare(other.getDistance(), distance);
	
       
	}
	return Integer.compare(degree, other.getDegree()); 
    }

    public String toString() {
	return "(" + x  + "," + y  + ")";
    } 
    
}


