
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Maze {
    
    private char[][] maze;
    private boolean animate; 
    
    private static final int[] xShift = {-1 ,-1, -1, 0,  0,  1 ,1, 1};
    private static final int[] yShift = {-1,  0,  1, 1, -1 ,-1, 0, 1};
    private int startX, startY, endX, endY;
    private ArrayList<Point> possMoves = new ArrayList<Point>(); 

    public Maze (String og) {
	try {
	    File text = new File(og);
	    Scanner inf = new Scanner(text);
	    String textstr = "";
	    int numrows = 0;
	    int numcols = 0; 
	    while(inf.hasNextLine()){
		String nextLine = inf.nextLine();
		numcols = nextLine.length();
		textstr += nextLine + "\n";
		numrows ++; 
	    }

	    if (txtstr.indexOf('S') == -1) {
		System.out.println("There is no start");
		System.exit(1);
	    }
	    if (txtstr.indexOf('E') == -1) {
		System.out.println("There is no end");
		System.out.exit(1);
	    } 
	
	    maze = new char[numrows][numcols];
		       
	    int i = 0;
	    int row = 0;
	    for (int r = 0 ; r < numrows; r ++) {
		for (int c = 0; c < numcols; c ++) {
		    if (textstr.charAt(i) == '\n') {
			row ++;
			i ++;
		    } 
		
		    maze[row][c] = textstr.charAt(i);

		    if (textstr.charAt(i) == 'S') {
			startX = row;
			startY = c;
		    }
		    if (textstr.charAt(i) == 'E') {
			endX = row;
			endY = c;
		    } 
		    i ++;

		} 
	    }
	} catch (FileNotFoundException e) {
	    System.out.println ("File not found");
	    System.exit(1);
	    
	} 

	setAnimate(false); 

    }

    public void setAnimate (boolean b) {
	animate = b; 
    }
    
    public void possMoves (int row, int col) {
	possMoves.clear();
	for (int i = 0; i < xShift.length; i ++) {

	    if ( isValid (row + xShift[i], col + yShift[i])) {
		possMoves.add(new Point(row + xShift[i], col + yShift[i])); 
	    }
	}

    } 


    public boolean isValid (int row, int col) {
	return maze[row][col] != '#' && maze[row][col] != ".";
    } 
    

    public void solve () {
	maze[startX][startY] = ' ';
	solvehelp (startX, startY); 
    }

    public boolean solvehelp (int r, int c) {
	if (r == endX && c == endY) {
	    return true;
	}

	possMoves(r, c);

	for (int i = 0; i < possMoves.size(); i++) {
	    Point nextMove = possMoves.get(i);
	    int x = nextMove.getX();
	    int y = nextMove.getX();
	    
	    if (maze[x][y] == ' ') { 
		// sqaures that were visited are marked with a '.' 
		maze[x][y] = '.';
	    } 

	} 

	return false;
	


    } 
    

    public String toString() {
	String str = "";
	for (int r = 0; r <  maze.length; r ++) {
	    for (int c = 0; c < maze[r].length; c ++) {
		
		str += maze[r][c];
	    }
	    str += "\n";
	}
	return str; 

    } 

    public void clearTerminal(){
        //erase terminal, go to top left of screen.
        System.out.println("\033[2J\033[1;1H");
    }
    
    public static void main(String args[]) {

      
 
	Maze a = new Maze (args[0]);
	System.out.println(a);
       
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

