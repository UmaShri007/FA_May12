package ai.ineuron.FinAsgmt_02_04_06_07_10;

import java.util.Arrays;
import java.util.Scanner;

public class DriverMainFA_07 {

	public static void main(String[] args) {

		int [] myArray = {12,4,54,-24,0,65,32,17};
		
		//sorting the array using bubble sort
		
		for(int i=0;i< myArray.length;i++) {
			
			for(int j=0;j<myArray.length-1-i;j++) {
				
				if(myArray[j]>myArray[j+1]) {
					
					int temp = myArray[j];
					myArray[j]=myArray[j+1];
					myArray[j+1]=temp;
				}
				}
			}
//		System.out.println(Arrays.toString(myArray));
		
		System.out.print("Sorted array is :: ");
		for(int element:myArray) {
			System.out.print(element+" ");
		}
		
		System.out.println();
		
		//Enter the target value to be searched
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the target value to be searched: ");
		int target = scan.nextInt();
		
		//Binary Search algo to find the index of the target value
		
		boolean flag = false;
		int low =0;
		int high = myArray.length-1;
		
		while(low<=high) {
			
			int mid = (low+high)/2;
			
			if(target==myArray[mid] ) {
				System.out.println("Target element  "+target+" found at index " + mid);
				break;
			}
			
			else if(target<myArray[mid]) {
				high = mid-1;
			}
			else {
				low = mid +1;
			}
			if(low>high) {
				System.out.println("Target element not found");
			}
		}
		
	}
}
