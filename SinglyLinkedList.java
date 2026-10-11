public class SinglyLinkedList<E> {

    private Node<E> head = null;              
    private Node<E> tail = null;               
    private int size = 0;                     
    
    public SinglyLinkedList() {
    }             

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;

    }

    public E first() {
        return head.getElement();
    }

    public E last() {
        return tail.getElement();
    }

    public void addFirst(E e) {
        Node<E> n = new Node<E>(e, head);
        head = n;
        if (size == 0) {
            tail = n;
        }
        size++;

    }
    
    public void addLast(E e) {
        Node<E> n = new Node<E>(e, null);
        tail.setNext(n);
        tail = n;
        if (size == 0) {
            head = n;
        }
        size++;

    }

    public E removeFirst() {
        E e = null;
        if (size != 0) {
            e = head.getElement();
            head = head.getNext();
            size--;
        }
        return e;
    }

    public E removeLast() {
        E e = null;
        if (size != 0) {
            e = tail.getElement();
            if (size == 1) {
                head = tail = null;
                size--;
            } else {
                Node<E> walk = head;
                while (walk.getNext().getNext() != null) {
                    walk = walk.getNext();
                }
                walk.setNext(null);
                tail = walk;
                size--;
            }
        }
        return e;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("(");

        Node<E> walk = head;
        while (walk != null) {
            sb.append(walk.getElement());
            if (walk != tail) {
                sb.append(", ");
            }
            walk = walk.getNext();
        }
        sb.append(")");
        return sb.toString();
    }
}