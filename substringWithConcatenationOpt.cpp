#include<bits/stdc++.h>
using namespace std;

class substringWithConcatenation{

public:
    //Hashmap to store the 
    //count of the words
	map<string,int>wordCount;

	//size of the string
	int n;

	//variable representing the wordlength
	int wordLength;

	//Substring size 
	int substringSize;

	//size of the words array
	int k;

	   //Function which finds the starting indices of the valid substrings
	void slidingWindow(int left, string s, vector<int>&answer){
         
       //temporary hashmap 
		map<string,int>wordsPresent;

		//variable to count the number of words used in the 
		//current window
		int wordsFound = 0;

			//Boolean variable to check for the given
		// if we have an excess word or not
		bool excessWord = false;

		//Iterate wordLength at a time 
		for(int right = left; right <= n-wordLength; right += wordLength){
                  //Find the substring of size wordLength
			     string sub = s.substring(right,right+wordLength);

                   //If we have sub as the word count
			     if(!wordCount[sub]){
			     	 wordsPresent.clear();
			     	 wordsFound = 0;
			     	 excessWord = false;
			     	 left = left + wordLength;
			     }
			     else{
			     	 //If we reach max window size or have an excess word
			     	 while(right - left == substringSize || excessWord){
			     	 	  string leftmostWord = s.substring(left,left+wordLength);
			     	 	  left += wordLength;
			     	 	  wordsCount[leftMostWord]--;

			     	 	  if(wordsCount[leftmostWord] >= wordsPresent[leftmostWord]){
			     	 	  	    //This word was an excess word
                                 excessWords = false;
			     	 	  }else{
			     	 	  	     //Otherwise we needed it 
                                 wordsFound--;
			     	 	  }
			     	 }

			     	 //Keep track of how many times 
			     	 // this word exists in the given window
			     	 wordPresent[sub]++;

			     	 if(wordPresent[sub] <= wordCount[sub]){
                         wordsFound++;
			     	 }else{
			     	 	//Found too many instances already
			     	 	excessWord = true;

			     	 }

			     	 if(wordsFound == k && !excessWord){
			     	 	 //Found a valid substring 
			     	 	 answer.push_back(left);
			     	 }

			     }

		}


	}

	//Find Substring Function
    vector<int>findSubstring(string s, vector<string>&words){
    	   //Find the length of of given string s
           n = s.length();

           //Length of the words
           k = words.size();

           //Size of each wrd
           wordLength = words[0].size();

           //Size of the substring
           substringSize = wordLength * k;

           //Iterate over the given words array
           // and make entries in it
           for(auto word: words){
           	  wordFound[word]++;
           }

           //Call the slidingWindow function wordLength times
           for(int i=0;i<wordLength;i++){
           	  slidingWindow(i,s,answer);
           }

           return answer;
    }


}
