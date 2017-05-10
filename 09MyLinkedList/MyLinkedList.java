java.util.*;

public class MyLinkedList implements Iterable<Integer> {

    private LNode start, end; 
    private int size;

    private class MyIterator implements Iterator<Integer>{
	
	private MyLinkedList list;
	private int i;
	
	public MyIterator(MyLinkedList list){
	    this.list = list;
	}

	public void remove(){throw new UnsupportedOperationException();}

	
	public boolean hasNext(){
	    return list.size > i; 
	}
	
	public Integer next(){
	    if(hasNext()){
		i ++;
		return list .get(i - 1);
	    } else{
		throw new NoSuchElementException();
	    }
	}

    }

    private class LNode {
	
	public LNode next = null, prev = null; 
	public xint value;

	public LNode (int value) {
	    this.value = value;
	}

	public LNode () {
	}

	public LNode (int value, LNode next, LNode prev) {
	    this.value = value;
	    this.next = next;
	    this.prev = prev; 
	} 
 
	public String toString(){
	    return value+" ";
	}
	

    }

    public Iterator<Integer> iterator() {
	return new MyIterator(this);

    }
    
    public MyLinkedList () {
	start = new LNode ();
	end = new LNode ();
	size = 0;	 
    }
    
    public int size() {
	return size; 
    }
   
    public int get(int index) {
        return getNthNode(index).value;
    } 
  

    public int set(int index,int newValue) {
	LNode temp = getNthNode(index);
	int oldVal = temp.value;
	temp.value = newValue;
	return oldVal;     
    }

    public String toString () {
	String str = "[ ";
	LNode temp = start; 
	for (int i = 0; i < size; i ++) {
	    str += temp; 
	    temp = temp.next; 
	}
	str += "]";
	return str;
    }

    private LNode getNthNode(int n){
	if (n < 0 || n >= size) {
	    throw new IndexOutOfBoundsException();
	}
	LNode temp;
	if (n < size / 2) {
	    temp = start; 
	    for (int i = 0; i < n; i ++) {
		temp = temp.next;
	    }
	} else {
	    temp = end;
	    for (int i = size - 1; i >= 0; i --) {
		temp = temp.prev;
	    }
	}
	return temp; 
    }
    
    private void addAfter(LNode location, LNode toBeAdded){
	toBeAdded.next = location.next;
	toBeAdded.prev = location;
	location.next = toBeAdded;
	location.next.prev = toBeAdded;
	size ++;
    }

    private void addBefore (LNode location, LNode tobeAdded) {
	LNode temp = location.prev;
	addAfter(temp, tobeAdded);	
    }

    private void remove(LNode target){
	target.prev.next = target.next;
	target.next.prev = target.prev; 
    }

    public boolean add(int value){
	add (size, value);
	return true;
    }

    public int indexOf(int value){
	LNode temp = start; 
	for (int i = 0; i < size; i ++) {
	    if (temp.value == value) {
		return i;
	    } 
	}
	return -1; 
    }

    public int remove(int index){
	if (index < 0 || index >= size) {
	    throw new IndexOutOfBoundsException();
	}
	if (index == 0) {
	    start = start.next;  
	} 
	LNode temp = start;
	for (int i = 0; i < index; i ++) {
	    temp = temp.next;
	}
	int oldVal = temp.value;
	remove (temp);
	return oldVal;	
    }

    public void add(int index,int value){
	
	LNode temp = getNthNode(index);
	addBefore(temp, new LNode(value));
    }

}



