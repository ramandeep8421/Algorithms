#include<bits/stdc++.h>
using namespace std;


class TrieNode {
 
 public:
  //Boolean variable to mark the end of a word
    bool isCompleteWord;
     //Trinode each containing a pointer to that particular
    // character
    TrieNode* children[26];

     TrieNode(){
       isCompleteWord = false; //When the word is complete then mark that node as true
       memset(children,0,sizeof(children)); // for 26 possible children (next characters)
    }    
      
};

class WordDictionary{
   public: 
      
//This is the root node 
       TrieNode* root;

            //Function to initialize 
     // a wordDictionary object
     WordDictionary(){
         root = new TrieNode();
     }
    
    //Function to add a new word in 
     // the trie
     void addWord(string word){
         //Node initialized to root
         TrieNode* node = root;

         //Iterate over the word and 
         // add this word into the dictionary
         for(char ch: word){
              //locate the particular index for the given character in the node
              int idx = ch - 'a';
          
              
              if(node->children[idx] == NULL)node->children[idx] = new TrieNode();

              node = node->children[idx];
         }

         //Mark the end of the word as true
         node->isCompleteWord = true;
     }

     //Function to search for the word
     bool search(string word, TrieNode* node){
     // .ad
      //Iterate over the word 
         for(int i=0; i < word.size(); i++){
             char c = word[i];
            //If the current character is a dot 
           // then check by putting each character at 
          // this position and validating the word if it exists or not
             if(c == '.'){
                 for(auto ch: node->children)

                     //If the word formed by putting ch at this position
                    // is present in the dictionary then return true..
                     if(ch && search(word.substr(i+1),ch))
                        return true;
                 return false;
             }
             //Find the index for that particular character
             int idx = c - 'a';
              
             //If the pointer for this node is NULL then return false
             if(node->children[idx] == NULL)return false;
        
             //Otherwise move the node to the next node
             node = node->children[idx];

         }
          //Check if the word is complete or not
         return node->isCompleteWord;
     }

};
