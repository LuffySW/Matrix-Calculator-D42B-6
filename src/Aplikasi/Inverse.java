package Aplikasi;

import Matrix.Matrix;
import Matrix.Operation;
import Utility.IO;

public class Inverse {
    
// Menghitung matriks kofaktor
public static Matrix matrikskofaktor(Matrix a) {
    Matrix b = new Matrix(a.getRow(), a.getCol());
    for (int i = 0; i < a.getRow(); i++) {
        for (int j = 0; j < a.getCol(); j++) {
            double kofaktor = Determinan.kofaktor(a, i, j);
            b.setElmt(i, j, kofaktor); // Mengisi elemen kofaktor
        }
    }
    return b;
}

// Menghitung matriks adjoint
public static Matrix adjoint(Matrix a) {
    Matrix kofaktorMatrix = matrikskofaktor(a); // Menghitung matriks kofaktor
    return Operation.transpose(kofaktorMatrix); // Transpose untuk mendapatkan adjoint
}

public static Matrix inverseAdjoint(Matrix a) {
    double det = Determinan.ekspansiKofaktor(a); // Menghitung determinan
    if (det == 0) {
        return null; // Matriks tidak memiliki invers
    } else {
        Matrix adjointMatrix = adjoint(a);
        Matrix inversMatrix = new Matrix(a.getRow(), a.getCol());
        for (int i = 0; i < a.getRow(); i++) {
            for (int j = 0; j < a.getCol(); j++) {
                inversMatrix.setElmt(i, j, adjointMatrix.getElmt(i, j) / det); // Invers menggunakan adjoint
            }
        }
        inversMatrix.setPrecision(4); // Mengatur presisi elemen matriks
        return inversMatrix;
    }
}

public static void displayInverseAdjoint(Matrix m) {
    Matrix n = inverseAdjoint(m);
    if (n == null) {
        System.out.println("Matriks tidak mempunyai invers.");
    } else {
        System.out.println("Invers dari matriks tersebut adalah:");
        n.displayMatrix(); // Tampilkan matriks invers
    }
}

    public static void fileInverseAdjoint(Matrix m, String namaFile) {
        Matrix n = inverseAdjoint(m);
        if (n == null) {
            IO.writeFileString(namaFile, "Matriks tidak mempunyai invers."); // Menulis ke file
        } else {
            IO.writeFileMatrix(namaFile, n); // Menulis matriks invers ke file
        }
    }

    public static Matrix eliminasiGaussJordan(Matrix a) {
        Matrix mAug = new Matrix(a.getRow(), a.getCol() * 2);
        Matrix I = new Matrix(a.getRow(), a.getCol());
        I.createIdentityMatrix(); // Membuat matriks identitas

        mAug = Operation.augmentedMatrix(a, I); // Pastikan augmentedMatrix ada

        for (int j = 0; j < a.getCol(); j++) {
            int idxMax = j;

            for (int i = j + 1; i < a.getRow(); i++) {
                if (Math.abs(mAug.getElmt(i, j)) > Math.abs(mAug.getElmt(idxMax, j))) {
                    idxMax = i; // Cari baris maksimum
                }
            }

            if (Math.abs(mAug.getElmt(idxMax, j)) == 0) {
                return null; // Tidak ada invers
            }

            Operation.swapRow(mAug, idxMax, j); // Menukar baris

            for (int i = 0; i < a.getRow(); i++) {
                if (i != j) {
                    Operation.rowReduction(mAug, j, i, j); // Reduksi baris
                }
            }
            Operation.rowTimesK(mAug, 1 / mAug.getElmt(j, j), j); // Normalisasi baris
        }

        Matrix mHasil = new Matrix(a.getRow(), a.getCol());
        for (int i = 0; i < a.getRow(); i++) {
            for (int j = 0; j < a.getCol(); j++) {
                mHasil.setElmt(i, j, mAug.getElmt(i, j + a.getCol())); // Mengambil hasil dari augmented matrix
            }
        }
        return mHasil;
    }

    public static void displayGaussJordan(Matrix m) {
        Matrix n = eliminasiGaussJordan(m);
        if (n == null) {
            System.out.println("Matriks tidak mempunyai invers.");
        } else {
            System.out.println("Invers dari matriks tersebut adalah:");
            n.displayMatrix(); // Tampilkan matriks hasil
        }
    }

    public static void fileGaussJordan(Matrix m, String namaFile) {
        Matrix n = eliminasiGaussJordan(m);
        if (n == null) {
            IO.writeFileString(namaFile, "Matriks tidak mempunyai invers."); // Menulis ke file
        } else {
            IO.writeFileMatrix(namaFile, n); // Menulis matriks invers ke file
        }
    }
}
