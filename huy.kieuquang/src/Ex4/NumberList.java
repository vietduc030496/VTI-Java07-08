/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex4;

import java.util.Scanner;

/**
 *
 * @author kieuq
 */
public class NumberList {
    public void input(int list[], int n){
        Scanner sc = new Scanner(System.in);

        for(int i=0; i<n; i++){
            list[i] = sc.nextInt();
        }
    }
    
    public void print(int list[]){
        for (int x : list) {
            System.out.print(x+" ");
        }
        System.out.println("");
    }
    
    public int[] NumberList(int n){
        int list[] = new int[n];
        return list;
    }
    
}

class run{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NumberList nl = new NumberList();
        
        System.out.print("Nhap so ptu: ");
        int n = Integer.parseInt(sc.nextLine());
        
        int list[] = nl.NumberList(n);
        nl.input(list, n);
        nl.print(list);
    }
}
