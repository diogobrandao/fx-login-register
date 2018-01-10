package org.academiadecodigo.bootcamp;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.academiadecodigo.bootcamp.controller.Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


public class Navigation {

    private final int MIN_WIDTH = 1024; // window width
    private final int MIN_HEIGHT = 768; // window height

    private LinkedList<Scene> scenes = new LinkedList<Scene>(); // Navigation History
    private Map<String, Controller> controllers = new HashMap<>(); //Container of controllers

    private Stage stage;


    private static Navigation instance = null;


    private Navigation() {
    }


    public static synchronized Navigation getInstance() {

        if(instance == null) {
            instance = new Navigation();
        }

        return instance;
    }

    public void loadScreen(String view) {
        try {

            // Instantiate the view and the controller
            FXMLLoader fxmlLoader;
            fxmlLoader = new FXMLLoader(getClass().getResource("view/" + view + ".fxml"));
            Parent root = fxmlLoader.load();

            //Store the controller
            controllers.put(view, fxmlLoader.getController());

            // Create a new scene and add it to the stack
            Scene scene = new Scene(root, MIN_WIDTH, MIN_HEIGHT);
            scenes.push(scene);

            // Put the scene on the stage
            setScene(scene);

        } catch (IOException e) {
            System.out.println("Failure to load view " + view + " : " + e.getMessage());
            e.printStackTrace();
        }
    }

    public Controller getController(String key){
        return controllers.get(key);
    }

    public void back() {

        if (scenes.isEmpty()) {
            return;
        }

        // remove the current scene from the stack
        scenes.pop();

        // load the scene at the top of the stack
        setScene(scenes.peek());
    }

    private void setScene(Scene scene) {

        // set the scene
        stage.setScene(scene);

        // show the stage to reload
        stage.show();
    }


    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public int getMIN_WIDTH() {
        return MIN_WIDTH;
    }

    public int getMIN_HEIGHT() {
        return MIN_HEIGHT;
    }
}
