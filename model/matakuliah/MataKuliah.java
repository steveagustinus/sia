package model.matakuliah;

public class MataKuliah {
    private String kode;
    private int sks;
    private String nama;
    
    public MataKuliah() { }

    public MataKuliah(String kode, int sks, String nama) {
        this.kode = kode;
        this.sks = sks;
        this.nama = nama;
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

    public String toString() {
        return "kode: " + this.kode + "\t " + sks + " SKS" + "\t " + this.nama;
    }
}
