/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thunderstickpockerserver;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author tawsoft
 */
public class Player implements Runnable {

    String Name;
    String ImageNumber;
    int Coins;
    Socket socketInfo;

    //to read and send data
    private Scanner INPUT;
    private PrintWriter OUT;
    
    String MESSAGE="";

    public Player(Socket s, String name, String in, int c) {

        socketInfo = s;
        Name = name;
        Coins = c;
        ImageNumber = in;

    }
    
    @Override
    public void run() {
        try {
            try {
                INPUT = new Scanner(socketInfo.getInputStream());
                OUT = new PrintWriter(socketInfo.getOutputStream());
                
                while (true) {
                    //code here
                    if(!INPUT.hasNext()){return;}
                    MESSAGE=INPUT.nextLine();
                    
                    if(MESSAGE.contains("sayHello")){
                        sayHello();
                    }
                    else if(MESSAGE.contains("sayBay")){
                        sayBay();
                    }
                    else{
                        System.out.println("unknown method");
                    }
                    
                }
            } finally {
                socketInfo.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    /*      Functions here    */
    public void sayHello() {
        System.out.println("Hello guyz my name is :" + Name);
    }

    public void sayBay() {
        System.out.println(Name + "   Says Bayyyyy");
    }

    

}
