package Aplikasi;

import java.lang.Math;
import java.util.Scanner;

import Matrix.Matrix;
import Matrix.Operation;
import Utility.IO;

public class Determinan {
    public static double determinanOBE(Matrix m){
        Matrix n = new Matrix();
        n = n.copyMatrix(m);
        double det = 1;
        System.out.println("Matriks awal:");
        n.displayMatrix();
        
        for (int i=0;i<n.getCol();i++){
            int max = i;
            for (int j=i+1;j<n.getRow();j++){
                if (Math.abs(n.getElmt(j, i)) > Math.abs(n.getElmt(max, i))){
                    max = j;
                }
            }
            
            if (Math.abs(n.getElmt(max, i)) == 0){
                return 0;
            }
            
            if (i != max){
                Operation.swapRow(n, i, max);
                det *= -1;
                System.out.println("Swap baris " + i + " dengan baris " + max + ":");
                n.displayMatrix();
            }
            
            det *= n.getElmt(i, i);
            System.out.println("Kali diagonal utama elemen [" + i + ", " + i + "] = " + n.getElmt(i, i));
            
            for (int k = i+1; k < n.getRow(); k++){
                Operation.rowReduction(n, i, k, i);
                System.out.println("Reduksi baris " + k + " menggunakan baris " + i + ":");
                n.displayMatrix();
            }
        }
        
        System.out.println("Determinan hasil: " + det);
        return Operation.setPrecisionValue(det, 4);
    }

    public static void displayOBE(Matrix m) {
        System.out.println("Determinan matriks tersebut adalah " + determinanOBE(m));
    }

    public static void fileOBE(Matrix m, String namaFile) {
        IO.writeFileString(namaFile, Double.toString(determinanOBE(m)));
    }

    public static double kofaktor(Matrix m, int a, int b) {
        int i, j, iHasil, jHasil;
        Matrix mHasil;
        double hasil = 0;
        mHasil = new Matrix(m.getRow() - 1, m.getCol() - 1);
    
        iHasil = 0;
        for (i = 0; i < m.getRow(); i++) {
            jHasil = 0;
            for (j = 0; j < m.getCol(); j++) {
                if (i == a) {
                    iHasil = i - 1;
                } else if (j == b) {
                    jHasil = j - 1;
                } else {
                    mHasil.setElmt(iHasil, jHasil, m.getElmt(i, j));
                }
                jHasil++;
            }
            iHasil++;
        }
    
        System.out.println("Submatriks tanpa baris " + a + " dan kolom " + b + ":");
        mHasil.displayMatrix();
    
        if ((a + b) % 2 == 0) {
            hasil = ekspansiKofaktor(mHasil);
        } else {
            hasil = -1 * ekspansiKofaktor(mHasil);
        }
    
        return Operation.setPrecisionValue(hasil, 4);
    }
    
    public static double ekspansiKofaktor(Matrix m) {
        int i, j;
        double hasil = 0;
    
        if (m.getRow() == 1 && m.getCol() == 1) {
            hasil = m.getElmt(0, 0);
        } else {
            i = 0;
            for (j = 0; j < m.getCol(); j++) {
                System.out.println("Menghitung kofaktor untuk elemen [" + i + ", " + j + "] = " + m.getElmt(i, j));
                hasil += m.getElmt(i, j) * kofaktor(m, i, j);
            }
        }
    
        System.out.println("Hasil determinan: " + hasil);
        return Operation.setPrecisionValue(hasil, 4);
    }

    public static void displayEkspansiKofaktor(Matrix m) {
        System.out.println("Determinant matriks tersebut adalah " + ekspansiKofaktor(m));
    }

    public static void fileEkspansiKofaktor(Matrix m, String namaFile) {
        IO.writeFileString(namaFile, Double.toString(ekspansiKofaktor(m)));
    }

    public static void displaySarrus(Matrix m) {
        double det = 0;
        if (m.isSquare()) {
            if (m.getRow() == 3) {
                System.out.println("Menggunakan metode Sarrus:");
                for (int i = 0; i < 3; i++) {
                    double positif = m.getElmt(0,i) * m.getElmt(1,(i+1)%3) * m.getElmt(2,(i+2)%3);
                    double negatif = m.getElmt(0,i) * m.getElmt(1,(i+2)%3) * m.getElmt(2,(i+1)%3);
                    
                    System.out.println("Penambahan: " + m.getElmt(0,i) + " * " + m.getElmt(1,(i+1)%3) + " * " + m.getElmt(2,(i+2)%3) + " = " + positif);
                    System.out.println("Pengurangan: " + m.getElmt(0,i) + " * " + m.getElmt(1,(i+2)%3) + " * " + m.getElmt(2,(i+1)%3) + " = " + negatif);
                    
                    det += positif - negatif;
                }
                System.out.println("Determinan akhir: " + det);
            } else {
                System.out.println("Ukuran matrix tidak 3x3, metode Sarrus tidak dapat digunakan");
            }
        } else {
            System.out.println("Matrix tidak memiliki determinan");
        }
    }
    
    public static void fileSarrus(Matrix m, String namaFile) {
        double det = 0;
        if(m.isSquare()){
            if(m.getRow()==3){
                for (int i=0;i<3;i++){
                    det +=m.getElmt(0,i)*(m.getElmt(1,(i+1)%3)*m.getElmt(2,(i+2)%3)-m.getElmt(1,(i+2)%3)*m.getElmt(2,(i+1)%3));
                }
                IO.writeFileString(namaFile, Double.toString(det));
                return;
            }
            IO.writeFileString(namaFile, "Ukuran matrix tidak 3x3, metode Sarrus tidak dapat digunakan");
            return;
        }
        else{
            IO.writeFileString(namaFile, "Matrix tidak memiliki determinan");
            return;
        }
    }
}




    // public static double kofaktor(Matrix m, int a, int b) {
    //     /* KAMUS */
    //     int i, j, iHasil, jHasil;
    //     Matrix mHasil;
    //     double hasil;

    //     /* ALGORITMA */
    //     hasil = 0;
    //     mHasil = new Matrix(m.getRow() - 1, m.getCol() - 1);

    //     iHasil = 0;
    //     for (i = 0; i < m.getRow(); i++) {
    //         jHasil = 0;
    //         for (j = 0; j < m.getCol(); j++) {
    //             if (i == a) {
    //                 iHasil = i - 1;
    //             } else if (j == b) {
    //                 jHasil = j - 1;
    //             } else {
    //                 mHasil.setElmt(iHasil, jHasil, m.getElmt(i, j));
    //             }
    //             jHasil++;
    //         }
    //         iHasil++;
    //     }

    //     if ((a + b) % 2 == 0) {
    //         hasil = ekspansiKofaktor(mHasil);
    //     } else {
    //         hasil = -1 * ekspansiKofaktor(mHasil);
    //     }

    //     return Operation.setPrecisionValue(hasil, 4);
    // }

    // public static double ekspansiKofaktor(Matrix m) {
    //     /* KAMUS */
    //     int i, j;
    //     double hasil;

    //     /* ALGORITMA */
    //     hasil = 0;

    //     if (m.getRow() == 1 && m.getCol() == 1) {
    //         hasil = m.getElmt(0, 0);
    //     } else {
    //         i = 0;
    //         for (j = 0; j < m.getCol(); j++) {
    //             hasil += m.getElmt(i, j) * kofaktor(m, i, j);
    //         }
    //     }

    //     return Operation.setPrecisionValue(hasil, 4);
    // }

    // public static void displayEkspansiKofaktor(Matrix m) {
    //     System.out.println("Determinant matriks tersebut adalah " + ekspansiKofaktor(m));
    // }

    // public static void fileEkspansiKofaktor(Matrix m, String namaFile) {
    //     IO.writeFileString(namaFile, Double.toString(ekspansiKofaktor(m)));
    // }

    // public static double determinanOBE(Matrix m){
    //     Matrix n = new Matrix();
    //     n = n.copyMatrix(m);
    //     double det = 1;
    //     for (int i=0;i<n.getCol();i++){
    //         int max = i;
    //         for (int j=i+1;j<n.getRow();j++){
    //             if (Math.abs(n.getElmt(j, i)) > Math.abs(n.getElmt(max, i))){
    //                 max = j;
    //             }
    //         }
    //         if (Math.abs(n.getElmt(max, i))==0){
    //             return 0;
    //         }
    //         Operation.swapRow(n, i, max);
    //         if (i!=max){
    //             det *= -1;
    //         }
    //         det *= n.getElmt(i, i);
    //         for (int k=i+1;k<n.getRow();k++){
    //             Operation.rowReduction(n, i, k, i);
    //         }
    //     }
    //     return Operation.setPrecisionValue(det, 4);
    // }

    // public static void displayOBE(Matrix m) {
    //     System.out.println("Determinan matriks tersebut adalah " + determinanOBE(m));
    // }

    // public static void fileOBE(Matrix m, String namaFile) {
    //     IO.writeFileString(namaFile, Double.toString(determinanOBE(m)));
    // }

    // public static void displaySarrus(Matrix m) {
    //     double det = 0;
    //     if(m.isSquare()){
    //         if(m.getRow()==3){
    //             for (int i=0;i<3;i++){
    //                 det +=m.getElmt(0,i)*(m.getElmt(1,(i+1)%3)*m.getElmt(2,(i+2)%3)-m.getElmt(1,(i+2)%3)*m.getElmt(2,(i+1)%3));
    //             }
    //             System.out.println("Determinan matriks tersebut adalah " + det);
    //             return;
    //         }
    //         System.out.println("Ukuran matrix tidak 3x3, metode Sarrus tidak dapat digunakan");
    //         return;
    //     }
    //     else{
    //         System.out.println("Matrix tidak memiliki determinan");
    //         return;
    //     }
    // }

//     public static void fileSarrus(Matrix m, String namaFile) {
//         double det = 0;
//         if(m.isSquare()){
//             if(m.getRow()==3){
//                 for (int i=0;i<3;i++){
//                     det +=m.getElmt(0,i)*(m.getElmt(1,(i+1)%3)*m.getElmt(2,(i+2)%3)-m.getElmt(1,(i+2)%3)*m.getElmt(2,(i+1)%3));
//                 }
//                 IO.writeFileString(namaFile, Double.toString(det));
//                 return;
//             }
//             IO.writeFileString(namaFile, "Ukuran matrix tidak 3x3, metode Sarrus tidak dapat digunakan");
//             return;
//         }
//         else{
//             IO.writeFileString(namaFile, "Matrix tidak memiliki determinan");
//             return;
//         }
//     }
// }
