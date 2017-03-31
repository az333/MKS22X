import java.util. *;
public class Merge {
    
    public static void merge (int[] a, int[] b, int[] destination) {
	int aIndex = 0;
	int bIndex = 0;
	while (aIndex + bIndex < destination.length) {  
	    if (bIndex < b.length && (a.length <= aIndex || a[aIndex] > b[bIndex])) {
		destination[aIndex + bIndex] = b[bIndex];
		bIndex ++;
	    } else if (aIndex < a.length && (b.length <= bIndex || b[bIndex] >= a[aIndex])) {
		destination[aIndex + bIndex] = a[aIndex];
		aIndex ++;
	    }
	}	
    }
      
    public static void mergesort (int[] ary) {
	if (ary.length < 2) {
	    return; 
	}
	int[] a = Arrays.copyOf(ary, ary.length / 2);
	int[] b = Arrays.copyOfRange(ary, ary.length / 2, ary.length);
	mergesort(a);
	mergesort(b);
	merge (a, b, ary);
	
    }

    	
    public static String toString (int[] ary) {
	String str = "[ "; 
	for (int i = 0; i < ary.length; i ++) {
	    str += ary[i] + " "; 
	}
	str += "]";
	return str; 

    } 

    public static void main (String args[]) {
	int[] a = { 1, 3, 4, 6};
	int[] b = { 1, 2, 2, 8, 10, 11};
        

	mergesort (a);

	System.out.println (toString(a));
	

    } 



}
