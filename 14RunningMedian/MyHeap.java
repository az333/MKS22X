import java.util.*;

public class MyHeap {

    private ArrayList<Integer> heap;

    public MyHeap () {
	this (true); 
    }

    public MyHeap (boolean max) {
        heap = new ArrayList<String>();
	heap.set(0) = 0; 
	if (max) {
	    a = 1;
	} else {
	    a = -1;
	} 
    }

    public void size () {
	return heap.size();
    } 

    public void add (String s) {

    }

    private  pushUp(int index) {
	while (
    }

    private int parentOf (int index) {
	return index/2; 
    }

    private int childOf (int index) {
	return index * 2; 
    } 
    

    public String peek() {
        if (size - 1 > 0) {
	    return heap.get(1); 
	} else {
	    throw new NoSuchElementException();
	}
    } 

    


}
