package view;

import javax.swing.JOptionPane;

import controller.Controller;

public class PrintMahasiswaTidakLulusMatakuliahScreen {
    public PrintMahasiswaTidakLulusMatakuliahScreen() {
        Controller controller = new Controller();

        String inputKodeMK = JOptionPane.showInputDialog(null, "Masukkan Kode MK");
        if (inputKodeMK == null) { return; }

        int total = controller.getListMahasiswa(inputKodeMK).size();
        int tidaklulus = controller.getListMahasiswaTidakLulus(inputKodeMK).size();
        String namaMK = controller.getMataKuliahNameByKodeMK(inputKodeMK);

        if (namaMK == null) {
            JOptionPane.showMessageDialog(
                null, 
                "Kode matakuliah tidak ditemukan",
                "Print Mahasiswa Tidak Lulus Matakuliah",
                JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        JOptionPane.showMessageDialog(
            null, 
            "<" + tidaklulus + "> dari <" + total + "> mahasiswa tidak lulus matakuliah " + namaMK,
            "Print Mahasiswa Tidak Lulus Matakuliah",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
}
