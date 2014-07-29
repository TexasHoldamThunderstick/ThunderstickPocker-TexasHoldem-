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
public class Board {
    
    static int bet;
    

    public static int getBet() {
        return bet;
    }

    public static void setBet(String be) {
        
        Board.bet = Integer.parseInt(be);
    }

    
    
    
}
