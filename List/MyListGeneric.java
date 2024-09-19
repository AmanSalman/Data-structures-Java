
public class MyListGeneric<T> {
    private T[] arr = (T[]) new Object[3];
    // private int []arr = new int [3];
    private int size = 0;

    private void addLast(T Value) {
        if (size == arr.length) {
            ensureCap();
        }
        arr[size++] = Value;
    }

    private void ensureCap() {
        T temp[] = (T[]) new Object[2 * arr.length];
        for (int i = 0; i < size; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < size; i++) {
            str += arr[i] + " ";
        }
        return str;
    }

    private void removeLast() {
        if (size > 0) {
            size--;
        }
    }

    private void clear() {
        size = 0;
    }

    private void addByIndex(int index, T value) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("index" + index);
        } else if (size == index) {
            addLast(value);
        } else {
            if (size == arr.length) {
                ensureCap();
            }
            for (int i = size - 1; i >= index; i--)
                arr[i + 1] = arr[i];
            arr[index] = value;
        }
    }

    private void addFirst(T value) {
        addByIndex(0, value);
    }

    private T get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("index" + index);
        } else {
            return arr[index];
        }
    }

    private T removeByIndex(int index) {
        T temp = arr[index];
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("index" + index);
        } else {

            for (int i = index; i < size - 1; i++) {
                arr[i] = arr[i + 1];
            }
            size--;
        }
        return temp;
    }

    public static void main(String[] args) {
        MyListGeneric list = new MyListGeneric();
        list.addLast(30);
        list.addLast(80);
        list.addLast(60);
        list.addLast(90);
        list.removeByIndex(0);
        System.out.println(list.toString());
        System.out.println(list.size);
    }
}
