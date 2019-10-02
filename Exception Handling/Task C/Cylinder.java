package service;
import service.CircleVolume;
import java.lang.Math;

public class Cylinder extends CircleVolume{
	private float height;
	private int count;
	CircleVolume circle;
	
	public Cylinder(){
		super();
		this.height = 0;
		count = 1;
	}
	public Cylinder(double radius, float height){
		super(radius);
		this.height = height;
		count = 1;
	}
	public Cylinder(CircleVolume c, float height){
		circle = c;
		this.height = height;
		count = 2;
	}
	
	public float getHeight(){
		return this.height;
	}
	
	public void setHeight(float height){
		this.height = height;
	}
	
	public double getVolume(){
		double V = 0;
		if(count == 1){
			V = (22d/7d)*(this.getHeight())*(super.getRadius()*super.getRadius());
		}
		else if(count == 2){
			V = (22d/7d)*(this.getHeight())*(circle.getRadius()*circle.getRadius());
		}
		return V;
	}
	
	public String toString(){
		String cylStr = "";
		
		if(count == 1){
			cylStr = super.toString() + "\nHeight: " + this.getHeight() + "\nVolume: " + this.getVolume();
		}
		else if(count == 2){
			cylStr = circle.toString() + "\nHeight: " + this.getHeight() + "\nVolume: " + this.getVolume();
		}
		
		return cylStr;
	}
}