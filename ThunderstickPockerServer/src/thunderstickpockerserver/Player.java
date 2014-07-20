/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thunderstickpockerserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tawsoft
 */
public class Player {

    String Name;
    String ImageNumber;
    int Coins;
    Socket socketInfo;
    

     DataInputStream inp;
     DataOutputStream out;
    
    String MESSAGE="";

    public Player(Socket s, String name, String in, int c) {

        socketInfo = s;
        Name = name;
        Coins = c;
        ImageNumber = in;
        try {
            inp=new DataInputStream((socketInfo.getInputStream()));
            out=new DataOutputStream((socketInfo.getOutputStream()));
        } catch (IOException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    

    /*      Functions here    */
    public void sayHello() throws IOException {
        System.out.println("Hello guyz my name is :" + Name);
        out.writeUTF(("function Hello done"));
    }

    public void sayBay() throws IOException {
        System.out.println(Name + "   Says Bayyyyy");
        out.writeUTF(("function Bay done"));
    }
    
    public void getName() throws IOException{
        out.writeUTF((Name.toString()));
    }

    public void getCoins() throws IOException{
        out.writeUTF((Coins+""));
        Coins=Coins-100;
    }
    
    public DataInputStream getDataInputStream(){
        
        return inp;
    }
    
     public DataOutputStream getDataOutputStream(){
         
        return out;
    }

}
