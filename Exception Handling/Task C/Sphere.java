package service;
import service.CircleVolume;
import java.lang.Math;

public class Sphere extends CircleVolume{
	CircleVolume circle;
	private int count;
	
	public Sphere(){
		super();
		count = 1;
	}
	public Sphere(double radius){
		super(radius);
		count = 1;
	}
	public Sphere(CircleVolume c){
		circle = c;
		count = 2;
	}
	
	public double getVolume(){
		double V = 0;
		if(count == 1){
			V = (4/3)*(22d/7d)*(super.getRadius()*super.getRadius()*super.getRadius());
		}
		else if(count == 2){
			V = (4/3)*(22d/7d)*(circle.getRadius()*circle.getRadius()*circle.getRadius());
		}
		return V;
	}
	
	public String toString(){
		String sphereStr = "";
		
		if(count == 1){
			sphereStr = super.toString() + "\nVolume: " + this.getVolume();
		}
		else if(count == 2){
			sphereStr = circle.toString() + "\nVolume: " + this.getVolume();
		}
		
		return sphereStr;
	}
}