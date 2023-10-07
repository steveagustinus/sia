package view;

import javax.swing.JOptionPane;

import controller.Controller;
import model.Consts;

public class PrintTotalJamMengajarDosenScreen {
    public PrintTotalJamMengajarDosenScreen() {
        Controller controller = new Controller();

        String inputNIK = JOptionPane.showInputDialog(null, "Masukkan NIK");
        if (inputNIK == null) { return; }

        int output = controller.countJamAjarDosen(inputNIK);
        if (output == Consts.StatusCountJamMengajarDosen.STAFF_DENGAN_NIK_DIINPUT_TIDAK_DITEMUKAN) {
            JOptionPane.showMessageDialog(
                null,
                "Staff dengan NIK " + inputNIK + " tidak ditemukan", 
                "Print Total Jam Mengajar Dosen",
                JOptionPane.ERROR_MESSAGE
            );
            return;
        } else if (output == Consts.StatusCountJamMengajarDosen.STAFF_DENGAN_NIK_DIINPUT_BUKAN_DOSEN) {
            JOptionPane.showMessageDialog(
                null,
                "NIK " + inputNIK + " bukan merupakan dosen", 
                "Print Total Jam Mengajar Dosen",
                JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        JOptionPane.showMessageDialog(
            null,
            "NIK " + inputNIK + "\r\nTotal jam mengajar: " + output, 
            "Print Total Jam Mengajar Dosen",
            JOptionPane.ERROR_MESSAGE
        );
    }
}
