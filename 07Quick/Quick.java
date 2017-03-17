import java.util.*;

public class Quick {

    public static int part (int[] data, int start, int end, int pivotIndex) {
	int pivot = data[pivotIndex];
	//System.out.println ("pivotIndex: " + pivotIndex);
	//System.out.println ("pivot: " + pivot);
	while (start <= end) {
	    while (data[start] < pivot)  {
		start ++;
	    }
	    while (data[end] > pivot) {
		end --;
	    }

	    //System.out.println ("start: " + start);
	    // System.out.println ("end: " + end);
	    //System.out.println ("Before Swap: "  + toString(data));
	    
	    if (start <= end) {

		data = swap (data, start, end);

		if (data[start] != pivot) { 
		    start ++;		  
		} if (data[end] != pivot || (data[start] == pivot && data[end] == pivot)) {
		    end --;
		}	      
	    }    
	    //System.out.println ("After Swap: "  + toString(data)); 
	}        
	//System.out.println ("End: "  + toString(data)); 
	return start;
	
    } 

    public static int part (int[] data, int  start, int end) {
	Random rand = new Random ();
	int pivotIndex = rand.nextInt((end - start) + 1) +  start;
	return part (data, start, end, pivotIndex);
    } 
 
    public static int quickselect (int [] data, int k) {
	int pivotIndex = 0,start = 0, end = data.length -1;
        while (start <  end) {	   
	    pivotIndex = part (data,start,end);
	    if (pivotIndex > k) {
		end = pivotIndex - 1; 
	    } else if (pivotIndex < k) {
		start = pivotIndex + 1;
	    } else {
		return data[pivotIndex];
	    }
	    // System.out.println ("PIVOTINDEX:  " + pivotIndex);
	    //System.out.println ("K: " + k);
	    //System.out.println ("START: " + start);
	    //System.out.println ("END: " + end);
	}
	return data[start];
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
	int[]ary2 = { 2, 10, 15, 23, 0,  5};
	int[] ary = {1,1,1,1,1,1,1};

	System.out.println ( quickselect(ary, 0) );
	System.out.println ( quickselect(ary, 1) );
	System.out.println ( quickselect(ary, 2) );
	System.out.println ( quickselect(ary, 3) );
	System.out.println ( quickselect(ary, 4) );
	System.out.println ( quickselect(ary, 5) );
	
    }
}
