/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.thunderstick.pocker.gui;

import com.thunderstick.poker.texasholdem.Card;
import com.thunderstick.poker.texasholdem.Deck;
import com.thunderstick.poker.texasholdem.GameTexasHoldem;
import com.thunderstick.poker.texasholdem.IDeck;
import com.thunderstick.poker.texasholdem.IPlayer;
import com.thunderstick.poker.texasholdem.Player;
import com.thunderstick.poker.texasholdem.RankingEnum;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;


public class SinglePlayerScreenController implements Initializable {

  @FXML
  Button btnStart;
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
    
    public void btnStartclick(ActionEvent e){
        GameTexasHoldem game = new GameTexasHoldem();
        IPlayer Thilina = new Player();
        IPlayer player1 = new Player();
        IPlayer player2 = new Player();
        IPlayer player3 = new Player();
        
        IDeck deck = new Deck();
        game.newGame(deck, Thilina, player1,player2,player3);
        
        game.deal();
        game.callFlop();
        game.betRiver();
        game.betTurn();
        
        List<IPlayer> winnerList = game.getWinner();
    
        System.out.println("Table cards : .............................");
        List<Card> c = game.getTableCards();
        
        for (int i = 0; i <= c.size() - 1; i++) {
            
            System.out.println(c.get(i));
            
        }
        
    if(winnerList.size() > 1){
        
        System.out.println("Draw");
        
        
    } else if(winnerList.contains(Thilina)) {
        
        System.out.println("Thilina wins");
        RankingEnum re = Thilina.getRankingEnum();
        System.out.println("Thilina wins by "+re);
        
        System.out.println("others.............");
        printRank(player1,"player1");
        printRank(player2,"player2");
        printRank(player3,"player3");
        
    } else if(winnerList.contains(player1)) {
        
         System.out.println("player1 wins");
         RankingEnum re = player1.getRankingEnum();
         System.out.println("player1 wins by "+re);
         
          System.out.println("others.............");
        printRank(Thilina,"Thilina");
        printRank(player2,"player2");
        printRank(player3,"player3");
    }
    else if(winnerList.contains(player2)){
        
        System.out.println("player2 wins");
        RankingEnum re = player2.getRankingEnum();
        System.out.println("player2 wins by "+re);
        
         System.out.println("others.............");
         printRank(Thilina,"Thilina");
        printRank(player1,"player1");
        printRank(player3,"player3");
        
    }
    else if(winnerList.contains(player3)){
        
        System.out.println("player3 wins");
        RankingEnum re = player3.getRankingEnum();
        System.out.println("player3 wins by "+re);
        
         System.out.println("others.............");
         printRank(Thilina,"Thilina");
        printRank(player1,"player1");
        printRank(player2,"player2");
    }
    
    }
    
    
    public void printRank(IPlayer pN,String name){
        RankingEnum re = pN.getRankingEnum();
        System.out.println(name+"have "+re);
    }
}
