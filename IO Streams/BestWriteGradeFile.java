 /* Demonstrating how to write basic data types to a text file
    
 */

 import java.io.FileWriter;
 import java.io.PrintWriter;
 import java.io.BufferedWriter;
 import java.io.FileNotFoundException;
 import java.io.IOException;

 public class BestWriteGradeFile
 {
   public static void main( String [ ] args )
   {
     try
     {
       FileWriter fw = new FileWriter
               ( "grades.txt", false );      
       BufferedWriter bw = new BufferedWriter( fw );
	   PrintWriter pw=new PrintWriter(bw);
      
       pw.print( "CS130: " );
       pw.println( 95 );
       pw.print( "Letter grade: " );
       pw.println( 'A' );
       pw.print( "Current GPA: " );
       pw.println( 3.68 );
       pw.print( "Successful student as of Spring semester: " );
       pw.println( true );
       
		bw.flush();
		bw.close();		
       // release the resources associated with grades.txt
       pw.close( );
     }
	 catch (IOException e)
	 {
		 System.out.println( "Text errors" );
	 }
   }
}  
