import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Linear{

	private boolean LinearSearch(int[] arr, int k){
		for (int i=0; i < arr.length ; i++) {
			if(arr[i] == k){
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("The element to print in the array: ");

		int search = Integer.parseInt(reader.readLine());
		
		int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};

		Linear linear = new Linear();

		if(linear.LinearSearch(arr, search)){
			System.out.println("The element is " + search + " present in the array.");	
		}
		else{
			System.out.println("The element is not present in the array");		
		}
		

	}
}