package nrs.tim5.projekat.DAO;

import javafx.application.Platform;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class LoginDAO {
    private static LoginDAO instance;

    public static LoginDAO getInstance(){
        if (instance==null) instance = new LoginDAO();
        return instance;
    }

    public int loginSistem(String username, String password) {
        //ako je potreban sleep za prezentacije
        /*try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        try {
            URL url = new URL("http://64.227.119.56:7000/privileges/" + username + "/" + password);
            URLConnection conn = url.openConnection();
            conn.setDoInput(true);
            conn.setDoOutput(true);

            InputStream inputStream = conn.getInputStream();
            String rezultat = "";
            Scanner scanner = new Scanner(inputStream);
            while (scanner.hasNextLine()){
                rezultat += scanner.nextLine() + "\n";
            }

            scanner.close();
            inputStream.close();
            String finalRezultat = rezultat.trim();
            return Integer.parseInt(finalRezultat);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return -1;
    }
}
