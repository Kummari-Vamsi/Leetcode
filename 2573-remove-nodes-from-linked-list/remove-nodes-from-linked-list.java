class Solution {
    public ListNode removeNodes(ListNode head) {
        //reversing the linked list
        ListNode curr = head, prev = null, next = null;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode res = null;
        int rightMax = 0;
        curr = prev; //reversed linked list
        while(curr != null) {
            next = curr.next;
            if(rightMax <= curr.val) {
                curr.next = res;
                res = curr;
                rightMax = Math.max(rightMax, curr.val); //tracking the maximum value
            }
            curr = next;
        }

        return res;
    }
}