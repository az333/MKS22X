import java.util.*;
import java.io.*;

public class USACO {

    public static int bronze(String filename) {
	try { 
	    File fileobj = new File (filename);
	    Scanner  s = new Scanner (fileobj);
        
	    int numRows = s.nextInt();
	    int numCols = s.nextInt();
	    int finalDepth = s.nextInt();
	    int numInstructions = s.nextInt();
	    
	    int[][] board = new int[numRows][numCols];

	    for (int r = 0; r < numRows; r ++) {
		for (int c = 0; c < numCols; c ++) {
		    board[r][c] = s.nextInt(); 
		}
	    }
	   	    
	    for (int i = 0; i < numInstructions; i ++) {	
		board = stomp (board, s.nextInt (), s.nextInt(), s.nextInt()); 
	    }

	    return findVolume (board, finalDepth);
	
	} catch (FileNotFoundException e) {
	    System.out.println ("File not found");
	    System.exit(1);
	}

	return 0;
    }
    
    
    public static int[][] stomp (int[][] lake, int startRow, int startCol, int depth) {
	int row = startRow - 1;
	int col = startCol - 1;

	int max = lake[row][col];
	
	for (int r = row; r < row + 3; r++){
	    for (int c = col; c < col + 3; c++){
		if (lake[r][c] > max){
		    max = lake[r][c];
		}
	    }
	}

	for (int r = row; r < row + 3; r++){
	    for (int c = col; c < col + 3; c++){
		if (lake[r][c] > max - depth){
		    lake[r][c] = max - depth;
		}
	    }
	}  

	return lake; 
    }

    public static int findVolume (int[][] lake, int finalDepth) {

	int sum = 0; 
	for (int row = 0; row < lake.length; row ++) {
	    for (int col = 0; col < lake[row].length; col ++) {

		if (lake[row][col] < finalDepth) {
		    sum += finalDepth - lake[row][col];
		}
	    }
	}

	return sum * 72 * 72; 

    } 


    public static int silver (String filename) {
	try { 
	    File fileobj = new File (filename);
	    Scanner  s = new Scanner (fileobj);

	    int numRows = s.nextInt();
	    int numCols = s.nextInt();
	    int time = s.nextInt();
	    
	    int[][] board = new int[numRows][numCols];

	    for (int r = 0; r < numRows; r ++) {
		
		String currentLine = s.next();
		for (int c = 0; c < numCols; c ++) {
		    if (currentLine.charAt(c) == '.') {
			// 0 represents valid space
			board[r][c] = 0;
		    } else {
			// -1 represents invalid sapce 
			board[r][c] = -1; 
			
		    }
		}
	    }

	    int startRow = s.nextInt();
	    int startCol = s.nextInt();
	    int endRow = s.nextInt();
	    int endCol = s.nextInt();

	    return numWays (board, startRow - 1, startCol -1 , endRow - 1, endCol - 1, time); 
	
	} catch (FileNotFoundException e) {
	    System.out.println ("File not found");
	    System.exit(1);
	}

	return 0;
    } 


    public static boolean isValid (int[][] board, int r, int c) {
	return r >= 0 && r < board.length && c >= 0 && c < board[r].length && board[r][c] != -1;
    }

    
    public static int numWays (int[][] board, int startRow, int startCol, int endRow, int endCol, int time) {
	int[] xShift = {-1, 0,  0, 1};
	int[] yShift = { 0, 1, -1, 0};

	int[][] temp = new int[board.length][board[0].length];


	board[startRow][startCol] = 1;
	

	for (int step = 0; step < time; step ++) {
	    for (int row = 0; row < temp.length; row ++) {
		for (int col = 0; col < temp[row].length; col ++) {
		    int sum = 0;
		    for (int i = 0; i < xShift.length; i ++) {
			if (board[row][col] != -1){
			    int newRow = row + xShift[i];
			    int newCol = col + yShift[i];
				      
			    if (isValid(board, newRow, newCol)) {
				sum += board[newRow][newCol];
			    }
			}
		    }
       
		    temp[row][col] = sum;

		    
		    if(board[row][col] == -1){
                        temp[row][col] = -1;
		    }
		}
	    }

	    for (int x = 0; x < temp.length; x++){
		for (int y = 0; y < temp[x].length; y++){
		    board[x][y] = temp[x][y];
		}
	    }
	}

	return board[endRow][endCol];
	    
    } 
   
 

    public static void main (String[] a) {

       	System.out.println(bronze (a[0]));
    } 


}
