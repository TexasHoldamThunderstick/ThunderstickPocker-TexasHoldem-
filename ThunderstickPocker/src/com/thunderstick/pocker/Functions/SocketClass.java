/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.thunderstick.pocker.Functions;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 *
 * @author tawsoft
 */
public class SocketClass {
    
    static Socket socket;
    static DataInputStream in;
    static DataOutputStream out;

    public static Socket getSocket() {
        return socket;
    }

    public static void setSocket(Socket socket) {
        
        SocketClass.socket = socket;
    }

    public static DataInputStream getIn() {
        return in;
    }

    public static void setIn(DataInputStream in) {
        SocketClass.in = in;
    }

    public static DataOutputStream getOut() {
        return out;
    }

    public static void setOut(DataOutputStream out) {
        SocketClass.out = out;
    }
    
    
    
    
}
