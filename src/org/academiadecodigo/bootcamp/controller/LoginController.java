package org.academiadecodigo.bootcamp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import org.academiadecodigo.bootcamp.Navigation;
import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.service.ServiceRegistry;
import org.academiadecodigo.bootcamp.service.UserService;
import org.academiadecodigo.bootcamp.utils.Security;

public class LoginController implements Controller{

    @FXML
    private GridPane gridPane1;

    @FXML
    private TextField usernameField1;

    @FXML
    private PasswordField passwordField1;

    @FXML
    private TextField emailField1;

    @FXML
    private Label emailLabel1;

    @FXML
    private Button loginButton1;

    @FXML
    private Label registerLabel1;

    @FXML
    private Label errorLabel1;

    private UserService userService;

    private boolean login = true;



    /**
     * Called reflectively by JavaFX after all bindings are done and
     * the root element has been completely processed
     */
    public void initialize() {
        userService = (UserService) ServiceRegistry.getInstance().getServiceMap("UserService");
        //gridPane1.setGridLinesVisible(true);
        //showLogin();

    }

    private void showLogin() {

        login = true;

        errorLabel1.setVisible(false);

        gridPane1.getChildren().remove(emailField1);
        gridPane1.getChildren().remove(emailLabel1);

        loginButton1.setText("Login");
        registerLabel1.setText("Register");

    }

    private void showRegister() {

        login = false;

        errorLabel1.setVisible(false);

        //RESOLVE THIS MOTHERFUCKER

        //gridPane1.add(emailLabel1, 0, 2);
        //gridPane1.add(emailField1, 1, 2);

        loginButton1.setText("Submit");
        registerLabel1.setText("Cancel");

    }

    private void doLogin() {

        if (usernameField1.getText().isEmpty()) {
            showConsoleText("username missing");
            return;
        }

        if (passwordField1.getText().isEmpty()) {
            showConsoleText("password missing");
            return;
        }

        if (userService.authenticate(usernameField1.getText(), Security.getHash(passwordField1.getText()))) { //here
            showConsoleText("login accepted");
            Navigation.getInstance().loadScreen("list");
        } else {
            showConsoleText("authentication failed");
        }

    }

    private void doRegister() {

        if (usernameField1.getText().isEmpty()) {
            showConsoleText("username missing");
            return;
        }

        if (passwordField1.getText().isEmpty()) {
            showConsoleText("password missing");
            return;
        }

        if (emailField1.getText().isEmpty()) {
            showConsoleText("email missing");
            return;
        }

        if (userService.findByName(usernameField1.getText()) != null) { //here
            showConsoleText("username taken");
            return;
        }

        System.out.println("test");
        userService.addUser(new User(usernameField1.getText(), emailField1.getText(), Security.getHash(passwordField1.getText())));

        showLogin();
        showConsoleText("registration successful");

    }

    private void showConsoleText(String text) {

        errorLabel1.setText("console.log(\"" + text + "\");");
        errorLabel1.setVisible(true);

    }

    public void onButton(ActionEvent event) {

        if (login) {
            doLogin();
        } else {
            doRegister();
        }

    }

    public void onLink(MouseEvent event) {

        if (login) {
            showRegister();
        } else {
            showLogin();
        }

    }

}
