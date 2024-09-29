package Utility;

import java.io.*;

import Matrix.*;
import Aplikasi.*;

public class Menu {
  private static InputStreamReader streamReader = new InputStreamReader(System.in);
  private static BufferedReader bufferedReader = new BufferedReader(Menu.streamReader);

  private static Matrix m = new Matrix();

  private static String namaFile;

  public static void menuLoop(){
    char Y = '\0';
    do {
      mainMenu();
      System.out.println("");
      System.out.print("Apakah ingin melanjutkan? [Y/N]: ");
      try {
        Y = bufferedReader.readLine().charAt(0);
      } catch (IOException e) {
        e.printStackTrace();
      }
    } while (Y == 'Y');
    exit();
  }

  public static void mainMenu() {
    System.out.println("");
    System.out.println("SELAMAT DATANG DI MATRIX CALCULATOR");
    System.out.println("###### MENU ######");
    System.out.println("1. Operasi Dasar");
    System.out.println("2. Perkalian Skalar dengan Matriks");
    System.out.println("3. Menghitung Determinan Matriks");
    System.out.println("4. Menghitung Matriks Invers (Balikan)");
    System.out.println("5. Menyelesaikan SPL");
    System.out.println("6. Menghitung Transpose Matriks");
    System.out.println("7. Keluar");
    System.out.print("Masukan pilihan: ");

    int i = 0, q = 0;

    try {
      i = Integer.parseInt(bufferedReader.readLine());
    } catch (IOException e) {
      e.printStackTrace();
    }
    switch (i) {
      case 1:
        inputOperasiMatriks();
        try {
          q = Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
          e.printStackTrace();
      }
       switch (q) {
        case 1:
          inputFileSqrtMatrix();
          break;
        case 2:
          inputSqrtMatrix();
          break;
        default:
          System.out.println("\nMohon masukan input yang benar!");
          break;
       }
      break;
      case 2:
      break;
      case 3:
        input();
        try {
          q = Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
          e.printStackTrace();
        }
        switch (q) {
          case 1:
            inputFileSqrtMatrix();
            break;
          case 2:
            inputSqrtMatrix();
            break;
          default:
            System.out.println("\nMohon masukan input yang benar!");
            break;
        }
        break;
      case 4:
        input();
        try {
          q = Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
          e.printStackTrace();
        }
        switch (q) {
          case 1:
            inputFileSqrtMatrix();
            break;
          case 2:
            inputSqrtMatrix();
            break;
          default:
            System.out.println("\nMohon masukan input yang benar!");
            break;
        }
        break;
      case 5:
        input();
        try {
          q = Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
          e.printStackTrace();
        }
        switch (q) {
          case 1:
            inputFileMatrix();
            break;
          case 2:
            inputMatrix();
            break;
          default:
            System.out.println("\nMohon masukan input yang benar!");
            break;
        }
        break;
      case 6:
        input();
        try {
          q = Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
          e.printStackTrace();
        }
        switch (q) {
          case 1:
            inputFileMatrix();
            break;
          case 2:
            inputTranspose();
            break;
          default:
            System.out.println("\nMohon masukan input yang benar!");
            break;
        }
        break;
      case 7:
        exit();
      default:
        System.out.println("\nMohon masukan input yang benar!");
        break;
    }

    switch (i) {
      case 1:
        output();
        try {
          q = Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
          e.printStackTrace();
        }
      break;
      case 2:
      break;
      case 3:
        output();
        try {
          q = Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
          e.printStackTrace();
        }
        switch (q) {
          case 1:
            DeterminanFile();
            break;
          case 2:
            DeterminanKeyboard();
            break;
          default:
            System.out.println("\nMohon masukan input yang benar!");
            break;
        }
        break;
      case 4:
        output();
        try {
          q = Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
          e.printStackTrace();
        }
        switch (q) {
          case 1:
            InverseFile();
            break;
          case 2:
            InverseKeyboard();
            break;
          default:
            System.out.println("\nMohon masukan input yang benar!");
            break;
        }
        break;
      case 5:
        output();
        try {
          q = Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
          e.printStackTrace();
        }
        switch (q) {
          case 1:
            SPLFile();
            break;
          case 2:
            SPLKeyboard();
            break;
          default:
            System.out.println("\nMohon masukan input yang benar!");
            break;
        }
        break;
      case 6:
        output();
        try {
          q = Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
          e.printStackTrace();
        }
        switch (q) {
          case 1:
            TransposeFile();
            break;
          case 2:
            TransposeKeyboard();
            break;
          default:
            System.out.println("\nMohon masukan input yang benar!");
            break;
        }
        break;
      case 7:
        exit();
    }
  }

  public static void input() {
    System.out.println("");
    System.out.println("###### Pilih jenis input ######");
    System.out.println("1. File");
    System.out.println("2. Keyboard");
    System.out.print("Masukan pilihan: ");
  }

  public static void output() {
    System.out.println("");
    System.out.println("###### Pilih jenis output ######");
    System.out.println("1. File");
    System.out.println("2. Keyboard");
    System.out.print("Masukan pilihan: ");
  }

  public static void inputOperasiMatriks(){
    System.out.println("");
    System.out.println("###### Pilih jenis operasi dasar ######");
    System.out.println("1. Penjumlahan matriks");
    System.out.println("2. Pengurangan matriks");
    System.out.println("3. Perkalian matriks dengan matriks");
    System.out.print("Masukan pilihan: ");
    //ini lanjutin sama code nya
  }

  public static void inputMatrix(){
    System.out.println("");
    System.out.println("Akan dibuat matrix berukuran m x n");

    System.out.print("Masukan m: ");
    int jumlahBaris = 0;
    try {
      jumlahBaris = Integer.parseInt(bufferedReader.readLine());
    } catch (IOException e) {
      e.printStackTrace();
    }

    System.out.print("Masukan n: ");
    int jumlahKolom = 0;
    try {
      jumlahKolom = Integer.parseInt(bufferedReader.readLine());
    } catch (IOException e) {
      e.printStackTrace();
    }
    Menu.m = new Matrix(jumlahBaris, jumlahKolom);

    System.out.println("Silahkan masukan setiap element matrix: ");
    Menu.m.createMatrix();
  }

  public static void inputSqrtMatrix(){
    System.out.println("");
    System.out.println("Akan dibuat matrix berukuran n x n");
    System.out.print("Masukan n: ");

    int n = 0;
    try {
      n = Integer.parseInt(bufferedReader.readLine());
    } catch (IOException e) {
      e.printStackTrace();
    }
    Menu.m = new Matrix(n, n);

    System.out.println("Silahkan masukan setiap element matrix: ");
    Menu.m.createMatrix();
  }


  public static void inputTranspose() {
    System.out.println("");
    System.out.println("Akan dibuat transpose matriks m x n");
    System.out.print("Masukan m: ");
    int m = 0;
    try {
      m = Integer.parseInt(bufferedReader.readLine());
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.print("Masukan n: ");
    int n = 0;
    try {
      n = Integer.parseInt(bufferedReader.readLine());
    } catch (IOException e) {
      e.printStackTrace();
    }
    Menu.m = new Matrix(m, n);

    System.out.println("Silahkan masukan setiap element matrix: ");
    Menu.m.createMatrix();
  }

  public static void SPLKeyboard(){
    System.out.println("");
    System.out.println("###### Pilih metode yang ingin digunakan ######");
    System.out.println("1. Metode Eliminasi Gauss");
    System.out.println("2. Metode Eliminasi Gauss-Jordan");
    System.out.println("3. Metode Matriks Invers (Balikan)");
    System.out.println("4. Kaidah Cramer");
    System.out.print("Masukan pilihan: ");
    int i = 0;
    try {
      i = Integer.parseInt(bufferedReader.readLine());
    } catch (IOException e) {
      e.printStackTrace();
    }
    switch (i) {
      case 1:
        SistemPersamaanLinear.SPLGauss(Menu.m);
        break;
      case 2:
        SistemPersamaanLinear.SPLGaussJordan(Menu.m);
        break;
      case 3:
        SistemPersamaanLinear.SPLinverse(Menu.m);
        break;
      case 4:
        Crammer.crammer(Menu.m);
        break;
      default:
        System.out.println("\nMohon masukan input yang benar!");
        break;
    }
  }

  public static void DeterminanKeyboard() {
    System.out.println("");
    System.out.println("###### Pilih metode yang ingin digunakan ######");
    System.out.println("1. Metode Eliminasi Gauss (OBE)");
    System.out.println("2. Metode Ekspansi Kofaktor");
    System.out.println("3. Metode Sarrus (Hanya untuk Matriks 3x3)");
    System.out.print("Masukan pilihan: ");
    int i = 0;
    try {
      i = Integer.parseInt(bufferedReader.readLine());
    } catch (IOException e) {
      e.printStackTrace();
    }

    switch (i) {
      case 1:
        Determinan.displayOBE(Menu.m);
        break;
      case 2:
        Determinan.displayEkspansiKofaktor(Menu.m);
        break;
      case 3:
        Determinan.displaySarrus(Menu.m); 
        break;
      default:
        System.out.println("\nMohon masukan input yang benar!");
        break;
    }
  }

  public static void InverseKeyboard() {
    System.out.println("");
    System.out.println("###### Pilih metode yang ingin digunakan ######");
    System.out.println("1. Metode Eliminasi Gauss-Jordan");
    System.out.println("2. Metode Adjoint");
    System.out.print("Masukan pilihan: ");
    int i = 0;
    try {
      i = Integer.parseInt(bufferedReader.readLine());
    } catch (IOException e) {
      e.printStackTrace();
    }

    switch (i) {
      case 1:
        Inverse.displayGaussJordan(Menu.m);
        break;
      case 2:
        Inverse.displayInverseAdjoint(Menu.m);
        break;
      default:
        System.out.println("\nMohon masukan input yang benar!");
        break;
    }
  }

  public static void TransposeKeyboard() {
    System.out.println("");
    System.out.println("Transpose dari matriks tersebut adalah: ");
    Operation.transpose(Menu.m).displayMatrix();
  }

  public static void InterpolasiKeyboard() {
    System.out.println("");
    System.out.println("Hasil interpolasi data tersebut adalah: ");
    Interpolasi.keluarkanInterpolasi(Menu.m);

    System.out.println("");
    System.out.print("Masukkan jumlah titik data yang ingin diprediksi: ");
    int n = 0;
    try {
      n = Integer.parseInt(bufferedReader.readLine());
    } catch (IOException e) {
      e.printStackTrace();
    }

    while (n > 0) {
      System.out.println("");
      double x = 0;
      try {
        System.out.print("Masukan nilai x: ");
        x = Double.parseDouble(bufferedReader.readLine());
      } catch (IOException e) {
        e.printStackTrace();
      }
      Interpolasi.outputInterpolasi(Menu.m, x);
      n--;
    }
  }

  public static void RegresiKeyboard() {
    System.out.println("");
    System.out.println("Hasil regresi data tersebut adalah: ");
    RLB.keluarkanRLB(Menu.m);

    System.out.println("");
    System.out.println("Akan dicek prediksi nilai y dengan memasukan nilai x");
    System.out.print("Masukkan jumlah test case yang ingin diprediksi: ");
    int n = 0;
    try {
      n = Integer.parseInt(bufferedReader.readLine());
    } catch (IOException e) {
      e.printStackTrace();
    }
    while (n > 0) {
      RLB.outputRLB(Menu.m, Menu.m.getCol() - 1);
      n--;
    }
  }

  public static void inputFileMatrix() {
    System.out.println("");
    System.out.println("Pilih file yang akan dibaca!");
    IO.printListDir();
    
    File[] listFiles = IO.getListDir();
    System.out.print("Masukan pilihan: ");
    int q = 0;
    try {
      q = Integer.parseInt(bufferedReader.readLine());
    } catch (IOException e) {
      e.printStackTrace();
    }

    Menu.m = new Matrix();
    Menu.m = IO.readMatrix(listFiles[q - 1].getName());
  }

  public static void inputFileSqrtMatrix() {
    System.out.println("");
    System.out.println("Pilih file yang akan dibaca!");
    IO.printListDir();
    
    File[] listFiles = IO.getListDir();
    System.out.print("Masukan pilihan: ");
    int q = 0;
    try {
      q = Integer.parseInt(bufferedReader.readLine());
    } catch (IOException e) {
      e.printStackTrace();
    }

    Menu.m = new Matrix();
    Menu.m = IO.readMatrix(listFiles[q - 1].getName());
  }

  public static void outputFile() {
    InputStreamReader streamReader = new InputStreamReader(System.in);
    BufferedReader bufferedReader = new BufferedReader(streamReader);

    System.out.println("");
    System.out.print("Masukan nama file output: ");

    Menu.namaFile = new String();

    try {
      namaFile = bufferedReader.readLine();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void InterpolasiFile() {
    outputFile();
    Interpolasi.fileInterpolasi(Menu.m, Menu.namaFile);
  }

  public static void RegresiFile() {
    outputFile();
    RLB.fileRLB(Menu.m, Menu.namaFile);
  }

  public static void DeterminanFile() {
    outputFile();
    System.out.println("");
    System.out.println("###### Pilih metode yang ingin digunakan ######");
    System.out.println("1. Metode Eliminasi Gauss");
    System.out.println("2. Metode Ekspansi Kofaktor");
    System.out.println("3. Metode Sarrus");
    System.out.print("Masukan pilihan: ");
    
    int i = 0;
    try {
      i = Integer.parseInt(bufferedReader.readLine());
    } catch (IOException e) {
      e.printStackTrace();
    }

    switch (i) {
      case 1:
        Determinan.fileEkspansiKofaktor(Menu.m, Menu.namaFile);
        break;
      case 2:
        Determinan.fileEkspansiKofaktor(Menu.m, Menu.namaFile);
        break;
      case 3:
        Determinan.fileSarrus(Menu.m, Menu.namaFile);
        break;
      default:
        System.out.println("\nMohon masukan input yang benar!");
        break;
    }
  }

  public static void InverseFile() {
    outputFile();
    System.out.println("");
    System.out.println("###### Pilih metode yang ingin digunakan ######");
    System.out.println("1. Metode Eliminasi Gauss-Jordan");
    System.out.println("2. Metode Adjoint");
    System.out.print("Masukan pilihan: ");

    int i = 0;
    try {
      i = Integer.parseInt(bufferedReader.readLine());
    } catch (IOException e) {
      e.printStackTrace();
    }

    switch (i) {
      case 1:
        Inverse.fileGaussJordan(Menu.m, Menu.namaFile);
        break;
      case 2:
        Inverse.fileInverseAdjoint(Menu.m, Menu.namaFile);
        break;
      default:
        System.out.println("\nMohon masukan input yang benar!");
        break;
    }
  }

  public static void SPLFile() {
    outputFile();
    System.out.println("");
    System.out.println("###### Pilih metode yang ingin digunakan ######");
    System.out.println("1. Metode Eliminasi Gauss");
    System.out.println("2. Metode Eliminasi Gauss-Jordan");
    System.out.println("3. Metode Matriks Invers (Balikan)");
    System.out.println("4. Kaidah Cramer");
    System.out.print("Masukan pilihan: ");
    int i = 0;
    try {
      i = Integer.parseInt(bufferedReader.readLine());
    } catch (IOException e) {
      e.printStackTrace();
    }
    switch (i) {
      case 1:
        SistemPersamaanLinear.FileSPLGauss(Menu.m, Menu.namaFile);
        break;
      case 2:
        SistemPersamaanLinear.FileSPLGaussJordan(Menu.m, Menu.namaFile);
        break;
      case 3:
        SistemPersamaanLinear.FileSPLinverse(Menu.m, Menu.namaFile);
        break;
      case 4:
        Crammer.FileCrammer(Menu.m, Menu.namaFile);
        break;
      default:
        System.out.println("\nMohon masukan input yang benar!");
        break;
    }
  }

  public static void TransposeFile() {
    outputFile();
    IO.writeFileMatrix(Menu.namaFile, Operation.transpose(Menu.m));
  }

  public static void exit(){
    System.out.println("\nTerima kasih telah menggunakan matrix calculator!");
    System.exit(0);
  }
}
