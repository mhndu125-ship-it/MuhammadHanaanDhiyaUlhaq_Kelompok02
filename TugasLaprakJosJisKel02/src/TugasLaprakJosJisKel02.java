import java.util.Scanner;

public class TugasLaprakJosJisKel02 {

    // 1. Non-return type tanpa parameter (menampilkan banner header)
    public static void tampilkanHeader() {
        System.out.println("=========================================");
        System.out.println("   SISTEM REKAPITULASI NILAI MAHASISWA   ");
        System.out.println("=========================================");
    }

    // 2. Return type tanpa parameter (mengambil pesan petunjuk awal)
    public static String getPetunjuk() {
        return "Silakan masukkan data mata kuliah dan nilai mahasiswa.";
    }

    // 3. Return type berparameter (menhitung nilai akhir berbobot)
    public static double hitungNilaiAkhir(double nilaiTugas, double nilaiUTS, double nilaiUAS) {
        // Bobot: Tugas 20%, UTS 35%, UAS 45%
        return (nilaiTugas * 0.20) + (nilaiUTS * 0.35) + (nilaiUAS * 0.45);
    }

    // 4. Return type berparameter (menentukan predikat nilai huruf)
    public static char tentukanPredikat(double nilaiAkhir) {
        // Pengkondisian untuk penentuan nilai huruf
        if (nilaiAkhir >= 85) {
            return 'A';
        } else if (nilaiAkhir >= 70) {
            return 'B';
        } else if (nilaiAkhir >= 60) {
            return 'C';
        } else if (nilaiAkhir >= 50) {
            return 'D';
        } else {
            return 'E';
        }
    }

    // 5. Non-return type berparameter (menampilkan rincian hasil nilai)
    public static void cetakHasil(String mataKuliah, double nilaiAkhir, char predikat) {
        System.out.println("\n-----------------------------------------");
        System.out.println(" Mata Kuliah  : " + mataKuliah);
        System.out.println(" Nilai Akhir  : " + nilaiAkhir);
        System.out.println(" Predikat     : " + predikat);

        // Pengkondisian untuk status kelulusan
        if (predikat == 'A' || predikat == 'B' || predikat == 'C') {
            System.out.println(" Status       : LULUS");
        } else {
            System.out.println(" Status       : TIDAK LULUS");
        }
        System.out.println("-----------------------------------------");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(inputSystem());

        // Memanggil method non-return tanpa parameter
        tampilkanHeader();

        // Memanggil function return type tanpa parameter
        System.out.println(getPetunjuk());

        char ulang;

        // Perulangan do-while untuk menginput beberapa mata kuliah
        do {
            System.out.print("\nMasukkan Nama Mata Kuliah : ");
            String matkul = input.nextLine();

            System.out.print("Masukkan Nilai Tugas (0-100): ");
            double tugas = input.nextDouble();

            System.out.print("Masukkan Nilai UTS   (0-100): ");
            double uts = input.nextDouble();

            System.out.print("Masukkan Nilai UAS   (0-100): ");
            double uas = input.nextDouble();

            // Memanggil function return type berparameter
            double nilaiAkhir = hitungNilaiAkhir(tugas, uts, uas);
            char predikat = tentukanPredikat(nilaiAkhir);

            // Memanggil method non-return type berparameter
            cetakHasil(matkul, nilaiAkhir, predikat);

            System.out.print("Input mata kuliah lain? (y/n): ");
            ulang = input.next().charAt(0);
            input.nextLine(); // Membersihkan buffer newline

        } while (ulang == 'y' || ulang == 'Y');

        System.out.println("\nProses rekapitulasi nilai selesai.");
        input.close();
    }

    // Helper sederhana untuk scanner input
    private static java.io.InputStream inputSystem() {
        return System.in;
    }
}