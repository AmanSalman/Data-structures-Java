
public class MyStackLinked<T> {
    private MyLinkedListGeneric<T> list = new MyLinkedListGeneric<T>();

    public void push(T value) {
        list.addFirst(value);
    }

    public T pop() {
        return list.removeFirst();

    }

    public T peek() {
        return list.get(0);
    }

    public int indexOf(T value) {
        return list.indexOf(value);
    }

    public int size() {
        return list.size();
    }

    @Override
    public String toString() {
        return list.toString();
    }

    public int search(T value) {
        int i = 1;
        for (int j = list.size() - 1; j >= 0; j--) {
            if (value.equals(list.get(j)))
                return i;
            i++;
        }
        return -1;
    }

    public static void main(String[] args) {
        MyStackLinked<Integer> S = new MyStackLinked<>();
        S.push(5);
        S.push(6);
        System.out.println(S);
    }
}
