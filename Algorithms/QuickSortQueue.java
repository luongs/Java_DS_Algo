package Ch12_Sort;

import java.util.LinkedList;
import java.util.Queue;

public class QuickSortQueue {
	
	public static void quickSort(Queue<Integer> s){
		int n = s.size();
		
		if(n<2)		// queue is trivially sorted
			return;
		
		// divide
		int pivot = s.peek();
		Queue<Integer> L = new LinkedList<Integer>();	// Queue with elements < pivot
		Queue<Integer> E = new LinkedList<Integer>();	// Queue with element = pivot
		Queue<Integer> G = new LinkedList<Integer>();	// Queue with elements > pivot
		
		while (!s.isEmpty()) {
			int	element = s.remove();
			
			if (element<pivot)
				L.add(element);
			else if (element>pivot)
				G.add(element);
			else	// element equal
				E.add(element);
		}
		
		// conquer
		quickSort(L);	// sort elements less than pivots
		quickSort(G);	// sort elements greater than pivots
		
		// concatenate results
		while(!L.isEmpty())
			s.add(L.remove());
		
		while(!E.isEmpty())
			s.add(E.remove());
		while(!G.isEmpty())
			s.add(G.remove());
		
	}
	
	public static void main(String[] args) {
		int[] unsorted = {5,2,4,7,1,3,2,6};
		Queue<Integer> s = new LinkedList<Integer>();
		
		for(int i=0; i<unsorted.length; i++){
			s.add(unsorted[i]);
		}
		
		quickSort(s);
		
		while(!s.isEmpty()){
			System.out.print(s.remove()+" ");
		}
	}

}
