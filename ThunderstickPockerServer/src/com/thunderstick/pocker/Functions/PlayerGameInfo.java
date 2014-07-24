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
public class PlayerGameInfo {

    int coins;
    boolean live = true;

    public PlayerGameInfo(int c, boolean status) {
        coins = c;
        live = status;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public boolean updateCoins(int c) {
        if (c > 0) {
            if (coins > c) {
                coins = coins - c;
            } else {
                coins = 0;
                live = false;
            }
            return true;
        } else {
            live = false;
            return false; //player is out
        }

    }

    public void incCoins(int c) {
       if (coins > 0) {
            coins = coins + c;
        } else {
            live = false;
            coins=0;
        }
    }
    
  
}
