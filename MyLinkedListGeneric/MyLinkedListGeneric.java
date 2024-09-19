
import Stack.Node;

public class MyLinkedListGeneric<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    private static MyLinkedListGeneric<Integer> Merge(MyLinkedListGeneric<Integer> Arr,
            MyLinkedListGeneric<Integer> Arr0) {
        MyLinkedListGeneric<Integer> temp = new MyLinkedListGeneric<>();
        Node<Integer> curr = Arr.head, curr0 = Arr0.head;
        while (curr != null && curr0 != null) {

            if (curr.getData() > curr0.getData()) {
                temp.addLast(curr.getData());
                curr = curr.getNext();
            } else {
                temp.addLast(curr0.getData());
                curr0 = curr0.getNext();
            }
        }
        while (curr != null) {
            temp.addLast(curr.getData());
            curr = curr.getNext();
        }
        while (curr0 != null) {
            temp.addLast(curr0.getData());
            curr0 = curr0.getNext();
        }
        return temp;
    }

    private static /* Integer */ void JoinPoint(Node<Integer> head1, Node<Integer> head2) {
        int c1 = 0, c2 = 0;
        Node<Integer> cur1 = head1;
        Node<Integer> cur2 = head2;
        while (cur1 != null) {
            cur1 = cur1.getNext();
            c1++;
        }
        while (cur2 != null) {
            cur2 = cur2.getNext();
            c2++;
        }
        System.out.println(c1 + " " + c2);
    }

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

    public static void main(String[] args) {
        MyLinkedListGeneric<Integer> Arr1 = new MyLinkedListGeneric<>();
        MyLinkedListGeneric<Integer> Arr2 = new MyLinkedListGeneric<>();
        Arr1.addLast(1);
        Arr1.addLast(2);
        Arr1.addLast(3);
        Arr1.addLast(4);
        Arr1.addLast(5);
        Arr2.OddEven(Arr2.head);
        System.out.println(Arr1.toString());
        // MyLinkedList <Integer> Arr3 = Arr1.insertSorted(Arr1,1);
        // MyLinkedList <Integer> Arr2 = new MyLinkedList<>();
        // Arr2.addLast(5);
        // Arr2.addLast(6);
        // Arr2.addLast(8);
        // Arr2.addLast(9);
        //// System.out.println(Arr.Binary(Arr.head));
        //// System.out.println(Arr);
        //// Arr.RotataionLeft(3);
        // System.out.println(Arr1);
        // System.out.println(Arr2);
        // JoinPoint(Arr1.head, Arr2.head);
        // System.out.println(Arr.get(0));
        // System.out.println(Arr.size);
        // System.out.println(Arr);
        // Arr.deleteByIndex(3);
        // System.out.println(Arr);
    }

    public int size() {
        return size;
    }

    public void clear() {
        head = tail = null;
    }

    private Double Binary(Node<T> head) {
        Node<T> curr = head;
        String s = "";
        while (curr != null) {
            if (curr.getData().equals("T"))
                s += "1";
            else
                s += "0";
            curr = curr.getNext();
        }
        System.out.println(s);
        double res = 0;
        for (int i = 0; i < s.length(); i++) {
            double po = i;
            int N = s.charAt(i) - '0';
            if (N == 1) {
                res = res + Math.pow(2, po);
            }
        }
        return res;
    }

    private void PrintMid() {
        Node<T> fast = head, slow = head;
        while (fast.getNext() != tail && fast != tail) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        System.out.println(slow.getData());
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

    private boolean contain(T data) {
        Node<T> temp = head;
        for (int i = 0; i < size; i++) {
            if (temp.getData().equals(data)) {
                return true;
            }
            temp = temp.getNext();
        }
        return false;
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

    public void addFirst(T data) {
        Node<T> temp = new Node<>(data);
        if (head == null) {
            head = tail = temp;
        } else {
            temp.setNext(head);
            head = temp;
        }
        size++;
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

    public T removelast() {
        T Data = tail.getData();
        if (head == null) {
            throw new NullPointerException();
        } else if (head.getNext() == null) {
            head = null;
        } else {
            Node<T> node = tail;
            Node<T> curr = head;
            while (curr.getNext().getNext() != null) {
                curr = curr.getNext();
            }
            System.out.println(curr.getData());
            tail = curr;
            tail.setNext(null);

        }
        size--;
        return Data;
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

    private T deleteByIndex(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        } else if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removelast();
        }
        Node<T> pre = null;
        Node<T> temp = head;
        for (int i = 0; i < index; i++) {
            pre = temp;
            temp = temp.getNext();
        }
        pre.setNext(temp.getNext());
        T data = temp.getData();
        size--;
        return data;
    }

    // private void reverse() {
    // if( head == null){
    // throw new NullPointerException();
    // }
    // Node <T> pre = null , curr=head ,next=head.getNext();
    // while (next!=null){
    // curr.setNext(pre);
    // pre = curr;
    // curr = next;
    // next = next.getNext();
    // }
    // curr.setNext(pre);
    // tail=head;
    // head=curr;
    // }

    private void reverse() {
        Node<T> pre = null, next = null, curr = head;
        while (curr != null) {
            next = curr.getNext();
            curr.setNext(pre);
            pre = curr;
            curr = next;
        }
        tail = head;
        head = pre;
    }

    private void removeTest(int index) {
        Node<T> curr = head, pre = null;
        for (int i = 0; i < index; i++) {
            pre = curr;
            curr = curr.getNext();
        }
        pre.setNext(curr.getNext());
        size--;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new NullPointerException();
        }
        Node<T> curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.getNext();
        }
        return curr.getData();
    }

    private void addAtPosition(int index, T data) {
        if (index < 0 || index >= size) {
            throw new NullPointerException();
        } else if (index == 0) {
            addFirst(data);
        } else if (index == size - 1) {
            addLast(data);
        } else {

            Node<T> N = new Node<>(data);
            Node<T> curr = head;
            for (int i = 0; i < index - 1; i++) {
                curr = curr.getNext();
            }
            N.setNext(curr.getNext());
            curr.setNext(N);
            size++;
        }

    }

    private void RotataionLeft(int k) {
        T data;
        for (int i = 1; i <= k; i++) {
            data = removeFirst();
            addLast(data);
        }
    }

    private void RotatationRight(int k) {
        T data;
        for (int i = 1; i <= k; i++) {
            data = removelast();
            addFirst(data);
        }
    }

    private boolean ispalind(MyLinkedListGeneric<T> A) {
        MyLinkedListGeneric<T> temp = new MyLinkedListGeneric<>();
        Node<T> curr1 = A.head;
        while (curr1 != null) {
            temp.addFirst(curr1.getData());
            curr1 = curr1.getNext();
        }
        Node<T> curr2 = temp.head;
        while (curr1 != null) {
            if (curr1.getData() != curr2.getData()) {
                return false;
            }
            curr1 = curr1.getNext();
            curr2 = curr2.getNext();
        }
        return true;
    }

    private MyLinkedListGeneric<T> mergeTwoLinked(MyLinkedListGeneric<T> Arr1, MyLinkedListGeneric<T> Arr2, int index) {
        Node<T> curr = Arr2.head;
        while (curr.getNext() != null) {
            Arr1.addAtPosition(index, curr.getData());
            index++;
            curr = curr.getNext();
        }
        return Arr1;
    }

    private void rotationright(int R) {
        Node newtail, end;
        newtail = end = head;
        while (end != tail) {
            if (R > 0) {
                end = end.getNext();
                R--;
            } else {
                end = end.getNext();
                newtail = newtail.getNext();
            }
        }
        end.setNext(head);
        head = newtail.getNext();
        tail = newtail;
        tail.setNext(null);

    }

    public static void OddEven(Node head) {

        MyLinkedListGeneric L = new MyLinkedListGeneric();
        L.head = head;
        Node<Integer> curr = head;
        int index = 0;
        while (curr != null) {
            index++;
            if (curr.data % 2 == 0) {
                L.addLast(L.deleteByIndex(index));
            }
            curr = curr.next;
        }
        System.out.println(L.toString());
    }

}