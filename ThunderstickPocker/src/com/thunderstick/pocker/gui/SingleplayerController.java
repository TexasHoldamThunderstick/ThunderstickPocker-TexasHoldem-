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
public class SingleplayerController implements Initializable {

    @FXML
    Button btnplay;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void startGameScreen() throws IOException{
        AnchorPane pane = (AnchorPane) FXMLLoader.load(MultiplayerController.class.getResource("/com/thunderstick/pocker/gui/singlePlayerScreen.fxml"));
            Scene scene = new Scene(pane);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Game screen");
            stage.show();
            
    }
    
    public void btnplayclick(ActionEvent e) throws IOException{
        startGameScreen();
        ((Node) e.getTarget()).getScene().getWindow().hide();
    }
    
}
