
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Maze {
    
    private char[][] maze;
    private boolean animate; 
    
    private static final int[] xShift = {-1, 0,  0 ,1};
    private static final int[] yShift = { 0, 1, -1, 0};
    private int startX, startY;

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

	    if (textstr.indexOf('S') == -1) {
		System.out.println("There is no start");
		System.exit(1);
	    }
	    if (textstr.indexOf('E') == -1) {
		System.out.println("There is no end");
		System.exit(1);
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
    

 

    public boolean solve () {
	maze[startX][startY] = ' ';
	return solvehelp (startX, startY); 
    }

    public boolean solvehelp (int r, int c) {

	if (maze[r][c] == 'E') {
	    return true;
	}

	if (maze[r][c] != ' '){
	    return false;
	}

	maze[r][c] = '@';
	
 	for (int i = 0; i < xShift.length; i++) {
	    int x = r + xShift[i]; 
	    int y = c + yShift[i];

	    if (solvehelp (x,y)) {		
		return true;
	    } 
	}

	maze[r][c] = '.';

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
	a.solve();
	System.out.println(a);
       
    }


}   
