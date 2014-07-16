/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.thunderstick.pocker.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.application.Platform;
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
public class HomeController implements Initializable {

    @FXML
    Button btnSingleplayer;
    
    @FXML
    Button btnMultiplayer;
    
    @FXML
    Button btnTutorial;
    
    @FXML
    Button btnSettings;
    
    @FXML
    Button btnExit;
  
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
 
    public void btnSingleplayerclick(ActionEvent e) throws IOException{
        AnchorPane pane = (AnchorPane) FXMLLoader.load(HomeController.class.getResource("/com/thunderstick/pocker/gui/Singleplayer.fxml"));
        Scene scene = new Scene(pane);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Singleplayer");
        stage.show();
        ((Node) e.getTarget()).getScene().getWindow().hide();
        
        
        
    }
    public void btnMultiplayerclick(ActionEvent e) throws IOException{
        AnchorPane pane = (AnchorPane) FXMLLoader.load(HomeController.class.getResource("/com/thunderstick/pocker/gui/Multiplayer.fxml"));
        Scene scene = new Scene(pane);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Multiplayer");
        stage.show();
        ((Node) e.getTarget()).getScene().getWindow().hide();
        
        
        
    }
    public void btnSettingsclick(ActionEvent e) throws IOException{
        
        AnchorPane pane = (AnchorPane) FXMLLoader.load(HomeController.class.getResource("/com/thunderstick/pocker/gui/Settings.fxml"));
        Scene scene = new Scene(pane);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Settings");
        stage.show();
        ((Node) e.getTarget()).getScene().getWindow().hide();
        
        
    }
    public void btnTutorialclick(ActionEvent e) throws IOException{
        
        AnchorPane pane = (AnchorPane) FXMLLoader.load(HomeController.class.getResource("/com/thunderstick/pocker/gui/Tutorial.fxml"));
        Scene scene = new Scene(pane);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Tutorial");
        stage.show();
        ((Node) e.getTarget()).getScene().getWindow().hide();
        
        
    }
    
    public void btnExitclick(ActionEvent e) throws IOException{
        
       Platform.exit();
        
    }
    
}
