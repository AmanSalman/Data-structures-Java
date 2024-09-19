
public class MyLinkedList {
    private node_1 head;
    private node_1 tail;
    private int size = 0;

    public static void main(String[] args) {
        MyLinkedList m = new MyLinkedList();
        m.addlast(10);
        m.addlast(20);
        m.addlast(30);
        m.addlast(40);
        m.addlast(50);
        m.addlast(60);
        m.rotationright(3);
        System.out.println(m.toString());

    }

    private void rotationright(int R) {
        node_1 newtail, end;
        newtail = end = head;
        while (end != tail) {
            if (R > 0) {
                end = end.getNext();
                R--;
                System.out.println(end.getData());
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

    public void addfirst(int value) {
        node_1 temp = new node_1(value);
        if (head == null) {
            tail = head = temp;
        } else {
            temp.setNext(head);
            head = temp;
        }
        size++;
    }

    @Override
    public String toString() {
        node_1 curr = head;
        String str = "";
        while (curr != null) {
            str += curr.getData() + " ";
            curr = curr.getNext();
        }
        return str;
    }

    public void addlast(int value) {
        node_1 temp = new node_1(value);
        if (head == null) {
            head = tail = temp;
        } else {
            tail.setNext(temp);
            tail = temp;
        }
        size++;
    }

    public void removefirst() {
        if (head == null) {
            throw new NullPointerException("Error - Attempting to call removefirst() on empty list");
        } else {
            head = head.getNext();
            size--;
        }

    }

    public void removelast() {
        if (head == null) {
            throw new NullPointerException("Error - Attempting to call removelast() on empty list");
        } else if (head.getNext() == null) {
            head = tail = null;
        } else {
            node_1 curr = head;
            while (curr.getNext().getNext() != null) {
                curr = curr.getNext();
            }
            tail = curr;
            curr.setNext(null);

        }
        size--;
    }

}
