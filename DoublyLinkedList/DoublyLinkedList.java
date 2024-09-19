
public class DoublyLinkedList<T> {
    NodeD<T> head = null;
    NodeD<T> tail = null;
    private int size = 0;

    private void addlast(T data) {
        NodeD<T> temp = new NodeD<>(data);
        if (head == null) {
            head = tail = temp;
            temp.pre = null;
            temp.next = null;
        } else {
            tail.next = temp;
            temp.pre = tail;
            tail = temp;
            tail.next = null;
        }
        size++;
    }

    private void addfirst(T data) {
        NodeD<T> temp = new NodeD<>(data);
        if (head == null) {
            head = tail = temp;
            temp.pre = null;
        } else {
            head.pre = temp;
            temp.next = head;
            temp.pre = null;
            head = temp;
        }
        size++;
    }

    private T removelast() {
        T data = tail.getData();
        if (head == null) {
            throw new NullPointerException();
        }
        if (head.next == null) {
            head = tail = null;
        } else {
            tail = tail.pre;
            tail.next = null;
        }
        size--;
        return data;
    }

    private T removefirst() {
        T data = head.getData();
        if (head == null) {
            throw new NullPointerException();
        }
        // if(head.next == null){
        // head = tail = null;
        // }
        else {
            head = head.next;
            head.pre = null;
        }
        size--;
        return data;
    }

    // private void add(T Data) {
    // NodeD <T> temp = new NodeD (Data);
    // if(head == null ){
    // temp.next = head;
    // temp.pre= null;
    // }
    // }

    @Override
    public String toString() {
        String str = "";
        NodeD<T> curr = head;
        while (curr != null) {
            str += curr.getData() + ",";
            curr = curr.next;
        }
        if (head != null)
            return "[" + str.subSequence(0, str.length() - 1) + "]";
        else
            return "[" + "]";
    }

    private void addAtIndex(int index, T value) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        } else if (index == 0) {
            addfirst(value);
        } else if (index == size - 1) {
            addlast(value);
        } else {
            NodeD<T> curr = head;
            NodeD<T> temp = new NodeD<>(value);
            for (int i = 1; i < index; i++) {
                curr = curr.next;
            }
            curr.next.pre = temp;
            temp.next = curr.next;
            curr.next = temp;
            temp.pre = curr;

        }
        size++;
    }

    private T removeByIndex(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        } else if (index == 0) {
            return removefirst();
        } else if (index == size - 1) {
            return removelast();
        } else {
            NodeD<T> curr = head;
            for (int i = 0; i < index - 1; i++) {
                curr = curr.next;
            }
            T Data = curr.next.getData();
            curr.next = curr.next.next;
            curr.next.pre = curr;
            size--;
            return Data;
        }
    }

    private String Print() {
        NodeD<T> curr = tail;
        String str = "";
        while (curr != null) {
            str += curr.getData() + ",";
            curr = curr.pre;
        }
        if (head != null)
            return "[" + str.subSequence(0, str.length() - 1) + "]";
        else
            return "[" + "]";
    }

    private boolean Check_Palind() {
        NodeD<T> curr1 = head;
        String s1 = "";
        NodeD<T> curr2 = tail;
        String s2 = "";

        while (curr1 != null && curr2 != null) {
            s1 += curr1.getData();
            curr1 = curr1.next;
            s2 += curr2.getData();
            curr2 = curr2.pre;
        }
        if (s1.equals(s2))
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> D = new DoublyLinkedList<>();
        // 5 9 10 4
        // 5 9 56 10 4
        D.addlast(2);
        D.addlast(3);
        D.addlast(31);
        D.addlast(2);
        System.out.println(D.Check_Palind());
    }

}
