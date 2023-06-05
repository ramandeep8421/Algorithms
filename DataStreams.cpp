class SummaryRanges {
public:
          set<int>values;

          SummaryRanges(){};

          void addValue(int value){
               values.insert(value);
          }

          vector<vector<int>>getIntervals(){
              if(values.empty())
                  return {};

              vector<vector<int>>intervals;

              int left = -1, right = -1;

              for(auto it: values){
                   if(left < 0){
                      left = right = it;
                   }else if(it == right + 1){
                      right = it;
                   }else{
                      intervals.push_back({left,right});
                      left = right = it;
                   }
              }

              intervals.push_back({left,right});

              return intervals;
          }

};
