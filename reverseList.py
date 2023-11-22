class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prevNode = null;
        ListNode current = head;

        while (head != null) {
            current = head.next;
            head.next = prevNode;
            prevNode = head;
            head = current;
        }

        return prevNode;
    }
}
