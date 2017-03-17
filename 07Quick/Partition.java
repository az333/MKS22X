import java.util.*;

public class Partition {

    public static int part (int[] data, int start, int end) {
	Random rand = new Random ();
	int pivotIndex = rand.nextInt(end) + start;
	int pivot = data[pivotIndex];
	System.out.println ("pivotIndex: " + pivotIndex);
	System.out.println ("pivot: " + pivot);
	while (start <= end) {
	    while (data[start] < pivot)  {
		start ++;
	    }
	    while (data[end] > pivot) {
		end --;
	    }

	    System.out.println ("start: " + start);
	    System.out.println ("end: " + end);
	     System.out.println ("Before Swap: "  + toString(data));

	    
	    if (start <= end) {

		data = swap (data, start, end);

		if (data[start] != pivot) { 
		    start ++;		  
		} if (data[end] != pivot || (data[start] == pivot && data[end] == pivot)) {
		    end --;
		}	      
	    }
	    
	    System.out.println ("After Swap: "  + toString(data)); 
	}
               

	System.out.println ("End: "  + toString(data)); 
	return start;
	

    } 

    public static int[] swap (int[] data, int first, int second) {
	int temp = data[first];
	data[first] = data[second];
	data[second] = temp;
	return data; 
    } 
	
    public static String toString(int[] data) {
	String str = "[ ";
 
	for (int j = 0; j < data.length; j++) {
	    str += data[j];
	    str += " ";
	}

	str += "]";
	return str;
    }
 
 
    public static void main(String[] args){
	int[] ary = {1,1,1,1,1};
	int[] ary2 = {1,5,89,12,65,2,4,2,5,3,6};
        	
	//part(ary2,0,ary2.length-1);
	//	part(ary3,0,ary3.length-1);
	//part(ary4,0,ary4.length-1);

	//System.out.println (part(ary,0,ary.length-1));
	//	System.out.println(toString(ary));
	//	System.out.println ("\n\n");
	
	System.out.println ("End index: "  +part(ary,0,ary.length-1));
	//	System.out.println(toString(ary2));
	System.out.println ("\n\n");
	
	
	//	System.out.println(toString(ary3));
	//	System.out.println(toString(ary4));
 
    }
}
