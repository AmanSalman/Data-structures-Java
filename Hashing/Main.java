
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aman
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int a[] = {1,2,3,4};
        int res [] = new int [4];
        for(int i=0;i<a.length;i++){
            res[i]=sum(a,i);
        }
        System.out.println(Arrays.toString(res));
        ArrayList<Integer> arr = new  ArrayList<>();
        arr.add(0);
        arr.add(0);
        arr.add(0);
        arr.add(1);
        moveZeros(arr);
    }
    
    public static int sum (int a[],int index){
        int sum =0;
        for(int i=0;i<=index;i++){
            sum+=a[i];
        }
        return sum;
    }
    
    public static void moveZeros (ArrayList <Integer> List){
        int size = List.size() - 1;
        for(int i=0;i<=size;i++){
            if(List.get(i) == 0){
                int temp = List.remove(i);
                List.add(temp);
                
            }i--;
                size--;
        }
        System.out.println(List);
    }
    
}
