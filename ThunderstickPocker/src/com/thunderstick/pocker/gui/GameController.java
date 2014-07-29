/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thunderstick.pocker.gui;

import com.thunderstick.pocker.Functions.CheckFunction;
import com.thunderstick.pocker.Functions.PlayerGameInfo;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author tawsoft
 */
public class GameController implements Initializable {

    String bet;
    
    //coins
    @FXML
    Label txtcoinsp1;
    @FXML
    Label txtcoinsp2;
    @FXML
    Label txtcoinsp3;
    @FXML
    Label txtcoinsp4;

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
    @FXML
    Label txtP1;
    @FXML
    Label txtP2;
    @FXML
    Label txtP3;
    @FXML
    Label txtP4;

    
    //PlayerModel
    PlayerGameInfo p1;
    PlayerGameInfo p2;
    PlayerGameInfo p3;
    PlayerGameInfo p4;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        play();
        
        p1 = new PlayerGameInfo(200, true);
        p2 = new PlayerGameInfo(200, true);
        p3 = new PlayerGameInfo(200, true);
        p4 = new PlayerGameInfo(200, true);
        
        
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

        txtcoinsp1.setText("200");
        txtcoinsp2.setText("200");
        txtcoinsp3.setText("200");
        txtcoinsp4.setText("200");

    }

    //player 1
    public void btnStartp1click(ActionEvent e) {

        txtP1.setVisible(true);
        txtP2.setVisible(true);
        txtP3.setVisible(true);
        txtP4.setVisible(true);

        showP1Cards();
        showP2Cards();
        showP3Cards();
        showP4Cards();

  
       

        coinsinit();
    }

    public void btncheckp1click(ActionEvent e) {

        txtP1.setText("");
        txtP2.setText("");
        txtP3.setText("");
        txtP4.setText("");

        txtP1.setVisible(false);
        txtP2.setVisible(false);
        txtP3.setVisible(false);
        txtP4.setVisible(false);

        hideP2Cards();
        hideP3Cards();
        hideP4Cards();

        System.out.println("p1 check clicked");
        try {

            out.writeUTF("check");
            
            out.writeUTF(txtamountp1.getText());

           bet = inp.readUTF();
           
            p1.updateCoins(Integer.parseInt(bet.toString().trim()));
        p2.updateCoins(Integer.parseInt(bet.toString().trim()));
        p3.updateCoins(Integer.parseInt(bet.toString().trim()));
        p4.updateCoins(Integer.parseInt(bet.toString().trim()));
        
           System.out.println("Bet is: "+bet);
           

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

            String by = inp.readUTF();

            if (winner.toString().trim().contains("player1")) {
                txtP1.setText("Player1 wins by :" + by);
                System.out.println("Player1 wins by :" + by);
                
                p1.incCoins(Integer.parseInt(bet.toString().trim())*4);

            } else if (winner.toString().trim().contains("player2")) {
                txtP2.setText("Player2 wins by :" + by);
                System.out.println("Player2 wins by :" + by);
                 p2.incCoins(Integer.parseInt(bet.toString().trim())*4);
            } else if (winner.toString().trim().contains("player3")) {
                txtP3.setText("Player3 wins by :" + by);
                System.out.println("Player3 wins by :" + by);
                 p3.incCoins(Integer.parseInt(bet.toString().trim())*4);
            } else {
                txtP4.setText("Player4 wins by :" + by);
                System.out.println("Player4 wins by :" + by);
                 p4.incCoins(Integer.parseInt(bet.toString().trim())*4);
            }

        } catch (IOException ex) {
            Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Hello world " + ex.toString());
        }

    }

    //player 2
    public void btnStartp2click(ActionEvent e) {
        txtP1.setVisible(true);
        txtP2.setVisible(true);
        txtP3.setVisible(true);
        txtP4.setVisible(true);

        showP1Cards();
        showP2Cards();
        showP3Cards();
        showP4Cards();
        
   
        coinsinit();
    }

    public void btncheckp2click(ActionEvent e) {
        txtP1.setText("");
        txtP2.setText("");
        txtP3.setText("");
        txtP4.setText("");

        txtP1.setVisible(false);
        txtP2.setVisible(false);
        txtP3.setVisible(false);
        txtP4.setVisible(false);

        hideP1Cards();
        hideP3Cards();
        hideP4Cards();
        try {
            System.out.println("p2 check clicked");
            out.writeUTF("check");     
            
            out.writeUTF(txtamountp2.getText());
            
         bet = inp.readUTF();
         
         
            p1.updateCoins(Integer.parseInt(bet.toString().trim()));
        p2.updateCoins(Integer.parseInt(bet.toString().trim()));
        p3.updateCoins(Integer.parseInt(bet.toString().trim()));
        p4.updateCoins(Integer.parseInt(bet.toString().trim()));
        
           System.out.println("Bet is: "+bet);

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
                txtP1.setText("Player1 wins by :" + by);
                System.out.println("Player1 wins by :" + by);
                 p1.incCoins(Integer.parseInt(bet.toString().trim())*4);
            } else if (winner.toString().trim().contains("player2")) {
                txtP2.setText("Player2 wins by :" + by);
                System.out.println("Player2 wins by :" + by);
                 p2.incCoins(Integer.parseInt(bet.toString().trim())*4);
            } else if (winner.toString().trim().contains("player3")) {
                txtP3.setText("Player3 wins by :" + by);
                System.out.println("Player3 wins by :" + by);
                 p3.incCoins(Integer.parseInt(bet.toString().trim())*4);
            } else {
                txtP4.setText("Player4 wins by :" + by);
                System.out.println("Player4 wins by :" + by);
                 p4.incCoins(Integer.parseInt(bet.toString().trim())*4);
            }

        } catch (IOException ex) {
            Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.toString());
        }

    }

    //player 3
    public void btnStartp3click(ActionEvent e) {

        txtP1.setVisible(true);
        txtP2.setVisible(true);
        txtP3.setVisible(true);
        txtP4.setVisible(true);

        showP1Cards();
        showP2Cards();
        showP3Cards();
        showP4Cards();
        
     
        coinsinit();
    }

    public void btncheckp3click(ActionEvent e) {
        txtP1.setText("");
        txtP2.setText("");
        txtP3.setText("");
        txtP4.setText("");

        txtP1.setVisible(false);
        txtP2.setVisible(false);
        txtP3.setVisible(false);
        txtP4.setVisible(false);

        hideP1Cards();
        hideP2Cards();
        hideP4Cards();

        try {
            System.out.println("p3 check clicked");
            out.writeUTF("check");
            
            out.writeUTF(txtamountp3.getText());

          bet = inp.readUTF();
          
          
            p1.updateCoins(Integer.parseInt(bet.toString().trim()));
        p2.updateCoins(Integer.parseInt(bet.toString().trim()));
        p3.updateCoins(Integer.parseInt(bet.toString().trim()));
        p4.updateCoins(Integer.parseInt(bet.toString().trim()));
        
           System.out.println("Bet is: "+bet);

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
                txtP1.setText("Player1 wins by :" + by);
                System.out.println("Player1 wins by :" + by);
                 p1.incCoins(Integer.parseInt(bet.toString().trim())*4);
            } else if (winner.toString().trim().contains("player2")) {
                txtP2.setText("Player2 wins by :" + by);
                System.out.println("Player2 wins by :" + by);
                 p2.incCoins(Integer.parseInt(bet.toString().trim())*4);
            } else if (winner.toString().trim().contains("player3")) {
                txtP3.setText("Player3 wins by :" + by);
                System.out.println("Player3 wins by :" + by);
                 p3.incCoins(Integer.parseInt(bet.toString().trim())*4);
            } else {
                txtP4.setText("Player4 wins by :" + by);
                System.out.println("Player4 wins by :" + by);
                 p4.incCoins(Integer.parseInt(bet.toString().trim())*4);
            }

        } catch (IOException ex) {
            Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.toString());
        }

    }

    //player 4
    public void btnStartp4click(ActionEvent e) {
        showP1Cards();
        showP2Cards();
        showP3Cards();
        showP4Cards();

        txtP1.setVisible(true);
        txtP2.setVisible(true);
        txtP3.setVisible(true);
        txtP4.setVisible(true);
        
        
        
        coinsinit();
    }

    public void btncheckp4click(ActionEvent e) {
        txtP1.setText("");
        txtP2.setText("");
        txtP3.setText("");
        txtP4.setText("");

        txtP1.setVisible(false);
        txtP2.setVisible(false);
        txtP3.setVisible(false);
        txtP4.setVisible(false);

        hideP1Cards();
        hideP2Cards();
        hideP3Cards();

        try {
            System.out.println("p4 check clicked");
            out.writeUTF("check");

            out.writeUTF(txtamountp4.getText());
            
            bet = inp.readUTF();
            
            
            p1.updateCoins(Integer.parseInt(bet.toString().trim()));
        p2.updateCoins(Integer.parseInt(bet.toString().trim()));
        p3.updateCoins(Integer.parseInt(bet.toString().trim()));
        p4.updateCoins(Integer.parseInt(bet.toString().trim()));
        
           System.out.println("Bet is: "+bet);
      

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
                txtP1.setText("Player1 wins by :" + by);
                System.out.println("Player1 wins by :" + by);
                 p1.incCoins(Integer.parseInt(bet.toString().trim())*4);
            } else if (winner.toString().trim().contains("player2")) {
                txtP2.setText("Player2 wins by :" + by);
                System.out.println("Player2 wins by :" + by);
                 p2.incCoins(Integer.parseInt(bet.toString().trim())*4);
            } else if (winner.toString().trim().contains("player3")) {
                txtP3.setText("Player3 wins by :" + by);
                System.out.println("Player3 wins by :" + by);
                 p3.incCoins(Integer.parseInt(bet.toString().trim())*4);
            } else {
                txtP4.setText("Player4 wins by :" + by);
                System.out.println("Player4 wins by :" + by);
                 p4.incCoins(Integer.parseInt(bet.toString().trim())*4);
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

    //hide cards
    public void hideP1Cards() {
        p1c1.setVisible(false);
        p1c2.setVisible(false);
    }

    public void hideP2Cards() {
        p2c1.setVisible(false);
        p2c2.setVisible(false);
    }

    public void hideP3Cards() {
        p3c1.setVisible(false);
        p3c2.setVisible(false);
    }

    public void hideP4Cards() {
        p4c1.setVisible(false);
        p4c2.setVisible(false);
    }

    //show
    public void showP1Cards() {
        p1c1.setVisible(true);
        p1c2.setVisible(true);
    }

    public void showP2Cards() {
        p2c1.setVisible(true);
        p2c2.setVisible(true);
    }

    public void showP3Cards() {
        p3c1.setVisible(true);
        p3c2.setVisible(true);
    }

    public void showP4Cards() {
        p4c1.setVisible(true);
        p4c2.setVisible(true);
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
    
    
    private void coinsinit() {
        
        txtcoinsp1.setText(p1.getCoins() + "");
        txtcoinsp2.setText(p2.getCoins() + "");
        txtcoinsp3.setText(p3.getCoins() + "");
        txtcoinsp4.setText(p4.getCoins() + "");

        if (p2.getCoins() == 0 && p3.getCoins() == 0 && p4.getCoins() == 0) {
            
            System.out.println("Player one Won");
            JOptionPane.showMessageDialog(null, "Player one Won");
        } else if (p1.getCoins() == 0 && p3.getCoins() == 0 && p4.getCoins() == 0) {
            System.out.println("Player two Won");
            JOptionPane.showMessageDialog(null, "Player two Won");
        } else if (p1.getCoins() == 0 && p2.getCoins() == 0 && p4.getCoins() == 0) {
            System.out.println("Player three Won");
            JOptionPane.showMessageDialog(null, "Player three Won");
        } else if (p1.getCoins() == 0 && p2.getCoins() == 0 && p3.getCoins() == 0) {
            System.out.println("Player four Won");
            JOptionPane.showMessageDialog(null, "Player four Won");
        }

    }
    
    
    public void play(){
          
    final URL resource = getClass().getResource("/Resources/texas.mp3");
    final Media media = new Media(resource.toString());
    final MediaPlayer mediaPlayer = new MediaPlayer(media);
    mediaPlayer.play();
    }

}
