package subclass;
import superclass.GeometricFigure;
import superclass.SidedObject;

public class Square extends GeometricFigure{
	private double height;
	private double weight;
	private int noSides;
	private double area;
	
	public Square(){
		super(1.0,1.0);
		this.height = 1;
		this.weight = 1;
		this.area = this.height*this.weight;
		this.noSides = 4;
	}
	
	public Square(double height, double weight){
		super(height,weight);
		this.height = height;
		this.weight = weight;
		this.area = height*weight;
		this.noSides = 4;
	}
	
	public double getArea(){
		return this.area;
	}
	
	public void setArea(double height, double weight){
		this.area = height*weight;
	}
	public int displaySides(){
		return this.noSides;
	}
	
	public String toString(){
		String sqrString = "";
		sqrString = "\nSquare: ";
		sqrString = sqrString + super.toString() + "\nArea: " + this.getArea();
		return sqrString;
	}
}