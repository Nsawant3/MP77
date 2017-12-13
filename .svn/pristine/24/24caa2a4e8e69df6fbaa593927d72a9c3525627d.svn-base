import java.util.Iterator;
import java.util.LinkedList;


/**
 * A class that adds a reversal method to the existing LinkedList class.
 * @param <T>- parameter
 */
public class ReverseList<T> extends LinkedList<T> {


    /**
     * Empty list constructor.
     */
    public ReverseList() {
         super();
    }

    /**
     * Create a ReverseLinkedList from another collection type.
     * @param collection - the collection to create the ReverseLinkedList from.
     */
    public ReverseList(final java.util.Collection<? extends T> collection) {
           super(collection);
    }

    /**
     * Reverse the linked list.
     * This method should return a new LinkedList containing the same
     * elements as the original list, but in the opposite order.
     *
     * You are free to implement this method either iteratively, or recursively,
     * whatever seems more natural to you. Try both! Note that a recursive
     * implementation may need to use a helper function.
     * @return - the reversed linked list.
     */
    public java.util.LinkedList<T> reverse() {

        LinkedList<T> reversedList = new LinkedList<>();
//        T firstVal = reversedList.get(0);
//        for (int i = 1; i < reversedList.size(); i++) {
//             reversedList.push(reversed.get())
//        }

        Iterator<T> originalListIterator = this.iterator();
        while (originalListIterator.hasNext()) {
            reversedList.push(originalListIterator.next());
        }
        return reversedList;
        }

    }

//}




