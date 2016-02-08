package Ch9_Priority_Queues;

import java.util.ArrayList;

/**
 * Implementation of max pq using heap as a data structure 
 *
 * @param <V>
 */
public class Heap {
	
	// The heap is built using a dynamic Array to make insertion easier
	// Index will serve as key and value at index will be value
	ArrayList<Integer> heap = new ArrayList<>();
	
	public int parent(int key){
		return key/2;
	}
	
	public int left(int key){
		return 2*key;
	}
	
	public int right(int key){
		return 2*key+1;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
}
