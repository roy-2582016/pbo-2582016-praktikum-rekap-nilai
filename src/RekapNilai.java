import java.util.Scanner;

public class RekapNilai {

    // Sentinel: tanda berhenti input. Dibuat konstanta supaya tidak ada "angka ajaib" di kode.
    static final int SELESAI = -1;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int nilai;               // nilai yang sedang dibaca
        int jumlahSah = 0;       // banyaknya nilai sah (0-100)
        int urutan = 1;          // nomor nilai ke-berapa yang sedang diminta
        double total = 0;        // akumulator untuk rata-rata

        System.out.println("===== REKAP NILAI KELAS =====");
        System.out.println("Ketik -1 kalau sudah selesai.");

        // Kenapa do-while, bukan while?
        // Nilai pertama HARUS diminta dulu sebelum bisa dinilai (dicek == SELESAI atau bukan).
        // Dengan while, kita perlu variabel nilai sudah terisi sebelum kondisi dicek,
        // sehingga harus baca input dua kali (di luar dan di dalam loop). do-while
        // menjamin badan loop jalan minimal sekali, jadi cukup satu tempat membaca input.
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

            // Ladder if / else if / else.
            // Urutan harus dari nilai TERBESAR ke terkecil. Kalau dibalik (mulai dari nilai >= 60),
            // nilai 85 akan langsung masuk cabang pertama yang cocok, yaitu D (>= 60),
            // padahal seharusnya B. Ladder berhenti di kondisi pertama yang benar.
            char grade;
            if (nilai >= 90) {
                grade = 'A';
            } else if (nilai >= 80) {
                grade = 'B';
            } else if (nilai >= 70) {
                grade = 'C';
            } else if (nilai >= 60) {
                grade = 'D';
            } else {
                grade = 'E';
            }

            // Keterangan grade memakai switch lambda (Java 14+)
            String keterangan = switch (grade) {
                case 'A' -> "Sangat Baik";
                case 'B' -> "Baik";
                case 'C' -> "Cukup";
                case 'D' -> "Kurang";
                default -> "Tidak Lulus";
            };

            System.out.println("  Grade " + grade + " - " + keterangan);

            total += nilai;   // augmented assignment
            jumlahSah++;
            urutan++;

        } while (nilai != SELESAI);

        System.out.println();

        // Jaga kasus tidak ada nilai sah sama sekali (langsung ketik -1): hindari pembagian nol.
        if (jumlahSah == 0) {
            System.out.println("Tidak ada nilai sah yang dimasukkan.");
        } else {
            double rata = total / jumlahSah;

            // Status kelas memakai ternary, bukan if
            String status = rata >= 60 ? "LULUS" : "TIDAK LULUS";

            System.out.println("Nilai sah : " + jumlahSah);
            System.out.println("Rata-rata : " + String.format("%.2f", rata));
            System.out.println("Status    : " + status);
        }

        input.close();
    }
}