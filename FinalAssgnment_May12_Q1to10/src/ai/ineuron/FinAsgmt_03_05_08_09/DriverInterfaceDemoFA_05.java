package ai.ineuron.FinAsgmt_03_05_08_09;

//Problem-Solution:05

interface IShape{
	
	//by default public ,static and final variables
	double pi = 3.14;
	
	//abstract method
	double calculateArea();
	
	//static method from java 8
	static void staticMethod() {
		System.out.println("A static method of Interface");
	}
	//default method from java 8
	default void defaultMethod() {
		System.out.println("Inside default Method of IShape");
	}
	
}

interface IB{
	
	void display();
}

class Circle implements IShape,IB{

	int radius;
	
	Circle(){
		
	}
	
	Circle (int radius){
		this.radius = radius;
	}
	
	@Override
	public void display() {
		System.out.println("Interface allows to implement MultipleInheritance!!");
		
	}

	@Override
	public double calculateArea() {
		
		return (pi*radius*radius);
	}
	
}
public class DriverInterfaceDemoFA_05 {

	public static void main(String[] args) {

		IShape circleObj = new Circle(10);
		circleObj.defaultMethod();
		IShape.staticMethod();
		System.out.println("The area of Circle is :: "+circleObj.calculateArea());
		
		IB ibObject = new Circle();
		ibObject.display();
		
		
}
}