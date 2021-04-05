public class ArrayDeque<T> {
    private final static int ASIZE = 8;
    private final static int factor = 2;
    private int size;
    private T[] items;
    private int nextFirst;
    private int nextLast;


    // build a constructor//
    public ArrayDeque() {
        T[] items = (T[]) new Object[8];
        nextFirst = 4;
        nextLast = 5;
        size = 0;
    }

    //
    public int plusone(int index) {
        if (index == ASIZE - 1) {
            return 0;
        }
        return index + 1;
    }

    public int minusone(int index) {
        if (index == 0) {
            return ASIZE;
        }
        return index - 1;
    }

    public void addFirst(T item) {

        items[nextFirst] = item;
        nextFirst = minusone(nextFirst);
        size += 1;

        if (nextFirst < 0) {
            nextFirst = items.length - 1;
        }
        resize();
    }

    public void addLast(T item) {

        items[nextLast] = item;
        nextLast = plusone(nextLast);
        size += 1;

        if (nextLast > items.length) {
            nextLast = 0;
        }
        resize();
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        return size;
    }

    public double getLoad() {
        return ((double) size) / items.length;
    }

    // the hardest part is resize!!!//
    public void resize() {
        T[] arr = (T[]) new Object[items.length * factor];
        int currentfirst = plusone(nextFirst);
        int currentlast = minusone(nextLast);

        if (currentfirst < currentlast) {
            int length = currentlast - currentfirst + 1;
            System.arraycopy(items, currentfirst, arr, 0, length);
            nextFirst = items.length * factor - 1;
            nextLast = length;
        } else {
            int lengthfirst = items.length - currentfirst;
            int lengthlast = nextLast;
            int currentfirst2 = lengthfirst - 1;

            System.arraycopy(items, currentfirst, arr, 0, lengthfirst);
            System.arraycopy(items, 0, arr, currentfirst2, lengthlast);
        }

        items = arr;
    }

    public T[] removeFirst() {
        if (isEmpty()) {
            return null;
        }
        int currentfirst = minusone(nextFirst);
        items[currentfirst] = null;
        size -= 1;
        return items;

    }

    public T[] removeLast() {
        if (isEmpty()) {
            return null;
        }
        int currentlast = plusone(nextLast);
        items[currentlast] = null;
        size -= 1;
        return items;
    }

    public T get(int index) {
        if (index >= size) {
            return null;
        }
        int position = minusone(nextFirst) + index;
        if (position >= items.length) {
            position = position - items.length;
        }
        else {
            position = position;
        }
        return items[position];
    }

    public void printDeque() {
        //use while rather than for !!!//
        int currentindex = plusone(nextFirst);
        while (currentindex != nextLast ) {
            System.out.print(items[currentindex] + " ");
            currentindex = plusone(currentindex);
        }
    }

    //** the main part to dubug **//
    public static void main(String[] args) {
        System.out.println("Running test");
        ArrayDeque A = new ArrayDeque();
        A.addLast(16);
        A.addFirst(13);
        System.out.println(A.get(0));
    }

}