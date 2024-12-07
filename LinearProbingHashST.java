public class LinearProbingHashST<Key, Value> {
    private int N; // number of key-value pairs
    private int M; // hash table size
    private SequentialSearchST<Key, Value>[] st; // array of ST objects
    private Key[] keys;
    private Value[] vals;


    public LinearProbingHashST(int M) {
    // Create M linked lists.
        this.M = M;
        keys = (Key[]) new Object[M];
        vals = (Value[]) new Object[M];
        st =(SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
        for (int i = 0; i < M; i++)
            st[i] = new SequentialSearchST();
    }
    private int hash(Key key) {
        return (hashCode(key) & 0x7fffffff) % M;
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
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                return vals[i]; // Return the value if the key is found
            }
        }
        return null; // Return null if the key is not found
    }
    public void put(Key key, Value val) {
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                vals[i] = val;
                return;
            }
        }
        keys[i] = key;
        vals[i] = val;
    }
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<>();
        for (int i = 0; i < M; i++) {
            StdOut.print(i + ":");
            if (keys[i] != null) { // Collect non-null keys from the keys[] array
                queue.enqueue(keys[i]);
                StdOut.print(" " + get(keys[i]));
            }
            StdOut.println();
        }
        return queue;
    }
}