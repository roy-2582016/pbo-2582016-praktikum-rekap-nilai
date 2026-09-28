import java.util.Scanner;

public class RekapNilai {

    // Sentinel: tanda berhenti input. Dibuat konstanta supaya tidak ada "angka ajaib" di kode.
    static final int SELESAI = -1;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int nilai;
        int jumlahSah = 0;
        int urutan = 1;

        System.out.println("===== REKAP NILAI KELAS =====");
        System.out.println("Ketik -1 kalau sudah selesai.");

        // Kenapa do-while, bukan while?
        // Nilai pertama HARUS diminta dulu sebelum bisa dicek == SELESAI atau bukan.
        // Dengan while, input harus dibaca dua kali (di luar dan di dalam loop).
        // do-while menjamin badan loop jalan minimal sekali, jadi cukup satu tempat membaca input.
        do {
            System.out.print("Nilai ke-" + urutan + " : ");
            nilai = input.nextInt();

            // Sentinel langsung keluar tanpa diproses.
            // continue pada do-while melompat ke pengecekan kondisi, lalu loop berhenti.
            if (nilai == SELESAI) {
                continue;
            }

            // Nilai di luar 0-100 ditolak; continue membuat pencacah tidak naik.
            if (nilai < 0 || nilai > 100) {
                System.out.println("  ditolak - nilai harus 0..100");
                continue;
            }

            jumlahSah++;
            urutan++;

        } while (nilai != SELESAI);

        System.out.println("Nilai sah : " + jumlahSah);

        input.close();
    }
}