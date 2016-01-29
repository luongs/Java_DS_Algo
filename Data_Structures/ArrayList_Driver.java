package Ch7_ArrayLists;

import java.util.ArrayList;

public class ArrayList_Driver {
	
	// The biggest advantage of the array list is 
	// the automatic resizing the array whenever
	// list grows too large. 
	
	public static void main(String[] args) {
		ArrayList<Object> al = new ArrayList<Object>();
		System.out.println("Initial size of array list: "+al.size());
		// ArrayList can take an object as a parameter to make it general
		al.add("Hello");
		al.add("World");
		al.add(5);
		al.add(0,"Start");
		al.add("Remove");
		al.add("Me");
		al.remove(al.indexOf("Remove"));
		
		System.out.println("Content of array list: "+al);
		

	}

}
