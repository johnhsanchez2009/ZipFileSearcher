import java.util.zip.*;
import java.io.*;
import java.util.Enumeration;

// Lists all the files of a given type within a given zip folder
public class ZipFileSearcher
{
   private static String FILE_NAME;
   private static String EXTENSION;
   public static void main (String[] args) throws IOException
   {
      FILE_NAME = args[0];
      EXTENSION = args[1];
      readUsingZipFile();
   }
   
   private static void readUsingZipFile() throws IOException 
   {
      final ZipFile file = new ZipFile(FILE_NAME);
      System.out.println("Zip file to be searched: " + FILE_NAME);
      int count = 0;
      
      try {
         final Enumeration<? extends ZipEntry> entries = file.entries();
         while (entries.hasMoreElements())
         {
            final ZipEntry entry = entries.nextElement();
            if (entry.getName().endsWith(EXTENSION))
            {
               System.out.println("File: " + entry.getName());
               count++;
            }
         }
         
         System.out.println();
         System.out.println("Numbers of files ending with " + EXTENSION + ": " +count);
         System.out.printf("Zip file %s extracted successfully", FILE_NAME);
      }
      finally {
         file.close();
      }
   }
}
