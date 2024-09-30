package model;

public class Jurnal {
    private String judul;
    private String isi;
    private String tanggal;

    public Jurnal(String judul, String isi, String tanggal) {
        this.judul = judul;
        this.isi = isi;
        this.tanggal = tanggal;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

   
    public void tampilkanRingkasan() {
        System.out.println("Judul: " + judul);
        System.out.println("Tanggal: " + tanggal);
    }

    
    public void tampilkanIsiLengkap() {
        System.out.println("Judul: " + judul);
        System.out.println("Tanggal: " + tanggal);
        System.out.println("Isi: " + isi);
        System.out.println("======================");
    }
}
