package org.academiadecodigo.bootcamp;

import javafx.application.Application;
import javafx.stage.Stage;
import org.academiadecodigo.bootcamp.controller.LoginController;
import org.academiadecodigo.bootcamp.service.*;

public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void init() {

        ServiceRegistry.getInstance().addService("UserService", new JdbcUserService());
        ServiceRegistry.getInstance().addService("BootcampService", new MockBootcampService());


    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Navigation.getInstance().setStage(primaryStage);
        Navigation.getInstance().loadScreen("login");

       // LoginController loginController = (LoginController) Navigation.getInstance().getController("login");
        //loginController.setUserService((UserService) ServiceRegistry.getInstance().getServiceMap("UserService"));
        Navigation.getInstance().setStage(primaryStage);


    }

}


