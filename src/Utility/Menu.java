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
    try {
      // Tampilkan layar selamat datang
      showWelcomeScreen();
    } catch (InterruptedException e) {
      System.out.println("Terjadi kesalahan pada proses loading: " + e.getMessage());
    }

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

  // Fungsi untuk menampilkan layar selamat datang
  public static void showWelcomeScreen() throws InterruptedException {
    // Kode warna terminal (untuk terminal yang mendukung)
    final String RESET = "\033[0m";   // Reset warna
    final String RED = "\033[0;31m";  // Warna Merah
    final String GREEN = "\033[0;32m"; // Warna Hijau
    final String YELLOW = "\033[0;33m"; // Warna Kuning
    final String BLUE = "\033[0;34m"; // Warna Biru
    final String PURPLE = "\033[0;35m"; // Warna Ungu
    final String CYAN = "\033[0;36m"; // Warna Cyan

    System.out.println(CYAN + "░██╗░░░░░░░██╗███████╗██╗░░░░░░█████╗░░█████╗░███╗░░░███╗███████╗  ████████╗░█████╗░" + RESET);
    System.out.println(CYAN + "░██║░░██╗░░██║██╔════╝██║░░░░░██╔══██╗██╔══██╗████╗░████║██╔════╝  ╚══██╔══╝██╔══██╗" + RESET);
    System.out.println(CYAN + "░╚██╗████╗██╔╝█████╗░░██║░░░░░██║░░╚═╝██║░░██║██╔████╔██║█████╗░░  ░░░██║░░░██║░░██║" + RESET);
    System.out.println(CYAN + "░░████╔═████║░██╔══╝░░██║░░░░░██║░░██╗██║░░██║██║╚██╔╝██║██╔══╝░░  ░░░██║░░░██║░░██║" + RESET);
    System.out.println(CYAN + "░░╚██╔╝░╚██╔╝░███████╗███████╗╚█████╔╝╚█████╔╝██║░╚═╝░██║███████╗  ░░░██║░░░╚█████╔╝" + RESET);
    System.out.println(CYAN + "░░░╚═╝░░░╚═╝░░╚══════╝╚══════╝░╚════╝░░╚════╝░╚═╝░░░░░╚═╝╚══════╝  ░░░╚═╝░░░░╚════╝░" + RESET);
    System.out.println();
    System.out.println(CYAN + "                  ███╗░░░███╗░█████╗░████████╗██████╗░██╗██╗░░██╗" + RESET);
    System.out.println(CYAN + "                  ████╗░████║██╔══██╗╚══██╔══╝██╔══██╗██║╚██╗██╔╝" + RESET);
    System.out.println(CYAN + "                  ██╔████╔██║███████║░░░██║░░░██████╔╝██║░╚███╔╝░" + RESET);
    System.out.println(CYAN + "                  ██║╚██╔╝██║██╔══██║░░░██║░░░██╔══██╗██║░██╔██╗░" + RESET);
    System.out.println(CYAN + "                  ██║░╚═╝░██║██║░░██║░░░██║░░░██║░░██║██║██╔╝╚██╗" + RESET);
    System.out.println(CYAN + "                  ╚═╝░░░░░╚═╝╚═╝░░╚═╝░░░╚═╝░░░╚═╝░░╚═╝╚═╝╚═╝░░╚═╝" + RESET);
    System.out.println();
    System.out.println(CYAN + "░█████╗░░█████╗░██╗░░░░░░█████╗░██╗░░░██╗██╗░░░░░░█████╗░████████╗░█████╗░██████╗░" + RESET);
    System.out.println(CYAN + "██╔══██╗██╔══██╗██║░░░░░██╔══██╗██║░░░██║██║░░░░░██╔══██╗╚══██╔══╝██╔══██╗██╔══██╗" + RESET);
    System.out.println(CYAN + "██║░░╚═╝███████║██║░░░░░██║░░╚═╝██║░░░██║██║░░░░░███████║░░░██║░░░██║░░██║██████╔╝" + RESET);
    System.out.println(CYAN + "██║░░██╗██╔══██║██║░░░░░██║░░██╗██║░░░██║██║░░░░░██╔══██║░░░██║░░░██║░░██║██╔══██╗" + RESET);
    System.out.println(CYAN + "╚█████╔╝██║░░██║███████╗╚█████╔╝╚██████╔╝███████╗██║░░██║░░░██║░░░╚█████╔╝██║░░██║" + RESET);
    System.out.println(CYAN + "░╚════╝░╚═╝░░╚═╝╚══════╝░╚════╝░░╚═════╝░╚══════╝╚═╝░░╚═╝░░░╚═╝░░░░╚════╝░╚═╝░░╚═╝" + RESET);
    System.out.println();

    System.out.println(PURPLE + "                           Bringing you the power of                " + RESET);
    System.out.println(PURPLE + "                          matrix operations made easy!             " + RESET);
    System.out.println();
    System.out.println(BLUE + "                              Loading the program...                " + RESET);
    System.out.println();

    // Menambahkan efek loading lucu
    String[] loadingDots = {".", "..", "...", "Hampir Selesai", "Tunggu sebentar lagi"};
    for (String dots : loadingDots) {
        System.out.print("Loading" + dots);
        Thread.sleep(700); // Memberikan jeda sejenak
        System.out.print("\r"); // Menghapus baris sebelumnya
    }

    // Efek suara (simulasi dengan teks)
    System.out.println(CYAN + "♫♫♫ DUNG DUNG DUNG... BUM BAM BAM... ♫♫♫" + RESET);
    Thread.sleep(500);

    // Pesan sambutan lucu
    System.out.println(YELLOW + "Yap! Matrix Calculator sudah siap untuk dipakai!" + RESET);
    System.out.println(PURPLE + "Jangan khawatir, nggak perlu jadi ahli matematika buat pakai ini :)" + RESET);
    Thread.sleep(1000);

    // Pesan akhir loading
    System.out.println(BLUE + "Loading... Complete!" + RESET);
    System.out.println(YELLOW + "Selamat datang! Matrix Calculator siap membantu perhitunganmu!" + RESET);
    Thread.sleep(1000);
}

  public static void mainMenu() {    
    System.out.println("╔═════════════════════════════════════════════════════╗");
    System.out.println("║                                                     ║");
    System.out.println("║          SELAMAT DATANG DI MATRIX CALCULATOR        ║");
    System.out.println("║                                                     ║");
    System.out.println("╠═════════════════════ MENU UTAMA ════════════════════╣");
    System.out.println("║                                                     ║");
    System.out.println("║  1. Operasi Dasar Matriks                           ║");
    System.out.println("║  2. Perkalian Skalar dengan Matriks                 ║");
    System.out.println("║  3. Menghitung Determinan Matriks                   ║");
    System.out.println("║  4. Menghitung Matriks Invers (Balikan)             ║");
    System.out.println("║  5. Menyelesaikan SPL                               ║");
    System.out.println("║  6. Menghitung Transpose Matriks                    ║");
    System.out.println("║  7. Keluar                                          ║");
    System.out.println("║                                                     ║");
    System.out.println("╚═════════════════════════════════════════════════════╝");
    System.out.print("Masukkan pilihan Anda: ");
    
    int i = 0, q = 0;

    try {
      i = Integer.parseInt(bufferedReader.readLine());
    } catch (IOException e) {
      e.printStackTrace();
    }
    switch (i) {
      case 1:
        input();
        try {
          q = Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
          e.printStackTrace();
        }
        switch (q) {
          case 1:
            basicMatrixOperationFile();
            break;
          case 2:
            basicMatrixOperations();
            break;
          default:
            System.out.println("\nMohon masukan input yang benar!");
            break;
        }
        break;
      case 2:
        multiplyScalarWithMatrix();
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
        break;
      default:
        System.out.println("\nMohon masukan input yang benar!");
        break;
    }

    switch (i) {
      case 1:
        // output();
        // try {
        //   q = Integer.parseInt(bufferedReader.readLine());
        // } catch (IOException e) {
        //   e.printStackTrace();
        // }
        // switch (q) {
        //   case 1:
        //     InterpolasiFile();
        //     break;
        //   case 2:
        //     InterpolasiKeyboard();
        //     break;
        //   default:
        //     System.out.println("\nMohon masukan input yang benar!");
        //     break;
        // }
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
    System.out.println("╔═══════════════════════════════════╗");
    System.out.println("║         PILIH JENIS INPUT         ║");
    System.out.println("╠═══════════════════════════════════╣");
    System.out.println("║ 1. File                           ║");
    System.out.println("║ 2. Keyboard                       ║");
    System.out.println("╚═══════════════════════════════════╝");
    System.out.print("Masukkan pilihan Anda: ");
  }

  public static void output() {
    System.out.println("");
    System.out.println("╔═══════════════════════════════════╗");
    System.out.println("║         PILIH JENIS OUTPUT        ║");
    System.out.println("╠═══════════════════════════════════╣");
    System.out.println("║ 1. File                           ║");
    System.out.println("║ 2. Keyboard                       ║");
    System.out.println("╚═══════════════════════════════════╝");
    System.out.print("Masukkan pilihan Anda: ");
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

  public static void inputInterpolasi(){
    System.out.println("");
    System.out.println("Akan dibuat interpolasi dengan pasangan sebanyak n buah");
    System.out.print("Masukan n: ");
    int n = 0;

    try {
      n = Integer.parseInt(bufferedReader.readLine());
    } catch (IOException e) {
      e.printStackTrace();
    }
    Menu.m = new Matrix(n, n + 1);

    System.out.println("Silahkan masukan setiap pasangan: ");
    Menu.m = Interpolasi.masukkanInterpolasi(n);
  }

  public static void inputRegresi(){
    System.out.println("");
    System.out.println("Akan dibuat RLB (Regresi Linear Berganda) dengan n buah persamaan dengan k peubah");
    System.out.print("Masukan n: ");

    int n = 0;
    try {
      n = Integer.parseInt(bufferedReader.readLine());
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.print("Masukan k: ");
    int k = 0;
    try {
      k = Integer.parseInt(bufferedReader.readLine());
    } catch (IOException e) {
      e.printStackTrace();
    }
    Menu.m = new Matrix(n, k + 1);
    System.out.println("Silahkan masukkan data:");
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
    System.out.println("╔═══════════════════════════════════════════════════╗");
    System.out.println("║         PILIH METODE YANG INGIN DIGUNAKAN         ║");
    System.out.println("╠═══════════════════════════════════════════════════╣");
    System.out.println("║ 1. Metode Eliminasi Gauss                         ║");
    System.out.println("║ 2. Metode Eliminasi Gauss-Jordan                  ║");
    System.out.println("║ 3. Metode Matriks Invers (Balikan)                ║");
    System.out.println("║ 4. Kaidah Cramer                                  ║");
    System.out.println("╚═══════════════════════════════════════════════════╝");
    System.out.print("Masukkan pilihan Anda: ");
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
    System.out.println("╔══════════════════════════════════════╗");
    System.out.println("║   PILIH METODE YANG INGIN DIGUNAKAN  ║");
    System.out.println("╠══════════════════════════════════════╣");
    System.out.println("║ 1. Metode Eliminasi Gauss            ║");
    System.out.println("║ 2. Metode Ekspansi Kofaktor          ║");
    System.out.println("║ 3. Metode Sarrus                     ║");
    System.out.println("╚══════════════════════════════════════╝");
    System.out.print("Masukkan pilihan Anda: ");

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
    System.out.println("╔══════════════════════════════════════╗");
    System.out.println("║   PILIH METODE YANG INGIN DIGUNAKAN  ║");
    System.out.println("╠══════════════════════════════════════╣");
    System.out.println("║ 1. Metode Eliminasi Gauss-Jordan     ║");
    System.out.println("║ 2. Metode Adjoint                    ║");
    System.out.println("╚══════════════════════════════════════╝");
    System.out.print("Masukkan pilihan Anda: "); 

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
    System.out.println("╔═══════════════════════════════════════╗");
    System.out.println("║   PILIH METODE YANG INGIN DIGUNAKAN   ║");
    System.out.println("╠═══════════════════════════════════════╣");
    System.out.println("║ 1. Metode Eliminasi Gauss             ║");
    System.out.println("║ 2. Metode Ekspansi Kofaktor           ║");
    System.out.println("║ 3. Metode Sarrus                      ║");
    System.out.println("╚═══════════════════════════════════════╝");
    System.out.print("Masukkan pilihan Anda: ");


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
    System.out.println("╔═══════════════════════════════════════╗");
    System.out.println("║   PILIH METODE YANG INGIN DIGUNAKAN   ║");
    System.out.println("╠═══════════════════════════════════════╣");
    System.out.println("║ 1. Metode Eliminasi Gauss-Jordan      ║");
    System.out.println("║ 2. Metode Adjoint                     ║");
    System.out.println("╚═══════════════════════════════════════╝");
    System.out.print("Masukkan pilihan Anda: ");

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
    System.out.println("╔═══════════════════════════════════════╗");
    System.out.println("║   PILIH METODE YANG INGIN DIGUNAKAN   ║");
    System.out.println("╠═══════════════════════════════════════╣");
    System.out.println("║ 1. Metode Eliminasi Gauss             ║");
    System.out.println("║ 2. Metode Eliminasi Gauss-Jordan      ║");
    System.out.println("║ 3. Metode Matriks Invers (Balikan)    ║");
    System.out.println("║ 4. Kaidah Cramer                      ║");
    System.out.println("╚═══════════════════════════════════════╝");
    System.out.print("Masukkan pilihan Anda: ");

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

  public static void basicMatrixOperations() {
    try {
      System.out.println("");
      System.out.println("╔══════════════════════════════════════╗");
      System.out.println("║      PILIH OPERASI DASAR MATRIKS     ║");
      System.out.println("╠══════════════════════════════════════╣");
      System.out.println("║ 1. Penjumlahan matriks               ║");
      System.out.println("║ 2. Pengurangan matriks               ║");
      System.out.println("║ 3. Perkalian matriks                 ║");
      System.out.println("║ 4. Pembagian matriks                 ║");
      System.out.println("╚══════════════════════════════════════╝");
      System.out.print("Masukkan pilihan Anda: ");

      int i = 0;
      try {
        i = Integer.parseInt(bufferedReader.readLine());
      } catch (IOException e) {
        e.printStackTrace();
      }

      Matrix a = inputMatrixFromUser("pertama");
      Matrix b = inputMatrixFromUser("kedua");
      Matrix result = null;

      switch (i) {
        case 1:
          if (a.getRow() != b.getRow() || a.getCol() != b.getCol()) {
            throw new IllegalArgumentException("Matriks harus memiliki ukuran yang sama untuk dijumlahkan.");
          }
          result = Operation.addMatrix(a, b);
          break;
        case 2:
          if (a.getRow() != b.getRow() || a.getCol() != b.getCol()) {
            throw new IllegalArgumentException("Matriks harus memiliki ukuran yang sama untuk dikurangkan.");
          }
          result = Operation.subtractMatrix(a, b);
          break;
        case 3:
          if (a.getCol() != b.getRow()) {
            throw new IllegalArgumentException("Jumlah kolom matriks pertama harus sama dengan jumlah baris matriks kedua untuk dikalikan.");
          }
          result = Operation.multMatrix(a, b);
          break;
        case 4:
          if (b.getRow() != b.getCol()) {
            throw new IllegalArgumentException("Matriks kedua harus matriks persegi untuk pembagian.");
          }
          result = Operation.divideMatrix(a, b);
          break;
        default:
          System.out.println("\nMohon masukan input yang benar!");
          return;
      }

      System.out.println("Hasil operasi adalah: ");
      result.displayMatrix();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public static void basicMatrixOperationFile() {
    try{
      System.out.println("");
      System.out.println("╔══════════════════════════════════════╗");
      System.out.println("║      PILIH OPERASI DASAR MATRIKS     ║");
      System.out.println("╠══════════════════════════════════════╣");
      System.out.println("║ 1. Penjumlahan matriks               ║");
      System.out.println("║ 2. Pengurangan matriks               ║");
      System.out.println("║ 3. Perkalian matriks                 ║");
      System.out.println("║ 4. Pembagian matriks                 ║");
      System.out.println("╚══════════════════════════════════════╝");
      System.out.print("Masukkan pilihan Anda: ");


      int i = 0;
      try {
        i = Integer.parseInt(bufferedReader.readLine());
      } catch (IOException e) {
        e.printStackTrace();
      }

      Matrix a = inputMatrixFromFile("pertama");
      Matrix b = inputMatrixFromFile("kedua");
      Matrix result = null;

      switch (i) {
        case 1:
          if (a.getRow() != b.getRow() || a.getCol() != b.getCol()) {
            throw new IllegalArgumentException("Matriks harus memiliki ukuran yang sama untuk dijumlahkan.");
          }
          result = Operation.addMatrix(a, b);
          break;
        case 2:
          if (a.getRow() != b.getRow() || a.getCol() != b.getCol()) {
            throw new IllegalArgumentException("Matriks harus memiliki ukuran yang sama untuk dikurangkan.");
          }
          result = Operation.subtract(a, b);
          break;
        case 3:
          if (a.getCol() != b.getRow()) {
            throw new IllegalArgumentException("Jumlah kolom matriks pertama harus sama dengan jumlah baris matriks kedua untuk dikalikan.");
          }
          result = Operation.multMatrix(a, b);
          break;
        case 4:
          if (b.getRow() != b.getCol()) {
            throw new IllegalArgumentException("Matriks kedua harus matriks persegi untuk pembagian.");
          }
          result = Operation.divideMatrix(a, b);
          break;
        default:
          System.out.println("\nMohon masukan input yang benar!");
          return;
      }

      outputFile();
      IO.writeFileMatrix(Menu.namaFile, result);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

    // Fungsi untuk perkalian skalar dengan matriks
    public static void multiplyScalarWithMatrix() {
      try {
          // Input jumlah baris dan kolom dari matriks
          System.out.print("Masukkan jumlah baris matriks: ");
          int rows = Integer.parseInt(bufferedReader.readLine());

          System.out.print("Masukkan jumlah kolom matriks: ");
          int cols = Integer.parseInt(bufferedReader.readLine());

          // Deklarasi matriks
          int[][] matrix = new int[rows][cols];

          // Input elemen-elemen matriks
          System.out.println("Masukkan elemen-elemen matriks:");
          for (int i = 0; i < rows; i++) {
              for (int j = 0; j < cols; j++) {
                  System.out.print("Elemen [" + i + "][" + j + "]: ");
                  matrix[i][j] = Integer.parseInt(bufferedReader.readLine());
              }
          }

          // Input skalar yang akan dikalikan
          System.out.print("Masukkan nilai skalar: ");
          int scalar = Integer.parseInt(bufferedReader.readLine());

          // Proses perkalian matriks dengan skalar
          int[][] resultMatrix = multiplyMatrixByScalar(matrix, scalar);

          // Menampilkan hasil
          System.out.println("Hasil operasi adalah: ");
          displayResult(resultMatrix);

      } catch (IOException e) {
          e.printStackTrace();
      } catch (NumberFormatException e) {
          System.out.println("Input tidak valid. Mohon masukkan angka.");
      }
  }

  // Fungsi untuk mengalikan matriks dengan skalar
  public static int[][] multiplyMatrixByScalar(int[][] matrix, int scalar) {
      int rows = matrix.length;
      int cols = matrix[0].length;
      int[][] resultMatrix = new int[rows][cols];

      // Perkalian skalar dengan matriks
      for (int i = 0; i < rows; i++) {
          for (int j = 0; j < cols; j++) {
              resultMatrix[i][j] = matrix[i][j] * scalar;
          }
      }
      return resultMatrix;
  }

  // Fungsi untuk menampilkan hasil matriks
  public static void displayResult(int[][] matrix) {
      int rows = matrix.length;
      int cols = matrix[0].length;

      System.out.println("Hasil perkalian skalar dengan matriks:");
      for (int i = 0; i < rows; i++) {
          for (int j = 0; j < cols; j++) {
              System.out.print(matrix[i][j] + " ");
          }
          System.out.println();
      }
  }

  public static Matrix inputMatrixFromUser(String matrixName) {
    System.out.println("Masukkan ukuran dan elemen matriks " + matrixName + ":");
    System.out.print("Masukkan jumlah baris: ");
    int rows = 0;
    try {
      rows = Integer.parseInt(bufferedReader.readLine());
    } catch (IOException e) {
      e.printStackTrace();
    }

    System.out.print("Masukkan jumlah kolom: ");
    int cols = 0;
    try {
      cols = Integer.parseInt(bufferedReader.readLine());
    } catch (IOException e) {
      e.printStackTrace();
    }

    Matrix m = new Matrix(rows, cols);
    System.out.println("Masukkan elemen matriks:");
    m.createMatrix();
    return m;
  }

  public static Matrix inputMatrixFromFile(String matrixName) {
    System.out.println("Pilih file untuk matriks " + matrixName + " yang akan dibaca!");
    IO.printListDir();

    File[] listFiles = IO.getListDir();
    System.out.print("Masukan pilihan: ");
    int q = 0;
    try {
      q = Integer.parseInt(bufferedReader.readLine());
    } catch (IOException e) {
      e.printStackTrace();
    }

    return IO.readMatrix(listFiles[q - 1].getName());
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
