package lab9;

import java.util.Iterator;
import java.util.Set;

/**
 * Implementation of interface Map61B with BST as core data structure.
 *
 *
 */
public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {

    private class Node {
        /* (K, V) pair stored in this Node. */
        private K key;
        private V value;

        /* Children of this Node. */
        private Node left;
        private Node right;

        private Node(K k, V v) {
            key = k;
            value = v;
        }
    }

    private Node root;  /* Root node of the tree. */
    private int size; /* The number of key-value pairs in the tree */

    /* Creates an empty BSTMap. */
    public BSTMap() {
        this.clear();
    }

    /* Removes all of the mappings from this map. */
    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    /** Returns the value mapped to by KEY in the subtree rooted in P.
     *  or null if this map contains no mapping for the key.
     */
    private V getHelper(K key, Node p) {
        if (p == null) {
            return null;
        }
        int compareResult = key.compareTo(p.key);
        if (compareResult == 0) {
            return p.value;
        } else if (compareResult < 0) {
            return getHelper(key, p.left);
        } else {
            return getHelper(key, p.right);
        }
    }

    /** Returns the value to which the specified key is mapped, or null if this
     *  map contains no mapping for the key.
     */
    @Override
    public V get(K key) {
        V value = getHelper(key, root);
        return value;
    }

    /** Returns a BSTMap rooted in p with (KEY, VALUE) added as a key-value mapping.
     * Or if p is null, it returns a one node BSTMap containing (KEY, VALUE).
     */
    private Node putHelper(K key, V value, Node p) {
        if (p == null) {
            this.size = this.size + 1;
            Node n = new Node(key, value);
            return n;
        }
        int compareResult = key.compareTo(p.key);
        if (compareResult == 0) {
            p.value = value;
        } else if (compareResult < 0) {
            p.left = putHelper(key, value, p.left);
        } else {
            p.right = putHelper(key, value, p.right);
        }
        return p;
    }

    /** Inserts the key KEY
     *  If it is already present, updates value to be VALUE.
     */
    @Override
    public void put(K key, V value) {
        root = putHelper(key, value, root);
    }

    /* Returns the number of key-value mappings in this map. */
    @Override
    public int size() {
        return this.size;
    }

    //////////////// EVERYTHING BELOW THIS LINE IS OPTIONAL ////////////////

    /* Returns a Set view of the keys contained in this map. */
    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

    private Node min(Node n) {
        if (n.left == null) {
            return n;
        } else {
            return min(n.left);
        }
    }

    private Node deleteMin(Node n) {
        if (n.left == null) {
            return n.right;
        } else {
            n.left = deleteMin(n.left);
            return n;
        }
    }

    private Node deleteHelper(Node n, K key) {
        if (n == null) {
            return null;
        }
        int c = key.compareTo(n.key);
        if (c < 0) {
            n.left = deleteHelper(n.left, key);
        } else if (c > 0) {
            n.right = deleteHelper(n.right, key);
        } else {
            if (n.left == null) {
                return n.right;
            } else if (n.right == null) {
                return n.left;
            } else {
                Node t = n;
                n = min(t.right);
                n.left = t.left;
                n.right = deleteMin(t.right);
            }
        }
        return n;
    }

    private void delete(K key) {
        size -= 1;
        root = deleteHelper(root, key);
    }

    /** Removes KEY from the tree if present
     *  returns VALUE removed,
     *  null on failed removal.
     */
    @Override
    public V remove(K key) {
        V value = get(key);
        delete(key);
        return value;
    }

    /** Removes the key-value entry for the specified key only if it is
     *  currently mapped to the specified value.  Returns the VALUE removed,
     *  null on failed removal.
     **/
    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<K> iterator() {
        throw new UnsupportedOperationException();
    }
}
