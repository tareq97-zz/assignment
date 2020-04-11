import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Binary{

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

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("The element to print in the array: ");
		int x = Integer.parseInt(reader.readLine());

		int arr[] = {1,2,3,4,5,6,7,8,9,10}; 
    	int n = arr.length - 1; 
    	Binary binary = new Binary();
    	boolean result = binary.BinarySearch(arr, 0, n ,x);
    	if(result == false)System.out.println("Element is not present in array");
        else System.out.println("Element is present in the array "); 
	}
}