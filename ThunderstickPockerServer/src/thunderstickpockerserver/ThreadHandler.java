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
public class ThreadHandler implements Runnable {

    //Players say check
    static String p1Says = "";
    static String p2Says = "";
    static String p3Says = "";
    static String p4Says = "";

    //Rounds
    static boolean P1Round = true, P2Round = false, P3Round = false, P4Round = false;

    String mapName;
    Player pl;

    DataInputStream inp;
    DataOutputStream out;

    static boolean p1 = true, p2 = true, p3 = true, p4 = true;

    static boolean gameNotExit = true;

    public ThreadHandler(Player pla, String na) {
        pl = pla;
        mapName = na;

    }

    @Override
    public void run() {
        while (true) {

            //Start region player 1
            if (mapName.contains("player1")) {

                Player pla = (Player) ThunderstickPockerServer.hm.get("player1");
                inp = pla.getDataInputStream();
                out = pla.getDataOutputStream();

                while (true) {
                    
                    try {
                        String says = inp.readUTF();

                        if (says.contains("check")) {
                            p1Says = "check";
                            if (P1Round) {
                                String bet = inp.readUTF();
                                Board.setBet(bet);
                            }
                            P1Round = false;
                            P2Round = true;
                        }

                    } catch (IOException ex) {
                        Logger.getLogger(ThreadHandler.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            }
            //End region player 1   

            //Start region player 2
            if (mapName.contains("player2")) {

                Player pla = (Player) ThunderstickPockerServer.hm.get("player2");
                inp = pla.getDataInputStream();
                out = pla.getDataOutputStream();

                while (true) {
                   
                    try {
                        String says = inp.readUTF();

                        if (says.contains("check")) {
                            p2Says = "check";
                            
                            if (P2Round) {
                                String bet = inp.readUTF();
                                Board.setBet(bet);
                            }
                            P2Round = false;
                            P3Round = true;

                        } 

                    } catch (IOException ex) {
                        Logger.getLogger(ThreadHandler.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
            //End region player 2

            //Start region player 3
            if (mapName.contains("player3")) {

                Player pla = (Player) ThunderstickPockerServer.hm.get("player3");
                inp = pla.getDataInputStream();
                out = pla.getDataOutputStream();

                while (true) {
                    
                    try {
                        String says = inp.readUTF();

                        if (says.contains("check")) {
                            p3Says = "check";
                            if (P3Round) {
                                String bet = inp.readUTF();
                                Board.setBet(bet);
                            }
                            P3Round = false;
                            P4Round = true;
                        } 
                    } catch (IOException ex) {
                        Logger.getLogger(ThreadHandler.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
            //End region player 3 

            //Start region player 4
            if (mapName.contains("player4")) {

                Player pla = (Player) ThunderstickPockerServer.hm.get("player4");
                inp = pla.getDataInputStream();
                out = pla.getDataOutputStream();

                while (true) {
                  
                    try {
                        String says = inp.readUTF();

                        if (says.contains("check")) {
                            p4Says = "check";
                            if (P4Round) {
                                String bet = inp.readUTF();
                                Board.setBet(bet);
                            }
                            P4Round = false;
                            P1Round = true;
                        } 

                    } catch (IOException ex) {
                        Logger.getLogger(ThreadHandler.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
            //End region player 3 

        }

    }

}
