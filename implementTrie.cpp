class Trie {

 private:
      int trie[200002][26];
      bool isEnd[200002];
      int root;
      int counter;
public:
    
     
    Trie() {
        root = 0;
        counter = 0;
        memset(trie, 0, sizeof(trie));
        memset(isEnd, false, sizeof(false));
    }
    
    void insert(string word) {
         int node = root;
         for(auto c: word){
            if(trie[node][c-'a'] == 0)trie[node][c-'a'] = ++counter;
            node = trie[node][c-'a'];
         }

         isEnd[node] = true;
    }
    
    bool search(string word) {
         int node = root;
         for(auto c: word){
                 if(trie[node][c-'a'] == 0)return false;
                 node = trie[node][c-'a'];
         }
         return isEnd[node];
    }
    
    bool startsWith(string prefix) {
        int node = root;
        for(auto c: prefix){
                if(trie[node][c-'a'] == 0)return false;
                node = trie[node][c-'a'];
        }
        return true;
    }
};

/**
 * Your Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * bool param_2 = obj->search(word);
 * bool param_3 = obj->startsWith(prefix);
 */
