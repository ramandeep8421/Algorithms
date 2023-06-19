#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    void countHaybales(vector<int>& haybales, vector<pair<int, int>>& queries) {
        int n = haybales.size();
        int Q = queries.size();

        sort(haybales.begin(), haybales.end());

        for (pair<int, int>& query : queries) {
            int ub = upperBound(haybales, query.second);
            int lb = lowerBound(haybales, query.first);

            cout << ub - lb << endl;
        }
    }

private:
    int upperBound(vector<int>& haybales, int target) {
        int low = 0;
        int high = haybales.size();

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (haybales[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    int lowerBound(vector<int>& haybales, int target) {
        int low = 0;
        int high = haybales.size();

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (haybales[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
};
