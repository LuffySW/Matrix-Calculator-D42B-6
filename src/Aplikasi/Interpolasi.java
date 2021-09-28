package Aplikasi;

import java.util.Scanner;

import Matrix.Matrix;

public class Interpolasi {
    public static Matrix masukkanInterpolasi(int n) {
        Matrix a = new Matrix(n, n+1);

        Scanner sc = new Scanner(System.in);
        for (int i=0;i<n;i++){
            double x = sc.nextDouble();
            double y = sc.nextDouble();
            a.setElmt(i, n, y);
            for (int j=0;j<n;j++){
                a.setElmt(i, j, Math.pow(x, j));
            }
        }
        sc.close();

        return a;
    }
    public static void keluarkanInterpolasi(Matrix a) {
        int n = a.getCol();
        Matrix b = new Matrix(a.getRow(), a.getCol());
        b = SistemPersamaanLinear.MatrixGaussJordan(a);
        for (int k=0;k<n-1;k++){
            if(k==0){
                System.out.print(String.format("%.4f", b.getElmt(k,n-1)));
            }
            else if(k==1){
                System.out.print(String.format("+ " + "%.4f", b.getElmt(k, n-1)) + "x");
            }
            else {
                System.out.print(String.format("+ " + "%.4f", b.getElmt(k, n-1)) + "x^" + k);
            }
        }
    }
}
