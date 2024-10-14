package Matrix;

import Aplikasi.Inverse;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Operation {
  public static Matrix addMatrix(Matrix a, Matrix b){
    Matrix c = new Matrix(a.getRow(), a.getCol());
    
    // Menampilkan langkah-langkah penjumlahan matriks
    System.out.println("Langkah-langkah penjumlahan matriks:");
    System.out.println("Matriks 1:");
    printMatrix(a);
    System.out.println("Matriks 2:");
    printMatrix(b);
    System.out.println("Langkah - langkah penjumlahan:");
    
    for(int i = 0; i < a.getRow(); i++){
      for(int j = 0; j < a.getCol(); j++){
        double sum = a.getElmt(i, j) + b.getElmt(i, j);
        c.setElmt(i, j, sum);
        System.out.printf("  Elemen [%d][%d] = %.1f + %.1f = %.1f%n", i, j, a.getElmt(i, j), b.getElmt(i, j), sum);
      }
    }
    
    System.out.println("Hasil penjumlahan matriks:");
    printMatrix(c);
    
    return c;
  }

  private static void printMatrix(Matrix m) {
    for (int i = 0; i < m.getRow(); i++) {
      for (int j = 0; j < m.getCol(); j++) {
        System.out.print(m.getElmt(i, j) + " ");
      }
      System.out.println();
    }
  }

  public static Matrix subtractMatrix(Matrix a, Matrix b) {
    if (a.getRow() != b.getRow() || a.getCol() != b.getCol()) {
      throw new IllegalArgumentException("Matriks harus memiliki ukuran yang sama untuk dikurangkan.");
    }
    
    Matrix c = new Matrix(a.getRow(), a.getCol());
    
    // Menampilkan langkah-langkah pengurangan matriks
    System.out.println("Langkah-langkah pengurangan matriks:");
    System.out.println("Matriks 1:");
    printMatrix(a);
    System.out.println("Matriks 2:");
    printMatrix(b);
    System.out.println("Langkah - langkah pengurangan:");
    
    for (int i = 0; i < a.getRow(); i++) {
      for (int j = 0; j < a.getCol(); j++) {
        double difference = a.getElmt(i, j) - b.getElmt(i, j);
        c.setElmt(i, j, difference);
        System.out.printf("  Elemen [%d][%d] = %.1f - %.1f = %.1f%n", i, j, a.getElmt(i, j), b.getElmt(i, j), difference);
      }
    }
    
    System.out.println("Hasil pengurangan matriks:");
    printMatrix(c);
    
    return c;
  }


  public static double timesRowCol(Matrix a, Matrix b, int row, int col){
    double ans = 0;
    for(int i = 0; i < a.getCol(); i++){
      ans += a.getElmt(row, i) * b.getElmt(i, col);
    }
    return ans;
  }

  public static Matrix multMatrix(Matrix a, Matrix b) {
    if (a.getCol() != b.getRow()) {
      throw new IllegalArgumentException("Jumlah kolom matriks A harus sama dengan jumlah baris matriks B.");
    }
    
    Matrix c = new Matrix(a.getRow(), b.getCol());
    
    // Menampilkan langkah-langkah perkalian matriks
    System.out.println("Langkah-langkah perkalian matriks:");
    
    for (int i = 0; i < a.getRow(); i++) {
      for (int j = 0; j < b.getCol(); j++) {
        double elmt = 0;
        StringBuilder step = new StringBuilder("Kalikan baris " + (i + 1) + " dengan kolom " + (j + 1) + ": ");
        
        for (int k = 0; k < a.getCol(); k++) {
          elmt += a.getElmt(i, k) * b.getElmt(k, j);
          step.append("(").append(a.getElmt(i, k)).append(" x ").append(b.getElmt(k, j)).append(") ");
          if (k < a.getCol() - 1) {
            step.append("+ ");
          }
        }
        
        c.setElmt(i, j, elmt);
        step.append("= ").append(elmt);
        System.out.println(step);
      }
    }
    
    System.out.println("Hasil perkalian kedua matriks adalah:");
    printMatrix(c);
    
    return c;
  }


  //mengalikan baris dengan konstanta k
  public static Matrix rowTimesK(Matrix a, double k) {
    System.out.println("Langkah-langkah perkalian skalar dengan matriks:");
    
    for (int i = 0; i < a.getRow(); i++) {
      for (int j = 0; j < a.getCol(); j++) {
        double originalValue = a.getElmt(i, j);
        double newValue = originalValue * k;
        a.setElmt(i, j, newValue);
        
        // Menampilkan langkah perkalian
        System.out.printf("Elemen [%d][%d] = %.1f x %.1f = %.1f%n", i, j, originalValue, k, newValue);
      }
    }
    
    System.out.println("Hasil perkalian skalar dengan matriks:");
    printMatrix(a);
    
    return a;
  }

  //menukar kolom 1 dengan kolom2
  public static void swapRow(Matrix a, int row1, int row2){
    double temp;
    for(int i = 0; i < a.getCol(); i++){
      temp = a.getElmt(row1, i);
      a.setElmt(row1, i, a.getElmt(row2, i));
      a.setElmt(row2, i, temp);
    }
  }
  public static void swapCol(Matrix a, int col1, int col2){
    double temp;
    for(int i = 0; i < a.getRow(); i++){
      temp = a.getElmt(i, col1);
      a.setElmt(i, col1, a.getElmt(i, col2));
      a.setElmt(i, col2, temp);
    }
  }
  //set col1 matrix a dengan col2 matrixb
  public static void setCol(Matrix a, Matrix b, int col1,  int col2){
    for(int i = 0; i < a.getRow(); i++){
      a.setElmt(i, col1, b.getElmt(i, col2));
    }
  }

  public static void setRow(Matrix a, Matrix b, int row1, int row2){
    for(int i = 0; i < a.getCol(); i++){
      a.setElmt(row1, i, b.getElmt(row2, i));
    }
  }



  public static double sumCol(Matrix m, int col){
    double sum = 0;
    for(int i = 0; i < m.getRow(); i++){
      sum += m.getElmt(i, col);
    }
    return sum;
  }

  //NOTE ini mungkin overflow kaykanya diganti ke int?
  public static double sumColTCol(Matrix m, int col1, int col2){
    double sum = 0;
    for(int i = 0; i < m.getRow(); i++){
      sum += m.getElmt(i, col1)*m.getElmt(i, col2);
    }
    return sum;
  }

  public static Matrix transpose(Matrix a){
    Matrix b = new Matrix(a.getCol(), a.getRow());
    for(int i = 0; i < a.getRow(); i++){
      for(int j = 0; j < a.getCol(); j++){
        b.setElmt(j, i, a.getElmt(i, j));
      }
    }
    return b;
  }
  //row 2 - row 1
  public static void rowReduction(Matrix a, int row1, int row2, int col){
    double anchor = a.getElmt(row2, col)/a.getElmt(row1, col);
    for(int i = 0; i < a.getCol(); i++){
      double elmt = a.getElmt(row2, i) - anchor * a.getElmt(row1, i);
      a.setElmt(row2, i, elmt);
    }
  }

  public static Matrix augmentedMatrix(Matrix a, Matrix b) {
    /* Prerequisite : jumlah baris a sama dengan jumlah baris b */

    /* KAMUS */
    Matrix m;
    int i, j;

    /* ALGORITMA */
    m = new Matrix(a.getRow(), a.getCol() + b.getCol());

    for (i = 0; i < m.getRow(); i++) {
      for (j = 0; j < m.getCol(); j++) {
        if (j < a.getCol()) {
          m.setElmt(i, j, a.getElmt(i, j));
        } else {
          m.setElmt(i, j, b.getElmt(i, j - a.getCol()));
        }
      }
    }

    return m;
  }

  public static void splitAugmentedMatrix(Matrix in, Matrix a, Matrix b){
    a.setRow(in.getRow());
    a.setCol(in.getCol()-1);
    b.setRow(in.getRow());
    b.setCol(1);
    for(int i = 0; i < in.getRow(); i++){
      for(int j = 0; j < in.getCol(); j++){
        if(j == in.getCol() - 1){
          b.setElmt(i, 0, in.getElmt(i, j));
        }else{
          a.setElmt(i, j, in.getElmt(i, j));
        }
      }
    }
  }

  public static double setPrecisionValue(double d, int scale){
    return BigDecimal.valueOf(d).setScale(scale, RoundingMode.HALF_UP).doubleValue();
  }

  public static void setPrecisionArray(double[] d, int scale){
    for(int i = 0; i < d.length; i++){
      d[i] = BigDecimal.valueOf(d[i]).setScale(scale, RoundingMode.HALF_UP).doubleValue();
    }
  }

  public static void setPrecision2DArray(double[][] d, int scale){
    for(int i = 0; i < d.length; i++){
      for(int j = 0; j < d[0].length; j++){
        d[i][j] = BigDecimal.valueOf(d[i][j]).setScale(scale, RoundingMode.HALF_UP).doubleValue();
      }
    }
  }

  public static Double eval(String s) {
    if (s.split("/").length == 1) {
      return Double.parseDouble(s);
    } else {
      return Double.parseDouble(s.split("/")[0]) / Double.parseDouble(s.split("/")[1]);
    }
  }

  public static Matrix subtract(Matrix a, Matrix b) {
    if (a.getRow() != b.getRow() || a.getCol() != b.getCol()) {
      throw new IllegalArgumentException("Matriks harus memiliki ukuran yang sama untuk dikurangkan.");
    }
    Matrix result = new Matrix(a.getRow(), a.getCol());
    for (int i = 0; i < a.getRow(); i++) {
      for (int j = 0; j < a.getCol(); j++) {
        result.setElmt(i, j, a.getElmt(i, j) - b.getElmt(i, j));
      }
    }
    return result;
  }



  public static Matrix divideMatrix(Matrix a, Matrix b) {
    Matrix bInverse = Inverse.inverseAdjoint(b);

    if (bInverse == null) {
      throw new IllegalArgumentException("Matriks B tidak mempunyai balikan, pembagian tidak dapat dilakukan.");
    }

    return multMatrix(a, bInverse);
  }


}
