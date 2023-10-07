package model.mahasiswa;

import java.util.Date;

import model.Enums;

public class MahasiswaDoktor extends Mahasiswa {
    private String judulPenelitianDisertasi;
    private float[] nilaiSidang;

    public MahasiswaDoktor() { }

    public MahasiswaDoktor(String nama, String alamat, Date tanggalLahir, String tempatLahir, String nomorTelepon, String nim, Enums.Jurusan jurusan, String judulPeneliitianDisertasi) {
        super(nama, alamat, tanggalLahir, tempatLahir,nomorTelepon, nim, jurusan);
        this.judulPenelitianDisertasi = judulPeneliitianDisertasi;
        this.nilaiSidang = new float[3];
        for (int i = 0; i < this.nilaiSidang.length; i++) {
            this.nilaiSidang[i] = -1f;
        }
    }

    public String getJudulPenelitianDisertasi() {
        return this.judulPenelitianDisertasi;
    }

    public void setJudulPenelitianDisertasi(String judul) {
        this.judulPenelitianDisertasi = judul;
    }

    public float[] getNilaiSidang() {
        return this.nilaiSidang;
    }

    public String printNilaiSidang() {
        String output = "";

        for (int i = 0; i < this.nilaiSidang.length; i++) {
            output += "Nilai sidang " + (i + 1) + ": ";
            if (this.nilaiSidang[i] == -1f) {
                 output += "Belum ada";
            } else {
                output += nilaiSidang[i];
            }
            
            if (i != this.nilaiSidang.length - 1) {
                output += "\r\n";
            }
        }

        return output;
    }

    public void setNilaiSidang(float[] nilai) {
        this.nilaiSidang = nilai;
    }

    public int setNilaiSidang(int nilaiKe, float nilai) {
        if (nilaiKe > nilaiSidang.length) { return -1; }

        this.nilaiSidang[nilaiKe - 1] = nilai;
        return 0;
    }

    @Override
    public String toString() {
        return super.toString() + "\r\njudulPenelitianDisertasi: " + this.judulPenelitianDisertasi + "\r\n" + printNilaiSidang();
    }
}