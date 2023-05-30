package ai.ineuron.FinAsgmt_02_04_06_07_10;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

//Problem/Solution::06
//A java program to demonstarte  Stream API to sort ,filter etc

public class DriverMainFA_06 {

	public static void main(String[] args) {

		//Create a large list of data, using java.util.Arrays.asList()
		List<Integer>myList = Arrays.asList(21,17,7,1,0,32,43,64,24,6,2,52);
		System.out.print("Unsorted stream is :: ");
		myList.forEach((n) -> System.out.print(n + " "));
		System.out.println();
		
		//creating a stream for the myList---->stream()
		Stream<Integer> myStream = myList.stream();
		
		//sort the stream and display using forEach and Lambda Expression
		Stream<Integer> sortedStream = myStream.sorted();
		System.out.print("Sorted stream is :: ");
		sortedStream.forEach((n) -> System.out.print(n + " "));
		System.out.println();
		
		//to display only the odd numbers----> filter()
		Stream<Integer> oddValuedStream = myList.stream().sorted().filter((n) -> (n%2)==1);
		System.out.print("Odd numbers :: ");
		oddValuedStream.forEach((n) -> System.out.print(n + " "));
		System.out.println();
		
		//to display even valued numbers that are greater than 30
		Stream<Integer> newStream = myList.stream().sorted().filter((n) -> (n%2)==0)
									.filter((n) -> (n>30));
		System.out.print("Even numbers greater than 30 :: ");
		newStream.forEach((n) -> System.out.print(n + " "));
	}

}
