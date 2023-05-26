package leetcode.jianzhiOffer;

public class T24 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode mid = head;
        ListNode next = null;

        while (head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head =  next;
        }
        return pre;
    }
}
