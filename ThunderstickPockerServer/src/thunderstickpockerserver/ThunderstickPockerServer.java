/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package thunderstickpockerserver;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author tawsoft
 */
public class ThunderstickPockerServer {

    static int users=1;
    static String userNo="";
    static boolean registerAllowed=true;
    

    
    public static void main(String[] args) {
   
        try{
            final int PORT=444;
            ServerSocket SERVER=new ServerSocket(PORT);
            
            System.out.println("Waiting for clients...");
            
            while(true){
               Socket SOCK=SERVER.accept();
               
               //allow only 4  players
               if(registerAllowed){
                    if(users==1){
                        userNo="player1";
                        registerAllowed=true;
                        users++;
                      
                        Player pla=new Player(SOCK, userNo, userNo, 200);
                        Thread X=new Thread(pla);
                        X.start();
                    }
                   else if(users==2){
                        userNo="player2";
                        registerAllowed=true;
                        users++;
                        Player pla=new Player(SOCK, userNo, userNo, 200);
                        Thread X=new Thread(pla);
                        X.start();
                    }
                    else if(users==3){
                        userNo="player3";
                        registerAllowed=true;
                        users++;
                        Player pla=new Player(SOCK, userNo, userNo, 200);
                        Thread X=new Thread(pla);
                        X.start();
                    }
                    else if(users==4){
                        userNo="player4";
                        registerAllowed=true;
                        users++;
                        Player pla=new Player(SOCK, userNo, userNo, 200);
                        Thread X=new Thread(pla);
                        X.start();
                    }
                    else{
                        userNo="error";
                        registerAllowed=false;
                        System.out.println("No more players");
                       DataOutputStream out=new DataOutputStream((SOCK.getOutputStream()));
                       out.writeUTF("no more users");
                    }
               }
              
               
            }
        }
          catch(Exception e)
        {
            System.out.println(e+"hi");
        }
           
    }
    
}
