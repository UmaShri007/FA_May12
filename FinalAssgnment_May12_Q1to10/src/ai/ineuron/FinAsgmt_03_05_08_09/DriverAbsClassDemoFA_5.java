package ai.ineuron.FinAsgmt_03_05_08_09;

//Problem-Solution:05

interface IShape01{
	
	void calcArea();
	
}

abstract class ShapeImpl implements IShape01{
	
	int side1;
	int  side2;
	
	 ShapeImpl(int s1, int s2) {
		side1 = s1;
		side2 = s2;
	}

	//abstract method of an abstract class
	abstract void drawFig();
	
	//non-abstract method of an abstract class
	void  display() {
		System.out.println( "Non-abstract meethods of a abstract class");
	}
	
}

class Rectangle extends ShapeImpl{
	
	int area;
	
	Rectangle(int s1,int s2){
		super(s1,s2);
				
	}
	
	@Override
	public void calcArea() {
		System.out.println("Inside calcArea of Rectangle");
		area  = side1*side2;
		System.out.println("The area of rectangle of"+side1+" and "+side2+" is "+area);
	}

	@Override
	public void drawFig() {
		System.out.println("Draw a rectangle of dimension "+side1+" and "+side2);
	}
	
}
public class DriverAbsClassDemoFA_5 {

	public static void main(String[] args) {

		ShapeImpl obj = new Rectangle(12,13);
		obj.calcArea();
		obj.drawFig();
		obj.display();
}
}