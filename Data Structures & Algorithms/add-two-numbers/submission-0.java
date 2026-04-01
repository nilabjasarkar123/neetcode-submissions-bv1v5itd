/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    ListNode reverse(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return dummy;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head1 = (l1);
        ListNode head2 = (l2);
        ListNode res = new ListNode();
        ListNode temp = res;
        int sum = 0, carry = 0;
        while(head1 != null || head2 != null) {
            sum = ((head1 != null) ? head1.val : 0) + 
                ((head2 != null) ? head2.val : 0) + carry;
            carry = sum / 10;
            ListNode temp2 = new ListNode();
            temp2.val = sum % 10 ;
            System.out.println(temp2.val);
            res.next = temp2;
            res = res.next;
            if(head1 != null) head1 = head1.next;
            if(head2 != null) head2 = head2.next;
        }
        System.out.println(res.val);
        if(carry != 0) {
            ListNode temp2 = new ListNode();
            temp2.val = carry;
            res.next = temp2;
            res = res.next;
        }
      //return reverse(temp.next);
      return temp.next;
    }
}
