/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.thunderstick.pocker.gui;

import com.thunderstick.pocker.Functions.SocketClass;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author tawsoft
 */
public class MultiplayerController implements Initializable {

    @FXML
    Button btnLogin;
    @FXML
    Button btnClose;
    
    /**
     * Initializes the controller class.
     */
    
    @FXML
    TextField txtServerIP;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void startGameScreen() throws IOException{
        System.out.println("Hi");
        AnchorPane pane = (AnchorPane) FXMLLoader.load(MultiplayerController.class.getResource("/com/thunderstick/pocker/gui/Game.fxml"));
            Scene scene = new Scene(pane);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Game screen");
            stage.show();
    }
    
    public void btnLoginclick(ActionEvent e) throws IOException{
       try{ 
        Socket socket=new Socket(txtServerIP.getText(),444);
        SocketClass.setSocket(socket);
        DataInputStream inp=new DataInputStream(socket.getInputStream());
        SocketClass.setIn(inp);
        DataOutputStream out=new DataOutputStream(socket.getOutputStream());
        SocketClass.setOut(out);
        
        startGameScreen();
        ((Node) e.getTarget()).getScene().getWindow().hide();
       }
       catch(IOException ex){
           
       }
       
    }
    
    
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
