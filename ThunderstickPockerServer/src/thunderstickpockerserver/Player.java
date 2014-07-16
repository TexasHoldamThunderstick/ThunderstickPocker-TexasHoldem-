/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package thunderstickpockerserver;

import java.net.Socket;

/**
 *
 * @author tawsoft
 */
public class Player {
    
    String Name;
    String ImageNumber;
    int Coins;
    Socket socketInfo;
    
    public Player(Socket s,String name,String in,int c){
        
        socketInfo=s;
        Name=name;
        Coins=c;
        ImageNumber=in;
        
    }
    
   /*      Functions here    */
    
    public void sayHello(){
        System.out.println("Hello guyz my name is :"+Name);
    }
    public void sayBay(){
        System.out.println(Name+"   Says Bayyyyy");
    }
    
}
