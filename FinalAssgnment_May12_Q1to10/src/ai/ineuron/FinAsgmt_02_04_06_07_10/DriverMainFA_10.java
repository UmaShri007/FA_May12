package ai.ineuron.FinAsgmt_02_04_06_07_10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// Problem/Solution::10
// To read a set of Integer from user and store them in a list.
// Find the second largest and second smallest element in the list

public class DriverMainFA_10 {

		
	public static void main(String[] args) {

		//to get input from the user and adding it to the array list.
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the number of elements to be added in  the list");
		int numOfElements = scan.nextInt();
		
		List<Integer> arrayList = new ArrayList<Integer>();
		for(int i =0;i <= numOfElements;i++) {
			System.out.println("Enter the elements");
			int element =scan.nextInt();
			arrayList.add(element);
		}
		
		//display the arraylist
		System.out.print("The user given elements are: ");
		arrayList.forEach((n) -> System.out.print(n + " "));
		System.out.println();
		
		if(arrayList.size()<2) {
			System.out.println("Enter atleast 2 elements for sorting");
		}
		//sorting the list in ascending order using sort() in collections class
		Collections.sort(arrayList);
		System.out.print("Sorted Array List: ");
		arrayList.forEach((n) -> System.out.print(n + " "));
		System.out.println();
		
		//to find the second smallest and secondd largest number
		int secondSmallest = arrayList.get(1);
		int secondLargest = arrayList.get(numOfElements-1);
		
		System.out.println("Second Smallest Number in the ArrayList is :: "+secondSmallest);
		System.out.println("Second Largest Number in the ArrayList is :: "+secondLargest);
		
	}

}
