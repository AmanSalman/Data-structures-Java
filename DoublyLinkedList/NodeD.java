package DoublyLinkedList;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aman
 */
public class NodeD<T> {
    private T Data;
    NodeD<T> next;
    NodeD<T> pre;

    public NodeD(T Data) {
        this.Data = Data;
    }

    public T getData() {
        return Data;
    }

    public void setData(T Data) {
        this.Data = Data;
    }

}
