class TrieNode{
     public:
     
        map<char, TrieNode*>children;
        bool isEnd;
     
};

class Solution {
public:
 
    TrieNode* root = new TrieNode();

    void insert(string word){
          TrieNode* cur = root;
          for(auto c: word){
                 if(cur->children[c] == NULL)cur->children[c] = new TrieNode();
                 cur = cur->children[c];
          }
          cur->isEnd = true;
    }
    
    bool search(string word){
         TrieNode* cur = root;
         for(auto c: word){
              if(!cur->children[c] and isupper(c))return false;

              if(cur->children[c])cur = cur->children[c];
         }
         return cur->isEnd;
    }
    
    vector<bool> camelMatch(vector<string>& queries, string pattern) {
    
          int n = queries.size();
          vector<bool>res(n, false);
          
          int i = 0;
          insert(pattern);
        
          for(auto query: queries)
            res[i++] = search(query);

          return res;
    }
};
