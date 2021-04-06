
//Modify your LinkedListDeque and/or ArrayDeque so that they implement the Deque interface by adding
//implements Deque<Item> to the line declaring the existence of the class.
//If you used something other than Item for your generic type parameter, use that instead.
//Add @Override tags to each method that overrides a Deque method.

public class LinkedListDeque<T> implements Deque<T> {
    private IntNode sentinel;
    private int size;

    //** the nested class **//
    private class IntNode {
        public IntNode prev;
        public T item;
        public IntNode next;

        public IntNode(T i, IntNode p, IntNode n) {
            this.prev = p;
            this.item = i;
            this.next = n;
        }
    }

    // constructor//
    public LinkedListDeque () {
        this.sentinel = new IntNode(null,null,null);
        this.size = 0;
        this.sentinel.prev = sentinel;
        this.sentinel.next = sentinel;
    }


    @Override
    public void addFirst(T item) {
        IntNode first = new IntNode (item, sentinel, sentinel.next);
        sentinel.next.prev = first;
        sentinel.next = first;
        sentinel = first;
        size += 1;
    }


    @Override
    public void addLast(T item) {
        IntNode last = new IntNode (item, sentinel.prev, sentinel);
        sentinel.prev.next = last;
        sentinel.prev = last;
        size += 1;
    }


    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    //Prints the items in the deque from first to last, separated by a space.//

    @Override
    public void printDeque() {
        IntNode itr = sentinel.next;
        while (itr != sentinel) {
            System.out.print(itr.item + " ");
            itr = itr.next;
        }
        System.out.println();
    }

    //Removes and returns the item at the front of the deque. If no such item exists, returns null.//

    @Override
    public T removeFirst() {
        if (sentinel.next == sentinel) {
            return null;
        }
        IntNode itr = sentinel.next;
        itr.prev = sentinel.prev;
        sentinel.prev.next = itr;
        sentinel = itr;
        size -= 1;
        return sentinel.item;
    }

    //Removes and returns the item at the back of the deque. If no such item exists, returns null.//

    @Override
    public T removeLast() {
        if (sentinel.next == sentinel) {
            return null;                                                
        }
        IntNode itr = sentinel.prev;
        sentinel.prev = itr.prev;
        itr.prev.next = sentinel;
        size -= 1;
        return itr.item;
    }

    //Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth. //
    // If no such item exists, returns null. Must not alter the deque!//

    @Override
    public T get(int index) {
        IntNode itr = sentinel.next;
        while (itr != sentinel) {
            if (index == 0) {
                return itr.item;
            }
            itr = itr.next;
            index -= 1;
        }
        return null;

    }

}
