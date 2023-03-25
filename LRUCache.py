# Function to get the recently used item 
def get(self, key: int) -> int:
    # if the cache does not contains the key, then return -1
    if key not in self.mp: 
        return -1

    # set this key as the most recently used item
    makeRecentlyUsed(key)

    # return the item in the linked list
    return self.mp.get(key)[1]

    # If the capacity has been extended
    if self.n < 0:
        # Find the key to be deleted
        # Least recently used key has to be deleted
        key_to_be_deleted = self.dll[-1]

        # Pop that key from the list
        self.dll.pop()

        # Erase the pointer in the hashmap
        del self.mp[key_to_be_deleted]

        # Increment the given capacity by one
        self.n += 1
