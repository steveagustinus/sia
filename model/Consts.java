package model;

public class Consts {
    public static final String TIDAK_MENGAMBIL_MATAKULIAH = "";

    public class StatusHadir {
        public static final int HADIR = 0;
        public static final int ALPHA = 1;
    }

    public class Nilai {
        public static final int NILAI_MINIMUM = 56;
    }

    public class StatusGetNilaiAkhirMahasiswa {
        public static final float MAHASISWA_TIDAK_DITEMUKAN = -1;
        public static final float TIDAK_MENGAMBIL_MATAKULIAH_BERSANGKUTAN = -2;
        public static final float BUKAN_MERUPAKAN_MAHASISWA = -3; 
    }

    public class StatusGetNilaiAkhir {
        public static final float KODE_MATAKULIAH_TIDAK_ADA = -1;
    }

    public class StatusCountJamMengajarDosen {
        public static final int STAFF_DENGAN_NIK_DIINPUT_TIDAK_DITEMUKAN = -1;
        public static final int STAFF_DENGAN_NIK_DIINPUT_BUKAN_DOSEN = -2;
    }

    public class StatusCountKehadiranStaff {
        public static final int STAFF_DENGAN_NIK_DIINPUT_TIDAK_DITEMUKAN = -1;
    }

    public class ErrorMessage {
        public static final String MAHASISWA_TIDAK_DITEMUKAN = "Mahasiswa yang dicari tidak ada";
    }
}
