package Ch12_Sort;

import java.util.LinkedList;
import java.util.Queue;

public class MergeSortQueue {
	
	public static void merge(Queue<Integer> s1, Queue<Integer> s2, Queue<Integer> s ){
		
		while (!s1.isEmpty() && !s2.isEmpty()) {
			if (s1.peek() < s2.peek()) 
				s.add(s1.remove());
			else 
				s.add(s2.remove());
		}
		
		while (!s1.isEmpty())
			s.add(s1.remove());		// move any remaining elements in s1 to s
		
		while (!s2.isEmpty())
			s.add(s2.remove());		// move any remaining elements in s2 to s
	}
	
	public static void mergeSort(Queue<Integer> s){
		int n = s.size();
		if (n<2)
			return;
		
		// divide
		Queue<Integer> s1 = new LinkedList<Integer>();
		Queue<Integer> s2 = new LinkedList<Integer>();
		
		while(s1.size()<n/2)
			s1.add(s.remove());		// move first n/2 elements of s to s1
		
		while(!s.isEmpty())
			s2.add(s.remove());		// move all remaining elements of s to s2
		
		// conquer
		mergeSort(s1);
		mergeSort(s2);
		
		// merge results
		merge(s1,s2,s);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> s = new LinkedList<Integer>();
		s.add(5);
		s.add(2);
		s.add(4);
		s.add(7);
		s.add(1);
		s.add(3);
		s.add(2);
		s.add(6);
		
		mergeSort(s);
		
		while(!s.isEmpty()){
			System.out.print(s.remove()+" ");
		}
	}

}
