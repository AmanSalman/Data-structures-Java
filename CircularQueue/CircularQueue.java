package CircularQueue;

import java.util.NoSuchElementException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aman
 */
public class CircularQueue {

    int[] queue = new int[8];
    int Front = -1, Rear = -1;
    int size = 0;

    boolean isFull() {
        return Front == (Rear + 1) % queue.length;
    }

    boolean isEmpty() {
        return Front == -1;
    }

    void enqueue(int value) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        if (Front == -1) {
            Front = 0;
        }
        Rear = (Rear + 1) % queue.length;
        queue[Rear] = value;
        size++;
    }

    int dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        int value = queue[Front];
        if (Front == Rear) {
            Front = Rear = -1;
        } else {
            Front = (Front + 1) % queue.length;
        }
        size--;
        return value;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "Empty Queue [ ]";
        } else {
            String str = "";
            int curr = Front;
            for (int i = 0; i < size; i++) {
                str += "Queue[" + curr + "] = " + queue[curr] + "\n";
                curr = (curr + 1) % queue.length;
            }
            return str;
        }
    }

    public void Print() {
        for (int i = 0; i < size; i++) {
            System.out.print(queue[i] + " ");
        }
    }

    public static void main(String[] args) {
        CircularQueue Q = new CircularQueue();
        Q.enqueue(10);
        Q.enqueue(20);
        Q.enqueue(30);
        Q.enqueue(40);
        Q.enqueue(50);
        Q.enqueue(60);
        Q.enqueue(70);
        Q.enqueue(80);
        Q.dequeue();
        System.out.println(Q);
        Q.Print();

    }
}
