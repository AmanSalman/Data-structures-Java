package StackNorArray;

public class StackNorArray<T> {
    private static final int Capacity = 16;
    private T[] data;
    private int top = -1;

    public StackNorArray() {
        data = (T[]) new Object[Capacity];
    }

    public StackNorArray(int Capacity) {
        data = (T[]) new Object[Capacity];
    }

    public int size() {
        return (top + 1);
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(T value) {
        if (size() == data.length) {
            throw new IllegalStateException("Stack is full");
        }
        data[++top] = value;
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T remove = data[top];
        top--;
        return remove;
    }

    public T peak() {
        if (isEmpty()) {
            return null;
        }
        return data[top];
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < top + 1; i++) {
            str += data[i] + ",";
        }
        if (!this.isEmpty())
            return "[" + str.subSequence(0, str.length() - 1) + "]";
        else
            return "[" + "]";
    }

}
