package leetcode;

public class T82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode headPre = new ListNode();
        headPre.next = head;

        ListNode pointPre = headPre;
        ListNode point = head;

        while(point != null && point.next != null){
            if (point.val == point.next.val){
                int val = point.val;
                while(point != null && point.val == val){
                    point = point.next;
                }
                pointPre.next = point;
            }else{
                pointPre = pointPre.next;
                point = point.next;
            }
        }
        return headPre.next;

    }
}
