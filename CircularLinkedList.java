public class CircularLinkedList<E> {

    /**
     * The last node of the list
     */
    private Node<E> tail = null;               // last node of the list (or null if empty)

    /**
     * Number of nodes in the list
     */
    private int size = 0;                      // number of nodes in the list

   
    // Constructs an initially empty list
    public CircularLinkedList() {
    }             

    // Returns the size 
    public int size() {
        return size;
    }

    //return true if the linked list is empty, false otherwise
    public boolean isEmpty() {
        return size == 0;

    }

    /*
     * Returns (but does not remove) the first element of the list
     * Return element at the front of the list (or null if empty)
     */
    public E first() {
        return tail.getNext().getElement();
    }

    /*
     * Returns (but does not remove) the last element of the list
     * Return element at the end of the list (or null if empty)
     */
    public E last() {
        return tail.getElement();
    }

    /*
     * Adds an element to the front of the list
     * @param e the new element to add
     */
    public void addFirst(E e) {
        if (size == 0) {
            tail = new Node<E>(e, null);
            tail.setNext(tail);

        } else {
            Node<E> n = new Node<E>(e, tail.getNext());
            tail.setNext(n);
        }
        size++;     
    }

    /*
     * Adds an element to the end of the list
     * @param e the new element to add
     */
    public void addLast(E e) {
        if (size == 0) {
            addFirst(e);
        } else {
            Node<E> n = new Node<E>(e, null);
            n.setNext(tail.getNext());
            tail.setNext(n);
            tail = n;
            size++;
        }
    }

    /*
     * Removes and returns the first element of the list
     * @return the removed element (or null if empty)
     */
    public E removeFirst() {
        E e = null;
        if (size != 0) {
            e=tail.getNext().getElement();
            tail = tail.getNext();
            size--;
            if (size == 0) {
                tail = null;
            }
        }
        return e;
    }

    /*
     * Removes and returns the last element of the list
     * @return the removed element (or null if empty)
     */
    public E removeLast() {
        E e = null;
        if (size != 0) {
            e = tail.getElement();
            if (size == 1) {
                tail = null;
                size--;
            } else {
                Node<E> walk = tail.getNext();
                while (walk.getNext() != tail) {
                    walk = walk.getNext();
                }
                walk.setNext(tail.getNext());
                tail = walk;
                size--;

            }
        }
        return e;
    }

    /*
     * Produces a string representation of the contents of the list. This exists
     * for debugging purposes only.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        if (size != 0) {
            Node<E> walk = tail.getNext();
            while (walk != tail) {
                sb.append(walk.getElement());

                sb.append(", ");

                walk = walk.getNext();
            }
        
            sb.append(walk.getElement());
        }
        sb.append(")");
        return sb.toString();
    }
}
