class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        
         ListNode* prevNode = NULL;
         ListNode* current = head;

         while(head){
                 current = head->next;
                 head->next = prevNode;
                 prevNode = head;
                 head = current;
         }

         return prevNode;
          
    }
};
