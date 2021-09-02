package nrs.tim5.projekat.childrenAdminController;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class ColdDrinksAdminController {
    public TextField tfCocaCola;
    public TextField tfSprite;
    public TextField tfAppleJuice;
    public TextField tfDvojniC;
    public TextField tfWatter;

    public static String cijenaCocaCola;
    public static String cijenaSprite;
    public static String cijenaAppleJuice;
    public static String cijenaDvojniC;
    public static String cijenaWatter;

    @FXML
    public void initialize() {
        tfCocaCola.setText(cijenaCocaCola);
        tfSprite.setText(cijenaSprite);
        tfAppleJuice.setText(cijenaAppleJuice);
        tfDvojniC.setText(cijenaAppleJuice);
        tfWatter.setText(cijenaWatter);

        tfCocaCola.textProperty().addListener((obs, oldIme, newIme) -> {
            cijenaCocaCola = tfCocaCola.getText();
        });

        tfSprite.textProperty().addListener((obs, oldIme, newIme) -> {
            cijenaSprite = tfSprite.getText();
        });

        tfAppleJuice.textProperty().addListener((obs, oldIme, newIme) -> {
            cijenaAppleJuice = tfAppleJuice.getText();
        });

        tfDvojniC.textProperty().addListener((obs, oldIme, newIme) -> {
            cijenaDvojniC = tfDvojniC.getText();
        });

        tfWatter.textProperty().addListener((obs, oldIme, newIme) -> {
            cijenaWatter = tfWatter.getText();
        });
    }

    public static String getCijenaCocaCola() {
        return cijenaCocaCola;
    }

    public static void setCijenaCocaCola(String cijenaCocaCola) {
        ColdDrinksAdminController.cijenaCocaCola = cijenaCocaCola;
    }

    public static String getCijenaSprite() {
        return cijenaSprite;
    }

    public static void setCijenaSprite(String cijenaSprite) {
        ColdDrinksAdminController.cijenaSprite = cijenaSprite;
    }

    public static String getCijenaAppleJuice() {
        return cijenaAppleJuice;
    }

    public static void setCijenaAppleJuice(String cijenaAppleJuice) {
        ColdDrinksAdminController.cijenaAppleJuice = cijenaAppleJuice;
    }

    public static String getCijenaDvojniC() {
        return cijenaDvojniC;
    }

    public static void setCijenaDvojniC(String cijenaDvojniC) {
        ColdDrinksAdminController.cijenaDvojniC = cijenaDvojniC;
    }

    public static String getCijenaWatter() {
        return cijenaWatter;
    }

    public static void setCijenaWatter(String cijenaWatter) {
        ColdDrinksAdminController.cijenaWatter = cijenaWatter;
    }

}
