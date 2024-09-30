# Matrix-Calculator-D42B-6

## Tugas Besar 1 Aljabar Linear dan Geometri D4-2B

Tugas ini adalah proyek untuk membangun sebuah kalkulator matriks yang menghitung **Operasi Dasar Matrix**, **Perkalian Skalar Dengan Matrix**, **Sistem Persamaan Linear**,  **Determinan**, **Menghitung Matriks Invers**, **Menghitung Transpose Matrix**. 

## Fitur

### 1. Operasi Dasar Matriks

Program mendukung empat operasi dasar pada matriks:

- **Penjumlahan**: Menambahkan dua matriks berukuran sama.
- **Pengurangan**: Mengurangi satu matriks dari matriks lainnya.
- **Perkalian**: Mengalikan dua matriks.
- **Pembagian**: Membagi elemen-elemen matriks satu dengan yang lain (hanya untuk elemen-elemen yang valid).

### 2. Perkalian Skalar

Dapat mengalikan matriks dengan skalar, yaitu angka tunggal yang dikalikan dengan setiap elemen dalam matriks.

### 3. Perhitungan Determinan

Program ini menyediakan tiga metode untuk menghitung determinan matriks:

- **Metode Eliminasi Gauss**: Menggunakan eliminasi baris untuk mengubah matriks menjadi bentuk segitiga atas sebelum menghitung determinan.

- **Metode Ekspansi Kofaktor**: Menghitung determinan dengan mengembangkan elemen-elemen dalam baris atau kolom tertentu melalui kofaktor.
- **Metode Sarrus**: Khusus untuk matriks 3x3, metode Sarrus memberikan cara cepat untuk menghitung determinan.

### 4. Invers Matriks

Dapat menghitung invers matriks menggunakan dua metode:

- **Metode Eliminasi Gauss Jordan**: Mengubah matriks menjadi matriks identitas dengan operasi baris elementer.
- **Metode Adjoint**: Menggunakan matriks adjoint dan determinan untuk menghitung invers.

### 5. Penyelesaian Sistem Persamaan Linear (SPL)

Program ini menyediakan beberapa metode untuk menyelesaikan SPL dalam bentuk matriks:

- **Metode Eliminasi Gauss**: Menggunakan eliminasi baris untuk menyelesaikan SPL.
- **Metode Eliminasi Gauss Jordan**: Penyelesaian SPL melalui modifikasi metode Gauss.
- **Metode Matriks Invers**: Menyelesaikan SPL menggunakan invers dari matriks koefisien.
- **Kaidah Cramer**: Menyelesaikan SPL dengan menggunakan determinan matriks.
---

## File Structure

```
├── .idea
├── bin
├── out
│   ├── production
│       └── Matrix-Calculator-D42B-6
│           ├── Aplikasi
│           │   ├── Crammer.class
│           │   ├── Determinan.class
│           │   ├── Interpolasi.class
│           │   ├── Inverse.class
│           │   ├── RLB.class
│           │   └── SistemPersamaanLinear.class
│           ├── Matrix
│           │   ├── Matrix.class
│           │   └── Operation.class
│           └── Utility
│               ├── IO.class
│               └── Menu.class
├── src
│   ├── Aplikasi
│   │   ├── Crammer.java
│   │   ├── Determinan.java
│   │   ├── Interpolasi.java
│   │   ├── Inverse.java
│   │   ├── RLB.java
│   │   └── SistemPersamaanLinear.java
│   ├── Matrix
│   │   ├── Matrix.java
│   │   └── Operation.java
│   └── Utility
│       ├── IO.java
│       └── Menu.java
├── test
│   ├── 2x6.txt
│   ├── 2x7.txt
│   ├── 2x10.txt
│   ├── 3_b.txt
│   ├── 3x3.txt
│   ├── 3x3_2.txt
│   ├── 4x3.txt
│   ├── 4x4.txt
│   ├── 5x4.txt
│   ├── 5x4_1.txt
│   ├── 5x4_2.txt
│   ├── 5x6.txt
│   ├── 6x4.txt
│   ├── 6x6.txt
│   └── 7.txt

```

---

## How To Use?

### Using source code

1. Clone folder with `git clone https://github.com/LuffySW/Matrix-Calculator-D42B-6.git` or download the zip file from the github
1. Run matrix calculator using `java Main` command
1. test folder is used to store input and output txt file




---
## Contributors

1. Astria Rizka Latifahsary **(231524037)**
1. Devi Febrianti **(231524039)**
1. Luthfi Satrio Wicaksono **(231524049)**
1. Muhammad Hasbi Asshidiqi **(231524055)**

## Referensi


Repository ini adalah fork dari Matrix-Calculator. Repository asli dapat dilihat di [sini](https://github.com/IloveNooodles/Matrix-Calculator).


