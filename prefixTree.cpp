class Trie {

 private:
     struct TrieNode{
         struct TrieNode* children[26];
         bool isEnd;

     };

     TrieNode* root;
 
public:
    
     
    Trie() {
         root = new TrieNode();
    }
    
    void insert(string word) {
       TrieNode* p = root;
       for(auto c: word){
             if(p->children[c-'a'] == NULL)p->children[c-'a'] = new TrieNode();
             p = p->children[c-'a'];
       }
       p->isEnd = true;
    }
    
    bool search(string word) {
         TrieNode*p = root;
         for(auto c: word){
               if(p->children[c-'a'] == NULL)return false;
               p = p->children[c-'a'];
         }

         return p->isEnd;
    }
    
    bool startsWith(string prefix) {
        TrieNode* p = root;
        for(auto c: prefix){
              if(p->children[c-'a'] == NULL)return false;
              p = p->children[c-'a']; 
        }

        return true;
    }
};
