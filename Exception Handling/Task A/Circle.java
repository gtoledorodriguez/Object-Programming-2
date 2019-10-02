package service;
import java.lang.Math;

public class Circle{
	private double radius;
	
	public Circle(){
		this.radius = 0;
	}
	public Circle(double radius){
		this.radius = radius;
	}
	
	public double getRadius(){
		return this.radius;
	}
	
	public void setRadius(double radius){
		this.radius = radius;
	}
	
	public double calCircum(){
		double C = 0;
		C = 2*(22d/7d)*this.radius;
		return C;
	}
	
	public double area(){
		double A = 0;
		A = (22d/7d)*(this.radius*this.radius);
		return A;
	}
	
	public String toString(){
		String str = "";
		str = "\nRadius: " + this.getRadius() + "\nArea: " + this.area() + "\nCircumference: " + this.calCircum();
		return str;
	}
}