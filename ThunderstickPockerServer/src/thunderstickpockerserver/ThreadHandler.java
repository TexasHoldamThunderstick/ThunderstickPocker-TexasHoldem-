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

                try {
                    out.writeUTF("player1");
                } catch (IOException ex) {
                    Logger.getLogger(ThreadHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
                while (true) {

                    if (p1) {

                        if (pla.Coins > 0) {
                            try {

                                String Message = inp.readUTF();

                                if (Message.contains("check")) {

                                    
                                    

                                } else if (Message.contains("done")) {
                                    
                                   

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

            }  //End region player 1         
            
               //Start region player 2
            if (mapName.contains("player2")) {
                
                Player pla = (Player) ThunderstickPockerServer.hm.get("player2");
                inp = pla.getDataInputStream();
                out = pla.getDataOutputStream();

                try {
                    out.writeUTF("player2");
                } catch (IOException ex) {
                    Logger.getLogger(ThreadHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
                while (true) {

                    if (p1) {

                        if (pla.Coins > 0) {
                            try {

                                String Message = inp.readUTF();

                                if (Message.contains("check")) {

                                    

                                } else if (Message.contains("done")) {
                                    
                                   

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
             //End region player 3

            //Start region player 3
            if (mapName.contains("player3")) {
                
                Player pla = (Player) ThunderstickPockerServer.hm.get("player3");
                inp = pla.getDataInputStream();
                out = pla.getDataOutputStream();

                try {
                    out.writeUTF("player3");
                } catch (IOException ex) {
                    Logger.getLogger(ThreadHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
                while (true) {

                    if (p1) {

                        if (pla.Coins > 0) {
                            try {

                                String Message = inp.readUTF();

                                if (Message.contains("check")) {

                                    

                                } else if (Message.contains("done")) {
                                    
                                   

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
             //End region player 3
            
            //Start region player 4
            if (mapName.contains("player4")) {
                
                Player pla = (Player) ThunderstickPockerServer.hm.get("player4");
                inp = pla.getDataInputStream();
                out = pla.getDataOutputStream();

                try {
                    out.writeUTF("player4");
                } catch (IOException ex) {
                    Logger.getLogger(ThreadHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
                while (true) {

                    if (p1) {

                        if (pla.Coins > 0) {
                            try {

                                String Message = inp.readUTF();

                                if (Message.contains("check")) {

                                    

                                } else if (Message.contains("done")) {
                                    
                                   

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
             //End region player 4
        }

    }

}
