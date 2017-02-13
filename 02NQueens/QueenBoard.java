public class QueenBoard{
    private int[] queenrows;
    private int solutionCount;
    

    
    public QueenBoard(int boardsize){
	queenrows = new int[boardsize];
	for (int i = 0; i < boardsize; i ++)  {
	    queenrows[i] = -1;
	}
					      
	solutionCount = -1;
    }


    public void solve () {
	 putQueens(0); 
    }

    
    public boolean putQueens(int c) {
	int n = queenrows.length;
        // the recursive process will go through each row  until the end,
	// so if it reaches the end it's done

        if (c == n ) {
	    return true;
	}
       	
	for (int r = 0; r < n; r ++) { 
	    if (isLegit (c, r)) {
		// if the queen causes no interferences put it in that spot
		//int temp = queenrows[c];
		queenrows[c] = r;
		if (putQueens(c  + 1)) {
		    return true;
		} else {        
		    queenrows[c] = -1;
		}
	    }
	}
	return false;
	    
	
    }




    public boolean isLegit (int queenc, int r) {
	// only go up to queenc because there are no queens placed further than this
	for (int col = 0; col < queenc; col ++) {
	    //if there are interferences in the rows or diagonals return false

	    
	    if (queenrows[col] == r || Math.abs(r - queenrows[col]) == Math.abs(queenc - col)) {
		return false;
	    }
	}
	return true; 
    }


    public void countSolutions() {
	solutionCount = 0;
        allSolutions (0);
	
    }

    public void allSolutions (int c) {
	int n = queenrows.length;
        if (c == n ) {
	    solutionCount ++;
	}
       	
	for (int r = 0; r < n; r ++) {
	    if (isLegit (c, r)) {
		queenrows[c] = r;
		allSolutions(c + 1);
	    }
	}


    }

    public int getCount(){
	
    	return solutionCount;
    }

    
    public String toString(){
	String str = "";
	for (int r = 0; r < queenrows.length; r ++) {
	    for (int c = 0; c < queenrows.length; c ++) {
		if ( r == queenrows[c]) {
		    str += "Q "; 
		} else {
		    str += "_ ";
		}
	    }
	    str += "\n"; 
	}
    	return str;
    }

    public static void main (String[] args) {

	/*	QueenBoard a = new QueenBoard (4);
	QueenBoard b = new QueenBoard (5);
	QueenBoard c = new QueenBoard (6);
	QueenBoard d = new QueenBoard (7);
	QueenBoard e = new QueenBoard (8); 

	a.solve();
	b.solve();
	c.solve();
	d.solve();
	e.solve();

	System.out.println (a);
	a.countSolutions();
	System.out.println (a.getCount() +"\n");

	System.out.println (b);
	b.countSolutions();
	System.out.println (b.getCount() +"\n");

	System.out.println (c);
	c.countSolutions();
	System.out.println (c.getCount() +"\n");

	System.out.println (d);
	d.countSolutions();
	System.out.println (d.getCount() +"\n");

	System.out.println (e);
	e.countSolutions();
	System.out.println (e.getCount() +"\n"); */
	
    } 
}
