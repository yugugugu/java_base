package leetcode.jianzhiOffer;

public class T27 {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode right = reverseList(slow);
        ListNode left = head;
        while (right != null){
            if (left == null) break;
            if(left.val != right.val) return  false;
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
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
