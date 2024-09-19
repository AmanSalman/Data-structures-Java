
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
public class Selection {
    public static void Selection (int a[]){
        int n=a.length;
        int min;
        for(int i=0;i<n-1;i++){
            min=i;
            for(int j=i+1;j<n;j++){
                if(a[j]<a[min]){
                    min=j;
                }
            }
            swap (a,min,i);
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
        Selection(a);
        System.out.println(Arrays.toString(a));
    }
}
