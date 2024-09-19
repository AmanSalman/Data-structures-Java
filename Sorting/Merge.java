
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
public class Merge {
    private static void Merge (int input[],int a[],int b[]){
        int L = a.length;
        int R = b.length;
        int i=0,j=0,k=0;
        while (i<L && j<R){
            if(a[i]<b[j]){
                input[k++] = a[i++];
            } else {
                input[k++] = b[j++];
            }
        }
        while (j<L){
            input[k++] = b[j++];
        }
        while (i<R){
            input[k++] = a[i++];
        }  
    }
    public static void MergeSort (int input[]){
        if(input.length>1){
            int Mid = input.length/2;
            int left[]=Arrays.copyOfRange(input, 0, Mid);
            int right[]=Arrays.copyOfRange(input, Mid, input.length);
            MergeSort(left);
            MergeSort(right);
            Merge(input, left, right);
        }
    }
    public static void main(String[] args) {
        int a[]={4,6,7,8};
        MergeSort(a);
        System.out.println(Arrays.toString(a));
    }
}
