package client;
import superclass.GeometricFigure;
import subclass.Square2;
import subclass.Triangle2;
import java.util.Vector;

public class UseGeometric2{
	public static void main(String[] args){
		Square2 s1 = new Square2();
		Square2 s2 = new Square2(2,2);
		Square2 s3 = new Square2(3,3);
		Square2 s4 = new Square2(4,4);
		Square2 s5 = new Square2(5,5);
		
		Triangle2 t1 = new Triangle2();
		Triangle2 t2 = new Triangle2(2,2);
		Triangle2 t3 = new Triangle2(3,3);
		Triangle2 t4 = new Triangle2(4,4);
		Triangle2 t5 = new Triangle2(5,5);
		
		Vector<GeometricFigure> v2 = new Vector<GeometricFigure>();
		v2.add(s1);
		v2.add(s2);
		v2.add(s3);
		v2.add(s4);
		v2.add(s5);
		
		v2.add(t1);
		v2.add(t2);
		v2.add(t3);
		v2.add(t4);
		v2.add(t5);
		
		for(int i=0; i<v2.size();i++){
			GeometricFigure gF2 = v2.get(i);
			System.out.println(gF2.toString());
		}
	}
}