/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class NumberList {

    private int lengOfList;
    private int[] array;

    public int getLengOfList() {
        return lengOfList;
    }

    public void setLengOfList(int lengOfList) {
        this.lengOfList = lengOfList;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public NumberList(int lengOfList) {
        this.lengOfList = lengOfList;
        this.array = new int[this.lengOfList];
    }

    public void input() {
        if (this.lengOfList > 0) {
            System.out.println("nhap day so:");
            Scanner input = new Scanner(System.in);
            for (int i = 0; i < this.lengOfList; i++) {
                this.array[i] = input.nextInt();
            }
            input.close();
        }

    }

    public void print() {
        if (this.lengOfList > 0) {
            for (int i = 0; i < this.lengOfList; i++) {
                System.out.print(this.array[i] + " ");
            }
            System.out.println();
        }

    }

    public NumberList() {
    }
}
