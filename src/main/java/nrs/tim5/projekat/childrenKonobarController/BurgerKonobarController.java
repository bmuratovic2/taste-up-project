package nrs.tim5.projekat.childrenKonobarController;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class BurgerKonobarController {
    public Label lbChickenCijena;
    public Label lbDoubleCijena;
    public Label lbRegularCijena;
    public Label lbCheeseCijena;

    public static String cijenaChickenBurger = "";
    public static String cijenaDoubleBurger = "";
    public static String cijenaRegularBurger = "";
    public static String cijenaCheeseBurger = "";

    @FXML
    public void initialize() {
        lbChickenCijena.setText(cijenaChickenBurger);
        lbDoubleCijena.setText(cijenaDoubleBurger);
        lbRegularCijena.setText(cijenaRegularBurger);
        lbCheeseCijena.setText(cijenaCheeseBurger);
    }

    public static void setCheeseBurgerText(String cijena) {
        cijenaCheeseBurger = cijena;
    }

    public static String getCijenaChickenBurger() {
        return cijenaChickenBurger;
    }

    public static void setCijenaChickenBurger(String cijenaChickenBurger) {
        BurgerKonobarController.cijenaChickenBurger = cijenaChickenBurger;
    }

    public static String getCijenaDoubleBurger() {
        return cijenaDoubleBurger;
    }

    public static void setCijenaDoubleBurger(String cijenaDoubleBurger) {
        BurgerKonobarController.cijenaDoubleBurger = cijenaDoubleBurger;
    }

    public static String getCijenaRegularBurger() {
        return cijenaRegularBurger;
    }

    public static void setCijenaRegularBurger(String cijenaRegularBurger) {
        BurgerKonobarController.cijenaRegularBurger = cijenaRegularBurger;
    }

    public static String getCijenaCheeseBurger() {
        return cijenaCheeseBurger;
    }

    public static void setCijenaCheeseBurger(String cijenaCheeseBurger) {
        BurgerKonobarController.cijenaCheeseBurger = cijenaCheeseBurger;
    }
}
