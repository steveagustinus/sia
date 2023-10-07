package model.mahasiswa;

import java.util.Date;

import model.Enums;

public class MahasiswaMagister extends MahasiswaSarjana {
    private String judulPenelitianTesis;

    public MahasiswaMagister() { }

    public MahasiswaMagister(String nama, String alamat, Date tanggalLahir, String tempatLahir, String nomorTelepon, String nim, Enums.Jurusan jurusan, String judulPenelitianTesis) {
        super(nama, alamat, tanggalLahir, tempatLahir,nomorTelepon, nim, jurusan);
        this.judulPenelitianTesis = judulPenelitianTesis;
    }

    public String getJudulPenelitianTesis() {
        return this.judulPenelitianTesis;
    }

    public void setJudulPenelitianTesis(String judul) {
        this.judulPenelitianTesis = judul;
    }

    @Override
    public String toString() {
        return super.toString() + "\r\njudulPenelitianTesis: " + this.judulPenelitianTesis;
    }
}