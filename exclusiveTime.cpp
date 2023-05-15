class Solution {
public:
     vector<int>exclusiveTime(int n, vector<string>&logs){
          //answer array to store the final answer
          vector<int>ans(n);


          //declare a stack to store the pairs
          stack<pair<int,int>>cur;


          //prev time variable 
          int prevTime = 0;

           for(auto & s: logs){

             int id = stoi(s.substr(0, s.find(':')));
             int time = stoi(s.substr(s.rfind(':') + 1));

             if(s.find('e') != -1){
                   ans[id] += time - prevTime + 1;
                   cur.pop();
                   prevTime = time + 1
             }
             else{
                  if(!cur.empty())ans[cur.top().first] += (time - prevTime);
                  cur.push({num, time});
                  prevTime = time;
             }
          }

          return ans;
     }
};
