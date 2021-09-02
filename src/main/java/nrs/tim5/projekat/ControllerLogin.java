package nrs.tim5.projekat;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import nrs.tim5.projekat.DAO.LoginDAO;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;


public class ControllerLogin {
    public LoginDAO loginDao;
    public TextField fldUsername;
    public PasswordField fldPassword;
    public Button btnSignIn;
    public Button btnBS;
    public Button btnEN;
    public Label labelStanje;

    @FXML
    public void initialize() {
        loginDao = new LoginDAO();
        LoginDAO loginDao = LoginDAO.getInstance();
        labelStanje.setVisible(false);
    }

    public void SignIn(ActionEvent actionEvent) throws IOException {
        if(fldUsername.getText().isEmpty() || fldPassword.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            if (Locale.getDefault().getCountry().equals("BA") && Locale.getDefault().getLanguage().equals("bs")) {
                alert.setTitle("Greška");
                alert.setHeaderText("Neispravno unešeni podaci.");
                alert.setContentText("Polja ne smiju biti prazna!");
            } else if (Locale.getDefault().getCountry().equals("US") && Locale.getDefault().getLanguage().equals("en")){
                alert.setTitle("ERROR");
                alert.setHeaderText("Incorrectly entered access data.");
                alert.setContentText("Fields must not be blank!");
            }

            alert.showAndWait();
        }else {
            new Thread(() -> {
                Platform.runLater(() -> {
                    btnSignIn.setDisable(true);
                    btnBS.setDisable(true);
                    btnEN.setDisable(true);
                    labelStanje.setVisible(true);
                });
                int privilegijaPrijave = loginDao.loginSistem(fldUsername.getText().trim(), fldPassword.getText().trim());
                Platform.runLater(() -> {
                    if (privilegijaPrijave > 0) {
                        Stage myStage = new Stage();
                        FXMLLoader loader = null;
                        Parent root = null;


                        ResourceBundle bundle = ResourceBundle.getBundle("Prijevod");
                        if (privilegijaPrijave == 1) loader = new FXMLLoader(getClass().getResource("/fxml/admin.fxml"), bundle);
                        //else if (privilegijaPrijave == 2); // kuhar
                        else if (privilegijaPrijave == 3) loader = new FXMLLoader(getClass().getResource("/fxml/konobar.fxml"), bundle);

                        try {
                            root = loader.load();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        myStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
                        myStage.show();

                        Stage stage = (Stage) btnSignIn.getScene().getWindow();
                        stage.close();
                    } else {
                        btnSignIn.setDisable(false);
                        btnBS.setDisable(false);
                        btnEN.setDisable(false);
                        labelStanje.setVisible(false);


                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        if (Locale.getDefault().getCountry().equals("BA") && Locale.getDefault().getLanguage().equals("bs")) {
                            alert.setTitle("Greška");
                            alert.setHeaderText("Neispravno unešeni podaci");
                            alert.setContentText("Unijeli ste pogrešan username i password. "
                                    + "\nMolim vas provjerite podatke.");
                        } else if (Locale.getDefault().getCountry().equals("US") && Locale.getDefault().getLanguage().equals("en")){
                            alert.setTitle("ERROR");
                            alert.setHeaderText("Incorrectly entered access data.");
                            alert.setContentText("You entered an incorrect username and password. "
                                    + "\nPlease check the entered data.");
                        }

                        alert.showAndWait();
                    }
                });
            }).start();
        }
    }

    public void actionBS(ActionEvent actionEvent){
        if (!Locale.getDefault().getCountry().equals("BA") && !Locale.getDefault().getLanguage().equals("bs")) {
            Locale.setDefault(new Locale("bs", "BA"));

            Stage thisStage = (Stage) btnBS.getScene().getWindow();
            thisStage.close();

            try {
                ResourceBundle bundle = ResourceBundle.getBundle("Prijevod");
                Parent root = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"), bundle);
                Stage primaryStage = new Stage();
                primaryStage.setTitle("Ugostiteljski objekat");
                primaryStage.setScene(new Scene(root, 500, 500));
                primaryStage.setResizable(false);
                primaryStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void actionEN(ActionEvent actionEvent){
        if (!Locale.getDefault().getCountry().equals("US") && !Locale.getDefault().getLanguage().equals("en")) {
            Locale.setDefault(new Locale("en", "US"));

            Stage thisStage = (Stage) btnBS.getScene().getWindow();
            thisStage.close();

            Stage stage = new Stage();
            try {
                ResourceBundle bundle = ResourceBundle.getBundle("Prijevod");
                Parent root = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"), bundle);
                Stage primaryStage = new Stage();
                primaryStage.setTitle("Ugostiteljski objekat");
                primaryStage.setScene(new Scene(root, 500, 500));
                primaryStage.setResizable(false);
                primaryStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
