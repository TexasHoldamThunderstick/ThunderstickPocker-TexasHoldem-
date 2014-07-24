/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.thunderstick.pocker.Functions;

/**
 *
 * @author tawsoft
 */
public class PlayerInfo {
    String name;
    String imgNo;
    
    PlayerInfo(String n,String im){
        name=n;
        imgNo=im;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgNo() {
        return imgNo;
    }

    public void setImgNo(String imgNo) {
        this.imgNo = imgNo;
    }
    
    
    
}
