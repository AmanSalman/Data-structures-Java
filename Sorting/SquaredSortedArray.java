
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
public class SquaredSortedArray {
    public /*int[]*/ static void sortedSquares(int[] nums) {
        int res[]=new int [nums.length];
        int left = 0,right = nums.length-1;
         for(int i=nums.length-1;i>=0;i--){
           if(Math.abs(nums[left])>nums[right]){
               res[i]=nums[left]*nums[left];
               left++;
           }
           else if(Math.abs(nums[left])<nums[right]){
               res[i]=nums[right]*nums[right];
               right--;
           }
        }
         System.out.println(Arrays.toString(res));
       // Arrays.sort(nums);
        //return nums;
    }
    public static void main(String[] args) {
        int num[]={-4,-1,0,3,10};
        sortedSquares(num);
    }
}
