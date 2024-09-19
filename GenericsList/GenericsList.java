package GenericsList;

public class GenericsList<E> {
    E[] arr = (E[]) new Object[10];
    int size = 0;
    // private int arr[]= new int [10];
    // private int size=0;

    private int size() {
        return size;
    }

    private void addlast(E value) {
        ensurCap();
        arr[size++] = value;
    }

    @Override
    public String toString() {
        String str = "{ ";
        for (int i = 0; i < size; i++) {
            str += arr[i] + " ";
        }
        return str + "}";
    }

    private void ReverseList() {
        for (int i = 0; i < size / 2; i++) {
            E temp = arr[i];
            arr[i] = arr[size - 1 - i];
            arr[size - 1 - i] = temp;
        }
    }

    private void addByIndex(int index, E value) {
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
            E[] temp = (E[]) new Object[arr.length * 2];
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

    private E get(int index) {
        return arr[index];
    }

    private boolean checkPrime(Integer N) {
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

    private void RemovePrime(GenericsList<Integer> l) {
        for (int i = 0; i <= l.size; i++) {
            if (checkPrime((Integer) get(i))) {
                removeByindex(i);
                i--;
            }
        }
    }

    private void duplicateEven(GenericsList<Integer> l) {
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
        GenericsList<Integer> a = new GenericsList<Integer>();
        a.addlast(8);
        a.addlast(14);
        a.addlast(13);
        a.addlast(5);
        a.addlast(7);
        a.addlast(3);
        a.addlast(9);
        System.out.println("Before\n" + a);
        a.RemovePrime(a);
        System.out.println("After\n" + a);
        System.out.println("====================");
        // 2 4 1 5 2 3 8
        // 2 2 4 4 1 5 2 2 3 8 8
        System.out.println("Second Question ");
        GenericsList<Integer> b = new GenericsList<Integer>();
        b.addlast(2);
        b.addlast(4);
        b.addlast(1);
        b.addlast(5);
        b.addlast(2);
        b.addlast(3);
        b.addlast(8);
        System.out.println("Before\n" + b);
        b.duplicateEven(b);
        System.out.println("After\n" + b);
        System.out.println("====================");
        // Ali Hasan Ahmad Amal
        // Amal Ahmad Hasan Ali
        System.out.println("Third Question ");
        GenericsList<String> S = new GenericsList<String>();
        S.addlast("Ali");
        S.addlast("Hasan");
        S.addlast("Ahmad");
        S.addlast("Amal");
        System.out.println("Before\n" + S);
        S.ReverseList();
        System.out.println("After\n" + S);

    }
}
