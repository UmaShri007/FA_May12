package ai.ineuron.FinAsgmt_03_05_08_09;

// Problem-Solution:03

import java.util.Scanner;

//**** Class that generates a custom exception ****
class NegativeNumberException extends Exception{
	
	public NegativeNumberException(String mssg){
		
		super(mssg);
	}
	
}
//**** Class that uses NegativeNumberException ****
class GenCustomException {
	
	private int number;
	
	public void acceptInput() {

		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter a number");
		number = scan.nextInt();

	}

	public void validate()throws NegativeNumberException  {
		if(number > 0)
			System.out.println("The user input number is:: "+number);
		else  {
			String mssg = "Number is negative number,its less than 0";
			NegativeNumberException nne = new NegativeNumberException(mssg);
//			System.out.println(nne.getMessage());
			throw nne;
	}
}
}
// ****** Driver Class *******
public class CustomExceptionHandler {

	public static void main(String[] args) {

		GenCustomException object = new GenCustomException();
		object.acceptInput();
		
		try {
			object.validate();
		} 
		catch (NegativeNumberException e) {
		System.out.println("NegativeNumberException caught");
		System.out.println(e);
		
		}
		System.out.println("Rest of the below the catch block will be exceuted!");

	}

}
