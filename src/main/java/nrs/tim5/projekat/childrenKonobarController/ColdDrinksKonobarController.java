package nrs.tim5.projekat.childrenKonobarController;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ColdDrinksKonobarController {
    public Label lbCocaCola;
    public Label lbSprite;
    public Label lbAppleJuice;
    public Label lbDvojniC;
    public Label lbWatter;

    public static String cijenaCocaCola;
    public static String cijenaSprite;
    public static String cijenaAppleJuice;
    public static String cijenaDvojniC;
    public static String cijenaWatter;

    @FXML
    public void initialize() {
        lbCocaCola.setText(cijenaCocaCola);
        lbSprite.setText(cijenaSprite);
        lbAppleJuice.setText(cijenaAppleJuice);
        lbDvojniC.setText(cijenaAppleJuice);
        lbWatter.setText(cijenaWatter);
    }

    public static String getCijenaCocaCola() {
        return cijenaCocaCola;
    }

    public static void setCijenaCocaCola(String cijenaCocaCola) {
        ColdDrinksKonobarController.cijenaCocaCola = cijenaCocaCola;
    }

    public static String getCijenaSprite() {
        return cijenaSprite;
    }

    public static void setCijenaSprite(String cijenaSprite) {
        ColdDrinksKonobarController.cijenaSprite = cijenaSprite;
    }

    public static String getCijenaAppleJuice() {
        return cijenaAppleJuice;
    }

    public static void setCijenaAppleJuice(String cijenaAppleJuice) {
        ColdDrinksKonobarController.cijenaAppleJuice = cijenaAppleJuice;
    }

    public static String getCijenaDvojniC() {
        return cijenaDvojniC;
    }

    public static void setCijenaDvojniC(String cijenaDvojniC) {
        ColdDrinksKonobarController.cijenaDvojniC = cijenaDvojniC;
    }

    public static String getCijenaWatter() {
        return cijenaWatter;
    }

    public static void setCijenaWatter(String cijenaWatter) {
        ColdDrinksKonobarController.cijenaWatter = cijenaWatter;
    }
}
