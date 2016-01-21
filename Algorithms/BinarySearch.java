package ch4_recursion;

public class BinarySearch {
	public static boolean binarySearch(int[] arr, int target, int low, int high){
		if (low>high)
			return false;
		else{
			int mid = (low+high)/2;
			if (arr[mid] == target)
				return true;
			if (arr[mid] > target)
				binarySearch(arr,target, mid+1, high);
			else
				binarySearch(arr, target, low, mid-1);
		}
		// added to make compiler happy
		return false;
		
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6};
		boolean test = BinarySearch.binarySearch(arr, 4, 0, arr.length);
		if (test)
			System.out.println("Target is in array");
		
	}
}
