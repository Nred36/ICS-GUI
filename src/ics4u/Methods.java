/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ics4u;

import java.awt.Rectangle;

/**
 *
 * @author naree1878
 */
public class Methods {

    public int[][] counting(int crnd, int count[][], int w, int h) {
        int tempx, tempy;
        for (int i = 0; i < crnd; i++) {//creats the number of images predetimed
            tempx = (int) Math.ceil(Math.random() * (w - 120) + 20);//creats new random x and y
            tempy = (int) Math.ceil(Math.random() * (h - 160) + 50);
            Rectangle r = new Rectangle(tempx, tempy, 100, 100);//creates a rectangle where the new potentional shape will be
            int t = 0;
            for (int c = 0; c < i; c++) {//goes through all previous shapes
                if (r.intersects(count[c][0], count[c][1], 100, 100)) {// checks if the new shape whould be to close to an exesting one
                    t = 123;//makes sure next if is false
                    c = 123;//leaves the loop
                }
            }
            if (t != 123) {//there is no problem with the new shapes postion
                count[i][0] = tempx;//sets the new shapes x and y
                count[i][1] = tempy;
            } else {
                i--;//goes back to the previous iteration
            }
        }
        return (count);
    }

    public void schedule() {
    }
}
