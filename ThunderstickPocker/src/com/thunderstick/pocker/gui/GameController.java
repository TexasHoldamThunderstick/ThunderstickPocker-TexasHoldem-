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
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author tawsoft
 */
public class GameController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    Button btnStartp1;
    @FXML
    Button btncheckp1;

    @FXML
    Button btnStartp2;
    @FXML
    Button btncheckp2;

    @FXML
    Button btnStartp3;
    @FXML
    Button btncheckp3;

    @FXML
    Button btnStartp4;
    @FXML
    Button btncheckp4;
    
    
    //amount
    @FXML
    TextField txtamountp1;
    @FXML
    TextField txtamountp2;
    @FXML
    TextField txtamountp3;
    @FXML
    TextField txtamountp4;

    DataInputStream inp;
    DataOutputStream out;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        inp=SocketClass.getIn();
        out=SocketClass.getOut();
        String playerName="";
        try {
           playerName=inp.readUTF();
        } catch (IOException ex) {
            Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(playerName.contains("player1")){
            hideP2();
            hideP3();
            hideP4();
        }
        else if(playerName.contains("player2")){
            hideP1();
            hideP3();
            hideP4();
        }
        else if(playerName.contains("player3")){
            hideP1();
            hideP2();
            hideP4();
        }
        else{
            hideP1();
            hideP2();
            hideP3();
        }
        
    }

    //player 1
    public void btnStartp1click(ActionEvent e) {

    }

    public void btncheckp1click(ActionEvent e) {

    }

    //player 2
    public void btnStartp2click(ActionEvent e) {

    }

    public void btncheckp2click(ActionEvent e) {

    }

    //player 3
    public void btnStartp3click(ActionEvent e) {

    }

    public void btncheckp3click(ActionEvent e) {

    }

    //player 4
    public void btnStartp4click(ActionEvent e) {

    }

    public void btncheckp4click(ActionEvent e) {

    }

    //hide Buttons
    public void hideP1() {
        btnStartp1.setVisible(false);
        btncheckp1.setVisible(false);
        txtamountp1.setEditable(false);
    }

    public void hideP2() {
        btnStartp2.setVisible(false);
        btncheckp2.setVisible(false);
        txtamountp2.setEditable(false);
    }

    public void hideP3() {
        btnStartp3.setVisible(false);
        btncheckp3.setVisible(false);
        txtamountp3.setEditable(false);
    }

    public void hideP4() {
        btnStartp4.setVisible(false);
        btncheckp4.setVisible(false);
        txtamountp4.setEditable(false);
    }
}
