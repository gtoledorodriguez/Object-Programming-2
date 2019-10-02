 /* Demonstrating how to write basic data types to a text file
    
 */

 import java.io.FileWriter;
 import java.io.BufferedWriter;
 import java.io.FileNotFoundException;
 import java.io.IOException;

 public class BufferedWriteGradeFile
 {
   public static void main( String [ ] args )
   {
     try
     {
       FileWriter fw = new FileWriter
               ( "grades.txt", false );
       // false means we will be writing to grades.txt,
	   // rather than appending to it

       BufferedWriter bw = new BufferedWriter( fw );
	   int counter=0;
	   
       // write data to the file
	   String s="CS130: ";	   
       bw.write( s, 0, s.length());
	   counter=counter+s.length();
	   s="95";
	   bw.write( s, 0, s.length());
	   counter=counter+s.length();
	   bw.newLine();
	   
       s="Letter grade: ";
	  bw.write( s, 0, s.length());
	   counter=counter+s.length();
	   s="A";
	   bw.write( s, 0, s.length());
	   counter=counter+s.length();
	   bw.newLine();
	   
       
       s="Current GPA: ";
	   bw.write( s, 0, s.length());
	   counter=counter+s.length();
       s="3.68";
	   bw.write( s, 0, s.length());
	   counter=counter+s.length();
	   bw.newLine();
       
		bw.flush();
       // release the resources associated with grades.txt
       bw.close( );
     }
	 catch (IOException e)
	 {
		 System.out.println( "Text errors" );
	 }
   }
}  
