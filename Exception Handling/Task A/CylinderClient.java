package client;
import service.Circle;
import service.Cylinder;

public class CylinderClient{
	public static void main(String[] args){
		Circle circle1 = new Circle(5);
		System.out.println("\nCircle 1: " + circle1.toString());
		
		Cylinder cylinder1 = new Cylinder(4,6);
		System.out.println("\nCylinder 1: " + cylinder1.toString());
		
		Cylinder cylinder2 = new Cylinder(circle1, 10);
		System.out.println("\nCylinder 2: " + cylinder2.toString());
		
		circle1.setRadius(10);
		System.out.println("\nCircle 1 with new Radius: " + circle1.toString());
		
		System.out.println("\nCall Circle methods on Cylinder1");
		System.out.println("Circumference: " + cylinder1.calCircum());
		System.out.println("Area: " + cylinder1.area());
	}
}