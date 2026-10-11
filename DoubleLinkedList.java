public class DoubleLinkedList<E> {

    
    //The head node of the list	
    private Node<E> header = null;               // head node of the list (or null if empty)

    //The last node of the list  
    private Node<E> trailer = null;               // last node of the list (or null if empty)

    
   // Number of nodes in the list       
    private int size = 0;                      // number of nodes in the list

    
    // Constructs an initially empty list.
     
    public DoubleLinkedList() {
        header = new Node(null, null, null); //previous,element,next
        trailer = new Node(null, null, null);//previous,element,next
        header.setNext(trailer); //pointing to each other
        trailer.setPrev(header);
        size = 0; //because the head and tail doesn't count

    }

    // Returns the number of elements in the linked list
    public int size() {
        return size;
    }

    /*
     * Tests if the linked list is empty or not
     * return true if the linked list is empty, false otherwise
    */
    public boolean isEmpty() {
        return size == 0;

    }
    
    public E first() {
        return header.getNext().getElement();// returns (but does not remove) the first element after the head
    }

    public E last() {
        return trailer.getPrev().getElement();// returns (but does not remove) the last element before the tail
    }

    // update methods
    /*
     * Adds an element to the front of the list
     *
     * @param e the new element to add
     */
    public void addFirst(E e) {
        Node n = new Node(e, header.getNext(), header);
        header.getNext().setPrev(n); //the new previous
        header.setNext(n); //the new next
        size++;
     // adds element e to the front of the list
    }

    /*
     * Adds an element to the end of the list
     * @param e the new element to add
     */
    public void addLast(E e) {
        Node n = new Node(e, trailer, trailer.getPrev());
        trailer.getPrev().setNext(n);
        trailer.setPrev(n);
        size++;
     // adds element e to the end of the list
    }

    /**
     * (Removes) and returns the first element of the list
     * return the removed element (or null if empty)
     */
    public E removeFirst() {
        E e = null;
        if(size>0){
        e = header.getNext().getElement();
        header.setNext(header.getNext().getNext());
        header.getNext().setPrev(header);
        
        size--;
        }
        return e;
     // removes and returns the first element
    }

    /*
     * (Removes) and returns the last element of the list
     * return the removed element (or null if empty)
     */
    public E removeLast() {
         E e = null;
        if(size>0){
        e= trailer.getPrev().getElement();
        trailer.setPrev(trailer.getPrev().getPrev());
        trailer.getPrev().setNext(trailer);
        
        size--;
        }
        return e;
    }

    /*
     * Produces a string representation of the contents of the list. This exists
     * for debugging purposes only.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("(");

        Node<E> walk = header.getNext();
        while (walk != trailer) {
            sb.append(walk.getElement());
            if (walk != trailer.getPrev()) {
                sb.append(", ");
            }
            walk = walk.getNext();
        }
        sb.append(")");
        return sb.toString();
    }
}
