package nrs.tim5.projekat.childrenKonobarController;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HotDrinksKonobarController {
    public Label lbEspresso;
    public Label lbLate;
    public Label lbMacchiato;
    public Label lbHotCh;
    public Label lbTea;

    public static String cijenaEspresso;
    public static String cijenaLate;
    public static String cijenaMacchiato;
    public static String cijenaHotCh;
    public static String cijenaTea;

    @FXML
    public void initialize() {
        lbEspresso.setText(cijenaEspresso);
        lbLate.setText(cijenaLate);
        lbMacchiato.setText(cijenaMacchiato);
        lbHotCh.setText(cijenaHotCh);
        lbTea.setText(cijenaTea);
    }

    public static String getCijenaEspresso() {
        return cijenaEspresso;
    }

    public static void setCijenaEspresso(String cijenaEspresso) {
        HotDrinksKonobarController.cijenaEspresso = cijenaEspresso;
    }

    public static String getCijenaLate() {
        return cijenaLate;
    }

    public static void setCijenaLate(String cijenaLate) {
        HotDrinksKonobarController.cijenaLate = cijenaLate;
    }

    public static String getCijenaMacchiato() {
        return cijenaMacchiato;
    }

    public static void setCijenaMacchiato(String cijenaMacchiato) {
        HotDrinksKonobarController.cijenaMacchiato = cijenaMacchiato;
    }

    public static String getCijenaHotCh() {
        return cijenaHotCh;
    }

    public static void setCijenaHotCh(String cijenaHotCh) {
        HotDrinksKonobarController.cijenaHotCh = cijenaHotCh;
    }

    public static String getCijenaTea() {
        return cijenaTea;
    }

    public static void setCijenaTea(String cijenaTea) {
        HotDrinksKonobarController.cijenaTea = cijenaTea;
    }
}
