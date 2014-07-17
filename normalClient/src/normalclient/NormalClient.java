/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package normalclient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author tawsoft
 */
public class NormalClient {
    
static Socket socket;

Scanner SEND=new Scanner(System.in);

static DataInputStream in;
static DataOutputStream out;


    public static void main(String[] args) throws Exception {
        System.out.println("Connecting...");
        socket=new Socket("localhost",444);
        System.out.println("Connection successfull.");
        
        in=new DataInputStream((socket.getInputStream()));
        out=new DataOutputStream((socket.getOutputStream()));
        
        out.writeUTF("sayHello");
        
        //Scanner sc=new Scanner(System.in);
       // System.out.println("Enter your name and enter");
       // String name=sc.nextLine();
        
        
         Input inp=new Input(in,out);
         Thread thread=new Thread(inp);
         thread.start();
       
       /*  while(true){
             String sendMessage=sc.nextLine();
             out.writeUTF(sendMessage);
         }*/
        
    }
    
}
