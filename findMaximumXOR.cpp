class Solution {
public:

    struct TrieNode{
         TrieNode* zero;
         TrieNode* one; // TrieNode* link[2];
    };

    void insert(TrieNode* root, int n){
           
           TrieNode* curr = root;
           for(int i=31;i>=0;i--){
                   int bit = (n >> i) & 1;
                   if(bit == 0){
                         if(curr->zero == nullptr){
                            TrieNode* newNode = new TrieNode();
                            curr->zero = newNode;
                         }
                          curr = curr->zero; 
                   }else{
                          
                           if(curr->one == nullptr){
                                   TrieNode* newNode = new TrieNode();
                                   curr->one = newNode;
                           }
                           curr = curr->one;

                   }
           }
    }

    int maximizeXor(TrieNode* root, int n){
            TrieNode* curr = root;
        int ans = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (n >> i) & 1;
            if (bit == 1) {
                if (curr->zero != nullptr) {  
                    ans += (1 << i); 
                    curr = curr->zero;
                }
                else {
                    curr = curr->one;   
                }
            }
            else {
                
                if (curr->one != nullptr) {   
                    ans += (1 << i);
                    curr = curr->one;
                }
                else {
                    curr = curr->zero;
                }
            }
        }
        return ans;
    }
 
    int findMaximumXOR(vector<int>& nums) {
      int n = nums.size();
        TrieNode* root = new TrieNode();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            insert(root, nums[i]);   
        }
        for (int i = 1; i < n; i++) {
            ans = max(ans, maximizeXor(root, nums[i]));  
        }
        return ans;
    }
};
