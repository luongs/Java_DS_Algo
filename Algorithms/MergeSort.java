package Ch12_Sort;

public class MergeSort {
	
	  private static int[] unsorted;
	  private static int[] copyArray;

	  public static void sort(int[] values) {
	    unsorted = values;
	    int n = values.length;
	    copyArray = new int[n];
	    mergesort(0, n - 1);
	  }

	  private static void mergesort(int low, int high) {
	    // check if low is smaller then high, if not then the array is sorted
	    if (low < high) {
	      // Get the index of the element which is in the middle
	      int middle = low + (high - low) / 2;
	      // Sort the left side of the array
	      mergesort(low, middle);
	      // Sort the right side of the array
	      mergesort(middle + 1, high);
	      // Combine them both
	      merge(low, middle, high);
	    }
	  }

	  private static void merge(int low, int middle, int high) {

	    // Copy both parts into the copyArray array
	    for (int i = low; i <= high; i++) {
	      copyArray[i] = unsorted[i];
	    }

	    int i = low;
	    int j = middle + 1;
	    int k = low;
	    // Copy the smallest values from either the left or the right side back
	    // to the original array
	    while (i <= middle && j <= high) {
	      if (copyArray[i] <= copyArray[j]) {
	        unsorted[k] = copyArray[i];
	        i++;
	      } 
	      else {
	        unsorted[k] = copyArray[j];
	        j++;
	      }
	      k++;
	    }
	    // Copy the rest of the left side of the array into the target array
	    while (i <= middle) {
	      unsorted[k] = copyArray[i];
	      k++;
	      i++;
	    }

	  }
	  
	  public static void main(String[] args) {
			
			int[] test = {5,2,4,7,1,3,2,6};
			sort(test);
			for (int i=0; i<test.length; i++){
				System.out.print(test[i]+",");
		
			}

		}

}
