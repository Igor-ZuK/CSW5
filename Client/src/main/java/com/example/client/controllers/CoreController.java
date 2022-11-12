package com.example.client.controllers;

import com.example.client.utils.InputDialog;
import com.example.client.utils.animations.Shake;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.stage.Stage;
import models.User;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.Connector;

import java.io.IOException;

public class CoreController {

    Logger logger = LogManager.getLogger(CoreController.class);
    public static Connector connector;

    public static User client;

    public TextField loginField;
    public Tooltip loginToolTip;
    public PasswordField passwordField;
    public Tooltip passToolTip;
    public Button authSignInButton;
    public Tooltip addTourToolTip;
    public Button loginSignUpButton;

    static {
        connector = new Connector("localhost", 8888);
    }

    public void openNewScene(String window) {
        try {
            loginSignUpButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(window));
            loader.load();
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        } catch (IOException e) {
            logger.log(Level.ERROR, e.getMessage());
        }
    }

    public void getOpenSignUp(ActionEvent actionEvent) {
        new InputDialog(actionEvent, "views/sign-up-view.fxml", 678, 400);
    }

    @FXML
    void initialize() {
        authSignInButton.setTooltip(addTourToolTip);
        passwordField.setTooltip(passToolTip);
        loginField.setTooltip(loginToolTip);

        authSignInButton.setOnAction(actionEvent -> {
                String login = loginField.getText().trim();
                String pass = passwordField.getText().trim();

                if (login.isEmpty()) {
                    Shake loginShake = new Shake(loginField);
                    loginShake.shake();
                } else if (pass.isEmpty()) {
                    Shake passShake = new Shake(passwordField);
                    passShake.shake();
                } else {
                    try {
                        connector.writeLine("signIn");
                        connector.writeLine(login);
                        connector.writeLine(pass);

                        String isStableConnectedStr = connector.readLine();
                        String isAdminOrClientStr = connector.readLine();

                        if (isStableConnectedStr.equals("true")) {
                            if (isAdminOrClientStr.equals("admin")) {
                                logger.log(Level.INFO, "Админ вошёл в учётную запись");
                                openNewScene("views/admin-view.fxml");
                            } else if (isAdminOrClientStr.equals("client")) {
                                client = (User) connector.readObj();

                                logger.log(Level.INFO, String.format("Пользователь \"%s\" прошёл авторизацию", client.getLogin()));
                                openNewScene("views/client-view.fxml");
                            } else {
                                loginField.setText("");
                                passwordField.setText("");

                                logger.log(Level.WARN, String.format("Пользователь \"%s\" не найден", login));
                            }
                        }
                    } catch (IOException | ClassNotFoundException e) {
                        logger.log(Level.ERROR, e.getMessage());

                        loginField.setText("");
                        passwordField.setText("");
                    }
                }
        });
    }
}
