
import java.io.FileNotFoundException;
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
import java.util.*;
import java.io.FileNotFoundException;
public class Exceptions {
     public static void main(String[] args) throws FileNotFoundException{
//        String str = "Aman";
//        if(str.length()<5){
//            throw new ArithmeticException("Wrong");
//        } else {
//            System.out.println("True");
//        }
//        
//        int N = 10;
//        if(N<20){
//            throw new FileNotFoundException("Error");
//        } else {
//            System.out.println("True");
//        }
//        
        int Arr[]={1,2,3};
         try {
             System.out.println(Arr[1]);
         } catch (Exception e) {
             throw new ArrayIndexOutOfBoundsException("5 index is not found");
         }
        
    }
}
