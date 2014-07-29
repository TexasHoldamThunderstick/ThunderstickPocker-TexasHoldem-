/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.thunderstick.pocker.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author tawsoft
 */

public class TutorialController implements Initializable {

    @FXML
    Button btnClose;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    @FXML
    public void btnCloseclick(ActionEvent e) throws IOException{
        AnchorPane pane = (AnchorPane) FXMLLoader.load(HomeController.class.getResource("/com/thunderstick/pocker/gui/Home.fxml"));
        Scene scene = new Scene(pane);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Home");
        stage.show();
        ((Node) e.getTarget()).getScene().getWindow().hide();
    }
    
}
