// Function to put the item on the top
private void makeRecentlyUsed(int key){
    dll.erase(mp.get(key).first);
    dll.push_front(key);
    mp.get(key).first = dll.begin();
}

// Constructor to initialize the n with capacity
LRUCache(int capacity){
    n = capacity;
    dll = new LinkedList<>();
    mp = new HashMap<>();
}

// Function to get the recently used item 
int get(int key){
    // if the cache does not contains the key, then return -1
    if(!mp.containsKey(key)) return -1;

    // set this key as the most recently used item
    makeRecentlyUsed(key);

    // return the item in the linked list
    return mp.get(key).second;

    // If the capacity has been extended
    if(n < 0){
        // Find the key to be deleted
        // Least recently used key has to be deleted
        int key_to_be_deleted = dll.back();

        // Pop that key from the list
        dll.pop_back();

        // Erase the pointer in the hashmap
        mp.remove(key_to_be_deleted);

        // Increment the given capacity by one
        n++;
    }
}
