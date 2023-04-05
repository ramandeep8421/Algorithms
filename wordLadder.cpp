#include<bits/stdc++.h>
using namespace std;


class Solution {
     
     public:

     	int ladderLength(string beginWord, string endWord, vector<string>&wordList){
     		 //queue to hold the nodes 
     		 queue<pair<string,int>>qu;

     		 qu.push({beginWord,1});

     		 //declare the hashmaps
     		 unordered_map<string,int>mp,visited;

     		 //Iterate over the wordList and mark them in the mp
     		 for(auto it: wordList)mp[it]=1;

     		 while(!qu.empty()){
     		 	 //Size of the queue
     		 	int n = qu.size();

     		 	//Iterate n times
     		 	while(n--){

     		 		 pair<string,int>ptr = qu.front();

     		 		 qu.pop();

     		 		 //current word
     		 		 string currWord = ptr.first;

     		 		 if(currWord == endWord)return ptr.second;

     		 		 visited[currWord] = true;

     		 		 for(int i=0;i<currWord; i++){
     		 		 	 char org_char = currWord[i];

     		 		 	 for(char c = 'a'; c <= 'z'; c++){
     		 		 	 	   currWord[i] = c;
     		 		 	 	   if(!vis[currWord] and mp[currWord]){
     		 		 	 	   	   qu.push({currWord, ptr.second + 1});
     		 		 	 	   	   visited[currWord]=1;
     		 		 	 	   }
     		 		 	 }
     		 		 	 currWord[i]=org_char;
     		 		 }
     		 	}


     		 }

     		 return 0;
     	}
};
