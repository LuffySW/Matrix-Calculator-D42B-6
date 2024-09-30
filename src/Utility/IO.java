package Utility;

import java.io.*;
import Matrix.*;

public class IO {

  public static File[] getListDir() {
    // Use the current working directory and append the 'test' folder
    String currentDir = System.getProperty("user.dir"); // Gets the current working directory
    File curDir = new File(currentDir, "test"); // Create a File object for the 'test' directory
    File[] listFiles = curDir.listFiles(); // List files in the 'test' directory
    return listFiles;
  }


  public static void printListDir(){
    File[] listFiles = getListDir();
    for(int i = 0; i < listFiles.length; i++){
      System.out.println(String.format("%d. %s", i+1, listFiles[i].getName()));
    }
  }

  public static int readRow(String s) {
    int count = 0;
    try {
      // Use user.dir to construct the file path
      FileReader reader = new FileReader(String.format("%s/test/%s", System.getProperty("user.dir"), s));
      BufferedReader bufferReader = new BufferedReader(reader);

      while (bufferReader.readLine() != null) {
        count++;
      }
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return count;
  }

  public static int readCol(String s) {
    int count = 0;
    try {
      // Use user.dir to construct the file path
      FileReader reader = new FileReader(String.format("%s/test/%s", System.getProperty("user.dir"), s));
      BufferedReader bufferReader = new BufferedReader(reader);

      String line = bufferReader.readLine();
      if (line != null) {
        String[] lines = line.split(" ");
        count = lines.length;
      }
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return count;
  }

  public static Matrix readMatrix(String s) {
    Matrix a = new Matrix(readRow(s), readCol(s));

    try {
      // Use user.dir to construct the file path
      FileReader reader = new FileReader(String.format("%s/test/%s", System.getProperty("user.dir"), s));
      BufferedReader bufferReader = new BufferedReader(reader);

      String line;
      int count = 0;
      while ((line = bufferReader.readLine()) != null) {
        String[] lines = line.split(" ");
        for (int i = 0; i < lines.length; i++) {
          double temp = Operation.eval(lines[i]);
          a.setElmt(count, i, temp);
        }
        count++;
      }
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return a;
  }

  public static void writeFileMatrix(String namaFile, Matrix m) {
    try {
      // Use user.dir to construct the file path
      FileWriter writer = new FileWriter(String.format("%s/test/%s.txt", System.getProperty("user.dir"), namaFile));
      for (int i = 0; i < m.getRow(); i++) {
        for (int j = 0; j < m.getCol(); j++) {
          String temp = Double.toString(m.getElmt(i, j));
          writer.write(temp);
          writer.write(" ");
        }
        writer.write("\n");
      }
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void writeFileString(String namaFile, String s) {
    try {
      // Use user.dir to construct the file path
      FileWriter writer = new FileWriter(String.format("%s/test/%s.txt", System.getProperty("user.dir"), namaFile));
      writer.write(s);
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    
  }
}
