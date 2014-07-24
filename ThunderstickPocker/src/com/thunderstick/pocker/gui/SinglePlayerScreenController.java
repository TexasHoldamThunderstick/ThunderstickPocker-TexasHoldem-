/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thunderstick.pocker.gui;

import com.thunderstick.pocker.Functions.PlayerGameInfo;
import com.thunderstick.pocker.texasholdem.Card;
import com.thunderstick.pocker.texasholdem.Deck;
import com.thunderstick.pocker.texasholdem.GameTexasHoldem;
import com.thunderstick.pocker.texasholdem.IDeck;
import com.thunderstick.pocker.texasholdem.IPlayer;
import com.thunderstick.pocker.texasholdem.Player;
import com.thunderstick.pocker.texasholdem.RankingEnum;
import java.awt.Dialog;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.swing.JOptionPane;

public class SinglePlayerScreenController implements Initializable {

    @FXML
    Button btnStart;

    //Images Deck
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

    //player cards
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

    //PlayerModel
    PlayerGameInfo p1;
    PlayerGameInfo p2;
    PlayerGameInfo p3;
    PlayerGameInfo p4;

    //Lables Messages
    @FXML
    Label p1message;
    @FXML
    Label p2message;
    @FXML
    Label p3message;
    @FXML
    Label p4message;

    //Names
    @FXML
    Label p1Name;
    @FXML
    Label p2Name;
    @FXML
    Label p3Name;
    @FXML
    Label p4Name;

  //Lable Coins
    @FXML
    Label p1coins;
    @FXML
    Label p2coins;
    @FXML
    Label p3coins;
    @FXML
    Label p4coins;

  //Button
    @FXML
    Button btnCheck;

    int coinsDeck;

    @FXML
    TextField txtp1bet;

    GameTexasHoldem game;
    IPlayer player1 = new Player();
    IPlayer player2 = new Player();
    IPlayer player3 = new Player();
    IPlayer player4 = new Player();

    //Game Barriers
    boolean p1Live, p2Live, p3Live, p4Live;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        p1 = new PlayerGameInfo(200, true);
        p2 = new PlayerGameInfo(200, true);
        p3 = new PlayerGameInfo(200, true);
        p4 = new PlayerGameInfo(200, true);

        p1message.setText("");
        p2message.setText("");
        p3message.setText("");
        p4message.setText("");

        p1Name.setText("Player1");
        p2Name.setText("Player2");
        p3Name.setText("Player3");
        p4Name.setText("Player4");

        coinsinit();
    }

    public void btnCheckclick(ActionEvent e) {

        hideP2Cards();
        hideP3Cards();
        hideP4Cards();
        
        int p1c, p2c, p3c, p4c;
        p1c = Integer.parseInt(p1coins.getText());
        p2c = Integer.parseInt(p2coins.getText());
        p3c = Integer.parseInt(p3coins.getText());
        p4c = Integer.parseInt(p4coins.getText());

        coinsinit();

        if (p1c == 0) {
            p1message.setText("out");
        }
        if (p2c == 0) {
            p2message.setText("out");
        }
        if (p3c == 0) {
            p3message.setText("out");
        }
        if (p4c == 0) {
            p4message.setText("out");
        }

        p1message.setText(p1c + "out");

       // getWinnerPlayer();
        p1message.setText("");
        p2message.setText("");
        p3message.setText("");
        p4message.setText("");

        game = new GameTexasHoldem();
        player1 = new Player();
        player2 = new Player();
        player3 = new Player();
        player4 = new Player();

        IDeck deck = new Deck();
        game.newGame(deck, player1, player2, player3, player4);

        game.deal();
        game.callFlop();
        game.betRiver();
        game.betTurn();

        //set Deck cards
        setDeckCards(game);

        showPlayer1Cards(player1);
    }

    public void btnStartclick(ActionEvent e) {

        int p1Coins = Integer.parseInt(txtp1bet.getText());

        int p2Coins = p1Coins;
        int p3Coins = p1Coins;
        int p4Coins = p1Coins;

        coinsDeck = p1Coins + p2Coins + p3Coins + p4Coins;

        p1.updateCoins(p1Coins);
        p2.updateCoins(p2Coins);
        p3.updateCoins(p3Coins);
        p4.updateCoins(p4Coins);

       

        showPlayer2Cards(player2);
        showPlayer3Cards(player3);
        showPlayer4Cards(player4);
        
        getWinnerPlayer();
    }

    public void printRank(IPlayer pN, String name) {
        RankingEnum re = pN.getRankingEnum();
        // System.out.println(name+"have "+re);
    }



    public void setDeckCards(GameTexasHoldem game) {
        //System.out.println("Table cards : .............................");
        List<Card> c = game.getTableCards();

        for (int i = 0; i <= c.size() - 1; i++) {

          //  System.out.println(c.get(i));
        }

        deckc1.setImage(new Image("/Resources/" + c.get(0) + ".png"));
        deckc2.setImage(new Image("/Resources/" + c.get(1) + ".png"));
        deckc3.setImage(new Image("/Resources/" + c.get(2) + ".png"));
        deckc4.setImage(new Image("/Resources/" + c.get(3) + ".png"));
        deckc5.setImage(new Image("/Resources/" + c.get(4) + ".png"));

    }

    public void showPlayer1Cards(IPlayer name) {

        List<Card> card = name.getRankingList();
        p1c1.setImage(new Image("/Resources/" + card.get(0) + ".png"));
        p1c2.setImage(new Image("/Resources/" + card.get(0) + ".png"));

    }

    public void showPlayer2Cards(IPlayer name) {

        List<Card> card = name.getRankingList();
        p2c1.setImage(new Image("/Resources/" + card.get(0) + ".png"));
        p2c2.setImage(new Image("/Resources/" + card.get(0) + ".png"));
    }

    public void showPlayer3Cards(IPlayer name) {

        List<Card> card = name.getRankingList();
        p3c1.setImage(new Image("/Resources/" + card.get(0) + ".png"));
        p3c2.setImage(new Image("/Resources/" + card.get(0) + ".png"));
    }

    public void showPlayer4Cards(IPlayer name) {

        List<Card> card = name.getRankingList();
        p4c1.setImage(new Image("/Resources/" + card.get(0) + ".png"));
        p4c2.setImage(new Image("/Resources/" + card.get(0) + ".png"));
    }

    public void p1Wins(String by) {
        p1message.setText("winner    :" + by);
        //coinsDeck
        p1.incCoins(coinsDeck);
        p1coins.setText(p1.getCoins() + "");
    }

    public void p2Wins(String by) {
        p2message.setText("winner    :" + by);
        p2.incCoins(coinsDeck);
        p2coins.setText(p2.getCoins() + "");
    }

    public void p3Wins(String by) {
        p3message.setText("winner    :" + by);
        p3.incCoins(coinsDeck);
        p3coins.setText(p3.getCoins() + "");
    }

    public void p4Wins(String by) {
        p4message.setText("winner    :" + by);
        p4.incCoins(coinsDeck);
        p4coins.setText(p4.getCoins() + "");
    }

    public void getWinnerPlayer() {
        List<IPlayer> winnerList = game.getWinner();

        if (winnerList.size() > 1) {

            System.out.println("Draw");

        } else if (winnerList.contains(player1)) {
            RankingEnum re = player1.getRankingEnum();
            p1Wins(re.toString());

        } else if (winnerList.contains(player2)) {
            RankingEnum re = player1.getRankingEnum();
            p2Wins(re.toString());

        } else if (winnerList.contains(player3)) {
            RankingEnum re = player1.getRankingEnum();
            p3Wins(re.toString());

        //System.out.println("player3 wins");
        } else if (winnerList.contains(player4)) {
            RankingEnum re = player1.getRankingEnum();
            p4Wins(re.toString());

        }

        coinsinit();

    }

    private void coinsinit() {
        p1coins.setText(p1.getCoins() + "");
        p2coins.setText(p2.getCoins() + "");
        p3coins.setText(p3.getCoins() + "");
        p4coins.setText(p4.getCoins() + "");
        
        if(p2.getCoins()==0&&p3.getCoins()==0&&p4.getCoins()==0){
            System.out.println("Player one Won");
            JOptionPane.showMessageDialog(null, "Player one Won");
        }
        else if(p1.getCoins()==0&&p3.getCoins()==0&&p4.getCoins()==0){
            System.out.println("Player two Won");
            JOptionPane.showMessageDialog(null, "Player two Won");
        }
        else if(p1.getCoins()==0&&p2.getCoins()==0&&p4.getCoins()==0){
            System.out.println("Player three Won");
            JOptionPane.showMessageDialog(null, "Player three Won");
        }
        else if(p1.getCoins()==0&&p2.getCoins()==0&&p3.getCoins()==0){
            System.out.println("Player four Won");
            JOptionPane.showMessageDialog(null, "Player four Won");
        }

    }

    public void hideP1Cards() {
        p1c1.setImage(null);
        p1c2.setImage(null);
    }

    public void hideP2Cards() {
        p2c1.setImage(null);
        p2c2.setImage(null);
    }

    public void hideP3Cards() {
        p3c1.setImage(null);
        p3c2.setImage(null);
    }

    public void hideP4Cards() {
        p4c1.setImage(null);
        p4c2.setImage(null);
    }

}
