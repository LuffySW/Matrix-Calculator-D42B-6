package Utility;

import java.io.*;
import Matrix.*;

public class IO {

  public static File[] getListDir(){
    File curDir = new File("D:/SMT 3/Tubes Aljabar Linear/Matrix-Calculator-D42B-6/test");
    File[] listFiles = curDir.listFiles();
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
    try{
      FileReader reader = new FileReader(String.format("D:/SMT 3/Tubes Aljabar Linear/Matrix-Calculator-D42B-6/%s", s));
      BufferedReader bufferReader = new BufferedReader(reader);
  
      while(bufferReader.readLine() != null){
        count++;
      }
      reader.close();
    } catch(IOException e){
      e.printStackTrace();
    }
    return count;
  }

  public static int readCol(String s){
    int count = 0;
    try{
      FileReader reader = new FileReader(String.format("D:/SMT 3/Tubes Aljabar Linear/Matrix-Calculator-D42B-6/test/%s", s));
      BufferedReader bufferReader = new BufferedReader(reader);
      
      String line = bufferReader.readLine();
      String[] lines = line.split(" ");
      count = lines.length;
      reader.close();
    } catch(IOException e){
      e.printStackTrace();
    }
    return count;
  }

  public static Matrix readMatrix(String s){
    Matrix a = new Matrix(readRow(s), readCol(s));

    try {
      FileReader reader = new FileReader(String.format("D:/SMT 3/Tubes Aljabar Linear/Matrix-Calculator-D42B-6/test/%s", s));
      BufferedReader bufferReader = new BufferedReader(reader);

      String line;
      int count = 0;
      while((line = bufferReader.readLine()) != null){
        String[] lines = line.split(" ");
        for(int i = 0; i < lines.length; i++){
          double temp = Operation.eval(lines[i]);
          a.setElmt(count, i, temp);
        }
        count++;
      }
      reader.close();
    } catch(IOException e){
      e.printStackTrace();
    }
    return a;
  }

  public static void writeFileMatrix(String namaFile, Matrix m){
    try{
      FileWriter writer = new FileWriter(String.format("D:/SMT 3/Tubes Aljabar Linear/Matrix-Calculator-D42B-6/%s.txt", namaFile));
      for(int i = 0; i < m.getRow(); i++){
        for(int j = 0; j < m.getCol(); j++){
          String temp = Double.toString(m.getElmt(i, j));
          writer.write(temp);
          writer.write(" ");
        }
        writer.write("\n");
      }
      writer.close();
    }catch(IOException e){
      e.printStackTrace();
    }
  }

  public static void writeFileString(String namaFile, String s) {
    try {
      FileWriter writer = new FileWriter(String.format("D:/SMT 3/Tubes Aljabar Linear/Matrix-Calculator-D42B-6/test/%s.txt", namaFile));
      writer.write(s);
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    
  }
}
