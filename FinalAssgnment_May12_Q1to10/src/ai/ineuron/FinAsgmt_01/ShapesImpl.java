package ai.ineuron.FinAsgmt_01;

import java.util.Scanner;

	
	class Circle implements IShapes{
		
		private  double area;
		private  double perimeter;
		
		private float radius;
		
		
		Scanner scan = new Scanner(System.in);
		
		public void acceptInput() {
			
		System.out.println("Please enter the radius");
         radius  = scan.nextFloat();
		}
		
		@Override
		public void calculateArea(String nameOfShape) {
			area = pi*(radius*radius) ;
			System.out.println("Area of "+nameOfShape+":: "+area);
		}
		
		@Override
		public void calculatePerimeter(String nameOfShape) {
			perimeter = 2 * pi * radius;
			System.out.println("Perimeter of "+nameOfShape+":: "+perimeter);
		}
	}
		class Triangle implements IShapes{
			
			private  double area;
			private  double perimeter;
			
			private float height;
			private float base;
			private float side1,side2,side3;
			
			Scanner scan = new Scanner(System.in);
			
			public void acceptInput() {
				
				System.out.println("Please enter the base and  height of the triangle to find area");
				height  = scan.nextFloat();
				base = scan.nextFloat();
				
				System.out.println("Please enter the 3 sides  of the triangle to find perimeter");
				side1 = scan.nextFloat();
				side2 = scan.nextFloat();
				side3 = scan.nextFloat();
				
			}
			
			@Override
			public void calculateArea(String nameOfShape) {
				area = ( base*height)/2 ;
				System.out.println("Area of "+nameOfShape+":: "+area);
			}
			
			@Override
			public void calculatePerimeter(String nameOfShape) {
				perimeter = side1+side2+side3;
				System.out.println("Perimeter of "+nameOfShape+":: "+perimeter);
			}
	}

