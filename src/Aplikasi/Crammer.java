package Aplikasi;

import Matrix.*;
import Utility.IO;

public class Crammer {

  public static boolean isDetZero(Matrix m) {
    return (Determinan.ekspansiKofaktor(m) == 0);
  }

  // NOTE: Asumsi determinan tidak nol
  public static Matrix matrixCrammer(Matrix m) {
    Matrix a, b;
    a = new Matrix();
    b = new Matrix();

    Operation.splitAugmentedMatrix(m, a, b);

    double temp = Determinan.ekspansiKofaktor(a);
    System.out.println("Determinan dari matriks koefisien: " + temp);

    Matrix ans = new Matrix(a.getRow(), 1);
    for (int i = 0; i < a.getCol(); i++) {
      Matrix c = new Matrix();
      c = c.copyMatrix(a);

      System.out.println("Langkah " + (i + 1) + ": Mengganti kolom ke-" + (i + 1) + " dengan vektor hasil:");
      Operation.setCol(c, b, i, 0);
      c.displayMatrix(); // Menampilkan matriks setelah penggantian kolom

      double detC = Determinan.ekspansiKofaktor(c);
      System.out.println("Determinan matriks pengganti: " + detC);

      ans.setElmt(i, 0, detC / temp);
      System.out.println("Nilai X" + (i + 1) + " = " + ans.getElmt(i, 0));
      System.out.println("--------------------------");
    }
    return ans;
  }

  public static void crammer(Matrix m) {
    Matrix a, b;

    a = new Matrix();
    b = new Matrix();

    Operation.splitAugmentedMatrix(m, a, b);

    if (a.getCol() != a.getRow()) {
      System.out.println("Jumlah persamaan tidak sama dengan jumlah variabel");
    } else {
      double temp = Determinan.ekspansiKofaktor(a);
      if (temp == 0) {
        System.out.println("Determinan Matrix 0");
      } else {
        System.out.println("Determinan dari matriks koefisien: " + temp);
        double[] listDet = new double[a.getRow()];
        for (int i = 0; i < a.getCol(); i++) {
          Matrix c = new Matrix();
          c = c.copyMatrix(a);

          System.out.println("Langkah " + (i + 1) + ": Mengganti kolom ke-" + (i + 1) + " dengan vektor hasil:");
          Operation.setCol(c, b, i, 0);
          c.displayMatrix(); // Menampilkan matriks setelah penggantian kolom

          double detC = Determinan.ekspansiKofaktor(c);
          System.out.println("Determinan matriks pengganti: " + detC);

          listDet[i] = detC / temp;
          System.out.println(String.format("X%d: %,.4f", i + 1, listDet[i]));
          System.out.println("--------------------------");
        }
      }
    }
  }

  public static void FileCrammer(Matrix m, String namaFile) {
    Matrix a, b;

    a = new Matrix();
    b = new Matrix();

    Operation.splitAugmentedMatrix(m, a, b);
    a.displayMatrix();
    m.displayMatrix();
    b.displayMatrix();
    
    if (a.getCol() != a.getRow()) {
      IO.writeFileString(namaFile, "Jumlah persamaan tidak sama dengan jumlah variabel");
    } else {
      double temp = Determinan.ekspansiKofaktor(a);
      if (temp == 0) {
        IO.writeFileString(namaFile, "Determinan Matrix 0");
      } else {
        double[] listDet = new double[a.getRow()];
        String tempString = "Determinan dari matriks koefisien: " + temp + "\n";
        for (int i = 0; i < a.getCol(); i++) {
          Matrix c = new Matrix();
          c = c.copyMatrix(a);

          tempString += "Langkah " + (i + 1) + ": Mengganti kolom ke-" + (i + 1) + " dengan vektor hasil:\n";
          Operation.setCol(c, b, i, 0);
          c.displayMatrix(); // Menampilkan matriks setelah penggantian kolom ke file
          tempString += matrixToString(c) + "\n";

          double detC = Determinan.ekspansiKofaktor(c);
          tempString += "Determinan matriks pengganti: " + detC + "\n";

          listDet[i] = detC / temp;
          tempString += String.format("X%d: %,.4f", i + 1, listDet[i]) + "\n";
          tempString += "--------------------------\n";
        }
        IO.writeFileString(namaFile, tempString);
      }
    }
  }

  // Method untuk mengonversi matriks menjadi string agar bisa disimpan ke file
  public static String matrixToString(Matrix m) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < m.getRow(); i++) {
      for (int j = 0; j < m.getCol(); j++) {
        sb.append(m.getElmt(i, j)).append(" ");
      }
      sb.append("\n");
    }
    return sb.toString();
  }
}
