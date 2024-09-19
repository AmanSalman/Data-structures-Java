package Stack;

public class Stack<T> {
    Node<T> top;

    public Stack() {
        top = null;
    }

    boolean isEmpty() {
        return top == null;

    }

    void push(T val) {
        Node<T> newNode = new Node<>(val);
        newNode.setNext(top);
        top = newNode;
    }

    T pop() {
        if (isEmpty())
            throw new NullPointerException();
        Node<T> temp = top;
        T ret = top.getData();
        temp = temp.getNext();
        top = temp;
        return ret;
    }

    T peek() {
        return top.getData();
    }

    @Override
    public String toString() {
        if (isEmpty())
            return "[ ]";
        StringBuilder str = new StringBuilder("[ ");
        Node<T> curr = top;
        while (curr != null) {
            str.append(curr.getData()).append(",");
            curr = curr.getNext();
        }
        return str.toString().substring(0, str.length() - 1) + "]";
    }

    public static void main(String[] args) {

    }
}