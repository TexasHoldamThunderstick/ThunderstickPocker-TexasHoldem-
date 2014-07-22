/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thunderstick.pocker.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class GamescreenController implements Initializable {

    //calls
    @FXML
    Button btnp1call;
    @FXML
    Button btnp2call;
    @FXML
    Button btnp3call;
    @FXML
    Button btnp4call;

    //checks
    @FXML
    Button btnp1check;
    @FXML
    Button btnp2check;
    @FXML
    Button btnp3check;
    @FXML
    Button btnp4check;

    //Fold
    @FXML
    Button btnp1fold;
    @FXML
    Button btnp2fold;
    @FXML
    Button btnp3fold;
    @FXML
    Button btnp4fold;

    //Raise
    @FXML
    Button btnp1raise;
    @FXML
    Button btnp2raise;
    @FXML
    Button btnp3raise;
    @FXML
    Button btnp4raise;

    //cards
    @FXML
    ImageView p1c1;
    @FXML
    ImageView p1c2;
    @FXML
    ImageView p2c1;
    @FXML
    ImageView p2c2;
    @FXML
    ImageView p3c1;
    @FXML
    ImageView p3c2;
    @FXML
    ImageView p4c1;
    @FXML
    ImageView p4c2;
    
    //deck
    @FXML
    ImageView deckc1;
    @FXML
    ImageView deckc2;
    @FXML
    ImageView deckc3;
    @FXML
    ImageView deckc4;
    @FXML
    ImageView deckc5;
    
    boolean p1=true,p2=false,p3=false,p4=false;

    public void initialize(URL url, ResourceBundle rb) {

        if(p1){
            disableP2();
            disableP3();
            disableP4();
           
        }
        else if(p2){
            disableP1();
            disableP3();
            disableP4();
        }
        else if(p3){
            disableP1();
            disableP2();
            disableP4();
        }
        else if(p4){
            disableP1();
            disableP2();
            disableP3();
            
        }
        else{
            System.out.println("Error");
        }
    }

    //Action Events
    //calls
    public void btnp1callclick(ActionEvent e) {
        System.out.println("player 1 call");
    }

    public void btnp2callclick(ActionEvent e) {
        System.out.println("player 2 call");
    }

    public void btnp3callclick(ActionEvent e) {
        System.out.println("player 3 call");
    }

    public void btnp4callclick(ActionEvent e) {
        System.out.println("player 4 call");
    }

    //check
    public void btnp1checkclick(ActionEvent e) {
        System.out.println("player 1 check");
    }

    public void btnp2checkclick(ActionEvent e) {
        System.out.println("player 2 check");
    }

    public void btnp3checkclick(ActionEvent e) {
        System.out.println("player 3 check");
    }

    public void btnp4checkclick(ActionEvent e) {
        System.out.println("player 4 check");
    }

    //fold
    public void btnp1foldclick(ActionEvent e) {
        System.out.println("player 1 fold");
    }

    public void btnp2foldclick(ActionEvent e) {
        System.out.println("player 2 fold");
    }

    public void btnp3foldclick(ActionEvent e) {
        System.out.println("player 3 fold");
    }

    public void btnp4foldclick(ActionEvent e) {
        System.out.println("player 4 fold");
    }

    //raise
    public void btnp1raiseclick(ActionEvent e) {
        System.out.println("player 1 raise");
    }

    public void btnp2raiseclick(ActionEvent e) {
        System.out.println("player 2 raise");
    }

    public void btnp3raiseclick(ActionEvent e) {
        System.out.println("player 3 raise");
    }

    public void btnp4raiseclick(ActionEvent e) {
        System.out.println("player 4 raise");
    }
    

    //visibility
    public void disableP1(){
        btnp1call.setVisible(false);
        btnp1check.setVisible(false);
        btnp1fold.setVisible(false);
        btnp1raise.setVisible(false);
    }
    public void disableP2(){
        btnp2call.setVisible(false);
        btnp2check.setVisible(false);
        btnp2fold.setVisible(false);
        btnp2raise.setVisible(false);
    }
     public void disableP3(){
        btnp3call.setVisible(false);
        btnp3check.setVisible(false);
        btnp3fold.setVisible(false);
        btnp3raise.setVisible(false);
    }
    public void disableP4(){
        btnp4call.setVisible(false);
        btnp4check.setVisible(false);
        btnp4fold.setVisible(false);
        btnp4raise.setVisible(false);
    }
    
    
  
}
