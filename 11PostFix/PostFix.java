import java.util.*;

public class PostFix {

    public static double  eval (String s) {

	String[] tokens = s.split(" ");
	Stack<Double> values = new Stack<Double>();

	for (String token: tokens) {
	    if (isOp(token)) {
		values.push(apply(token, values.pop(), values.pop()));
	    } else {
		values.push(Double.parseDouble(token));
	    }

	}
	return values.pop(); 
    }

    public static double apply (String op, double b, double a) {
	if (op.equals("+")) {
	    return a + b;
	} if (op.equals("*")) {
	    return a * b;
	} if (op.equals("/")) {
	    return a / b;
	}return a - b;
    } 

    
    public static boolean isOp (String token) {
	return (token.equals("+") || token.equals("/") || token.equals("-") || token.equals("*"));
    }

    public static void main (String[] args) {

	//System.out.println (eval("8 2 + 99 9 - * 2 + 9 -"));
    } 

} 
