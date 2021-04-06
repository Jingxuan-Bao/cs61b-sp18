public interface Deque <T> {

    //interface is a "abstract class", that is used to group //
    // related methods with empty bodies.//

    // the methods below are all according to the proj1a//

    void addFirst(T item);

    void addLast(T item);

    boolean isEmpty();

    int size();

    void printDeque();

    T removeFirst();

    T removeLast();

    T get(int index);

}
