/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.thunderstick.poker.texasholdem;

import java.util.List;

/**
 *
 * @author tawsoft
 */
public class MainClass {
    
    public static void main(String[] args) {
    GameTexasHoldem game = new GameTexasHoldem();
    
    IPlayer homer = new Player();
    IPlayer flanders = new Player();
    IPlayer taw = new Player();
    IPlayer asd = new Player();
    
    IDeck deck = new Deck();
    
    game.newGame(deck, homer, flanders,taw);
    game.deal();
    game.callFlop();
    game.betRiver();
    game.betTurn();
    
    List<IPlayer> winnerList = game.getWinner();
    
    if(winnerList.size() > 1){
        // DRAW GAME
    } else if(winnerList.contains(homer)) {
        System.out.println("homer wins");
    } else if(winnerList.contains(flanders)) {
         System.out.println("flanders wins");
    }
    else if(winnerList.contains(taw)){
        System.out.println("taw wins");
    }
    
    List<Card> c=game.getTableCards();
    for(int i=0;i<=c.size()-1;i++){
        System.out.println(c.get(i));
    }
    
    System.out.println("..........................");
    RankingEnum re=homer.getRankingEnum();
    System.out.println(re);
    List<Card> c2=flanders.getRankingList();
    
    for(int i=0;i<=c2.size()-1;i++){
        System.out.println(c2.get(i));
    }
    }
}
