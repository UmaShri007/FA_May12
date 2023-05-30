package ai.ineuron.FinAsgmt_02_04_06_07_10;

// Problem-Solution:02
// Program to invoke Parent Class constructor from Childd class.

class Parent{
	
	String name;
	String mssg;
	
	Parent(){
		System.out.println("Parent class default zero-arg Constructor");
	}
	
	
}
class Child extends Parent{
	
	int number;
	
	Child () {
		
		System.out.println("Inside child class zero -arg constructor");
	}
	
	Child(int value){
		System.out.println("Inside child class parameterized constructor");
		number = value;
		System.out.println(number);
	}
}
class GrandChild extends Child{

//	To call the parameterized constructor of the parent class, 
//	the super keyword must be the first statement inside the child class constructor, 
//	and we must pass the parameter values.
	
	GrandChild(){
		super(20);
		System.out.println("Inside grandd child classs zero-arg constructor and  explicitly invoikng parameteized constructor of Child class.");
	}
	GrandChild (String name,String mssg) {
		System.out.println("Inside GrandChild class parameterized constructor");
		this.name = name;
		this.mssg = mssg;
		System.out.println(name+","+mssg);
	}
	
	
}
public class DriverMainFA_02 {

	public static void main(String[] args) {
		
		Parent pObj = new GrandChild();
		pObj = new GrandChild("Aspirants","All the Best!!");
	}

}
