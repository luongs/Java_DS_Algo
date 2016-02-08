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
	ArrayList<Integer> heap;
	
	public Heap() {
		heap = new ArrayList<Integer>();
	}
	
	public int parent(int key){
		return key/2;
	}
	
	public int left(int key){
		return 2*key+1;
	}
	
	public int right(int key){
		return 2*key+2;
	}
	
	// Check and move root value to proper position to maintain heap 
	// property. Assume heap left and right have kept heap property.  
	public void downHeap(ArrayList<Integer> arr, int key) {
		int leftIndex = left(key);
		int rightIndex = right(key);
		int lastIndex = arr.size()-1;
		int largestIndex;
		
		if (leftIndex<=lastIndex && arr.get(leftIndex) > arr.get(key)){
			largestIndex = leftIndex;
		}
		else{
			largestIndex = key;
		}
		if (rightIndex<=lastIndex && arr.get(rightIndex) > arr.get(largestIndex))
			largestIndex = rightIndex;
		
		if (largestIndex != key){
			// swap value at key and largestIndex
			int temp = arr.get(key);
			arr.set(key, arr.get(largestIndex));
			arr.set(largestIndex, temp);
			// repeat to move key to proper position
			downHeap(arr, largestIndex);
		}
	}
	
	
	public static void main(String[] args) {
		Heap cur = new Heap();
		ArrayList<Integer> heap = cur.heap;
		heap.add(16);
		heap.add(4);
		heap.add(10);
		heap.add(14);
		heap.add(7);
		heap.add(9);
		heap.add(3);
		heap.add(2);
		heap.add(8);
		heap.add(1);
		
		System.out.println(heap.toString());
		
		// Downheap to correct heap config
		cur.downHeap(heap, 1);
		
		System.out.println("Downheap to fix");
		System.out.println(heap.toString());
		
		
		

	}
	
}
