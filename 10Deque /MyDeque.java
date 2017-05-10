import java.util.*;

public class MyDeque{
    private int size, start, end;
    private String[] ary;


    public MyDeque(){
	ary = new String[100];
    }

    public void addFirst(String str){
    	if (str == null){
	    throw new NullPointerException();
	}
	grow();
	if (size > 0){
    	    start --;
	    reposStart();
    	}
    	ary[start] = str;
    	size++;
    }

    public void grow () {
	if (size >= ary.length){
	    resize();
	}
    }
    
    public void addLast(String str){
    	if (str == null){
	    throw new NullPointerException();
	}
	grow();
	if (size > 0){
    	    end ++;
    	    rePosEnd();
    	}
    	ary[end] = str;
    	size ++;
    }  
     
  
    public String removeFirst(){
	if (size < 1){
	    throw new NoSuchElementException();
	}
	String temp = ary[start];
        start ++;
	rePosStart();
	size --;
	return temp;       
    }

    private void rePosStart () {
	if (start > ary.length - 1){
	    start = 0;
	}if (start < 0){
	    start = ary.length - 1;
	}
    }

    private void rePosEnd() {
	if (end > ary.length - 1) {
	    end = 0;
	}if (end < 0){
	    end = ary.length - 1;
	}

    } 
    
    public String removeLast(){
	if (size < 1){
	    throw new NoSuchElementException();
	}
	String temp = ary[end];
        end --; 
        rePosEnd();
	size --; 
	return temp;
    }

    private void resize(){
    	String[] temp = new String[ary.length * 2];
    	int s = start;
	for (int i = 0; i < start + size; i ++){
	    temp[i] = ary[s % ary.length];
	    s ++;
	}
	start = 0;
	end = size - 1;
	ary = temp;
    }


    public String getFirst(){
	if (size < 1)
	    throw new NoSuchElementException();
	else{
	    return ary[start];
	}
    }

    public String getLast(){
	if (size < 1)
	    throw new NoSuchElementException();
	else{
	    return ary[end];
	}
    }
    
}
