import java.util.*;

class LRUCache {

    private int n;
    private List<Integer> dll;
    private Map<Integer, Pair<List<Integer>.Iterator, Integer>> mp;

    public LRUCache(int capacity) {
        this.n = capacity;
        this.dll = new LinkedList<>();
        this.mp = new HashMap<>();
    }

    private void makeRecentlyUsed(int key){
        dll.remove(mp.get(key).getKey());
        dll.add(0, key);
        mp.put(key, new Pair<>(dll.listIterator(), mp.get(key).getValue()));
    }

    public int get(int key) {
        if(!mp.containsKey(key)) {
            return -1;
        }
        makeRecentlyUsed(key);
        return mp.get(key).getValue();
    }

    public void put(int key, int value) {
        if(mp.containsKey(key)) {
            mp.get(key).setValue(value);
            makeRecentlyUsed(key);
        } else {
            dll.add(0, key);
            mp.put(key, new Pair<>(dll.listIterator(), value));
            n--;
        }
        if(n < 0) {
            int keyToBeDeleted = dll.remove(dll.size() - 1);
            mp.remove(keyToBeDeleted);
            n++;
        }
    }
}

