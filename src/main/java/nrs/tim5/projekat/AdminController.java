package nrs.tim5.projekat;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import nrs.tim5.projekat.DAO.MenuDAO;
import nrs.tim5.projekat.childrenAdminController.*;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AdminController {
    public BorderPane mainPane;
    public Button btnSingOut;
    public Button btnSpasi;

    public MenuDAO menuDao = null;
    public ObservableList<Stavka> stavke = FXCollections.observableArrayList();

    private ResourceBundle bundle = ResourceBundle.getBundle("Prijevod");

    @FXML
    public void initialize() {
        if (menuDao == null) menuDao = new MenuDAO();
        if (stavke.size() == 0) {
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            new Thread(() -> {
                Platform.runLater(() -> {
                    if (Locale.getDefault().getCountry().equals("BA") && Locale.getDefault().getLanguage().equals("bs")) {
                        alert1.setTitle("Informationi prozor");
                        alert1.setHeaderText("Trenutno je učitavanje podataka sa servera u toku.");
                        alert1.setContentText("Molim vas sačekajte.");
                    } else if (Locale.getDefault().getCountry().equals("US") && Locale.getDefault().getLanguage().equals("en")){
                        alert1.setTitle("Information Dialog");
                        alert1.setHeaderText("Getting data from server in process.");
                        alert1.setContentText("Please wait.");
                    }

                    alert1.initStyle(StageStyle.UNDECORATED);
                    alert1.getDialogPane().lookupButton(ButtonType.OK).setVisible(false);
                    alert1.show();
                });
                stavke = menuDao.sveStavke();
                for (int i=0; i<stavke.size(); i++) {
                    if (stavke.get(i).getNaziv().equals("Cheese Burger")) {
                        Double cijena = stavke.get(i).getCijena();
                        BurgerAdminController.setCijenaCheeseBurger(cijena.toString());
                    }
                    else if (stavke.get(i).getNaziv().equals("Chicken Burger")) {
                        Double cijena = stavke.get(i).getCijena();
                        BurgerAdminController.setCijenaChickenBurger(cijena.toString());
                    }
                    else if (stavke.get(i).getNaziv().equals("Double Burger")) {
                        Double cijena = stavke.get(i).getCijena();
                        BurgerAdminController.setCijenaDoubleBurger(cijena.toString());
                    }
                    else if (stavke.get(i).getNaziv().equals("Regular Burger")) {
                        Double cijena = stavke.get(i).getCijena();
                        BurgerAdminController.setCijenaRegularBurger(cijena.toString());
                    }
                    else if (stavke.get(i).getNaziv().equals("Coca Cola")) {
                        Double cijena = stavke.get(i).getCijena();
                        ColdDrinksAdminController.setCijenaCocaCola(cijena.toString());
                    }
                    else if (stavke.get(i).getNaziv().equals("Sprite")) {
                        Double cijena = stavke.get(i).getCijena();
                        ColdDrinksAdminController.setCijenaSprite(cijena.toString());
                    }
                    else if (stavke.get(i).getNaziv().equals("Apple Juice")) {
                        Double cijena = stavke.get(i).getCijena();
                        ColdDrinksAdminController.setCijenaAppleJuice(cijena.toString());
                    }
                    else if (stavke.get(i).getNaziv().equals("Dvojni C")) {
                        Double cijena = stavke.get(i).getCijena();
                        ColdDrinksAdminController.setCijenaDvojniC(cijena.toString());
                    }
                    else if (stavke.get(i).getNaziv().equals("Watter")) {
                        Double cijena = stavke.get(i).getCijena();
                        ColdDrinksAdminController.setCijenaWatter(cijena.toString());
                    }
                    else if (stavke.get(i).getNaziv().equals("Espresso")) {
                        Double cijena = stavke.get(i).getCijena();
                        HotDrinksAdminController.setCijenaEspresso(cijena.toString());
                    }
                    else if (stavke.get(i).getNaziv().equals("Late")) {
                        Double cijena = stavke.get(i).getCijena();
                        HotDrinksAdminController.setCijenaLate(cijena.toString());
                    }
                    else if (stavke.get(i).getNaziv().equals("Macchiato")) {
                        Double cijena = stavke.get(i).getCijena();
                        HotDrinksAdminController.setCijenaMacchiato(cijena.toString());
                    }
                    else if (stavke.get(i).getNaziv().equals("Hot Chocolate")) {
                        Double cijena = stavke.get(i).getCijena();
                        HotDrinksAdminController.setCijenaHotCh(cijena.toString());
                    }
                    else if (stavke.get(i).getNaziv().equals("Tea")) {
                        Double cijena = stavke.get(i).getCijena();
                        HotDrinksAdminController.setCijenaTea(cijena.toString());
                    }
                    else if (stavke.get(i).getNaziv().equals("Classic Margarita")) {
                        Double cijena = stavke.get(i).getCijena();
                        PizzaAdminController.setCijenaMargarita(cijena.toString());
                    }
                    else if (stavke.get(i).getNaziv().equals("Pepperoni")) {
                        Double cijena = stavke.get(i).getCijena();
                        PizzaAdminController.setCijenaPepperoni(cijena.toString());
                    }
                    else if (stavke.get(i).getNaziv().equals("The Veggie One")) {
                        Double cijena = stavke.get(i).getCijena();
                        PizzaAdminController.setCijenaVeggie(cijena.toString());
                    }
                    else if (stavke.get(i).getNaziv().equals("Garlic Pizza Bread")) {
                        Double cijena = stavke.get(i).getCijena();
                        PizzaAdminController.setCijenaGarlic(cijena.toString());
                    }
                    else if (stavke.get(i).getNaziv().equals("Chicken Pizza")) {
                        Double cijena = stavke.get(i).getCijena();
                        PizzaAdminController.setCijenaChicken(cijena.toString());
                    }
                    else if (stavke.get(i).getNaziv().equals("Tuna & Salad")) {
                        Double cijena = stavke.get(i).getCijena();
                        SendwichAdminController.setCijenaTuna(cijena.toString());
                    }
                    else if (stavke.get(i).getNaziv().equals("Chicken Sandwich")) {
                        Double cijena = stavke.get(i).getCijena();
                        SendwichAdminController.setCijenaChickenSendw(cijena.toString());
                    }
                    else if (stavke.get(i).getNaziv().equals("Pepper & Eggs")) {
                        Double cijena = stavke.get(i).getCijena();
                        SendwichAdminController.setCijenaPepperEgg(cijena.toString());
                    }
                    else if (stavke.get(i).getNaziv().equals("BBQ & Cheese")) {
                        Double cijena = stavke.get(i).getCijena();
                        SendwichAdminController.setCijenaBBQ(cijena.toString());
                    }
                    else if (stavke.get(i).getNaziv().equals("Vegeterian")) {
                        Double cijena = stavke.get(i).getCijena();
                        SendwichAdminController.setCijenaVegeterianSendw(cijena.toString());
                    }



                }
                Platform.runLater(() -> {
                    alert1.close();
                    Parent root2 = null;
                    try {
                        root2=FXMLLoader.load(getClass().getResource("/fxml/burgeriAdmin.fxml"), bundle);
                    } catch (Exception e) {
                    }
                    mainPane.setCenter(root2);
                });
            }).start();
        }
    }

    public void krajAction(ActionEvent actionEvent) throws IOException {
        Stage thisStage = (Stage) btnSingOut.getScene().getWindow();
        thisStage.close();

        ResourceBundle bundle = ResourceBundle.getBundle("Prijevod");
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"), bundle);
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Ugostiteljski objekat");
        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public void tab2(Event event) throws InterruptedException {
        Parent root2 = null;
        try {
            root2= FXMLLoader.load(getClass().getResource("/fxml/burgeriAdmin.fxml"), bundle);
        } catch (Exception e) {
        }
        mainPane.setCenter(root2);
    }

    public void burgeriAction(ActionEvent actionEvent) throws IOException {
        Parent root2 = null;
        try {
            root2=FXMLLoader.load(getClass().getResource("/fxml/burgeriAdmin.fxml"), bundle);
        } catch (Exception e) {
        }
        mainPane.setCenter(root2);

           /* mainPane.getChildren().clear();
            root = FXMLLoader.load(getClass().getResource("/fxml/burgeri.fxml"));
            mainPane.getChildren().setAll(root.getChildren());*/

    }

    public void sendwichAction(ActionEvent actionEvent) {
        Parent root = null;
        try {
            root=FXMLLoader.load(getClass().getResource("/fxml/sendwichAdmin.fxml"), bundle);
        } catch (Exception e) {
        }
        mainPane.setCenter(root);
    }

    public void pizzaAction(ActionEvent actionEvent) {
        Parent root = null;
        try {
            root=FXMLLoader.load(getClass().getResource("/fxml/pizzaAdmin.fxml"), bundle);
        } catch (Exception e) {
        }
        mainPane.setCenter(root);
    }

    public void drinksAction(ActionEvent actionEvent) {
        Parent root = null;
        try {
            root=FXMLLoader.load(getClass().getResource("/fxml/drinksAdmin.fxml"), bundle);
        } catch (Exception e) {
        }
        mainPane.setCenter(root);
    }

    public void spasiAction(ActionEvent actionEvent) {
        Alert alert12 = new Alert(Alert.AlertType.INFORMATION);

        ObservableList<String> cijene = FXCollections.observableArrayList();

        for(int i=0; i<stavke.size(); i++) {
            if (stavke.get(i).getNaziv().equals("Cheese Burger")) {
                String novaCijena = BurgerAdminController.getCijenaCheeseBurger();
                cijene.add(novaCijena);
            } else if (stavke.get(i).getNaziv().equals("Chicken Burger")) {
                String novaCijena = BurgerAdminController.getCijenaChickenBurger();
                cijene.add(novaCijena);
            } else if (stavke.get(i).getNaziv().equals("Double Burger")) {
                String novaCijena = BurgerAdminController.getCijenaDoubleBurger();
                cijene.add(novaCijena);
            } else if (stavke.get(i).getNaziv().equals("Regular Burger")) {
                String novaCijena = BurgerAdminController.getCijenaRegularBurger();
                cijene.add(novaCijena);
            } else if (stavke.get(i).getNaziv().equals("Coca Cola")) {
                String novaCijena = ColdDrinksAdminController.getCijenaCocaCola();
                cijene.add(novaCijena);
            } else if (stavke.get(i).getNaziv().equals("Sprite")) {
                String novaCijena = ColdDrinksAdminController.getCijenaSprite();
                cijene.add(novaCijena);
            } else if (stavke.get(i).getNaziv().equals("Apple Juice")) {
                String novaCijena = ColdDrinksAdminController.getCijenaAppleJuice();
                cijene.add(novaCijena);
            } else if (stavke.get(i).getNaziv().equals("Dvojni C")) {
                String novaCijena = ColdDrinksAdminController.getCijenaDvojniC();
                cijene.add(novaCijena);
            } else if (stavke.get(i).getNaziv().equals("Watter")) {
                String novaCijena = ColdDrinksAdminController.getCijenaWatter();
                cijene.add(novaCijena);
            } else if (stavke.get(i).getNaziv().equals("Espresso")) {
                String novaCijena = HotDrinksAdminController.getCijenaEspresso();
                cijene.add(novaCijena);
            } else if (stavke.get(i).getNaziv().equals("Late")) {
                String novaCijena = HotDrinksAdminController.getCijenaLate();
                cijene.add(novaCijena);
            } else if (stavke.get(i).getNaziv().equals("Macchiato")) {
                String novaCijena = HotDrinksAdminController.getCijenaMacchiato();
                cijene.add(novaCijena);
            } else if (stavke.get(i).getNaziv().equals("Hot Chocolate")) {
                String novaCijena = HotDrinksAdminController.getCijenaHotCh();
                cijene.add(novaCijena);
            } else if (stavke.get(i).getNaziv().equals("Tea")) {
                String novaCijena = HotDrinksAdminController.getCijenaTea();
                cijene.add(novaCijena);
            } else if (stavke.get(i).getNaziv().equals("Classic Margarita")) {
                String novaCijena = PizzaAdminController.getCijenaMargarita();
                cijene.add(novaCijena);
            } else if (stavke.get(i).getNaziv().equals("Pepperoni")) {
                String novaCijena = PizzaAdminController.getCijenaPepperoni();
                cijene.add(novaCijena);
            } else if (stavke.get(i).getNaziv().equals("The Veggie One")) {
                String novaCijena = PizzaAdminController.getCijenaVeggie();
                cijene.add(novaCijena);
            } else if (stavke.get(i).getNaziv().equals("Garlic Pizza Bread")) {
                String novaCijena = PizzaAdminController.getCijenaGarlic();
                cijene.add(novaCijena);
            } else if (stavke.get(i).getNaziv().equals("Chicken Pizza")) {
                String novaCijena = PizzaAdminController.getCijenaChicken();
                cijene.add(novaCijena);
            } else if (stavke.get(i).getNaziv().equals("Tuna & Salad")) {
                String novaCijena = SendwichAdminController.getCijenaTuna();
                cijene.add(novaCijena);
            } else if (stavke.get(i).getNaziv().equals("Chicken Sandwich")) {
                String novaCijena = SendwichAdminController.getCijenaChickenSendw();
                cijene.add(novaCijena);
            } else if (stavke.get(i).getNaziv().equals("Pepper & Eggs")) {
                String novaCijena = SendwichAdminController.getCijenaPepperEgg();
                cijene.add(novaCijena);
            } else if (stavke.get(i).getNaziv().equals("BBQ & Cheese")) {
                String novaCijena = SendwichAdminController.getCijenaBBQ();
                cijene.add(novaCijena);
            } else if (stavke.get(i).getNaziv().equals("Vegeterian")) {
                String novaCijena = SendwichAdminController.getCijenaVegeterianSendw();
                cijene.add(novaCijena);
            }
        }

        new Thread(() -> {
            Platform.runLater(() -> {
                if (Locale.getDefault().getCountry().equals("BA") && Locale.getDefault().getLanguage().equals("bs")) {
                    alert12.setTitle("Informationi prozor");
                    alert12.setHeaderText("Trenutno je spremanje podataka na servera u toku.");
                    alert12.setContentText("Molim vas sačekajte.");
                } else if (Locale.getDefault().getCountry().equals("US") && Locale.getDefault().getLanguage().equals("en")){
                    alert12.setTitle("Information Dialog");
                    alert12.setHeaderText("Sending data to server in process.");
                    alert12.setContentText("Please wait.");
                }
                alert12.show();
                btnSpasi.setDisable(true);
            });

            for(int i=0; i<stavke.size(); i++) {
                Double cijena = stavke.get(i).getCijena();
                String novaCijena = cijene.get(i);
                if(!cijena.toString().equals( novaCijena )){
                    Boolean odgovor = menuDao.postaviCijenu(stavke.get(i).getNaziv(), novaCijena);
                    if(odgovor)
                        stavke.get(i).setCijena(Double.parseDouble(novaCijena));
                }
            }

            Platform.runLater(() -> {
                btnSpasi.setDisable(false);
                Alert alert10 = new Alert(Alert.AlertType.INFORMATION);
                if (Locale.getDefault().getCountry().equals("BA") && Locale.getDefault().getLanguage().equals("bs")) {
                    alert10.setTitle("Informationi prozor");
                    alert10.setHeaderText("Cijene uspješno spašene na server.");
                    alert10.setContentText("Ponovo možete korisiti aplikaciju i mijenjati cijene.");
                } else if (Locale.getDefault().getCountry().equals("US") && Locale.getDefault().getLanguage().equals("en")){
                    alert10.setTitle("Information Dialog");
                    alert10.setHeaderText("Prices successfully saved to server.");
                    alert10.setContentText("You can use the app again and change prices.");
                }
                alert10.show();

                for (int i=0; i<stavke.size(); i++) {
                    if (stavke.get(i).getNaziv().equals("Cheese Burger")) {
                        Double cijena = stavke.get(i).getCijena();
                        BurgerAdminController.setCijenaCheeseBurger(cijena.toString());
                    }
                    else if (stavke.get(i).getNaziv().equals("Chicken Burger")) {
                        Double cijena = stavke.get(i).getCijena();
                        BurgerAdminController.setCijenaChickenBurger(cijena.toString());
                    }
                    else if (stavke.get(i).getNaziv().equals("Double Burger")) {
                        Double cijena = stavke.get(i).getCijena();
                        BurgerAdminController.setCijenaDoubleBurger(cijena.toString());
                    }
                    else if (stavke.get(i).getNaziv().equals("Regular Burger")) {
                        Double cijena = stavke.get(i).getCijena();
                        BurgerAdminController.setCijenaRegularBurger(cijena.toString());
                    }
                    else if (stavke.get(i).getNaziv().equals("Coca Cola")) {
                        Double cijena = stavke.get(i).getCijena();
                        ColdDrinksAdminController.setCijenaCocaCola(cijena.toString());
                    }
                    else if (stavke.get(i).getNaziv().equals("Sprite")) {
                        Double cijena = stavke.get(i).getCijena();
                        ColdDrinksAdminController.setCijenaSprite(cijena.toString());
                    }
                    else if (stavke.get(i).getNaziv().equals("Apple Juice")) {
                        Double cijena = stavke.get(i).getCijena();
                        ColdDrinksAdminController.setCijenaAppleJuice(cijena.toString());
                    }
                    else if (stavke.get(i).getNaziv().equals("Dvojni C")) {
                        Double cijena = stavke.get(i).getCijena();
                        ColdDrinksAdminController.setCijenaDvojniC(cijena.toString());
                    }
                    else if (stavke.get(i).getNaziv().equals("Watter")) {
                        Double cijena = stavke.get(i).getCijena();
                        ColdDrinksAdminController.setCijenaWatter(cijena.toString());
                    }
                    else if (stavke.get(i).getNaziv().equals("Espresso")) {
                        Double cijena = stavke.get(i).getCijena();
                        HotDrinksAdminController.setCijenaEspresso(cijena.toString());
                    }
                    else if (stavke.get(i).getNaziv().equals("Late")) {
                        Double cijena = stavke.get(i).getCijena();
                        HotDrinksAdminController.setCijenaLate(cijena.toString());
                    }
                    else if (stavke.get(i).getNaziv().equals("Macchiato")) {
                        Double cijena = stavke.get(i).getCijena();
                        HotDrinksAdminController.setCijenaMacchiato(cijena.toString());
                    }
                    else if (stavke.get(i).getNaziv().equals("Hot Chocolate")) {
                        Double cijena = stavke.get(i).getCijena();
                        HotDrinksAdminController.setCijenaHotCh(cijena.toString());
                    }
                    else if (stavke.get(i).getNaziv().equals("Tea")) {
                        Double cijena = stavke.get(i).getCijena();
                        HotDrinksAdminController.setCijenaTea(cijena.toString());
                    }
                    else if (stavke.get(i).getNaziv().equals("Classic Margarita")) {
                        Double cijena = stavke.get(i).getCijena();
                        PizzaAdminController.setCijenaMargarita(cijena.toString());
                    }
                    else if (stavke.get(i).getNaziv().equals("Pepperoni")) {
                        Double cijena = stavke.get(i).getCijena();
                        PizzaAdminController.setCijenaPepperoni(cijena.toString());
                    }
                    else if (stavke.get(i).getNaziv().equals("The Veggie One")) {
                        Double cijena = stavke.get(i).getCijena();
                        PizzaAdminController.setCijenaVeggie(cijena.toString());
                    }
                    else if (stavke.get(i).getNaziv().equals("Garlic Pizza Bread")) {
                        Double cijena = stavke.get(i).getCijena();
                        PizzaAdminController.setCijenaGarlic(cijena.toString());
                    }
                    else if (stavke.get(i).getNaziv().equals("Chicken Pizza")) {
                        Double cijena = stavke.get(i).getCijena();
                        PizzaAdminController.setCijenaChicken(cijena.toString());
                    }
                    else if (stavke.get(i).getNaziv().equals("Tuna & Salad")) {
                        Double cijena = stavke.get(i).getCijena();
                        SendwichAdminController.setCijenaTuna(cijena.toString());
                    }
                    else if (stavke.get(i).getNaziv().equals("Chicken Sandwich")) {
                        Double cijena = stavke.get(i).getCijena();
                        SendwichAdminController.setCijenaChickenSendw(cijena.toString());
                    }
                    else if (stavke.get(i).getNaziv().equals("Pepper & Eggs")) {
                        Double cijena = stavke.get(i).getCijena();
                        SendwichAdminController.setCijenaPepperEgg(cijena.toString());
                    }
                    else if (stavke.get(i).getNaziv().equals("BBQ & Cheese")) {
                        Double cijena = stavke.get(i).getCijena();
                        SendwichAdminController.setCijenaBBQ(cijena.toString());
                    }
                    else if (stavke.get(i).getNaziv().equals("Vegeterian")) {
                        Double cijena = stavke.get(i).getCijena();
                        SendwichAdminController.setCijenaVegeterianSendw(cijena.toString());
                    }



                }
            });
        }).start();
    }
}
