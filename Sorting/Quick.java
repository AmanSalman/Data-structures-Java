
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
public class Quick {
    
    public static void QuickSort (int a[],int S,int E){
        int pivot = a[S + (E - S)/2];
        int L = S;
        int R = E;
        
        while ( L <= R ){
            while (a[L]<pivot){
                L++;
            }
            while (a[R]>pivot){
                R--;
            }
            if(R<L)break;
            swap (a,L++,R--);
        }
        if(S < R){
            QuickSort(a, S, R);
        }
        if(E > L){
            QuickSort(a, L, E);
        }
    }
    
    private static void swap(int[] a, int i, int j) {
        int temp =a[i];
        a[i] = a[j];
        a[j]=temp;
    }
    
    public static void main(String[] args) {
        int a[]={4,1,-1,0,5};
        System.out.println(Arrays.toString(a));
        QuickSort(a, 0, a.length-1);
        System.out.println(Arrays.toString(a));
    }
}
