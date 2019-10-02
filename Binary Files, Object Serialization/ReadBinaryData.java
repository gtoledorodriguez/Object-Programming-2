//Example of reading binary data

import java.io.*;
import java.util.*;

/**  Demonstrate reading primitive type values from a binary file. **/
public class ReadBinaryData
{
  public static void main (String arg[]) {
    File file = null;
    int    i_data = 0;
    double d_data = 0.0;

    // Get the file from the argument line.
    if (arg.length > 0) file = new File (arg[0]);
    if (file == null) {
      System.out.println ("Default: numerical.dat");
      file = new File ("numerical.dat");
    }

    try {
      // Wrap the FileInputStream with a DataInputStream
      FileInputStream file_input = new FileInputStream (file);
      DataInputStream data_in    = new DataInputStream (file_input );

      while (true) {
        try {
          i_data = data_in.readInt ();
          d_data = data_in.readDouble ();
        }
        catch (EOFException eof) {
          System.out.println ("End of File");
          break;
        }
        // Print out the integer, double data pairs.
        System.out.printf ("%3d. Data = %8.3e %n", i_data, d_data );
      }
      data_in.close ();
    } catch  (IOException e) {
       System.out.println ( "IO Exception =: " + e );
    }
  } // main
} // class BinInputApp 


/*OUTPUT
C:\CS116\Lectures\Lecture11Revised>java ReadBinaryData binarydata.dat
  0. Data = 1.077e+00
  1. Data = 8.243e-02
  2. Data = 6.441e+00
  3. Data = 3.640e+00
  4. Data = 8.525e+00
  5. Data = 5.570e+00
  6. Data = 8.063e-01
  7. Data = 5.632e-01
  8. Data = 3.305e+00
  9. Data = 4.531e+00
 10. Data = 4.680e-01
 11. Data = 6.139e+00
 12. Data = 2.464e+00
 13. Data = 8.997e+00
 14. Data = 6.482e+00
End of File

*/