package ai.ineuron.FinAsgmt_01;

// Problem-Solutin:01
// Program to calculate the area and perimeteer of various shapes using 
// the concept of Polymorphism using Interface.

public class DriverMainFA_01 {

	public static void main(String[] args) {

		 IShapes shapesObj;

		
		shapesObj = new Circle();
		shapesObj.acceptInput();
		shapesObj.calculateArea("Circle");
		shapesObj.calculatePerimeter("Circle");

		shapesObj = new Triangle();
		shapesObj.acceptInput();
		shapesObj.calculateArea("Triangle");
		shapesObj.calculatePerimeter("Triangle");
	}

}
