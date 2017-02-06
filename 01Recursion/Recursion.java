
public class  Recursion {

    public static String name(){
	return "Zverovich,Angelica";
    }

    public static  boolean isCloseEnough(double a,double b){
	if (a == 0 && b == 0 ) {
	    return true;
	}
	else if (a == 0 || b == 0) {
	    return false;
	}
	else {
	    double PE = Math.abs ((a - b) / a);
	    if (PE > 0.000000000000001) {
		return false;
	    }
	    else {
		return true;
	    }
   
	}
    }
    
    public static double sqrt (int n) {
	if ( n < 0) {
	    throw new IllegalArgumentException();
	}
	return  sqrthelp(n, 1);
    }

    private static double sqrthelp (int n, double  guess) {
	if (n == 0) {
	    return 0;
	}
	if (isCloseEnough (guess * guess, n)) {
	    return guess;
	}
	return sqrthelp(n, ((n/guess + guess) /2.0));
	  
    }
	
    public static void main (String[] args) {

    }
}
