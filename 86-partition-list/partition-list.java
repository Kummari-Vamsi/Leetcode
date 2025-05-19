
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode a=new ListNode(-1);
          ListNode b=new ListNode(-1);
        ListNode ta=a;
        ListNode tb=b;
        ListNode t=head;
        while(t!=null){
            if(t.val <x){
                ta.next=t;
                ta=ta.next;
            }
            else {
                tb.next=t;
                tb=tb.next;
            }
            t=t.next;
        }
        ta.next=b.next;
        tb.next=null;

        return a.next;

    }
}