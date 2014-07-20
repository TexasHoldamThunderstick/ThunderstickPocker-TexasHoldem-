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

    boolean p1=true, p2=true, p3=true, p4=true;

    public ThreadHandler(Player pla, String na) {
        pl = pla;
        mapName = na;
    }

    @Override
    public void run() {
        while (true) {

            if (mapName.contains("player1")) {
                 Player pla = (Player) ThunderstickPockerServer.hm.get("player1");
                    inp = pla.getDataInputStream();
                    out = pla.getDataOutputStream();
               
                    while (true) {

                        if(p1){
                        try {

                            String Message = inp.readUTF();

                            if (Message.contains("fold")) {

                                System.out.println(pla.Name + " is out");
                                out.writeUTF("you are out");
                                p1 = false;

                            }
                            else if(Message.contains("raise")){
                                System.out.println(pla.Name + " is raised");
                                out.writeUTF("you have raise");
                            }
                            else if(Message.contains("check")){
                                System.out.println(pla.Name + " said check");
                                out.writeUTF("you have checked");
                            }
                            else{
                                System.out.println("no idea");
                                out.writeUTF("no idea");
                            }
                        } catch (IOException ex) {
                            System.out.println(ex.toString());
                        }
                        }
                        else{
                            try {
                               
                                out.writeUTF("you are out wait");
                            } catch (IOException ex) {
                                Logger.getLogger(ThreadHandler.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }

                    }
              
            } else if (mapName.contains("player2")) {
                Player pla = (Player) ThunderstickPockerServer.hm.get("player2");
                    inp = pla.getDataInputStream();
                    out = pla.getDataOutputStream();
               
                    while (true) {

                        if(p2){
                        try {

                            String Message = inp.readUTF();

                            if (Message.contains("fold")) {

                                System.out.println(pla.Name + " is out");
                                out.writeUTF("you are out");
                                p2 = false;

                            }
                            else if(Message.contains("raise")){
                                System.out.println(pla.Name + " is raised");
                                out.writeUTF("you have raise");
                            }
                            else if(Message.contains("check")){
                                System.out.println(pla.Name + " said check");
                                out.writeUTF("you have check");
                            }
                            else{
                                System.out.println("no idea");
                                out.writeUTF("no idea");
                            }
                        } catch (IOException ex) {
                            System.out.println(ex.toString());
                        }
                        }
                        else{
                            try {
                               
                                out.writeUTF("you are out wait");
                            } catch (IOException ex) {
                                Logger.getLogger(ThreadHandler.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }

                    }
            } else if (mapName.contains("player3")) {
              Player pla = (Player) ThunderstickPockerServer.hm.get("player3");
                    inp = pla.getDataInputStream();
                    out = pla.getDataOutputStream();
               
                    while (true) {

                        if(p3){
                        try {

                            String Message = inp.readUTF();

                            if (Message.contains("fold")) {

                                System.out.println(pla.Name + " is out");
                                out.writeUTF("you are out");
                                p3 = false;

                            }
                            else if(Message.contains("raise")){
                                System.out.println(pla.Name + " is raised");
                                out.writeUTF("you have raise");
                            }
                            else if(Message.contains("check")){
                                System.out.println(pla.Name + " said check");
                                out.writeUTF("you have check");
                            }
                            else{
                                System.out.println("no idea");
                                out.writeUTF("no idea");
                            }
                        } catch (IOException ex) {
                            System.out.println(ex.toString());
                        }
                        }
                        else{
                            try {
                               
                                out.writeUTF("you are out wait");
                            } catch (IOException ex) {
                                Logger.getLogger(ThreadHandler.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }

                    }
            } else {
               Player pla = (Player) ThunderstickPockerServer.hm.get("player4");
                    inp = pla.getDataInputStream();
                    out = pla.getDataOutputStream();
               
                    while (true) {

                        if(p4){
                        try {

                            String Message = inp.readUTF();

                            if (Message.contains("fold")) {

                                System.out.println(pla.Name + " is out");
                                out.writeUTF("you are out");
                                p4 = false;

                            }
                            else if(Message.contains("raise")){
                                System.out.println(pla.Name + " is raised");
                                out.writeUTF("you have raise");
                            }
                            else if(Message.contains("check")){
                                System.out.println(pla.Name + " said check");
                                out.writeUTF("you have checked");
                            }
                            else{
                                System.out.println("no idea");
                                out.writeUTF("no idea");
                            }
                        } catch (IOException ex) {
                            System.out.println(ex.toString());
                        }
                        }
                        else{
                            try {
                               
                                out.writeUTF("you are out wait");
                            } catch (IOException ex) {
                                Logger.getLogger(ThreadHandler.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }

                    }
            }

        }

    }

}
