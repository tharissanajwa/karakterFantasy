import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GamePemilihanKarakter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<List<String>> karakterData = new ArrayList<>();

        // Inisialisasi data karakter beserta deskripsinya
        karakterData.add(Arrays.asList("Knight",
                "Knight adalah pejuang yang ulung dengan kemampuan bertahan yang hebat.\nDia membawa perisai besar dan pedang berat untuk melindungi diri dan rekan-rekannya dalam pertempuran."));
        karakterData.add(Arrays.asList("Mage",
                "Mage adalah penyihir kuat dengan kemampuan sihir yang luar biasa. Dia dapat melempar mantra untuk menghancurkan musuhnya dari jarak jauh.\nMeskipun dia lemah dalam pertempuran fisik, kekuatannya dalam sihir menjadikannya pilihan yang bijaksana dalam tim."));
        karakterData.add(Arrays.asList("Archer",
                "Archer adalah penembak jitu yang sangat terampil. Dia menggunakan busur panjang untuk menyerang musuh dari jarak jauh dengan tepat.\nKecepatan dan ketepatan adalah kekuatannya dalam pertempuran."));
        karakterData.add(Arrays.asList("Berserker",
                "Berserker adalah pejuang berani yang mengandalkan kekuatan dan kemarahan dalam pertempuran. Dia bergerak cepat dan menyerang musuhnya dengan kemarahan yang tak terbendung.\nMeskipun dia kuat dalam serangan, kekurangan pertahanan membuatnya harus berhati-hati dalam pertempuran."));

        System.out.println("Selamat datang di Pemilihan Karakter Fantasy!");

        boolean lanjut = true;
        while (lanjut) {
            // Menampilkan pilihan karakter yang tersedia
            System.out.println("Berikut adalah pilihan karakter yang tersedia:");
            System.out.println("1. Knight");
            System.out.println("2. Mage");
            System.out.println("3. Archer");
            System.out.println("4. Berserker");

            int pilihanKarakter = 0;
            boolean validInput = false;

            while (!validInput) {
                // Meminta pengguna memasukkan nomor karakter yang dipilih
                System.out.print("Masukkan nomor karakter yang Anda pilih (1-4) : ");
                if (scanner.hasNextInt()) {
                    pilihanKarakter = scanner.nextInt();
                    validInput = pilihanKarakter >= 1 && pilihanKarakter <= 4;
                } else {
                    // Jika input bukan bilangan bulat, kosongkan loop scanner
                    System.out.println("Input tidak valid! Harap masukkan angka antara 1 hingga 4.");
                    scanner.next(); // Menghilangkan error infinity loop
                }
            }

            // Menampilkan deskripsi karakter berdasarkan pilihan pengguna
            List<String> karakter = karakterData.get(pilihanKarakter - 1);
            String namaKarakter = karakter.get(0);
            String deksripsiKarakter = karakter.get(1);

            System.out.println("Anda memilih karakter " + namaKarakter + ".");
            System.out.println(deksripsiKarakter);
            System.out.println("\nSelamat bermain permainan fantasy dengan karakter " + namaKarakter + " Anda.");

            // Meminta pengguna untuk menjalankan permainan karakter kembali atau tidak
            System.out.print("Apakah permainan ingin dijalankan kembali? (ya/tidak) : ");
            String isRunning = scanner.next();

            if (isRunning.equalsIgnoreCase("ya")) {
                // Jika pengguna ingin menjalankan permainan karakter kembali, program akan terus berjalan
                System.out.println("=================================================================================");
                System.out.println("Permainan Selanjutnya");
                lanjut = true;
            } else if (isRunning.equalsIgnoreCase("tidak")) {
                // Jika pengguna tidak ingin menjalankan permainan karakter kembali, program akan selesai
                System.out.println("Terimakasih! Permainan Pemilihan Karakter Telah Selesai.");
                System.out.println("=================================================================================");
                lanjut = false;
            } else {
                // Jika pengguna memasukkan input selain "ya" atau "tidak", program akan selesai
                System.out.println("Input salah, format harus berupa ya/tidak. Silahkan refresh kembali.");
                System.out.println("=================================================================================");
                lanjut = false;
            }
        }

        // Menutup scanner untuk mencegah resource leak
        scanner.close();
    }
}
