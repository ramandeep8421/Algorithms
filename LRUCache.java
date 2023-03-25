import java.util.*;

class LRUCache {
    private int n;
    private List<Integer> dll;
    private Map<Integer, Pair<List<Integer>.Iterator, Integer>> mp;

    public LRUCache(int capacity) {
        n = capacity;
        dll = new LinkedList<Integer>();
        mp = new HashMap<Integer, Pair<List<Integer>.Iterator, Integer>>();
    }

    private void makeRecentlyUsed(int key) {
        dll.remove(mp.get(key).getKey());
        dll.add(0, key);
        mp.put(key, new Pair<List<Integer>.Iterator, Integer>(dll.listIterator(), mp.get(key).getValue()));
    }

    public int get(int key) {
        if (!mp.containsKey(key)) return -1;
        makeRecentlyUsed(key);
        return mp.get(key).getValue();
    }

    // other methods can be added as per the requirements
}
