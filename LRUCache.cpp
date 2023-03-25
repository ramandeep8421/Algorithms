#include<bits/stdc++.h>
using namespace std;


class LRUCache {
public:
     
     private:
        //n represents the capacity of the cache
         int n;

         //Actual queue
         list<int>dll;

         //Here we have the hashmap 
         map<int, pair<list<int>::iterator, int>>mp;
   
         //Function to put the item on the top
         void makeRecentlyUsed(int key){
             dll.erase(mp[key].first);
             dll.push_front(key);
             mp[key].first = dll.begin();
         }

    
    public:
        //Constructor to initialize the 
        //n with capacity
        LRUCache(int capacity){
             n = capacity;
        }

        //Function to get the recently used 
        //item 
        int get(int key){
            //if the cache does not 
            // contains the key, then return -1
            if(mp.find(key) == mp.end())return -1;

            //Set this key as the most recent used item
            makeRecentlyUsed(key);
            
            //Return the item in the linked list
            return mp[key].second;

            //If the capacity has been extended
            if(n < 0){
                 //Find the key to be deleted
                 //LEast recently used key 
                // has to be deleted
                  int key_to_be_deleted = dll.back();
                 
                 //Pop that key from the list
                 dll.pop_back();
                
                 //Erase the pointer in the hashmap
                 mp.erase(key_to_be_deleted);
                
                 //Increment the given capacity by one.
                 n++;
            }

        }

         

};

