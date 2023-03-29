#include<bits/stdc++.h>
using namespace std;


class SubstringWithConcatenation{

  public:
    //Declare a global hashmap for <word,int>pair
     unordered_map<string,int>mp;


     //Declare the wordlength, substringSize and length of 
     // each word in given words dictionary
     int wordLength, substringSize, k;

      //Function to check if the substring starting at i
     // is a valid substring or not 
     bool check(int i, string s){


          //First copy the given hashmap 
         // into the temporary map
         unordered_map<string,int>dict;
         dict.insert(mp.begin(),mp.end());
  

         //It represents the number of words used 
         // in the given concatenation of words
         int wordsUsed = 0;
       
         //Start from index i and check for the substrings of 
         // length substringSize
         for(int j=i;j < i + substringSize; j += wordLength){
             //Find the first substring starting from 
             // i with length of wordLength
             string sub = s.substr(j, j+wordLength);

             if(dict[sub] > 0){
                 dict[sub]--;
                 wordsUsed++;
             }else{
                 break;
             }
         }
   
         return wordsUsed == k;

     }

         vector<int> findSubstring(string s, vector<string>&words){
             //size of the string 
           int n = s.length();

           //size of the words array
           k = words.size();

           //Find the length of the word in the dictionary
           wordLength = words[0].size();

           //Find the substring size
           substringSize = wordLength * k;

              //Build the hashmap for the given 
           //global map mp;
           for(auto word: words){
              mp[word]++;
           } 


           //Declare an answer array
           vector<int>answer;



           //Iterate over all the indices of the given string
           for(int i=0;i<n-substringSize+1; i++){
                if(check(i,s)){
                      answer.push_back(i);
                }
           }

           return answer;

         }
     
};
