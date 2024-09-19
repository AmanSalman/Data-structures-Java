
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aman
 */
public class Bubble {
    public static void Bubble (int a[]){
        int n =a.length;
        for(int i=0;i<n-1;i++) {
            for(int j=0;j<n-i-1;j++){
                if(a[j]>a[j+1]){
                    swap(a,i,j+1);
                }
            }
        }
    }
    private static void swap(int[] a, int min, int i) {
        int temp =a[min];
        a[min] = a[i];
        a[i]=temp;
    }
    public static void main(String[] args) {
        int a[] = {1,6,9,3,-1};
        System.out.println(Arrays.toString(a));
        Bubble(a);
        System.out.println(Arrays.toString(a));
    }
}
