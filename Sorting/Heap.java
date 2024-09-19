
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
public class Heap {

    
    static int HeapSize;
    static int a[]= {5,10,8,13,0,22,4,36,200};
    
    public static void sort (){
        sort(a);
    }
    private static void sort (int a[]){
        BuildHeap (a);
        for(int i=HeapSize;i>0;i--){
            swap(a, 0, i);
            HeapSize--;
            heapify(a, 0);
        }
        System.out.println(Arrays.toString(a));
    }
    
    private static void BuildHeap(int[] a) {
        HeapSize = a.length -1;
        int LastParent = a.length/2 -1;
        for(int i=LastParent;i>=0;i--){
            heapify(a,i);
        }
    }

    private static void heapify(int[] a, int i) {
        int L = i*2 +1;
        int R = i*2 +2;
        int max = i;
        if(L<=HeapSize && a[L]>a[max]){
            max = L;
        }
        if(R<=HeapSize && a[R]>a[max]){
            max = R;
        }
        if(i != max){
            swap(a,i,max);
            heapify(a, max);
        }   
    }
    private static void swap(int[] a, int i, int max) {
        int temp = a[i];
        a[i] = a[max];
        a[max] = temp;
    }
    
    public static void main(String[] args) {
        int arr[]={6, 3, 2, 10, 8, 1, 11, 7, 5, 4, 9};
        System.out.println(arr.length);
        sort(arr);
    }
}
