import java.util.*;

public class MyHeap {

    private ArrayList<String> heap;
    private int a; 

    public MyHeap () {
	this (true); 
    }

    public MyHeap (boolean max) {
        heap = new ArrayList<String>();
	heap.add("blank"); 
	if (max) {
	    a = 1;
	} else {
	    a = -1;
	} 
    }

     
    private void swap(int index1, int index2){
	String temp = heap.get(index1);
	heap.set(index2,heap.get(index1));
	heap.set(index1, temp);
    }

    public void size () {
	return heap.size() - 1;
    }

    public String peek(){
	if (size() <= 0){
	    throw new NoSuchElementException();
	}else{
	    return heap.get(1);
	}
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
