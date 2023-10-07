package model.matakuliah;

public class MataKuliahPilihan {
    private String kode;
    private int sks;
    private String nama;
    private int jumlahMinimumMahasiswa;

    public MataKuliahPilihan() { }
    
    public MataKuliahPilihan(String kode, int sks, String nama, int jumlahMinimumMahasiswa) {
        this.kode = kode;
        this.sks = sks;
        this.nama = nama;
        this.jumlahMinimumMahasiswa = jumlahMinimumMahasiswa;
    }

    public String getKode() {
        return this.kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public int getSKS() {
        return this.sks;
    }

    public void setSKS(int sks) {
        this.sks = sks;
    }

    public String getNama() {
        return this.nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getJumlahMinimumMahasiswa() {
        return this.jumlahMinimumMahasiswa;
    }

    public void setJumlahMinimumMahasiswa(int jumlah) {
        this.jumlahMinimumMahasiswa = jumlah;
    }

    public String toString() {
        return "kode: " + this.kode + "\t " + sks + " SKS\t " + this.nama + "\t jumlahMinumumMahasiswa: " + this.jumlahMinimumMahasiswa;
    }
}
