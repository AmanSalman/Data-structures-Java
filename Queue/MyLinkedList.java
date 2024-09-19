import Stack.Node;

public class MyLinkedList<T> implements Queue<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    public T GetFirst() {
        if (head != null) {
            return head.getData();
        }
        return null;
    }

    public T GetLast() {
        if (tail != null) {
            return tail.getData();
        }
        return null;
    }

    public int size() {
        return size;
    }

    public void clear() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public int indexOf(T data) {
        Node<T> temp = head;
        for (int i = 0; i < size; i++) {
            if (temp.getData().equals(data)) {
                return i;
            }
            temp = temp.getNext();
        }
        return -1;
    }

    @Override
    public String toString() {

        String Str = "";
        Node curr = head;
        while (curr != null) {
            Str += curr.getData() + ",";
            curr = curr.getNext();
        }
        if (head != null)
            return "[" + Str.subSequence(0, Str.length() - 1) + "]";
        else
            return "[" + "]";
    }

    public void addLast(T data) {
        Node<T> temp = new Node<>(data);
        if (head == null) {
            head = tail = temp;
        } else {
            tail.setNext(temp);
            tail = temp;
        }
        size++;
    }

    public T removeFirst() {
        T Data = head.getData();
        if (head == null) {
            throw new NullPointerException();
        } else {
            head = head.getNext();
        }
        size--;
        return Data;
    }

    private T get(int index) {
        if (index < 0 || index >= size) {
            throw new NullPointerException();
        }
        Node<T> curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.getNext();
        }
        return curr.getData();
    }

    @Override
    public void enqueue(T value) {
        addLast(value);
    }

    @Override
    public T dequeue() {
        return removeFirst();
    }

    @Override
    public T Front() {
        return GetFirst();
    }

    @Override
    public T Rear() {
        return GetLast();
    }
}