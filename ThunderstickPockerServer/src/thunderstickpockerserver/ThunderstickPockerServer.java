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
import java.util.HashMap;
import static jdk.nashorn.internal.objects.NativeArray.map;
import static jdk.nashorn.internal.objects.NativeDebug.map;

/**
 *
 * @author tawsoft
 */
public class ThunderstickPockerServer {

    static int users = 1;
    static String userNo = "";
    static boolean registerAllowed = true;

    public static HashMap hm = new HashMap();

    public ThunderstickPockerServer(){

        try {
            final int PORT = 444;
            ServerSocket SERVER = new ServerSocket(PORT);

            System.out.println("Waiting for clients...");

            Distributer d = new Distributer();
            Thread t3 = new Thread(d);
            t3.start();

            while (true) {

                //allow only 4  players
                if (registerAllowed) {
                    Socket SOCK = SERVER.accept();
                    if (users == 1) {
                        userNo = "player1";
                        registerAllowed = true;
                        users++;

                        Player pla = new Player(SOCK, userNo, userNo, 200);
                        hm.put("player1", pla);
                        
                        ThreadHandler th = new ThreadHandler(pla, userNo);
                        Thread X = new Thread(th);
                        X.start();
                        
                        DataInputStream inp = new DataInputStream(SOCK.getInputStream());
                        DataOutputStream out = new DataOutputStream(SOCK.getOutputStream());
                        out.writeUTF("player1");

                        

                    } else if (users == 2) {
                        userNo = "player2";
                        registerAllowed = true;
                        users++;
                        Player pla = new Player(SOCK, userNo, userNo, 200);
                        hm.put("player2", pla);
                        ThreadHandler th = new ThreadHandler(pla, userNo);
                        Thread X = new Thread(th);
                        X.start();

                        DataInputStream inp = new DataInputStream(SOCK.getInputStream());
                        DataOutputStream out = new DataOutputStream(SOCK.getOutputStream());
                        out.writeUTF("player2");

                        
                    } else if (users == 3) {
                        userNo = "player3";
                        registerAllowed = true;
                        users++;

                        Player pla = new Player(SOCK, userNo, userNo, 200);
                        hm.put("player3", pla);
                        
                        ThreadHandler th = new ThreadHandler(pla, userNo);
                        Thread X = new Thread(th);
                        X.start();

                        DataInputStream inp = new DataInputStream(SOCK.getInputStream());
                        DataOutputStream out = new DataOutputStream(SOCK.getOutputStream());
                        out.writeUTF("player3");

                        
                    } else if (users == 4) {
                        userNo = "player4";
                        registerAllowed = true;
                        users++;
                        Player pla = new Player(SOCK, userNo, userNo, 200);
                        
                           hm.put("player4", pla);
                        
                        ThreadHandler th = new ThreadHandler(pla, userNo);
                        Thread X = new Thread(th);
                        X.start();

                        DataInputStream inp = new DataInputStream(SOCK.getInputStream());
                        DataOutputStream out = new DataOutputStream(SOCK.getOutputStream());
                        out.writeUTF("player4");

                     
                    } else {
                        userNo = "error";
                        registerAllowed = true;
                        System.out.println("No more players");
                        DataOutputStream out = new DataOutputStream((SOCK.getOutputStream()));
                        out.writeUTF("no more users");
                    }
                }

            }
        } catch (Exception e) {
            System.out.println(e);
        }

 
    
}

}
