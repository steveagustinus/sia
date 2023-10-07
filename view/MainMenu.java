package view;

import javax.swing.JOptionPane;

public class MainMenu {
    
    public MainMenu() {
        showMainMenu();
    }

    private void showMainMenu() {
        boolean exit = false;

        while (!exit) {

            String userInput = JOptionPane.showInputDialog(
                null,
                "1. Print UserData\r\n" +
                    "2. Print Nilai Akhir\r\n" +
                    "3. Print Rata-rata Nilai Akhir\r\n" +
                    "4. Print Mahasiswa Tidak Lulus Matakuliah\r\n" +
                    "5. Print List Matakuliah Diambil Mahasiswa\r\n" +
                    "6. Print Total Jam Mengajar Dosen\r\n" +
                    "7. Print Gaji Staff\r\n" +
                    "8. Keluar",
                "Sistem Informasi Akademik",
                JOptionPane.QUESTION_MESSAGE
            );

            if (userInput == null) {
                exit = true;
                break;
            }

            switch (userInput) {
                case "1": new PrintUserDataScreen(); break;
                case "2": new PrintNilaiAkhirScreen(); break;
                case "3": new PrintRataNilaiAkhirScreen(); break;
                case "4": new PrintMahasiswaTidakLulusMatakuliahScreen(); break;
                case "5": new PrintMatakuliahAmbilMahasiswaScreen(); break;
                case "6": new PrintTotalJamMengajarDosenScreen(); break;
                case "7": new PrintGajiScreen(); break;
                case "8": exit = true; break;
            }
        }
    }
}
