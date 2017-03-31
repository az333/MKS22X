import java.util.*;

public class Quick {

    public static int partOld (int[] data, int start, int end, int pivotIndex) {
	int pivot = data[pivotIndex];
	//System.out.println ("pivotIndex: " + pivotIndex);
	//System.out.println ("pivot: " + pivot);
	data = swap (data, pivotIndex, start);

	int lt = start;
	int gt = end;
	//System.out.println ("Before Swap: "  + toString(data));
							  
	while (start <= gt) {
	    
	    //System.out.println ("start: " + start);
	    //System.out.println ("end: " + end);
	    // System.out.println ("lt: " + lt);
	    // System.out.println ("gt: " + gt);
	    
	    //System.out.println ("During Swap: "  + toString(data));
	    if (data[start] < pivot)  {
		data = swap (data, lt, start);
		lt ++; 
		start ++;
	    } else  if (data[start] > pivot) {
		data = swap (data, gt, start); 
		gt --;
	    } else {
		start ++;
	    } 
	
	}        
	//System.out.println ("End: "  + toString(data)); 
	return lt;
	
    }
    
    public static int partOld (int[] data, int  start, int end) {
	Random rand = new Random ();
	int pivotIndex = rand.nextInt((end - start) + 1) +  start;
	return partOld (data, start, end, pivotIndex);
    }
    
    public static int quickselect(int[] data, int k, int left, int right){
	if(left == right){
	    return data[k];
	}
	int pivotIndex = partOld(data, left, right);
	if(pivotIndex == k){
	    return data[k];
	}if(k < pivotIndex){
	    return quickselect(data, k, left, pivotIndex-1);
	}else{
	    return quickselect(data, k, pivotIndex+1, right);
	}
    }


    public static int quickselect (int[] data, int k) {
	if (data.length > 0) {
	    return quickselect (data,k,0,data.length -1);
	}
	return 0;
    }
    
    public static int quickselectOld (int [] data, int k) {
	int pivotIndex = 0,start = 0, end = data.length -1;
        while (start <  end) {	   
	    pivotIndex = partOld (data,start,end);
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

    public static void quicksort(int[]data, int left, int right){

	if (left >= right) {
	    return;
	}
	Random rand = new Random ();
	int pivotIndex = rand.nextInt((right - left) + 1) +  left;
	int pivot = data[pivotIndex];

	//System.out.println ("pivotIndex: " + pivotIndex);
	//System.out.println ("pivot: " + pivot);
	data = swap (data, pivotIndex, left);

	int lt = left;
	int gt = right;
	int i = left; 
	//	System.out.println ("Before Swap: "  + toString(data));
	
	while (i <= gt) {

	    /* System.out.println ("start: " + left);
	    System.out.println ("i: " + i);
	    System.out.println ("end: " + right);
	     System.out.println ("lt: " + lt);
	     System.out.println ("gt: " + gt); 
	    System.out.println ("During Swap: "  + toString(data)); */
	    
	    if (data[i] == pivot)  {
		i ++;
	    } else  if (data[i] < pivot) {
		data = swap (data, i, lt); 
		lt ++;
		i ++;  
	    } else {
	        swap(data, i, gt);
                gt--;
	    } 
	
	}        

	/*	 System.out.println ("start: " + left);
	 System.out.println ("end: " + right);
	 System.out.println ("i: " + i);
	 System.out.println ("lt: " + lt);
	 System.out.println ("gt: " + gt); */ 
	 

	 if ( lt > 0) { 
	     quicksort(data, left, lt-1);
	 }
	 quicksort(data, gt + 1, right);
            
	
        

	 //	System.out.println ("End: "  + toString(data)); 
    
     
    }

    public static int[] swap (int[] data, int first, int second) {
	int temp = data[first];
	data[first] = data[second];
	data[second] = temp;
	return data; 
    }

    public static void quicksort(int[] ary) {
	quicksort (ary, 0, ary.length - 1);
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
	int[]ary = { 2, 10, 15, 23, 0,  5, 5, 5, 5, 5, 5, 5};
	int[] ary2 = new int[1000];

	for (int i = 0; i < ary2.length; i ++) {
	    ary2[i] = 1;
	}

	for ( int i = 0; i < ary2.length; i ++) {
	    quickselect (ary2,i);

	}

	quicksort(ary);

	System.out.println (toString(ary));

	//System.out.println ("DONE");
						 

	//System.out.println ( quickselect(ary, 0) );
	//System.out.println ( quickselect(ary, 1) );
	//System.out.println ( quickselect(ary, 2) );
	//System.out.println ( quickselect(ary, 3) );
	//System.out.println ( quickselect(ary, 4) );
	//System.out.println ( quickselect(ary, 5) );

	
	
    }
}
