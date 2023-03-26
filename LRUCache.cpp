#include<bits/stdc++.h>
using namespace std;


class LRUCache {

     
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

           int get(int key) {
        if(mp.find(key) == mp.end()) return -1;
        
        makeRecentlyUsed(key);
        return mp[key].second;
    }

      void put(int key, int value) {
        //If already present in the map
        if(mp.find(key) != mp.end()){
            mp[key].second = value;
            makeRecentlyUsed(key);
        }else{
            //Not present and make a new entry
            dll.push_front(key);
            mp[key] = make_pair(dll.begin(), value);
            n--;
        }
        
        //If capacity has been exceeded
        if(n < 0){
            int key_tobe_deleted = dll.back();
            dll.pop_back();
            mp.erase(key_tobe_deleted); 
            n++;
        }
    }
        

         

};
