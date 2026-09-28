import java.util.Scanner;

public class RekapNilai {

    // Sentinel: tanda berhenti input
    static final int SELESAI = -1;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("===== REKAP NILAI KELAS =====");
        System.out.println("Ketik -1 kalau sudah selesai.");

        input.close();
    }
}