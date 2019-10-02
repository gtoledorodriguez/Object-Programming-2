package service;
import java.lang.Math;

public abstract class CircleVolume{
	private double radius;
	CircleVolume cVol;
	
	public CircleVolume(){
		this.radius = 0;
	}
	public CircleVolume(double radius){
		this.radius = radius;
	}
	public CircleVolume(CircleVolume cV){
		cVol = cV;
	}
	
	public double getRadius(){
		return this.radius;
	}
	
	public void setRadius(double radius){
		this.radius = radius;
	}
	
	public double getCircumference(){
		double C = 0;
		C = 2*(22d/7d)*this.radius;
		return C;
	}
	
	public double getArea(){
		double A = 0;
		A = (22d/7d)*(this.radius*this.radius);
		return A;
	}
	
	public abstract double getVolume();
	
	public String toString(){
		String str = "";
		str = "\nRadius: " + this.getRadius() + "\nArea: " + this.getArea() + "\nCircumference: " + this.getCircumference();
		return str;
	}
}