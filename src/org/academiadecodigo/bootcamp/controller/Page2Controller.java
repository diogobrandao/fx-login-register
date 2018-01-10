package org.academiadecodigo.bootcamp.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import org.academiadecodigo.bootcamp.Navigation;
import org.academiadecodigo.bootcamp.model.Bootcamp;
import org.academiadecodigo.bootcamp.model.CodeCadet;
import org.academiadecodigo.bootcamp.model.Gender;
import org.academiadecodigo.bootcamp.service.BootcampService;
import org.academiadecodigo.bootcamp.service.Service;
import org.academiadecodigo.bootcamp.service.ServiceRegistry;

import java.util.Date;

public class Page2Controller implements Controller{

    //private boolean back = true;
    private boolean login = true;
    private BootcampService bootcampService;

    @FXML
    private GridPane pane2;

    @FXML
    private GridPane pane;



    @FXML
    private TableView<Bootcamp> grid;

    @FXML
    private TableColumn<Bootcamp, Integer> Id;

    @FXML
    private TableColumn<Bootcamp, String> Location;

    @FXML
    private TableColumn<Bootcamp, Date> Start;

    @FXML
    private TableColumn<Bootcamp, Date> End;

    @FXML
    private TableView<CodeCadet> table2;

    @FXML
    private TableColumn<CodeCadet, String> name;

    @FXML
    private TableColumn<CodeCadet, String> adress;

    @FXML
    private TableColumn<CodeCadet, String> city;

    @FXML
    private TableColumn<CodeCadet, String> phone;

    @FXML
    private TableColumn<CodeCadet, Date> birthdate;

    @FXML
    private TableColumn<CodeCadet, Bootcamp> bootcamp;

    @FXML
    private TableColumn<CodeCadet, Gender> gender;

    @FXML
    private Button back;

    @FXML
    void onBack(ActionEvent event) {
    }


    /*
    @FXML
    void goBack(ActionEvent event) {
        if (back) {
            goBack();
        }
    }*/

    public void initialize(){
        bootcampService = (BootcampService) ServiceRegistry.getInstance().getServiceMap("BootcampService");

        Id.setCellValueFactory(new PropertyValueFactory<>("id"));
        Location.setCellValueFactory(new PropertyValueFactory<>("location"));
        Start.setCellValueFactory(new PropertyValueFactory<>("start"));
        End.setCellValueFactory(new PropertyValueFactory<>("end"));

        grid.setItems(FXCollections.observableArrayList(bootcampService.getAllBootcamps()));
    }

    /*private void showLogin() {

        login = true;

        errorLabel.setVisible(false);

        gridPane.getChildren().remove(emailField);
        gridPane.getChildren().remove(emailLabel);

        loginButton.setText("Login");
        registerLabel.setText("Register");

    }

    private void goBack() {
        if(back = true){
            Navigation.getInstance().back();

        }

    } */

    @FXML
    void onButton(ActionEvent event) {

    }

    @FXML
    void onLink(MouseEvent event) {

    }

    public void click(MouseEvent mouseEvent) {
        Bootcamp bootcamp1 = grid.getSelectionModel().getSelectedItem();
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        adress.setCellValueFactory(new PropertyValueFactory<>("adress"));
        city.setCellValueFactory(new PropertyValueFactory<>("city"));
        phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        birthdate.setCellValueFactory(new PropertyValueFactory<>("birthdate"));
        bootcamp.setCellValueFactory(new PropertyValueFactory<>("bootcamp"));
        gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        table2.setItems(FXCollections.observableArrayList(bootcampService.getAllCadets(bootcamp1)));
        pane.setVisible(false);
        pane2.setVisible(true);


    }
}
