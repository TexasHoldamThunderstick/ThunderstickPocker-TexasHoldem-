/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thunderstickpockerserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author tawsoft
 */
public class ThreadHandler implements Runnable {

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

                    if (p1) {

                        if (pla.Coins > 0) {
                            try {

                                String Message = inp.readUTF();

                                if (Message.contains("fold")) {

                                    System.out.println(pla.Name + " is out");
                                    out.writeUTF("you are out");
                                    p1 = false;

                                } else if (Message.contains("raise")) {
                                    
                                    System.out.println(pla.Name + " is raised");
                                    
                                    out.writeUTF("you have raise");
                                    
                                } else if (Message.contains("check")) {
                                    
                                    System.out.println(pla.Name + " said check");
                                    
                                    pla.getCoins();
                                    //out.writeUTF("you have checked");
                                }
                                else if(Message.contains("call")){
                                    
                                    System.out.println(pla.Name + " said call");
                                }
                                else {
                                    System.out.println("no idea");
                                    out.writeUTF("no idea");
                                }
                            } catch (IOException ex) {
                                System.out.println(ex.toString());
                            }
                        } else {
                            p1=false;
                        }
                    } else {
                        try {
                            
                            out.writeUTF("you are out wait");
                            
                        } catch (IOException ex) {
                            Logger.getLogger(ThreadHandler.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                }

            } 
            //end region player 1
            
            
            

        }

    }

}
