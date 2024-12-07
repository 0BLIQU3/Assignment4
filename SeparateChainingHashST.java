public class SeparateChainingHashST<Key, Value> {
    private int N; // number of key-value pairs
    private int M; // hash table size
    private SequentialSearchST<Key, Value>[] st; // array of ST objects

    public SeparateChainingHashST(int M) {
    // Create M linked lists.
        this.M = M;
        st =(SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
        for (int i = 0; i < M; i++)
            st[i] = new SequentialSearchST();
    }
    private int hash(Key key) {
        return (hashCode() & 0x7fffffff) % M;
    }

    public int hashCode(Key key) {
        String stringKey = (String) key;
        int hash = 0;
        int skip = Math.max(1, stringKey.length() / 8);
        for (int i = 0; i < stringKey.length(); i += skip)
            hash = (hash * 37) + stringKey.charAt(i);
        return hash;
    }
    public Value get(Key key) {
        return (Value) st[hash(key)].get(key);
    }
    public void put(Key key, Value val) {
        if (get(key) != null) {

        }

        st[hash(key)].put(key, val);
    }
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<>();
        for (int i = 0; i < M; i++) {
            StdOut.print(i + ":");
            for (Key key : st[i].keys()) {
                queue.enqueue(key);
                StdOut.print(" " + get(key));
            }
            StdOut.println();
        }
        return queue;
    }
}