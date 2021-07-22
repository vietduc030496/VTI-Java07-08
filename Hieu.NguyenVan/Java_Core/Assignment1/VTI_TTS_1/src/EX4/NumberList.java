/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EX4;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author hieu.nguyenvan1
 */
public class NumberList {
    protected int[] array;

    public NumberList(int[] array) {
        this.array = array;
    }

    
    public NumberList(int n) {
        array=new int[n];
        Random random=new Random();
        for(int i=0;i<n;i++){
            array[i]=random.nextInt(100);
            System.out.println(array[i]);
        }
        System.out.println("-------");
          
    }
    
    public void input(){
        Scanner scanner=new Scanner(System.in);
        for(int i=0;i<this.array.length-1;i++){
            int inputNumber=scanner.nextInt();
            this.array[i]=inputNumber;
        }
    }
    public void print(){
        for(int i=0;i<this.array.length;i++){
            System.out.println(array[i]+" ");
        }
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] newArray) {
        for(int i=0;i<array.length;i++){
            this.array[i]=newArray[i];
        }
    }
    
}
