class TrieNode{
      public:
          TrieNode* children[26];
          bool isEnd;

          TrieNode(){
              memset(children, NULL, sizeof(children));
              isEnd = false;
          }
};

class MagicDictionary {
public:

    TrieNode* root;
    MagicDictionary() {
         root = new TrieNode();
    }

    void insert(string word){
         TrieNode* node = root;
         for(auto c: word){
               if(node->children[c-'a'] == NULL)node->children[c-'a'] = new TrieNode();
               node = node->children[c-'a'];
         }
         node->isEnd = true;
    }
    
    void buildDict(vector<string> dictionary) {
        for(auto word: dictionary){
              insert(word);
        }
    }

   bool searchHelper(string word, TrieNode* node, int index, bool isReplaced){

        if(index >= word.length())return node->isEnd && isReplaced;
         TrieNode* curr = node;
         int curIndex = word[index] - 'a';
         bool res = false;
         for(int i=0;i<26;i++){
              if(curr->children[i]){
                  if(curIndex == i){
                       res = searchHelper(word, curr->children[i], index+1, isReplaced);
                  }else if(!isReplaced){
                        res = searchHelper(word, curr->children[i], index+1, true);
                  }
              }
              if(res)return true;
         }

         return res;
   }
    
    bool search(string searchWord) {
           
           return searchHelper(searchWord, root, 0, false);
    }
};
