package superclass;

public abstract class GeometricFigure{
	private double height;
	private double weight;
	
	public GeometricFigure(){
		this.height = 1;
		this.weight = 1;
		this.area = this.height*this.weight;
	}
	
	public GeometricFigure(double height, double weight){
		this.height = height;
		this.weight = weight;
		this.area = height*weight;
	}
	
	public double getHeight(){
		return this.height;
	}
	public double getWeight(){
		return this.weight;
	}
	
	public void setHeight(double height){
		this.height = height;
	}
	public void setWeight(double weight){
		this.weight = weight;
	}
	
	public String toString(){
		String gFString = "";
		gFString = "Height: " + this.getHeight() + "\nWeight: " + this.getWeight();
		return gFString;
	}
}