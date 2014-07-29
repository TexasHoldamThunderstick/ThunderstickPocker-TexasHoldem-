/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thunderstickpockerserver;

import com.thunderstick.pocker.Functions.Board;
import com.thunderstick.pocker.texasholdem.Card;
import com.thunderstick.pocker.texasholdem.Deck;
import com.thunderstick.pocker.texasholdem.GameTexasHoldem;
import com.thunderstick.pocker.texasholdem.IDeck;
import com.thunderstick.pocker.texasholdem.IPlayer;
import com.thunderstick.pocker.texasholdem.RankingEnum;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tawsoft
 */
public class Distributer implements Runnable {

    DataInputStream inp;
    DataOutputStream out;

    boolean NotStart = true;

    GameTexasHoldem game;

    IPlayer player1;
    IPlayer player2;
    IPlayer player3;
    IPlayer player4;

    Distributer() {
        game = new GameTexasHoldem();

        player1 = new com.thunderstick.pocker.texasholdem.Player();
        player2 = new com.thunderstick.pocker.texasholdem.Player();
        player3 = new com.thunderstick.pocker.texasholdem.Player();
        player4 = new com.thunderstick.pocker.texasholdem.Player();

    }

    @Override
    public void run() {

        Player p1,p2,p3,p4;
        
        while (NotStart) {

            if (ThreadHandler.p1Says.contains("check") && ThreadHandler.p2Says.contains("check") && ThreadHandler.p3Says.contains("check") && ThreadHandler.p4Says.contains("check")) {

                 //players
                            p1 = (Player) ThunderstickPockerServer.hm.get("player1");
                            p2 = (Player) ThunderstickPockerServer.hm.get("player2");
                            p3 = (Player) ThunderstickPockerServer.hm.get("player3");
                            p4 = (Player) ThunderstickPockerServer.hm.get("player4");
                            
                if (ThunderstickPockerServer.hm.size() == 4) {

                    while (true) {

                        if (ThreadHandler.p1Says.contains("check") && ThreadHandler.p2Says.contains("check") && ThreadHandler.p3Says.contains("check") && ThreadHandler.p4Says.contains("check")) {

                            int bet=Board.getBet();
                            
                          
                            
                            
                            ThreadHandler.p1Says = "";
                            ThreadHandler.p2Says = "";
                            ThreadHandler.p3Says = "";
                            ThreadHandler.p4Says = "";

                           

                            System.out.println("done Gathering Players all said check");
                            NotStart = false;
                            NewGames();

                            String[] c1, c2, c3, c4, Deck;

                            Deck = getDeck();

                            Player pla1 = (Player) ThunderstickPockerServer.hm.get("player1");
                            inp = pla1.getDataInputStream();
                            out = pla1.getDataOutputStream();

                            c1 = getP1Cards();
                            c2 = getP2Cards();
                            c3 = getP3Cards();
                            c4 = getP4Cards();

                            try {

                                //bet
                                out.writeUTF(bet+"");
                     

                                
                                out.writeUTF(c1[0]);
                                out.writeUTF(c1[1]);

                                out.writeUTF(c2[0]);
                                out.writeUTF(c2[1]);

                                out.writeUTF(c3[0]);
                                out.writeUTF(c3[1]);

                                out.writeUTF(c4[0]);
                                out.writeUTF(c4[1]);

                                //Print Deck
                                out.writeUTF(Deck[0]);
                                out.writeUTF(Deck[1]);
                                out.writeUTF(Deck[2]);
                                out.writeUTF(Deck[3]);
                                out.writeUTF(Deck[4]);

                                String win = winnerPlayer();

                                out.writeUTF(win);

                                RankingEnum re = null;
                                if (win.contains("player1")) {
                                    re = player1.getRankingEnum();
                                   
                                } else if (win.contains("player2")) {
                                    re = player2.getRankingEnum();
                                  
                                } else if (win.contains("player3")) {
                                    re = player3.getRankingEnum();
                                   
                                } else if (win.contains("player4")) {
                                   
                                    re = player4.getRankingEnum();
                                }
                                out.writeUTF(re.toString());
                                
                            

                            } catch (IOException ex) {

                            }

                            //player 2
                            Player pla2 = (Player) ThunderstickPockerServer.hm.get("player2");
                            inp = pla2.getDataInputStream();
                            out = pla2.getDataOutputStream();

                            c1 = getP2Cards();
                            c2 = getP1Cards();
                            c3 = getP3Cards();
                            c4 = getP4Cards();

                            try {
                                
                                //bet
                                out.writeUTF(bet+"");
                                
                                
                                out.writeUTF(c1[0]);
                                out.writeUTF(c1[1]);

                                out.writeUTF(c2[0]);
                                out.writeUTF(c2[1]);

                                out.writeUTF(c3[0]);
                                out.writeUTF(c3[1]);

                                out.writeUTF(c4[0]);
                                out.writeUTF(c4[1]);

                                //Print Deck
                                out.writeUTF(Deck[0]);
                                out.writeUTF(Deck[1]);
                                out.writeUTF(Deck[2]);
                                out.writeUTF(Deck[3]);
                                out.writeUTF(Deck[4]);

                                String win = winnerPlayer();

                                out.writeUTF(win);

                                RankingEnum re = null;
                                if (win.contains("player1")) {
                                    re = player1.getRankingEnum();
                                    
                                } else if (win.contains("player2")) {
                                    re = player2.getRankingEnum();
                                    
                                } else if (win.contains("player3")) {
                                    re = player3.getRankingEnum();
                                   
                                } else if (win.contains("player4")) {
                                    re = player4.getRankingEnum();
                                    
                                }
                                out.writeUTF(re.toString());
                                
                                
                         
                                
                            } catch (IOException ex) {

                            }

                            //player 3
                            Player pla3 = (Player) ThunderstickPockerServer.hm.get("player3");
                            inp = pla3.getDataInputStream();
                            out = pla3.getDataOutputStream();

                            c1 = getP3Cards();
                            c2 = getP1Cards();
                            c3 = getP2Cards();
                            c4 = getP4Cards();

                            try {
                                 //bet
                                out.writeUTF(bet+"");

                                out.writeUTF(c1[0]);
                                out.writeUTF(c1[1]);

                                out.writeUTF(c2[0]);
                                out.writeUTF(c2[1]);

                                out.writeUTF(c3[0]);
                                out.writeUTF(c3[1]);

                                out.writeUTF(c4[0]);
                                out.writeUTF(c4[1]);

                                //Print Deck
                                out.writeUTF(Deck[0]);
                                out.writeUTF(Deck[1]);
                                out.writeUTF(Deck[2]);
                                out.writeUTF(Deck[3]);
                                out.writeUTF(Deck[4]);

                                String win = winnerPlayer();

                                out.writeUTF(win);

                                RankingEnum re = null;
                                if (win.contains("player1")) {
                                    re = player1.getRankingEnum();
                                  
                                } else if (win.contains("player2")) {
                                    re = player2.getRankingEnum();
                                  
                                } else if (win.contains("player3")) {
                                    re = player3.getRankingEnum();
                                   
                                } else if (win.contains("player4")) {
                                    re = player4.getRankingEnum();
                                   
                                }
                                out.writeUTF(re.toString());
                                
                              
                                
                            } catch (IOException ex) {

                            }

                            //player 4
                            Player pla4 = (Player) ThunderstickPockerServer.hm.get("player4");
                            inp = pla4.getDataInputStream();
                            out = pla4.getDataOutputStream();

                            c1 = getP4Cards();
                            c2 = getP1Cards();
                            c3 = getP2Cards();
                            c4 = getP3Cards();

                            try {

                             //bet
                                out.writeUTF(bet+"");

                                out.writeUTF(c1[0]);
                                out.writeUTF(c1[1]);

                                out.writeUTF(c2[0]);
                                out.writeUTF(c2[1]);

                                out.writeUTF(c3[0]);
                                out.writeUTF(c3[1]);

                                out.writeUTF(c4[0]);
                                out.writeUTF(c4[1]);

                                //Print Deck
                                out.writeUTF(Deck[0]);
                                out.writeUTF(Deck[1]);
                                out.writeUTF(Deck[2]);
                                out.writeUTF(Deck[3]);
                                out.writeUTF(Deck[4]);

                                String win = winnerPlayer();

                                out.writeUTF(win);

                                RankingEnum re = null;
                                if (win.contains("player1")) {
                                    re = player1.getRankingEnum();
                                   
                                } else if (win.contains("player2")) {
                                    re = player2.getRankingEnum();
                                   
                                } else if (win.contains("player3")) {
                                    re = player3.getRankingEnum();
                                   
                                } else if (win.contains("player4")) {
                                    re = player4.getRankingEnum();
                                
                                }
                                out.writeUTF(re.toString());
                                
                              

                            } catch (IOException ex) {

                            }
                        }

                    }  //end while

                }
            }
        }
    }

    public boolean NewGames() {
        if (ThunderstickPockerServer.hm.size() == 4) {

            game = new GameTexasHoldem();
            IDeck deck = new Deck();

            game.newGame(deck, player1, player2, player3, player4);
            // game.newGame(deck, player1, player2);

            game.deal();
            game.callFlop();
            game.betRiver();
            game.betTurn();

            System.out.println("can play");

            return true;

        } else {

            return false;

        }

    }

    public String[] getP1Cards() {

        Card[] c1 = player1.getCards();
        System.out.println(c1[0]);
        System.out.println(c1[1]);
        String[] asd = {"", ""};

        String[] a = {c1[0].toString(), c1[1].toString()};

        return a;
    }

    public String[] getP2Cards() {

        Card[] c1 = player2.getCards();
        System.out.println(c1[0]);
        System.out.println(c1[1]);
        String[] asd = {"", ""};

        String[] a = {c1[0].toString(), c1[1].toString()};

        return a;
    }

    public String[] getP3Cards() {

        Card[] c1 = player3.getCards();
        System.out.println(c1[0]);
        System.out.println(c1[1]);
        String[] asd = {"", ""};

        String[] a = {c1[0].toString(), c1[1].toString()};

        return a;
    }

    public String[] getP4Cards() {

        Card[] c1 = player4.getCards();
        System.out.println(c1[0]);
        System.out.println(c1[1]);
        String[] asd = {"", ""};

        String[] a = {c1[0].toString(), c1[1].toString()};

        return a;
    }

    public String getWinner() {

        List<IPlayer> winnerList = game.getWinner();
        String winner = "";

        if (winnerList.contains("player1")) {
            winner = "player1";
        } else if (winnerList.contains("player2")) {
            winner = "player2";
        } else if (winnerList.contains("player3")) {
            winner = "player3";
        } else {
            winner = "player4";
        }

        return winner;
    }

    public String[] getDeck() {
        List<Card> c = game.getTableCards();
        String[] crd = {c.get(0).toString(), c.get(1).toString(), c.get(2).toString(), c.get(3).toString(), c.get(4).toString()};

        return crd;
    }

    public String winnerPlayer() {
        String winner = "";

        List<IPlayer> winnerList = game.getWinner();

        if (winnerList.size() > 1) {
            // DRAW GAME
        } else if (winnerList.contains(player1)) {
            winner = "player1";
            //System.out.println("homer wins");
        } else if (winnerList.contains(player2)) {
            winner = "player2";
            //System.out.println("flanders wins");
        } else if (winnerList.contains(player3)) {
            winner = "player3";
            //System.out.println("taw wins");
        } else if (winnerList.contains(player4)) {
            winner = "player4";
            // System.out.println("taw wins");
        }

        return winner;
    }

}
