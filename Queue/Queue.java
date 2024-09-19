/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aman
 */
public interface Queue<T> {
     void enqueue(T value);

     T dequeue();

     String toString();

     T Front();

     T Rear();

     boolean isEmpty();

     void clear();

}
