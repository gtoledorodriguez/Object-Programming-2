package client;
import superclass.GeometricFigure;
import subclass.Square;
import subclass.Triangle;
import java.util.Vector;

public class UseGeometric{
	public static void main(String[] args){
		Square s1 = new Square();
		Square s2 = new Square(2,2);
		Square s3 = new Square(3,3);
		Square s4 = new Square(4,4);
		Square s5 = new Square(5,5);
		
		Triangle t1 = new Triangle();
		Triangle t2 = new Triangle(2,2);
		Triangle t3 = new Triangle(3,3);
		Triangle t4 = new Triangle(4,4);
		Triangle t5 = new Triangle(5,5);
		
		Vector<GeometricFigure> v1 = new Vector<GeometricFigure>();
		v1.add(s1);
		v1.add(s2);
		v1.add(s3);
		v1.add(s4);
		v1.add(s5);
		
		v1.add(t1);
		v1.add(t2);
		v1.add(t3);
		v1.add(t4);
		v1.add(t5);
		
		for(int i=0; i<v1.size();i++){
			GeometricFigure gF1 = v1.get(i);
			System.out.println(gF1.toString());
		}
	}
}