package synthesizer;

public class AbstractBoundedQueue<T> implements BoundedQueue<T> {
    protected int fillCount;
    protected int capacity;

    @Override
    public int capacity() {
        return fillCount;
    }

    @Override
    public int fillCount() {
        return capacity;
    }

}
