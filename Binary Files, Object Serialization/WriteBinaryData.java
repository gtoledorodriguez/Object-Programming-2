//Example of writing binary data


import java.io.*;
import java.util.*;

/**  Write a primitive type data array to a binary file.**/
public class WriteBinaryData
{
  public static void main (String arg[]) {
    Random ran = new Random ();

    // Create an integer array and a double array.
    int    [] i_data = new int[15];
    double [] d_data = new double[15];
    // and fill them
    for  (int i=0; i < i_data.length; i++) {
      i_data[i] = i;
      d_data[i] = ran.nextDouble () * 10.0;
    }

    File file = null;
    // Get the output file name from the argument line.
    if (arg.length > 0) file = new File (arg[0]);
    // or use a default file name
    if (file == null) {
        System.out.println ("Default: numerical.dat");
        file = new File ("numerical.dat");
    }

    // Now write the data array to the file.
    try {
      // Create an output stream to the file.
      FileOutputStream file_output = new FileOutputStream (file);
      // Wrap the FileOutputStream with a DataOutputStream
      DataOutputStream data_out = new DataOutputStream (file_output);

      // Write the data to the file in an integer/double pair
      for (int i=0; i < i_data.length; i++) {
          data_out.writeInt (i_data[i]);
          data_out.writeDouble (d_data[i]);
      }
      // Close file when finished with it..
      file_output.close ();
    }
    catch (IOException e) {
       System.out.println ("IO exception = " + e );
    }
  } // main

} // class BinOutputFileApp

 
