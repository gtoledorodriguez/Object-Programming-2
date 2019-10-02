package subclass;
import superclass.GeometricFigure;
import superclass.SidedObject;

public class Triangle extends GeometricFigure{
	private double height;
	private double weight;
	private int noSides;
	private double area;
	
	public Triangle(){
		super(1.0,1.0);
		this.height = 1;
		this.weight = 1;
		this.area = (this.height*this.weight)/2;
		this.noSides = 3;
	}
	
	public Triangle(double height, double weight){
		super(height,weight);
		this.height = height;
		this.weight = weight;
		this.area = (height*weight)/2;
		this.noSides = 3;
	}
	
	public double getArea(){
		return this.area;
	}
	public int displaySides(){
		return this.noSides;
	}
	
	public void setArea(double height, double weight){
		this.area = (height*weight)/2;
	}
	
	public String toString(){
		String triString = "";
		triString = "\nTriangle: ";
		triString = triString + super.toString() + "\nArea: " + this.getArea();
		return triString;
	}

}