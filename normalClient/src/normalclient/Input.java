/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package normalclient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tawsoft
 */
public class Input implements Runnable{
    DataInputStream in;
    DataOutputStream out;
    
    public Input(DataInputStream in,DataOutputStream out){
        this.in=in;
        this.out=out;
    }
    
    @Override
    public void run() {
        while(true){
            try {
                String message=in.readUTF();
                System.out.println(message);
            } catch (IOException ex) {
                Logger.getLogger(Input.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
}
