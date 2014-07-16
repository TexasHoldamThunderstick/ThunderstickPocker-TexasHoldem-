/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.thunderstick.pocker.client;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author tawsoft
 */
public class Mainclass extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        try
       {
           AnchorPane pane=(AnchorPane)FXMLLoader.load(Mainclass.class.getResource("/com/thunderstick/pocker/gui/Home.fxml"));
        
           Scene scene=new Scene(pane);
           primaryStage.setScene(scene);
           primaryStage.setTitle("Home");
           primaryStage.show();
           
    
       }
       catch(Exception ex)
       {
           System.out.println(ex.getMessage());
         Logger.getLogger(Mainclass.class.getName()).log(Level.SEVERE,null,ex);
       } 
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Application.launch(Mainclass.class,(java.lang.String) null);

    }
    
}
