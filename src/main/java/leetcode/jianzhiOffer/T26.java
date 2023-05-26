package leetcode.jianzhiOffer;

public class T26 {
    public void reorderList(ListNode head) {
        //把后半部分翻转过来，然后将两个链表合成一条
        int len = 0;
        ListNode right = head;
        while (right != null){
            len++;
            right = right.next;
        }
        
        right = head;
        for (int i = 0; i < (len-1)/2; i++) {
            right = head.next;   
        }

        ListNode tem = right.next;
        right.next = null;
        right = tem;
        System.out.println(right.val);

        right = reverseList(right);
        
        ListNode left = head;
        while (right != null){
            ListNode temleft = left.next;
            ListNode temright = right.next;

            left.next = right;
            right.next = temleft;

            left = temleft;
            right = temright;

        }

        
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
