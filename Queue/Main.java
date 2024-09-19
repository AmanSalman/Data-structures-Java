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
import static java.util.Collections.list;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Queue <Integer> MyQueue = new MyLinkedList<>();
        // MyQueue.enqueue(5);
        // MyQueue.enqueue(8);
        // MyQueue.enqueue(9);
        // MyQueue.enqueue(20);
        // MyQueue.enqueue(59);
        // System.out.println(MyQueue);
        // System.out.println(MyQueue.Front());
        // System.out.println(MyQueue.Rear());
        Deque<Integer> D = new LinkedList<>();
        D.add(9);
        D.add(6);
        System.out.println(D);

    }

}
