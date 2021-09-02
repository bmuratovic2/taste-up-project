package nrs.tim5.projekat.childrenAdminController;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class BurgerAdminController {
    public TextField chickenBurger;
    public TextField doubleBurger;
    public TextField regularBurger;
    public TextField cheeseBurger;

    public static String cijenaChickenBurger = "";
    public static String cijenaDoubleBurger = "";
    public static String cijenaRegularBurger = "";
    public static String cijenaCheeseBurger = "";

    @FXML
    public void initialize() {
        chickenBurger.setText(cijenaChickenBurger);
        doubleBurger.setText(cijenaDoubleBurger);
        regularBurger.setText(cijenaRegularBurger);
        cheeseBurger.setText(cijenaCheeseBurger);

        chickenBurger.textProperty().addListener((obs, oldIme, newIme) -> {
            cijenaChickenBurger = chickenBurger.getText();
        });

        doubleBurger.textProperty().addListener((obs, oldIme, newIme) -> {
            cijenaDoubleBurger = doubleBurger.getText();
        });

        regularBurger.textProperty().addListener((obs, oldIme, newIme) -> {
            cijenaRegularBurger = regularBurger.getText();
        });

        cheeseBurger.textProperty().addListener((obs, oldIme, newIme) -> {
            cijenaCheeseBurger = cheeseBurger.getText();
        });
    }

    public static void setCheeseBurgerText(String cijena) {
        cijenaCheeseBurger = cijena;
    }

    public static String getCijenaChickenBurger() {
        return cijenaChickenBurger;
    }

    public static void setCijenaChickenBurger(String cijenaChickenBurger) {
        BurgerAdminController.cijenaChickenBurger = cijenaChickenBurger;
    }

    public static String getCijenaDoubleBurger() {
        return cijenaDoubleBurger;
    }

    public static void setCijenaDoubleBurger(String cijenaDoubleBurger) {
        BurgerAdminController.cijenaDoubleBurger = cijenaDoubleBurger;
    }

    public static String getCijenaRegularBurger() {
        return cijenaRegularBurger;
    }

    public static void setCijenaRegularBurger(String cijenaRegularBurger) {
        BurgerAdminController.cijenaRegularBurger = cijenaRegularBurger;
    }

    public static String getCijenaCheeseBurger() {
        return cijenaCheeseBurger;
    }

    public static void setCijenaCheeseBurger(String cijenaCheeseBurger) {
        BurgerAdminController.cijenaCheeseBurger = cijenaCheeseBurger;
    }
}
