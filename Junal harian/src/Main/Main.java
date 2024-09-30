package main;

import model.Jurnal;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Jurnal> daftarJurnal = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Menu Pengelolaan Jurnal Harian ===");
            System.out.println("1. Lihat Jurnal");
            System.out.println("2. Tambah Jurnal");
            System.out.println("3. Edit Jurnal");
            System.out.println("4. Hapus Jurnal");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); 

            switch (pilihan) {
                case 1:
                    bacaIsiJurnal();
                    break;
                case 2:
                    tambahJurnal();
                    break;
                case 3:
                    editJurnal();
                    break;
                case 4:
                    hapusJurnal();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("invalid.");
            }
        }
    }

  
    static void tambahJurnal() {
        System.out.print("Masukkan judul : ");
        String judul = scanner.nextLine();
        System.out.print("Masukkan isi jurnal: ");
        String isi = scanner.nextLine();
        System.out.print("Masukkan tanggal jurnal (DD/MM/YYYY): ");
        String tanggal = scanner.nextLine();
        
        Jurnal jurnal = new Jurnal(judul, isi, tanggal);
        daftarJurnal.add(jurnal);
        System.out.println("Jurnal berhasil ditambahkan!");
    }

    static void lihatSemuaJurnal() {
        if (daftarJurnal.isEmpty()) {
            System.out.println("Tidak ada jurnal.");
        } else {
            for (int i = 0; i < daftarJurnal.size(); i++) {
                System.out.println((i + 1) + ". ");
                daftarJurnal.get(i).tampilkanRingkasan();
            }
        }
    }

    static void bacaIsiJurnal() {
        if (daftarJurnal.isEmpty()) {
            System.out.println("Tidak ada jurnal.");
            return;
        }

        lihatSemuaJurnal();
        System.out.print("Pilih nomor jurnal untuk membaca isinya: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Konsumsi newline

        if (index > 0 && index <= daftarJurnal.size()) {
            Jurnal jurnalDipilih = daftarJurnal.get(index - 1);
            jurnalDipilih.tampilkanIsiLengkap();
        } else {
            System.out.println("Nomor jurnal tidak valid.");
        }
    }

    static void editJurnal() {
        if (daftarJurnal.isEmpty()) {
            System.out.println("Tidak ada jurnal.");
            return;
        }

        lihatSemuaJurnal();
        System.out.print("Pilih nomor jurnal yang ingin diedit: ");
        int index = scanner.nextInt();
        scanner.nextLine(); 

        if (index > 0 && index <= daftarJurnal.size()) {
            Jurnal jurnal = daftarJurnal.get(index - 1);

            System.out.print("Judul saat ini: " + jurnal.getJudul() + ". Tekan Enter jika tidak ingin mengubah: ");
            String judulBaru = scanner.nextLine();
            if (!judulBaru.isEmpty()) {
                jurnal.setJudul(judulBaru);
            }

            System.out.print("Isi saat ini: " + jurnal.getIsi() + ". Tekan Enter jika tidak ingin mengubah: ");
            String isiBaru = scanner.nextLine();
            if (!isiBaru.isEmpty()) {
                jurnal.setIsi(isiBaru);
            }

            System.out.print("Tanggal saat ini: " + jurnal.getTanggal() + ". Tekan Enter jika tidak ingin mengubah: ");
            String tanggalBaru = scanner.nextLine();
            if (!tanggalBaru.isEmpty()) {
                jurnal.setTanggal(tanggalBaru);
            }

            System.out.println("Jurnal berhasil diupdate!");
        } else {
            System.out.println("Nomor jurnal tidak valid.");
        }
    }

    static void hapusJurnal() {
        if (daftarJurnal.isEmpty()) {
            System.out.println("Tidak ada jurnal.");
            return;
        }

        lihatSemuaJurnal();
        System.out.print("Pilih nomor jurnal yang ingin dihapus: ");
        int index = scanner.nextInt();
        scanner.nextLine(); 

        if (index > 0 && index <= daftarJurnal.size()) {
            daftarJurnal.remove(index - 1);
            System.out.println("Jurnal berhasil dihapus!");
        } else {
            System.out.println("Nomor jurnal tidak valid.");
        }
    }
}
