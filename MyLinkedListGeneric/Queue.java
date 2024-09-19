
public class Queue<T> extends MyLinkedListGeneric<T> {

    void enqueue(T value) {
        this.addLast(value);
    }

    T dequeue() {
        return this.removeFirst();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    T Front() {
        return this.GetFirst();
    }

    T Rear() {
        return this.GetLast();
    }

    @Override
    public boolean isEmpty() {
        return this.isEmpty();
    }

    @Override
    public void clear() {
        super.clear();
    }

    public static void main(String[] args) {
        Queue<Integer> Q = new Queue<>();
        System.out.println(6 % 7);
        // Q.enqueue(6);
        // Q.enqueue(7);
        // Q.enqueue(9);
        // Q.enqueue(10);
        // System.out.println(Q);
        // System.out.println(Q.Front());
        // System.out.println(Q.Rare());
    }
}
