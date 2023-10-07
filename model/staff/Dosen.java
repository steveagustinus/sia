package model.staff;

import model.matakuliah.MataKuliah;
import model.matakuliah.MataKuliahPilihan;
import model.MatkulAjar;

import java.util.ArrayList;
import java.util.Date;

public abstract class Dosen extends Staff {
    private String departemen;
    private ArrayList<MatkulAjar> mataKuliahDiajar;
    // private ArrayList<MataKuliah> mataKuliahDiajar;
    // private ArrayList<MataKuliahPilihan> mataKuliahPilihanDiajar;

    public Dosen() { }

    public Dosen(String nama, String alamat, Date tanggalLahir, String tempatLahir, String nomorTelepon, String nik, String departemen) {
        super(nama, alamat, tanggalLahir, tempatLahir, nomorTelepon, nik);
        this.departemen = departemen;
        this.mataKuliahDiajar = new ArrayList<MatkulAjar>();
    }

    public String getDepartemen() {
        return this.departemen;
    }

    public void setDepartemen(String departemen) {
        this.departemen = departemen;
    }

    public ArrayList<MatkulAjar> getMataKuliahDiajar() {
        return this.mataKuliahDiajar;
    }

    public void setMataKuliahDiajar(ArrayList<MatkulAjar> mataKuliahDiajar) {
        this.mataKuliahDiajar = mataKuliahDiajar;
    }

    public void addMatkulAjar(MataKuliah matkul) {
        this.mataKuliahDiajar.add(new MatkulAjar(matkul));
    }

    public void addMatkulAjar(MataKuliahPilihan matkul) {
        this.mataKuliahDiajar.add(new MatkulAjar(matkul));
    }

    public int hapusMataKuliahDiajarBerdasarkanKode(String kode) {
        for (MatkulAjar mkAjar : this.mataKuliahDiajar) {
            if (mkAjar.getMataKuliahDiajar() instanceof MataKuliah) {
                if (((MataKuliah) mkAjar.getMataKuliahDiajar()).getKode().equals(kode)) {
                    this.mataKuliahDiajar.remove(mkAjar);
                    return 0;
                }
            }
            else if (mkAjar.getMataKuliahDiajar() instanceof MataKuliahPilihan) {
                if (((MataKuliahPilihan) mkAjar.getMataKuliahDiajar()).getKode().equals(kode)) {
                    this.mataKuliahDiajar.remove(mkAjar);
                    return 0;
                }
            }
        }

        return -1;
    }

    public String printMataKuliahDiajar() {
        String output = "List matakuliah: ";

        for (int i = 0; i < this.mataKuliahDiajar.size(); i++) {
            output += "\r\n" + this.mataKuliahDiajar.get(i).toString();
        }
        
        return output;
    }

    @Override
    public String toString() {
        return super.toString() + "\r\ndepartemen: " + this.departemen + "\r\n" + printMataKuliahDiajar();
    }
}
