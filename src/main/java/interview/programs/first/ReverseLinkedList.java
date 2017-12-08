package interview.programs.first;

public class ReverseLinkedList {

    public static void main(String[] args) {

        final LinkedList<String> three = new LinkedList<>("3", null);
        final LinkedList<String> two = new LinkedList<>("2", three);
        final LinkedList<String> one = new LinkedList<>("1", two);

        LinkedList<String> reversed = LinkedList.reverse(one);
        while (reversed != null) {
            System.out.println(reversed.getElement());
            reversed = reversed.getNext();
        }
    }
}


class LinkedList<T> {
    private T element;
    private LinkedList<T> next;

    public LinkedList(T element, LinkedList<T> next) {
        this.element = element;
        this.next = next;
    }

    public T getElement() {
        return element;
    }

    public LinkedList<T> getNext() {
        return next;
    }

    public static LinkedList<String> reverse(LinkedList<String> original) {

        final LinkedList<String> next = original.next;

        if (next == null) {
            return original;
        }

        original.next = null;

        final LinkedList<String> othersReversed = reverse(next);

        next.next = original;

        return othersReversed;


    }

}