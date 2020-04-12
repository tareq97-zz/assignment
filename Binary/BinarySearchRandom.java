import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class BinarySearchRandom{

	public boolean BinarySearch(int arr[], int left , int right, int k) {
		
		//0>n return false
		if(left > right){
			return false;
		}

		int mid = (left + (right-left)/2);

		if(arr[mid] ==k ){
			return true;
		} else if(k < arr[mid]){
			return BinarySearch(arr, left, mid-1, k);
		}else{
			return BinarySearch(arr, mid+1, right, k);
		}
	}

	private static Random rand = new Random();

	public static int[] generateSorted(final int length, final int minVal, final int maxVal) {
   		int span = maxVal - minVal + 1;
   		int[] accumulator = new int[span];
   		for(int genIdx = 0; genIdx < length; genIdx++) {
      		accumulator[rand.nextInt(span)]++;
      		
	   	}
   		int resultIdx = 0;
   		int[] result = new int[length];
   		for(int accIdx = 0; accIdx < span; accIdx++) {
      		for(int valIdx = 0; valIdx < accumulator[accIdx]; valIdx++) {
         		result[resultIdx++] = accIdx + minVal;
    	  	}
   		}

   		return result;
	}

	public static void main(String[] args) throws IOException {
		int[] arr = generateSorted(1000, 1, 1000);
		for (int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);			
		}
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("The element to print in the array: ");
		int x = Integer.parseInt(reader.readLine());
		
    	int n = arr.length - 1; 
    	Binary binary = new Binary();
    	boolean result = binary.BinarySearch(arr, 0, n ,x);
    	if(result == false)System.out.println("Element is not present in array");
        else System.out.println("Element is present in the array "); 
	}
}