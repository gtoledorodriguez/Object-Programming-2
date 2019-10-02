package client;
import service.CircleVolume;
import service.Cylinder;
import service.Sphere;
import java.lang.Math;
import java.util.Vector;

public class CylinderSphereClient{
	public static void main(String[] args){
		Cylinder cy1 = new Cylinder(30,35);
		System.out.println("\nCylinder 1: " + cy1.toString());
		
		Sphere s1 = new Sphere(10);
		System.out.println("\nSphere 1: " + s1.toString());
		
		
		
		System.out.println("\nCylinder 1 calls CircleVolume method area:\n Area: " + cy1.getArea());
		
		System.out.println("\nSphere 1 calls CircleVolume method circumference:\n Circumference: " + s1.getCircumference());
		
		Vector<CircleVolume> v1 = new Vector<CircleVolume>();
		Cylinder cy2 = new Cylinder(6,5);
		Sphere s2 = new Sphere(18);
		Cylinder cy3 = new Cylinder(65,31);
		Sphere s3 = new Sphere(51);
		
		v1.add(cy2);
		v1.add(s2);
		v1.add(cy3);
		v1.add(s3);
		
		for(int i = 0;i<v1.size();i++){
			System.out.println(v1.get(i).toString());
		}
	}
}