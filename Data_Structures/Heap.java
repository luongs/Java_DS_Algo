package Ch9_Priority_Queues;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Implementation of max pq using heap as a data structure 
 *
 * @param <V>
 */
public class Heap {
	
	// The heap is built using a dynamic Array to make insertion easier
	// Index will serve as key and value at index will be value
	ArrayList<Integer> heap;
	int heapSize;
	
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
	
	public int getHeapSize() {
		return heapSize; 
	}
	
	// Check and move root value to proper position to maintain heap 
	// property. Assume heap left and right have kept heap property. 
	// O(log n)
	public void downHeap(ArrayList<Integer> arr, int key, int heapSize) {
		int leftIndex = left(key);
		int rightIndex = right(key);
		int largestIndex;
		// Subtract one since heap is zero-indexed
		heapSize = heapSize-1;
		
		if (leftIndex<=heapSize && arr.get(leftIndex) > arr.get(key)){
			largestIndex = leftIndex;
		}
		else{
			largestIndex = key;
		}
		if (rightIndex<=heapSize && arr.get(rightIndex) > arr.get(largestIndex))
			largestIndex = rightIndex;
		
		if (largestIndex != key){
			// swap value at key and largestIndex
			int temp = arr.get(key);
			arr.set(key, arr.get(largestIndex));
			arr.set(largestIndex, temp);
			// repeat to move key to proper position
			downHeap(arr, largestIndex, heapSize);
		}
	}
	
	// Reorder unsorted heap into max heap
	// Starts from 1/2 array in order to start at parents of leaves
	// O(n) 
	public void buildMaxHeap(ArrayList<Integer> arr, int heapSize) {
		// startIndex of last parent
		int startIndex = (int) Math.ceil(arr.size()/2) - 1;
		
		for (int i = startIndex; i>=0; i--){
			this.downHeap(arr,i, heapSize);
		}
	}
	
	// Heapsort performed on a max heap
	// O(n log n) in place
	public void heapSort(ArrayList<Integer> arr, int heapSize) {
		this.buildMaxHeap(arr, heapSize);
		
		for (int i = arr.size()-1; i>=0; i--) {
			// swap values
			int temp = arr.get(0);
			arr.set(0, arr.get(i));
			arr.set(i, temp);
			// Decrement heap size to exclude sorted values 
			// from being moved. Those values are already at 
			// the right position!
			heapSize--;
			this.downHeap(arr,0, heapSize);
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
		
		ArrayList<Integer> unorderedHeap = new ArrayList<>();
		unorderedHeap.add(4);
		unorderedHeap.add(1);
		unorderedHeap.add(3);
		unorderedHeap.add(2);
		unorderedHeap.add(16);
		unorderedHeap.add(9);
		unorderedHeap.add(10);
		unorderedHeap.add(14);
		unorderedHeap.add(8);
		unorderedHeap.add(7);
		
		System.out.println("Value 4 breaks max heap property");
		System.out.println(heap.toString());
		// Downheap to correct heap config
		cur.downHeap(heap, 1, heap.size());
		System.out.println("Fix with Downheap");
		System.out.println(heap.toString());
		System.out.println("===================================");
		System.out.println("Unordered heap");
		System.out.println(unorderedHeap.toString());
		System.out.println("Fix using buildMaxHeap()");
		cur.buildMaxHeap(unorderedHeap, heap.size());
		System.out.println("Unordered heap sorted into max heap");
		System.out.println(unorderedHeap);
		System.out.println("===================================");
		
		// Heapsort from smallest to largest
		System.out.println("Initial before heapsort");
		System.out.println(heap);
		cur.heapSort(heap, heap.size());
		System.out.println("heapSort: ");
		System.out.println(heap);
		System.out.println("===================================");


	}
	
}
