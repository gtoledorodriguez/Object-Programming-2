package client;
import service.Circle;
import service.Cylinder;
import service.Sphere;
import java.lang.Math;
import java.util.Vector;

public class CylinderSphereClient{
	public static void main(String[] args){
		Cylinder cy1 = new Cylinder(28,35);
		System.out.println("\nCylinder 1: " + cy1.toString());
		
		Sphere s1 = new Sphere(6);
		System.out.println("\nSphere 1: " + s1.toString());
		
		int numOfSpheres = Math.round((float)(cy1.volume()/s1.volume()));
		if(numOfSpheres<0){
			numOfSpheres = 0;
		}
		
		System.out.println("\nThere are " + numOfSpheres + " spheres in the cylinder.");
		
		Circle c1 = new Circle(5);
		System.out.println("\nCircle 1: " + c1.toString());
		
		System.out.println("\nCylinder 1 calls Circle method area:\n Area: " + cy1.area());
		
		System.out.println("\nSphere 1 calls Circle method circumference:\n Circumference: " + s1.calCircum());
		
		Vector<Circle> v1 = new Vector<Circle>();
		Circle c2 = new Circle(10);
		Cylinder cy2 = new Cylinder(5,10);
		Sphere s2 = new Sphere(13);
		
		v1.add(c2);
		v1.add(cy2);
		v1.add(s2);
		
		for(int i = 0;i<v1.size();i++){
			System.out.println(v1.get(i).toString());
		}
	}
}