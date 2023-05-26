package leetcode.jianzhiOffer;

public class T25 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //思路一：反转链表，链表反转过来相加之后反转回去
        //思路二：用bigDecimal 将两个链表转为bigdecimal计算之后再转换为链表
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        boolean addone = false;

        ListNode head = new ListNode();
        ListNode point = head;
        while (l1 != null && l2 !=null){
            int sum = l1.val + l2.val;
            sum += addone?1:0;
            if (sum >= 10) addone =  true;
            else  addone = false;
            point.next = new ListNode(sum%10);
            point = point.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null){
            int sum = l1.val;
            sum += addone?1:0;
            if (sum >= 10) addone =  true;
            else  addone = false;
            point.next = new ListNode(sum%10);
            point = point.next;
            l1 = l1.next;
        }
        while (l2 != null){
            int sum = l2.val;
            sum += addone?1:0;
            if (sum >= 10) addone =  true;
            else  addone = false;
            point.next = new ListNode(sum%10);
            point = point.next;
            l2 = l2.next;
        }

        if (addone){
            point.next = new ListNode(1);
            point = point.next;
        }
        return reverseList(head.next);

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
