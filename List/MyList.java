public class MyList {
    private int[] arr = new int[3];
    private int size = 0;

    private void addLast(int Value) {
        if (size == arr.length) {
            ensureCap();
        }
        arr[size++] = Value;
    }

    private void ensureCap() {
        int temp[] = new int[2 * arr.length];
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

    private void addByIndex(int index, int value) {
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

    private void addFirst(int value) {
        addByIndex(0, value);
    }

    private int get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("index" + index);
        } else {
            return arr[index];
        }
    }

    private int removeByIndex(int index) {
        int temp = arr[index];
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("index" + index);
        } else {

            for (int i = index; i < size - 1; i++) {
                arr[i] = arr[i + 1];
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        MyList list = new MyList();
        list.addLast(30);
        list.addLast(80);
        list.addLast(60);
        list.addLast(90);
        System.out.println(list.toString());
    }
}
