package Aplikasi;

import java.util.Scanner;

import Matrix.Matrix;
import Matrix.Operation;
import Utility.IO;

import java.util.Scanner;

public class SistemPersamaanLinear {
    public static boolean IsEmpty(double[] m) {
        for (int i = 0; i < m.length; i++) {
            if (m[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static String ToString(double[] m) {
        String variabel = "abcdefghijklmnopqrstuvwxyz";
        String ans = "";
        for (int i = 1; i < m.length; i++) {
            if (m[i] != 0) {
                if (ans == "") {
                    if (m[i] == 1) {
                        ans = variabel.substring(i - 1, i);
                    } else if (m[i] == -1) {
                        ans = "-" + variabel.substring(i - 1, i);
                    } else {
                        ans = String.format("%.2f", m[i]) + variabel.substring(i - 1, i);
                    }
                } else {
                    if (m[i] > 0) {
                        if (m[i] == 1) {
                            ans += " + " + variabel.substring(i - 1, i);
                        } else {
                            ans += " + " + String.format("%.2f", m[i]) + variabel.substring(i - 1, i);
                        }
                    } else {
                        if (m[i] == -1) {
                            ans += " - " + variabel.substring(i - 1, i);
                        } else {
                            ans += " - " + String.format("%.2f", m[i] * (-1)) + variabel.substring(i - 1, i);
                        }
                    }
                }
            }
        }
        if (m[0] != 0) {
            if (ans == "") {
                ans = String.format("%.2f", m[0]);
            } else {
                if (m[0] > 0) {
                    ans += " + " + String.format("%.2f", m[0]);
                } else {
                    ans += " - " + String.format("%.2f", m[0] * (-1));
                }
            }
        } else {
            if (ans == "") {
                ans = "0";
            }
        }
        return ans;
    }

    public static Matrix MatrixGaussJordan(Matrix m) {
        Scanner input = new Scanner(System.in);
        System.out.println("Tentukan presisi matrix: ");
        int q = input.nextInt();
        Matrix n;
        int i, j, idxMax, row;

        n = new Matrix();
        n = n.copyMatrix(m);
        n.setPrecision(q);
        row = 0;
        for (j = 0; j < n.getCol() - 1; j++) {
            if (row == n.getRow()) {
                break;
            }

            idxMax = row;
            for (i = row + 1; i < n.getRow(); i++) {
                idxMax = Math.abs(n.getElmt(i, j)) > Math.abs(n.getElmt(idxMax, j)) ? i : idxMax;
            }

            if (Math.abs(n.getElmt(idxMax, j)) == 0) {
                continue;
            }

            Operation.swapRow(n, idxMax, row);
            printMatrixStep(n, "Setelah swap baris " + idxMax + " dan " + row);

            for (i = 0; i < n.getRow(); i++) {
                if (i == row) {
                    continue;
                }

                Operation.rowReduction(n, row, i, j);
                printMatrixStep(n, "Setelah reduksi baris " + i + " dengan baris " + row);
            }
            n.setPrecision(q);
            Operation.rowTimesK(n, 1 / n.getElmt(row, j));
            printMatrixStep(n, "Setelah mengalikan baris " + row + " dengan " + (1 / n.getElmt(row, j)));
            row++;
        }
        n.setPrecision(q);
        return n;
    }

    public static void printMatrixStep(Matrix m, String step) {
        System.out.println(step + ":");
        for (int i = 0; i < m.getRow(); i++) {
            for (int j = 0; j < m.getCol(); j++) {
                System.out.print(m.getElmt(i, j) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void SPLinverse(Matrix m) {
        // Pisahkan matriks augmented menjadi A (koefisien) dan b (konstanta)
        Matrix a = new Matrix(m.getRow(), m.getCol() - 1);
        Matrix b = new Matrix(m.getRow(), 1);

        // Langkah 1: Pisahkan matriks augmented
        System.out.println("Langkah 1: Memisahkan matriks augmented menjadi matriks A dan vektor b");
        Operation.splitAugmentedMatrix(m, a, b);

        System.out.println("Matriks A:");
        printMatrix(a);
        System.out.println("Vektor b:");
        printMatrix(b);

        // Periksa apakah matriks A adalah matriks persegi
        if (a.isSquare()) {
            // Langkah 2: Cek apakah matriks A persegi
            System.out.println("Langkah 2: Mengecek apakah matriks A adalah matriks persegi...");

            // Langkah 3: Hitung determinan matriks A
            double det = Determinan.ekspansiKofaktor(a);
            System.out.println("Langkah 3: Menghitung determinan matriks A...");
            System.out.println("Determinant: " + det);

            // Jika determinan 0, solusi tidak bisa diselesaikan dengan metode invers
            if (det == 0) {
                System.out.println("Matriks A memiliki determinan nol. Sistem tidak dapat diselesaikan dengan metode invers.");
                return;
            } else {
                // Langkah 4: Hitung invers matriks A
                System.out.println("Langkah 4: Menghitung invers matriks A...");
                Matrix inverseA = Inverse.inverseAdjoint(a);
                System.out.println("Inverse Matriks A:");
                printMatrix(inverseA);

                // Langkah 5: Kalikan invers A dengan vektor b
                System.out.println("Langkah 5: Mengalikan matriks invers A dengan vektor b...");
                Matrix result = Operation.multMatrix(inverseA, b);

                // Langkah 6: Tampilkan solusi
                System.out.println("Langkah 6: Menampilkan solusi dari sistem persamaan linear:");
                for (int i = 0; i < result.getRow(); i++) {
                    System.out.println("x" + (i + 1) + " = " + String.format("%.4f", result.getElmt(i, 0)));
                }
            }
        } else {
            System.out.println("Jumlah persamaan tidak sama dengan jumlah variabel. Sistem tidak dapat diselesaikan.");
        }
    }   

    public static void FileSPLinverse(Matrix m, String namaFile) {
        Matrix a = new Matrix(m.getRow(), m.getCol() - 1);
        Matrix b = new Matrix(m.getRow(), 1);

        // Langkah-langkah dalam bentuk string untuk file output
        StringBuilder tempString = new StringBuilder();
        tempString.append("Langkah 1: Memisahkan matriks augmented menjadi matriks A dan vektor b\n");
        Operation.splitAugmentedMatrix(m, a, b);
        
        tempString.append("Matriks A:\n").append(matrixToString(a)).append("\n");
        tempString.append("Vektor b:\n").append(matrixToString(b)).append("\n");

        if (a.isSquare()) {
            tempString.append("Langkah 2: Mengecek apakah matriks A adalah matriks persegi...\n");

            // Hitung determinan
            double det = Determinan.ekspansiKofaktor(a);
            tempString.append("Langkah 3: Menghitung determinan matriks A...\n");
            tempString.append("Determinant: ").append(det).append("\n");

            if (det == 0) {
                tempString.append("Matriks A memiliki determinan nol. Sistem tidak dapat diselesaikan dengan metode invers.\n");
                IO.writeFileString(namaFile, tempString.toString());
                return;
            } else {
                tempString.append("Langkah 4: Menghitung invers matriks A...\n");
                Matrix inverseA = Inverse.inverseAdjoint(a);
                tempString.append("Inverse Matriks A:\n").append(matrixToString(inverseA)).append("\n");

                tempString.append("Langkah 5: Mengalikan matriks invers A dengan vektor b...\n");
                Matrix result = Operation.multMatrix(inverseA, b);
                
                tempString.append("Langkah 6: Menampilkan solusi dari sistem persamaan linear:\n");
                for (int i = 0; i < result.getRow(); i++) {
                    tempString.append("x").append(i + 1).append(" = ").append(String.format("%.4f", result.getElmt(i, 0))).append("\n");
                }

                IO.writeFileString(namaFile, tempString.toString());
            }
        } else {
            tempString.append("Jumlah persamaan tidak sama dengan jumlah variabel. Sistem tidak dapat diselesaikan.\n");
            IO.writeFileString(namaFile, tempString.toString());
        }
    }

    // Fungsi untuk mencetak matriks
    public static void printMatrix(Matrix m) {
        for (int i = 0; i < m.getRow(); i++) {
            for (int j = 0; j < m.getCol(); j++) {
                System.out.print(m.getElmt(i, j) + " ");
            }
            System.out.println();
        }
    }

    // Fungsi untuk mengubah matriks menjadi string
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

    public static Matrix matrixGauss(Matrix m) {
        Matrix n = new Matrix();
        n = n.copyMatrix(m);
        int utama = 0;

        for (int i = 0; i < n.getCol(); i++) {
            int max = utama;
            for (int j = utama + 1; j < n.getRow(); j++) {
                if (Math.abs(n.getElmt(j, i)) > Math.abs(n.getElmt(max, i))) {
                    max = j;
                }
            }

            if (Math.abs(n.getElmt(max, i)) == 0) {
                continue;
            } else {
                Operation.swapRow(n, utama, max);
                printMatrixStep(n, "Setelah swap baris " + utama + " dan " + max);
                Operation.rowTimesK(n, 1 / n.getElmt(utama, i));
                printMatrixStep(n, "Setelah mengalikan baris " + utama + " dengan " + (1 / n.getElmt(utama, i)));

                for (int k = utama + 1; k < n.getRow(); k++) {
                    Operation.rowReduction(n, utama, k, i);
                    printMatrixStep(n, "Setelah reduksi baris " + k + " dengan baris " + utama);
                }
                utama++;
            }

            if (utama == n.getRow() - 1) {
                for (int x = i + 1; x < n.getCol(); x++) {
                    if (Math.abs(n.getElmt(utama, x)) > 0) {
                        Operation.rowTimesK(n, 1 / n.getElmt(utama, x));
                        printMatrixStep(n, "Setelah mengalikan baris " + utama + " dengan " + (1 / n.getElmt(utama, x)));
                        break;
                    }
                }
                break;
            }
        }
        return n;
    }
    
    public static void SPLGauss(Matrix m) {
        String variable = "abcdefghijklmnopqrstuvwxyz";
        boolean noSolution = false;
        boolean infiniteSolutions = false;
        Matrix n = new Matrix();
        n = n.copyMatrix(m);
        m = matrixGauss(m);  // Lakukan eliminasi Gauss
        double[][] solusi = new double[27][27];
        int variabel = 1;
    
        // Cek apakah ada baris yang menyebabkan sistem tidak memiliki solusi atau solusi tak hingga
        for (int i = 0; i < m.getRow(); i++) {
            boolean allZeroes = true;
            for (int j = 0; j < m.getCol() - 1; j++) {
                if (m.getElmt(i, j) != 0) {
                    allZeroes = false;
                    break;
                }
            }
            if (allZeroes && m.getElmt(i, m.getCol() - 1) != 0) {
                // Baris dalam bentuk [0 0 ... | b] di mana b ≠ 0
                noSolution = true;
                break;
            } else if (allZeroes && m.getElmt(i, m.getCol() - 1) == 0) {
                // Baris dalam bentuk [0 0 ... | 0], ini kemungkinan solusi tak hingga
                infiniteSolutions = true;
            }
        }
    
        if (noSolution) {
            System.out.println("SPL tidak memiliki solusi.");
            return;
        }
    
        // Proses mencari solusi
        for (int i = m.getRow() - 1; i >= 0; i--) {
            int found = -1;
            double[] hasil = new double[27];
            for (int j = 0; j < m.getCol(); j++) {
                if (m.getElmt(i, j) != 0) {
                    if (j == m.getCol() - 1) {
                        hasil[0] += m.getElmt(i, j); // Nilai konstanta
                    } else {
                        if (IsEmpty(solusi[j])) {
                            if (found != -1) {
                                solusi[j][variabel] = 1;
                                hasil[variabel] = (-1) * m.getElmt(i, j);
                                variabel += 1;
                            } else {
                                found = j;  // Pivot ditemukan
                            }
                        } else {
                            for (int k = 0; k < 27; k++) {
                                hasil[k] = hasil[k] - solusi[j][k] * m.getElmt(i, j);
                            }
                        }
                    }
                }
            }
    
            // Tambahkan pengecekan untuk menghindari error jika tidak ada pivot yang ditemukan
            if (found == -1) {
                if (m.getElmt(i, m.getCol() - 1) != 0) {
                    // Tidak ada solusi karena konstanta tidak nol
                    noSolution = true;
                    break;
                } else {
                    // Baris 0, ini adalah variabel bebas
                    infiniteSolutions = true;
                    continue;
                }
            }
    
            // Simpan hasil ke solusi hanya jika pivot ditemukan
            solusi[found] = hasil;
        }
    
        if (infiniteSolutions) {
            System.out.println("SPL memiliki solusi tak hingga.");
            return;
        }
    
        if (!noSolution) {
            // Tampilkan solusi
            for (int i = 0; i < m.getCol() - 1; i++) {
                if (!ToString(solusi[i]).equals("0")) {
                    System.out.println("x" + (i + 1) + " = " + ToString(solusi[i]));
                } else {
                    for (int k = 0; k < n.getRow(); k++) {
                        if (n.getElmt(k, i) != 0) {
                            System.out.println("x" + (i + 1) + " = " + ToString(solusi[i]));
                            break;
                        } else if (k == n.getRow() - 1) {
                            solusi[i][variabel] = 1;
                            variabel++;
                            System.out.println("x" + (i + 1) + " = " + ToString(solusi[i]));
                        }
                    }
                }
            }
        }
    }    
    
    public static void FileSPLGaussJordan(Matrix m, String namaFile) {
        String variable = "abcdefghijklmnopqrstuvwxyz";
        boolean noSolution = false;
        Matrix n = new Matrix();
        n = n.copyMatrix(m);
        m = matrixGauss(m);
        double[][] solusi = new double[27][27];
        int variabel = 1;
        StringBuilder tempString = new StringBuilder();

        for (int i = m.getRow() - 1; i >= 0; i--) {
            int found = -1;
            double[] hasil = new double[27];
            for (int j = 0; j < m.getCol(); j++) {
                if (m.getElmt(i, j) != 0) {
                    if (j == m.getCol() - 1) {
                        hasil[0] += m.getElmt(i, j);
                    } else {
                        if (IsEmpty(solusi[j])) {
                            if (found != -1) {
                                solusi[j][variabel] = 1;
                                hasil[variabel] = (-1) * m.getElmt(i, j);
                                variabel += 1;
                            } else {
                                found = j;
                            }
                        } else {
                            for (int k = 0; k < 27; k++) {
                                hasil[k] = hasil[k] - solusi[j][k] * m.getElmt(i, j);
                            }
                        }
                    }
                }
            }
            if (found == -1) {
                if (m.getElmt(i, m.getCol() - 1) != 0) {
                    noSolution = true;
                }
            } else {
                solusi[found] = hasil;
            }
        }

        if (noSolution) {
            tempString.append("SPL tidak memiliki solusi\n");
        } else {
            for (int i = 0; i < m.getCol() - 1; i++) {
                if (!ToString(solusi[i]).equals("0")) {
                    tempString.append("x").append(i + 1).append(" = ").append(ToString(solusi[i])).append("\n");
                } else {
                    for (int k = 0; k < n.getRow(); k++) {
                        if (n.getElmt(k, i) != 0) {
                            tempString.append("x").append(i + 1).append(" = ").append(ToString(solusi[i])).append("\n");
                            break;
                        } else if (k == n.getRow() - 1) {
                            solusi[i][variabel] = 1;
                            variabel++;
                            tempString.append("x").append(i + 1).append(" = ").append(ToString(solusi[i])).append("\n");
                        }
                    }
                }
            }
        }
        IO.writeFileString(namaFile, tempString.toString());
    }

    // Fungsi untuk menuliskan hasil SPL Gauss ke dalam file
    public static void FileSPLGauss(Matrix m, String fileName) {
        boolean noSolution = false;
        Matrix augmentedMatrix = m.copyMatrix(m);
        Matrix reducedMatrix = matrixGauss(augmentedMatrix);
        double[][] solusi = new double[27][27];
        int freeVariableIndex = 1;
        StringBuilder tempString = new StringBuilder();
        
        for (int i = reducedMatrix.getRow() - 1; i >= 0; i--) {
            int pivotIndex = -1;
            double[] solutionRow = new double[27];
            
            for (int j = 0; j < reducedMatrix.getCol(); j++) {
                if (reducedMatrix.getElmt(i, j) != 0) {
                    if (j == reducedMatrix.getCol() - 1) {
                        solutionRow[0] += reducedMatrix.getElmt(i, j);
                    } else {
                        if (isEmpty(solusi[j])) {
                            if (pivotIndex != -1) {
                                solusi[j][freeVariableIndex] = 1;
                                solutionRow[freeVariableIndex] = -1 * reducedMatrix.getElmt(i, j);
                                freeVariableIndex++;
                            } else {
                                pivotIndex = j;
                            }
                        } else {
                            for (int k = 0; k < 27; k++) {
                                solutionRow[k] -= solusi[j][k] * reducedMatrix.getElmt(i, j);
                            }
                        }
                    }
                }
            }

            if (pivotIndex == -1) {
                if (reducedMatrix.getElmt(i, reducedMatrix.getCol() - 1) != 0) {
                    noSolution = true;
                }
            } else {
                solusi[pivotIndex] = solutionRow;
            }
        }

        if (noSolution) {
            tempString.append("SPL tidak memiliki solusi.");
        } else {
            for (int i = 0; i < reducedMatrix.getCol() - 1; i++) {
                if (!toString(solusi[i]).equals("0")) {
                    tempString.append("x").append(i + 1).append(" = ").append(toString(solusi[i])).append("\n");
                } else {
                    for (int k = 0; k < augmentedMatrix.getRow(); k++) {
                        if (augmentedMatrix.getElmt(k, i) != 0) {
                            tempString.append("x").append(i + 1).append(" = ").append(toString(solusi[i])).append("\n");
                            break;
                        } else if (k == augmentedMatrix.getRow() - 1) {
                            solusi[i][freeVariableIndex] = 1;
                            freeVariableIndex++;
                            tempString.append("x").append(i + 1).append(" = ").append(toString(solusi[i])).append("\n");
                        }
                    }
                }
            }
        }

        // Tulis hasil ke dalam file
        IO.writeFileString(fileName, tempString.toString());
    }

    // Fungsi untuk mengubah solusi menjadi string
    public static String toString(double[] solusi) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < solusi.length; i++) {
            if (solusi[i] != 0) {
                if (result.length() > 0) {
                    result.append(" + ");
                }
                result.append(solusi[i]).append("x").append(i + 1);
            }
        }
        return result.toString().isEmpty() ? "0" : result.toString();
    }

    // Fungsi untuk mengecek apakah array solusi kosong
    public static boolean isEmpty(double[] solusi) {
        for (double v : solusi) {
            if (v != 0) {
                return false;
            }
        }
        return true;
    }

    public static void SPLGaussJordan(Matrix m) {
        String variable = "abcdefghijklmnopqrstuvwxyz";
        boolean noSolution = false;
        boolean infiniteSolutions = false; // Untuk menandai solusi tak hingga
        Matrix n = new Matrix();
        n = n.copyMatrix(m);
        m = MatrixGaussJordan(m);
        double[][] solusi = new double[27][27];
        int variabel = 1;
    
        // Proses Gauss-Jordan
        for (int i = m.getRow() - 1; i >= 0; i--) {
            int found = -1;
            double[] hasil = new double[27];
    
            for (int j = 0; j < m.getCol(); j++) {
                if (m.getElmt(i, j) != 0) {
                    if (j == m.getCol() - 1) {
                        hasil[0] += m.getElmt(i, j); // Nilai konstanta
                    } else {
                        if (IsEmpty(solusi[j])) {
                            if (found != -1) {
                                solusi[j][variabel] = 1; // Variabel bebas
                                hasil[variabel] = (-1) * m.getElmt(i, j);
                                variabel++;
                            } else {
                                found = j;  // Pivot ditemukan
                            }
                        } else {
                            for (int k = 0; k < 27; k++) {
                                hasil[k] -= solusi[j][k] * m.getElmt(i, j);
                            }
                        }
                    }
                }
            }
    
            // Pengecekan solusi
            if (found == -1) {
                if (m.getElmt(i, m.getCol() - 1) != 0) {
                    // Tidak ada solusi karena konstanta tidak nol
                    noSolution = true;
                    break;
                } else {
                    // Baris nol, ini adalah variabel bebas
                    infiniteSolutions = true;
                }
            } else {
                solusi[found] = hasil;
            }
        }
    
        // Menampilkan hasil
        if (noSolution) {
            System.out.println("SPL tidak memiliki solusi.");
        } else if (infiniteSolutions) {
            System.out.println("SPL memiliki solusi tak hingga.");
        } else {
            // Tampilkan solusi
            for (int i = 0; i < m.getCol() - 1; i++) {
                if (!ToString(solusi[i]).equals("0")) {
                    System.out.println("x" + (i + 1) + " = " + ToString(solusi[i]));
                } else {
                    for (int k = 0; k < n.getRow(); k++) {
                        if (n.getElmt(k, i) != 0) {
                            System.out.println("x" + (i + 1) + " = " + ToString(solusi[i]));
                            break;
                        } else if (k == n.getRow() - 1) {
                            solusi[i][variabel] = 1; // Menandakan variabel bebas
                            variabel++;
                            System.out.println("x" + (i + 1) + " = " + ToString(solusi[i]));
                        }
                    }
                }
            }
        }
    }    
}