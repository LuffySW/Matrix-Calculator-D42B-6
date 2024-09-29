package Matrix;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.io.*;

public class Matrix {
  private int row, col;
  private Double mtxr[][];
  
  // KONSTRUKTOR
  public Matrix(){
    this.row = 0;
    this.col = 0;
  }

  //membuat matrix dengan baris dengan kolom
  public Matrix(int row, int col){
    this.row = row;
    this.col = col;
    this.mtxr = new Double [row][col];
  }

  //membuat dan mengisi matrix dengan konstanta c
  public Matrix(int row, int col, double c){
    this.row = row;
    this.col = col;
    for(int i = 0; i < this.row; i++){
      for(int j = 0; j < this.col; j++){
        this.mtxr[i][j] = c;
      }
    }
  }

  // GETTER DAN SETTER
  public int getRow(){
    return this.row;
  }

  public int getCol(){
    return this.col;
  }

  public double getElmt(int row, int col){
    return this.mtxr[row][col];
  }

  public void setRow(int row){
    this.row = row;
    this.mtxr = new Double [this.row][this.col];
  }

  public void setCol(int col){
    this.col = col;
    this.mtxr = new Double [this.row][this.col];
  }

  public void setElmt(int row, int col, double elmt){
    this.mtxr[row][col] = elmt;
  }

  //OPERASI

  public void createMatrix(){
    InputStreamReader inputan = new InputStreamReader(System.in);
    BufferedReader readInput = new BufferedReader(inputan);

    for(int i = 0; i < this.row; i++){
      for(int j = 0; j < this.col; j++){
        String line = new String();
        try {
          System.out.println("Masukkan elemen baris " + (i+1) + ", kolom " + (j+1) + ":");
          line = readInput.readLine();
        } catch (IOException e) {
          e.printStackTrace();
        }
        double d = Operation.eval(line); // evaluasi elemen input
        d = BigDecimal.valueOf(d).setScale(8, RoundingMode.HALF_UP).doubleValue();
        this.mtxr[i][j] = d; // masukkan ke matrix
      }
    }
  }


  public void createIdentityMatrix(){
    for(int i = 0; i < this.row; i++){
      for(int j = 0; j < this.col; j++){
        if(i == j)setElmt(i, j, 1);
        else setElmt(i, j, 0);
      }
    }
  }

  public void displayMatrix(){
    for(int i = 0; i < this.row; i++){
      for(int j = 0; j < this.col; j++){
        System.out.print(this.mtxr[i][j]);
        System.out.print(" ");
      }
      System.out.println("");
    }
  }

  public Matrix copyMatrix(Matrix a){
    Matrix result = new Matrix(a.getRow(), a.getCol());
    for (int i=0;i<a.getRow();i++){
      for (int j=0;j<a.getCol();j++){
        result.mtxr[i][j] = a.mtxr[i][j];
      }
    }
    return result;
  }

  public double getDiagonalElmt(int idx){
    return this.mtxr[idx][idx];
  }

  public boolean isSquare(){
    return (this.getRow() == this.getCol());
  }

  public boolean isIdentity(){
    boolean identity = this.isSquare();
    if(identity){
      for(int i = 0; i < this.row; i++){
        for(int j = 0; j < this.col; j++){
          if(i == j){
            if(this.getElmt(i, j) != 1){
              identity = false;
              break;
            }
          }else{
            if(this.getElmt(i, j) != 0){
              identity = false;
              break;
            }
          }
        }
      }
    }
    return identity;
  }
  public void setPrecision(int scale){
    for(int i = 0; i < this.row; i++){
      for(int j = 0; j < this.col; j++){
        this.mtxr[i][j] = BigDecimal.valueOf(this.mtxr[i][j]).setScale(scale, RoundingMode.HALF_UP).doubleValue();
      }
    }
  }

  public void setPrecisionWORounding(int scale){
    for(int i = 0; i < this.row; i++){
      for(int j = 0; j < this.col; j++){
        this.mtxr[i][j] = BigDecimal.valueOf(this.mtxr[i][j]).setScale(scale).doubleValue();
      }
    }
  }

}
