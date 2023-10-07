package controller;

import java.util.ArrayList;

import model.Consts;
import model.MatkulAmbil;
import model.MatkulAjar;
import model.User;
import model.mahasiswa.*;
import model.matakuliah.*;
import model.presensi.*;
import model.staff.*;


public class Controller {
    public Controller() { }

    public ArrayList<User> getUserByName(String nama) {
        if (nama.equals("*")) {
            return Database.users;
        }
        
        ArrayList<User> output = new ArrayList<User>();
        for (User user : Database.users) {
            if (user.getNama().equals(nama)) {
                output.add(user);
            }
        }
        return output;
    }

    public Mahasiswa getMahasiswaByNIM(String nim) {
        for (User user : Database.users) {
            if (user instanceof Mahasiswa) {
                if (((Mahasiswa) user).getNim().equals(nim)) {
                    return (Mahasiswa) user;
                }
            }
        }

        return null;
    }

    public Staff getStaffByNIK(String nik) {
        for (User user : Database.users) {
            if (user instanceof Staff) {
                if (((Staff) user).getNik().equals(nik)) {
                    return (Staff) user;
                }
            }
        }

        return null;
    }
    
    public int countJamAjarDosen(String nik) {
        int output = 0;

        Staff dosen = getStaffByNIK(nik);
        if (dosen == null) { return -1; }
        if (!(dosen instanceof Dosen)) { return -2; }

        ArrayList<MatkulAjar> mkList = ((Dosen) dosen).getMataKuliahDiajar();
        for (MatkulAjar mkAjar : mkList) {
            ArrayList<PresensiStaff> listPresensi = mkAjar.getListPresensi();
            for (PresensiStaff pres : listPresensi) {
                output += pres.getJam();
            }
        }

        return output;
    }

    public int countKehadiranStaff(String nik) {
        int count = 0;
        
        Staff staff = getStaffByNIK(nik);
        if (staff == null) { return -1; }
        
        if (staff instanceof Dosen) {
            ArrayList<MatkulAjar> mkList = ((Dosen) staff).getMataKuliahDiajar();
            for(MatkulAjar mkAjar : mkList) {
                ArrayList<PresensiStaff> listPresensi = mkAjar.getListPresensi();
                for (PresensiStaff pres : listPresensi) {
                    if(pres.getStatus() == Consts.StatusHadir.HADIR) { count++; }
                }
            }
        } else if (staff instanceof Karyawan) {
            ArrayList<PresensiStaff> listPresensi = ((Karyawan) staff).getPresensiStaff();
            for (PresensiStaff pres : listPresensi) {
                if(pres.getStatus() == Consts.StatusHadir.HADIR) { count++; }
            }
        }

        return count;
    }

    public int hitungGajiStaff(String nik) {
        float output = 0;
        Staff staff = getStaffByNIK(nik);
        if (staff == null) { return -1; }

        int unit = countKehadiranStaff(nik);
        if (staff instanceof Karyawan) {
            output = (float) unit / 22f * ((Karyawan) staff).getSalary();
        } else if (staff instanceof DosenTetap) {
            output = ((DosenTetap) staff).getSalary() + (unit * 25000);
        } else if (staff instanceof DosenHonorer) {
            output = unit * ((DosenHonorer) staff).getHonorPerSKS();
        }

        return (int) output;
    }

    private MatkulAmbil getMatkulAmbilByKodeMK(ArrayList<MatkulAmbil> matkulAmbil, String kodeMK) {
        for (MatkulAmbil mkAmbil : matkulAmbil) {
            Object mataKuliah = mkAmbil.getMataKuliahDiambil();
            if (mataKuliah instanceof MataKuliah) {
                if (((MataKuliah) mataKuliah).getKode().equals(kodeMK)) {
                    return mkAmbil;
                }
            } else if (mataKuliah instanceof MataKuliahPilihan) {
                if (((MataKuliahPilihan) mataKuliah).getKode().equals(kodeMK)) {
                    return mkAmbil;
                }
            }
        }

        return null;
    }

    private MatkulAjar getMatkulAjarByKodeMK(ArrayList<MatkulAjar> matkulAjar, String kodeMK) {
        for (MatkulAjar mkAjar : matkulAjar) {
            Object mataKuliah = mkAjar.getMataKuliahDiajar();
            if (mataKuliah instanceof MataKuliah) {
                if (((MataKuliah) mataKuliah).getKode().equals(kodeMK)) {
                    return mkAjar;
                }
            } else if (mataKuliah instanceof MataKuliahPilihan) {
                if (((MataKuliahPilihan) mataKuliah).getKode().equals(kodeMK)) {
                    return mkAjar;
                }
            }
        }

        return null;
    }
    
    private boolean isMataKuliahExistsByKodeMK(String kodeMK) {
        for (MataKuliah mk : Database.mataKuliah) {
            if (mk.getKode().equals(kodeMK)) { return true; }
        }

        for (MataKuliahPilihan mk : Database.mataKuliahPilihan) {
            if (mk.getKode().equals(kodeMK)) { return true; }
        }

        return false;
    }

    public String printUserData(ArrayList<User> users) {
        String output = "";

        for (int i = 0; i < users.size(); i++) {
            if (i != 0) { output += "\r\n"; }
            output += users.get(i).getClass().getSimpleName();
            output += "\r\n" + users.get(i).toString();
            output += "\r\n=============================================================";
        }

        return output;
    }

    public String printUserData(User user) {
        String output = "";

        output += user.getClass().getSimpleName();
        output += "\r\n" + user.toString();

        return output;
    }
    
    public float getNilaiAkhirMahasiswa(String nim, String kodeMK) {
        Mahasiswa mhs = getMahasiswaByNIM(nim);
        if (mhs == null) { return -1; }

        float[] nilai;

        if (mhs instanceof MahasiswaSarjana) {
            MatkulAmbil mkAmbil = getMatkulAmbilByKodeMK(((MahasiswaSarjana) mhs).getMataKuliahAmbil(), kodeMK);
            if (mkAmbil == null) { return -2; }

            nilai = mkAmbil.getNilai();
        } else if (mhs instanceof MahasiswaDoktor) {
            nilai = ((MahasiswaDoktor) mhs).getNilaiSidang();
        } else { return -3; }

        float output = 0;
        for (int i = 0; i < nilai.length; i++) {
            if (nilai[i] == -1f) { 
                output = (output * i) / (i + 1);
            } else { 
                output = ((output * i) + nilai[i]) / (i + 1);
            }
        }

        return output;
    }

    public float getNilaiAkhir(String kodeMK) {
        // Cek kodeMK
        if (!isMataKuliahExistsByKodeMK(kodeMK)) { return -1; }

        float output = 0;
        int count = 0;

        for (User user : Database.users) {
            if (user instanceof MahasiswaDoktor) { continue; }
            if (user instanceof Mahasiswa) {
                float na = getNilaiAkhirMahasiswa(((Mahasiswa) user).getNim(), kodeMK);
                if (na < 0) { continue; }

                output += na;
                count++;
            }
        }

        if (count == 0) { return 0; }
        return output / count;
    }

    public ArrayList<Mahasiswa> getListMahasiswa(String kodeMK) {
        ArrayList<Mahasiswa> output = new ArrayList<Mahasiswa>();

        for (User user : Database.users) {
            if (user instanceof MahasiswaSarjana) {
                ArrayList<MataKuliah> mkList = ((MahasiswaSarjana) user).getMataKuliah();

                boolean isMataKuliah = false;
                for (MataKuliah mk : mkList) {
                    if (mk.getKode().equals(kodeMK)) { isMataKuliah = true; output.add((Mahasiswa) user); }
                }

                if (!isMataKuliah) {
                    ArrayList<MataKuliahPilihan> mkpList = ((MahasiswaSarjana) user).getMataKuliahPilihan();
                    for (MataKuliahPilihan mkp : mkpList) {
                        if (mkp.getKode().equals(kodeMK)) { output.add((Mahasiswa) user); }
                    }
                }
            }
        }

        return output;
    }

    public ArrayList<Mahasiswa> getListMahasiswaTidakLulus(String kodeMK) {
        ArrayList<Mahasiswa> output = new ArrayList<Mahasiswa>();

        ArrayList<Mahasiswa> listMahasiswa = getListMahasiswa(kodeMK);

        for (Mahasiswa mhs : listMahasiswa) {
            if (getNilaiAkhirMahasiswa(mhs.getNim(), kodeMK) < Consts.Nilai.NILAI_MINIMUM) {
                output.add(mhs);
            }
        }

        return output;
    }
    
    public String getMataKuliahNameByKodeMK(String kodeMK) {
        for (MataKuliah mk : Database.mataKuliah) {
            if (mk.getKode().equals(kodeMK)) { return mk.getNama(); }
        }
        for (MataKuliahPilihan mk : Database.mataKuliahPilihan) {
            if (mk.getKode().equals(kodeMK)) { return mk.getNama(); }
        }
        return null;
    }

    private int getUserIndex(User user) {
        for (int i = 0; i < Database.users.size(); i++) {
            if (Database.users.get(i) == user) {
                return i;
            }
        }
        return -1;
    }

    public void insertUser(User user) {
        Database.users.add(user);
    }

    public void insertUser(ArrayList<Object> users) {
        for (int i = 0; i < users.size(); i++) {
            Database.users.add((User) users.get(i));
        }
    }

    public void insertMataKuliah(MataKuliah mataKuliah) {
        Database.mataKuliah.add(mataKuliah);
    }

    public void insertMataKuliah(ArrayList<MataKuliah> mataKuliah) {
        for (int i = 0; i < mataKuliah.size(); i++) {
            Database.mataKuliah.add(mataKuliah.get(i));
        }
    }

    public void insertMataKuliahPilihan(MataKuliahPilihan mataKuliahPilihan) {
        Database.mataKuliahPilihan.add(mataKuliahPilihan);
    }

    public void insertMataKuliahPilihan(ArrayList<MataKuliahPilihan> mataKuliahPilihan) {
        for (int i = 0; i < mataKuliahPilihan.size(); i++) {
            Database.mataKuliahPilihan.add(mataKuliahPilihan.get(i));
        }
    }

    public int insertMataKuliahToMahasiswa(MataKuliah mataKuliah, Mahasiswa mahasiswa) {
        // Check matakuliah ada
        boolean matakuliahExist = false;
        for (MataKuliah mk : Database.mataKuliah) {
            if (mk == mataKuliah) {
                matakuliahExist = true;
                break;
            }
        }

        // Check user index
        int userIndex = getUserIndex(mahasiswa);

        if (matakuliahExist && userIndex != -1) {
            if (mahasiswa instanceof MahasiswaSarjana) {
                ((MahasiswaSarjana) Database.users.get(userIndex)).addMatkulAmbil(mataKuliah);
                return 0;
            }
            else if (mahasiswa instanceof MahasiswaMagister) {
                ((MahasiswaMagister) Database.users.get(userIndex)).addMatkulAmbil(mataKuliah);
                return 0;
            }
        }

        return -1;
    }

    public int insertMataKuliahToMahasiswa(MataKuliahPilihan mataKuliahPilihan, Mahasiswa mahasiswa) {
        // Check matakuliah ada
        boolean matakuliahExist = false;
        for (MataKuliahPilihan mk : Database.mataKuliahPilihan) {
            if (mk == mataKuliahPilihan) {
                matakuliahExist = true;
                break;
            }
        }

        // Check user index
        int userIndex = getUserIndex(mahasiswa);

        if (matakuliahExist && userIndex != -1) {
            if (mahasiswa instanceof MahasiswaSarjana) {
                ((MahasiswaSarjana) Database.users.get(userIndex)).addMatkulAmbil(mataKuliahPilihan);
                return 0;
            }
            else if (mahasiswa instanceof MahasiswaMagister) {
                ((MahasiswaMagister) Database.users.get(userIndex)).addMatkulAmbil(mataKuliahPilihan);
                return 0;
            }
        }

        return -1;
    }

    public int insertMataKuliahToDosen(MataKuliah mataKuliah, Dosen dosen) {
        // Check matakuliah ada
        boolean matakuliahExist = false;
        for (MataKuliah mk : Database.mataKuliah) {
            if (mk == mataKuliah) {
                matakuliahExist = true;
                break;
            }
        }

        // Check user index
        int userIndex = getUserIndex(dosen);

        if (matakuliahExist && userIndex != -1) {
            if (dosen instanceof DosenTetap) {
                ((DosenTetap) Database.users.get(userIndex)).addMatkulAjar(mataKuliah);
                return 0;
            }
            else if (dosen instanceof DosenHonorer) {
                ((DosenHonorer) Database.users.get(userIndex)).addMatkulAjar(mataKuliah);
                return 0;
            }
        }

        return -1;
    }

    public int insertMataKuliahToDosen(MataKuliahPilihan mataKuliahPilihan, Dosen dosen) {
        // Check matakuliah ada
        boolean matakuliahExist = false;
        for (MataKuliahPilihan mk : Database.mataKuliahPilihan) {
            if (mk == mataKuliahPilihan) {
                matakuliahExist = true;
                break;
            }
        }

        // Check user index
        int userIndex = getUserIndex(dosen);

        if (matakuliahExist && userIndex != -1) {
            if (dosen instanceof DosenTetap) {
                ((DosenTetap) Database.users.get(userIndex)).addMatkulAjar(mataKuliahPilihan);
                return 0;
            }
            else if (dosen instanceof DosenHonorer) {
                ((DosenHonorer) Database.users.get(userIndex)).addMatkulAjar(mataKuliahPilihan);
                return 0;
            }
        }

        return -1;
    }

    public int tambahKehadiranMahasiswa(String nim, String kodeMK, Presensi presensi) {
        Mahasiswa mhs = getMahasiswaByNIM(nim);
        if (mhs == null) { return -1; }
        if (!(mhs instanceof MahasiswaSarjana)) { return -2; }

        MatkulAmbil mkAmbil = getMatkulAmbilByKodeMK(((MahasiswaSarjana) mhs).getMataKuliahAmbil(), kodeMK);
        
        if (mkAmbil == null) { return -3; }

        mkAmbil.getListPresensi().add(presensi);

        return 0;
    }

    public int tambahKehadiranDosen(String nik, String kodeMK, PresensiStaff presensiStaff) {
        Staff dosen = getStaffByNIK(nik);
        if (dosen == null) { return -1; }
        if (!(dosen instanceof Dosen)) { return -2; }

        MatkulAjar mkAjar = getMatkulAjarByKodeMK(((Dosen)dosen).getMataKuliahDiajar(), kodeMK);
        
        if (mkAjar == null) {
            return -2;
        }

        mkAjar.getListPresensi().add(presensiStaff);

        return 0;
    }
}