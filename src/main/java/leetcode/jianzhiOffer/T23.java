package leetcode.jianzhiOffer;

public class T23 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode temA = headA;
        ListNode temB = headB;
        while (temA!=null){
            lenA++;
            temA = temA.next;
        }

        while (temB!=null){
            lenB++;
            temB = temB.next;
        }
        if (lenA > lenB){
            for (int i = 0; i < lenA -lenB; i++) {
                headA = headA.next;
            }
        }else {
            for (int i = 0; i < lenB -lenA; i++) {
                headB = headB.next;
            }
        }
        while (headA != null){
            if (headA == headB) return headA;
            else {
                headA = headA.next;
                headB = headB.next;
            }
        }
        return null;

    }
}
