/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thunderstick.pocker.gui;

import com.thunderstick.pocker.Functions.CheckFunction;
import com.thunderstick.pocker.Functions.SocketClass;
import com.thunderstick.pocker.texasholdem.Card;
import com.thunderstick.pocker.texasholdem.IPlayer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author tawsoft
 */
public class GameController implements Initializable {

    Thread t1;
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

    //Deck
    @FXML
    ImageView Dc1;
    @FXML
    ImageView Dc2;
    @FXML
    ImageView Dc3;
    @FXML
    ImageView Dc4;
    @FXML
    ImageView Dc5;

    DataInputStream inp;
    DataOutputStream out;

    //cardImages
    String p1Card1 = "";
    String p1Card2 = "";

    String p2Card1 = "";
    String p2Card2 = "";

    String p3Card1 = "";
    String p3Card2 = "";

    String p4Card1 = "";
    String p4Card2 = "";

    //Text messages
    /*
    @FXML
    TextField txtP1;
    @FXML
    TextField txtP2;
    @FXML
    TextField txtP3;
    @FXML
    TextField txtP4;
*/
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        inp = SocketClass.getIn();
        out = SocketClass.getOut();
        String playerName = "";
        try {
            playerName = inp.readUTF();
        } catch (IOException ex) {
            Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (playerName.contains("player1")) {
            hideP2();
            hideP3();
            hideP4();
        } else if (playerName.contains("player2")) {
            hideP1();
            hideP3();
            hideP4();
        } else if (playerName.contains("player3")) {
            hideP1();
            hideP2();
            hideP4();
        } else {
            hideP1();
            hideP2();
            hideP3();
        }

    }

    //player 1
    public void btnStartp1click(ActionEvent e) {

    }

    public void btncheckp1click(ActionEvent e) {
        System.out.println("p1 check clicked");
        try {

            out.writeUTF("check");

            String myCards1 = inp.readUTF();
            String myCards2 = inp.readUTF();

            System.out.println(myCards1);
            System.out.println(myCards2);

            showPlayer1Cards(myCards1.toString().trim(), myCards2.toString().trim());

            p2Card1 = inp.readUTF();
            p2Card2 = inp.readUTF();

            showPlayer2Cards(p2Card1.toString().trim(), p2Card2.toString().trim());

            System.out.println(p2Card1);
            System.out.println(p2Card2);

            p3Card1 = inp.readUTF();
            p3Card2 = inp.readUTF();

            showPlayer3Cards(p3Card1.toString().trim(), p3Card2.toString().trim());

            System.out.println(p3Card1);
            System.out.println(p3Card2);

            p4Card1 = inp.readUTF();
            p4Card2 = inp.readUTF();

            showPlayer4Cards(p4Card1.toString().trim(), p4Card2.toString().trim());

            String d1, d2, d3, d4, d5;

            d1 = inp.readUTF();
            d2 = inp.readUTF();
            d3 = inp.readUTF();
            d4 = inp.readUTF();
            d5 = inp.readUTF();

            String[] a = {d1.toString().trim(), d2.toString().trim(), d3.toString().trim(), d4.toString().trim(), d5.toString().trim()};
            setDeck(a);

            String winner = inp.readUTF();
            System.out.println("Winner is :" + winner);
          
           String by=inp.readUTF();
            
                    if(winner.toString().trim().contains("player1")){
                       // txtP1.setText("Player1 wins by :"+by);
                        System.out.println("Player1 wins by :"+by);
                    }
                    else if(winner.toString().trim().contains("player2")){
                       // txtP2.setText("Player2 wins by :"+by);
                        System.out.println("Player2 wins by :"+by);
                    }
                    else if(winner.toString().trim().contains("player3")){
                       // txtP3.setText("Player3 wins by :"+by);
                        System.out.println("Player3 wins by :"+by);
                    }
                    else{
                         //txtP4.setText("Player4 wins by :"+by);
                        System.out.println("Player4 wins by :"+by);
                    }

        } catch (IOException ex) {
            Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Hello world " + ex.toString());
        }

    }

    //player 2
    public void btnStartp2click(ActionEvent e) {

    }

    public void btncheckp2click(ActionEvent e) {
        try {
            System.out.println("p2 check clicked");
            out.writeUTF("check");

            String myCards1 = inp.readUTF();
            String myCards2 = inp.readUTF();

            System.out.println(myCards1);
            System.out.println(myCards2);

            showPlayer2Cards(myCards1, myCards2);

            p1Card1 = inp.readUTF();
            p1Card2 = inp.readUTF();

            showPlayer1Cards(p1Card1, p1Card2);

            p3Card1 = inp.readUTF();
            p3Card2 = inp.readUTF();

            showPlayer3Cards(p3Card1, p3Card2);

            p4Card1 = inp.readUTF();
            p4Card2 = inp.readUTF();

            showPlayer4Cards(p4Card1, p4Card2);

            String d1, d2, d3, d4, d5;

            d1 = inp.readUTF();
            d2 = inp.readUTF();
            d3 = inp.readUTF();
            d4 = inp.readUTF();
            d5 = inp.readUTF();

            String[] a = {d1.toString().trim(), d2.toString().trim(), d3.toString().trim(), d4.toString().trim(), d5.toString().trim()};
            setDeck(a);

            String winner = inp.readUTF();
            System.out.println("Winner is :" + winner);

          
            String by = inp.readUTF();

            if (winner.toString().trim().contains("player1")) {
                //txtP1.setText("Player1 wins by :" + by);
                System.out.println("Player1 wins by :"+by);
            } else if (winner.toString().trim().contains("player2")) {
               // txtP2.setText("Player2 wins by :" + by);
                System.out.println("Player2 wins by :"+by);
            } else if (winner.toString().trim().contains("player3")) {
              //  txtP3.setText("Player3 wins by :" + by);
                System.out.println("Player3 wins by :"+by);
            } else {
               // txtP4.setText("Player4 wins by :" + by);
                System.out.println("Player4 wins by :"+by);
            }

        } catch (IOException ex) {
            Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.toString());
        }
    }

    //player 3
    public void btnStartp3click(ActionEvent e) {

    }

    public void btncheckp3click(ActionEvent e) {
        try {
            System.out.println("p3 check clicked");
            out.writeUTF("check");

            String myCards1 = inp.readUTF();
            String myCards2 = inp.readUTF();

            System.out.println(myCards1);
            System.out.println(myCards2);

            showPlayer3Cards(myCards1, myCards2);

            p1Card1 = inp.readUTF();
            p1Card2 = inp.readUTF();

            showPlayer1Cards(p1Card1, p1Card2);

            p2Card1 = inp.readUTF();
            p2Card2 = inp.readUTF();

            showPlayer2Cards(p2Card1, p2Card2);

            p4Card1 = inp.readUTF();
            p4Card2 = inp.readUTF();

            showPlayer4Cards(p4Card1, p4Card2);

            String d1, d2, d3, d4, d5;

            d1 = inp.readUTF();
            d2 = inp.readUTF();
            d3 = inp.readUTF();
            d4 = inp.readUTF();
            d5 = inp.readUTF();

            String[] a = {d1.toString().trim(), d2.toString().trim(), d3.toString().trim(), d4.toString().trim(), d5.toString().trim()};
            setDeck(a);

            String winner = inp.readUTF();
            System.out.println("Winner is :" + winner);

           
            String by = inp.readUTF();

            if (winner.toString().trim().contains("player1")) {
              //  txtP1.setText("Player1 wins by :" + by);
                System.out.println("Player1 wins by :"+by);
            } else if (winner.toString().trim().contains("player2")) {
               // txtP2.setText("Player2 wins by :" + by);
                System.out.println("Player2 wins by :"+by);
            } else if (winner.toString().trim().contains("player3")) {
               // txtP3.setText("Player3 wins by :" + by);
                System.out.println("Player3 wins by :"+by);
            } else {
               // txtP4.setText("Player4 wins by :" + by);
                System.out.println("Player4 wins by :"+by);
            }

        } catch (IOException ex) {
            Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.toString());
        }
    }

    //player 4
    public void btnStartp4click(ActionEvent e) {

    }

    public void btncheckp4click(ActionEvent e) {
        try {
            System.out.println("p4 check clicked");
            out.writeUTF("check");

            String myCards1 = inp.readUTF();
            String myCards2 = inp.readUTF();

            showPlayer4Cards(myCards1, myCards2);

            p1Card1 = inp.readUTF();
            p1Card2 = inp.readUTF();

            showPlayer1Cards(p1Card1, p1Card2);

            p2Card1 = inp.readUTF();
            p2Card2 = inp.readUTF();
            showPlayer2Cards(p2Card1, p2Card2);

            p3Card1 = inp.readUTF();
            p3Card2 = inp.readUTF();
            showPlayer3Cards(p3Card1, p3Card2);

            String d1, d2, d3, d4, d5;

            d1 = inp.readUTF();
            d2 = inp.readUTF();
            d3 = inp.readUTF();
            d4 = inp.readUTF();
            d5 = inp.readUTF();

            String[] a = {d1.toString().trim(), d2.toString().trim(), d3.toString().trim(), d4.toString().trim(), d5.toString().trim()};
            setDeck(a);

            String winner = inp.readUTF();
            System.out.println("Winner is :" + winner);

            
            String by = inp.readUTF();

            if (winner.toString().trim().contains("player1")) {
                //txtP1.setText("Player1 wins by :" + by);
                System.out.println("Player1 wins by :"+by);
            } else if (winner.toString().trim().contains("player2")) {
                //txtP2.setText("Player2 wins by :" + by);
                System.out.println("Player2 wins by :"+by);
            } else if (winner.toString().trim().contains("player3")) {
                //txtP3.setText("Player3 wins by :" + by);
                System.out.println("Player3 wins by :"+by);
            } else {
                //txtP4.setText("Player4 wins by :" + by);
                System.out.println("Player4 wins by :"+by);
            }

        } catch (IOException ex) {
            Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.toString());
        }
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

    public void showPlayer1Cards(String c1, String c2) {

        p1c1.setImage(new Image("/Resources/" + c1 + ".png"));
        p1c2.setImage(new Image("/Resources/" + c2 + ".png"));

    }

    public void showPlayer2Cards(String c1, String c2) {

        p2c1.setImage(new Image("/Resources/" + c1 + ".png"));
        p2c2.setImage(new Image("/Resources/" + c2 + ".png"));

    }

    public void showPlayer3Cards(String c1, String c2) {

        p3c1.setImage(new Image("/Resources/" + c1 + ".png"));
        p3c2.setImage(new Image("/Resources/" + c2 + ".png"));

    }

    public void showPlayer4Cards(String c1, String c2) {

        p4c1.setImage(new Image("/Resources/" + c1 + ".png"));
        p4c2.setImage(new Image("/Resources/" + c2 + ".png"));

    }

    public void setDeck(String[] de) {
        Dc1.setImage(new Image("/Resources/" + de[0] + ".png"));
        Dc2.setImage(new Image("/Resources/" + de[1] + ".png"));
        Dc3.setImage(new Image("/Resources/" + de[2] + ".png"));
        Dc4.setImage(new Image("/Resources/" + de[3] + ".png"));
        Dc5.setImage(new Image("/Resources/" + de[4] + ".png"));

    }
}
