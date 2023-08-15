class TrieNode{
     public:
        TrieNode* children[26];
        bool isEnd;

        TrieNode(){
            isEnd = false;
            memset(children, 0, sizeof(children));
        };
};



class WordDictionary {
public:

    TrieNode *root;
    WordDictionary() {
        root = new TrieNode();
    }
    
    void addWord(string word) {
        TrieNode*p = root;
        for(auto c: word){
              if(p->children[c-'a'] == NULL)p->children[c-'a'] = new TrieNode();
              p = p->children[c-'a'];
        }
        p->isEnd = true;
    }
    
    bool search(string word) {
        return searchHelper(word, root);
    }

    bool searchHelper(string word, TrieNode* node){
         for(int i=0;i<word.length();i++){
               char c = word[i];
               if(c == '.'){
                     for(auto child: node->children){
                           if(child && searchHelper(word.substr(i+1), child))return true;
                     }
                     return false;
               }

               if(node->children[c-'a'] == NULL)return false;
               node = node->children[c-'a'];
         }

         return node->isEnd;

          
    }
};
