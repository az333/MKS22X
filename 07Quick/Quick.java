import java.util.*;

public class Quick {

    public static int[] part (int[] data, int left, int right) {
	Random rand = new Random ();
	int pivotIndex = rand.nextInt((right - left) + 1) +  left;
	int pivot = data[pivotIndex];
	data = swap (data, pivotIndex, left);
	
	int lt = left, gt = right, i = left;     
	while (i <= gt) {	    
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
	int[] a = {lt, gt};
	return a;
	
    }
      

    public static int[] swap (int[] data, int first, int second) {
	int temp = data[first];
	data[first] = data[second];
	data[second] = temp;
	return data; 
    }

    public static int quickselect(int[] data, int k, int left, int right){
	if(left == right){
	    return data[k];
	}
	int pivotIndex = part(data, left, right)[0];
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

    
    public static void quicksort(int[]data, int left, int right){

	if (left >= right) {
	    return;
	}

	int[] a  = part(data, left, right);
	int lt = a[0], gt = a[1];


	if ( lt > 0) { 
	    quicksort(data, left, lt-1);
	}
	quicksort(data, gt + 1, right);
     
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
	int[]ary2 = new int[10000000];
	int[]ary3 = {};

	for (int i = 0; i < ary2.length; i ++) {
	    ary2[i] = 1; 
	}



	quicksort(ary3);

	System.out.println (toString(ary3));

	//System.out.println ("DONE");
						 

	//System.out.println ( quickselect(ary, 0) );
	//System.out.println ( quickselect(ary, 1) );
	//System.out.println ( quickselect(ary, 2) );
	//System.out.println ( quickselect(ary, 3) );
	//System.out.println ( quickselect(ary, 4) );
	//System.out.println ( quickselect(ary, 5) );

	
	
    }
}
