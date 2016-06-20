/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ics4u;

import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author naree1878
 */
public class Methods {

    public int[][] counting(int crnd, int count[][], int w, int h) {
        int tempx, tempy;
        for (int i = 0; i < crnd; i++) {//creats the number of images predetimed
            tempx = (int) Math.ceil(Math.random() * (w - 140) + 20);//creats new random x and y
            tempy = (int) Math.ceil(Math.random() * (h - 180) + 50);
            Rectangle r = new Rectangle(tempx, tempy, 120, 120);//creates a rectangle where the new potentional shape will be
            int t = 0;
            for (int c = 0; c < i; c++) {//goes through all previous shapes
                if (r.intersects(count[c][0], count[c][1], 120, 120)) {// checks if the new shape whould be to close to an exesting one
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

    public String[][] score(String score[][], int n, int thisT) {
        String temp1 = "", temp2 = "";
        if (thisT != 0) {
            score[n][0] = thisT + "";
            DateFormat dateFormat = new SimpleDateFormat("mm-dd-yyyy hh:mm");//adds the date and time the score was added
            score[n][1] = dateFormat.format(new Date());
            n++;
        }
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                for (int j = 1; j < (n - i); j++) {
                    if (Integer.parseInt(score[j - 1][0]) > Integer.parseInt(score[j][0])) {//sorts the scoreboard using bubble sort
                        temp1 = score[j - 1][0];
                        score[j - 1][0] = score[j][0];
                        score[j][0] = temp1;
                        temp2 = score[j - 1][1];
                        score[j - 1][1] = score[j][1];
                        score[j][1] = temp2;
                    }
                }
            }
        }
        return (score);
    }

    public int num(String[][] score) {//reads the number of scores saved
        int n = 0;
        try {
            FileReader fr = new FileReader("score.txt"); //reads from text file (located in "files")
            BufferedReader br = new BufferedReader(fr);
            for (int r = 0; r < 25; r++) {
                score[r][0] = br.readLine();
                score[r][1] = br.readLine();
                if (score[r][0] == null) {
                    n = r;
                    r = 123;
                }
            }
            br.close();

        } catch (IOException a) {
            System.out.println("Couldn't Load");//if it fails
        }
        return (n);
    }
}
