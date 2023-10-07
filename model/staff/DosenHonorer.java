package model.staff;

import java.util.Date;

public class DosenHonorer extends Dosen {
    private int honorPerSKS;

    public DosenHonorer() { }

    public DosenHonorer(String nama, String alamat, Date tanggalLahir, String tempatLahir, String nomorTelepon, String nik, String departemen, int honorPerSKS) {
        super(nama, alamat, tanggalLahir, tempatLahir, nomorTelepon, nik, departemen);
        this.honorPerSKS = honorPerSKS;
    }

    public int getHonorPerSKS() {
        return this.honorPerSKS;
    }

    public void setHonorPerSKS(int honorPerSKS) {
        this.honorPerSKS = honorPerSKS;
    }

    public String toString() {
        return super.toString() + "\r\nhonorPerSKS: " + this.honorPerSKS;
    }
}
