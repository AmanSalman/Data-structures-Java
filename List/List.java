public class List {
    private int arr[] = new int[10];
    private int size = 0;

    private int size() {
        return size;
    }

    private void addlast(int value) {
        ensurCap();
        arr[size++] = value;
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < size; i++) {
            str += arr[i] + " ";
        }
        return str;
    }

    private void addByIndex(int index, int value) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException(" index " + index);
        } else if (size == index) {
            addlast(value);
        } else {
            for (int i = size - 1; i >= index; i--) {
                arr[i + 1] = arr[i];
            }
            arr[index] = value;
            size++;
        }
    }

    private void ensurCap() {
        if (size == arr.length) {
            int temp[] = new int[arr.length * 2];
            for (int i = 0; i < size; i++) {
                temp[i] = arr[i];
            }
            arr = temp;
        }
    }

    private void removeByindex(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(" index " + index);
        } else if (index == size - 1) {
            size--;
        } else {
            for (int i = index; i < size - 1; i++)
                arr[i] = arr[i + 1];
            size--;
        }
    }

    private int get(int index) {
        return arr[index];
    }

    private boolean checkPrime(int N) {
        if (N == 0 || N == 1) {
            return false;
        }
        for (int i = 2; i < N / 2; i++) {
            if (N % i == 0) {
                return false;
            }
        }
        return true;
    }

    private void RemovePrime(List l) {
        for (int i = 0; i <= l.size; i++) {
            if (checkPrime(get(i))) {
                removeByindex(i);
                i--;
            }
        }
    }

    private void duplicateEven(List l) {
        for (int i = 0; i < l.size(); i++) {
            if (l.get(i) % 2 == 0) {
                l.addByIndex(i + 1, l.get(i));
                i++;
            }
        }
    }

    public static void main(String[] args) {
        // 8 14 13 5 7 3 9
        // 8 14 9
        System.out.println("First Question ");
        List a = new List();
        a.addlast(8);
        a.addlast(14);
        a.addlast(13);
        a.addlast(5);
        a.addlast(7);
        a.addlast(3);
        a.addlast(9);
        System.out.println(a);
        a.RemovePrime(a);
        System.out.println(a);

        // 2 4 1 5 2 3 8
        // 2 2 4 4 1 5 2 2 3 8 8
        System.out.println("Second Question ");
        List b = new List();
        b.addlast(2);
        b.addlast(4);
        b.addlast(1);
        b.addlast(5);
        b.addlast(2);
        b.addlast(3);
        b.addlast(8);
        System.out.println(b);
        b.duplicateEven(b);
        System.out.println(b);
    }
}
