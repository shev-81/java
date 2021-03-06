package algoritm_lesson_8;

public class DoubleHashTable<K, V> extends HashTableLinkimp<K, V> {
    public DoubleHashTable(int initialCapacity) {
        super(initialCapacity);
    }

    @Override
    protected int getStep(K key) {
        return hashDoubleFunc(key);
    }

    private int hashDoubleFunc(K key) {
        return 5 - (key.hashCode() % 5);
    }
}
