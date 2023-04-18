#include <bits/stdc++.h>
using namespace std;
 

class HitCounter {
      queue<int> hits;

      public:
    /** Initialize your data structure here. */
    HitCounter() {
        
    }


    /** Record a hit. @param timestamp - The current timestamp (in seconds granularity). */
    void hit(int timestamp) {
        hits.push(timestamp);
    }

    /** Return the number of hits in the past 5 minutes.@param timestamp - The current timestamp (in seconds granularity). */
    int getHits(int timestamp) {
        while (!hits.empty() && hits.front() <= timestamp - 300) {
            hits.pop();
        }
        return hits.size();
    }


};

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter* obj = new HitCounter();
 * obj->hit(timestamp);
