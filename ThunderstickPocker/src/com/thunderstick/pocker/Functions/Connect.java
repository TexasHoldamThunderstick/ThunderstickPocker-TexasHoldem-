/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.thunderstick.pocker.Functions;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tawsoft
 */
public class Connect {
    
    String url;
    int port;
    
    static DataInputStream in;
    static DataOutputStream out;
    
    Socket socket;
    
    public void connectToServer(String server,int port){
        
        try {
            socket=new Socket(server,port);
            System.out.println("Connection successfull.");
            
            in=new DataInputStream((socket.getInputStream()));
            out=new DataOutputStream((socket.getOutputStream()));
            
            
            
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
        
        
      
    }

    public static DataInputStream getIn() {
        return in;
    }

    public static void setIn(DataInputStream in) {
        Connect.in = in;
    }

    public static DataOutputStream getOut() {
        return out;
    }

    public static void setOut(DataOutputStream out) {
        Connect.out = out;
    }
    
}
