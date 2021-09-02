package nrs.tim5.projekat.childrenAdminController;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class HotDrinksAdminController {
    public TextField tfEspresso;
    public TextField tfLate;
    public TextField tfMacchiato;
    public TextField tfHotCh;
    public TextField tfTea;

    public static String cijenaEspresso;
    public static String cijenaLate;
    public static String cijenaMacchiato;
    public static String cijenaHotCh;
    public static String cijenaTea;

    @FXML
    public void initialize() {
        tfEspresso.setText(cijenaEspresso);
        tfLate.setText(cijenaLate);
        tfMacchiato.setText(cijenaMacchiato);
        tfHotCh.setText(cijenaHotCh);
        tfTea.setText(cijenaTea);

        tfEspresso.textProperty().addListener((obs, oldIme, newIme) -> {
            cijenaEspresso = tfEspresso.getText();
        });

        tfLate.textProperty().addListener((obs, oldIme, newIme) -> {
            cijenaLate = tfLate.getText();
        });

        tfMacchiato.textProperty().addListener((obs, oldIme, newIme) -> {
            cijenaMacchiato = tfMacchiato.getText();
        });

        tfHotCh.textProperty().addListener((obs, oldIme, newIme) -> {
            cijenaHotCh = tfHotCh.getText();
        });

        tfTea.textProperty().addListener((obs, oldIme, newIme) -> {
            cijenaTea = tfTea.getText();
        });
    }

    public static String getCijenaEspresso() {
        return cijenaEspresso;
    }

    public static void setCijenaEspresso(String cijenaEspresso) {
        HotDrinksAdminController.cijenaEspresso = cijenaEspresso;
    }

    public static String getCijenaLate() {
        return cijenaLate;
    }

    public static void setCijenaLate(String cijenaLate) {
        HotDrinksAdminController.cijenaLate = cijenaLate;
    }

    public static String getCijenaMacchiato() {
        return cijenaMacchiato;
    }

    public static void setCijenaMacchiato(String cijenaMacchiato) {
        HotDrinksAdminController.cijenaMacchiato = cijenaMacchiato;
    }

    public static String getCijenaHotCh() {
        return cijenaHotCh;
    }

    public static void setCijenaHotCh(String cijenaHotCh) {
        HotDrinksAdminController.cijenaHotCh = cijenaHotCh;
    }

    public static String getCijenaTea() {
        return cijenaTea;
    }

    public static void setCijenaTea(String cijenaTea) {
        HotDrinksAdminController.cijenaTea = cijenaTea;
    }
}
