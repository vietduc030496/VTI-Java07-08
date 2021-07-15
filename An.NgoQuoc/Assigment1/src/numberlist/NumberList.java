/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numberlist;

import java.util.Scanner;

/**
 *
 * @author an.ngoquoc
 */
public class NumberList {
    private int[] arr;
    private int n;

    public NumberList(int[] arr, int n) {
        this.arr = arr;
        this.n = n;
    }

    public int[] input(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập phần từ của mảng:");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        return arr;
    }
     public void printf(){
        for(int i=0;i<n;i++){
             System.out.print(arr[i] + " ");
        }
         System.out.print("\n");
     }

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
    
}
