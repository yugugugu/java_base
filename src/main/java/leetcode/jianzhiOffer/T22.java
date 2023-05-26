package leetcode.jianzhiOffer;

import jdk.nashorn.internal.runtime.regexp.joni.SearchAlgorithm;

public class T22 {
    public ListNode detectCycle(ListNode head) {
        ListNode A = head;
        ListNode B = head;
        while (A != null && B != null){
            A = A.next;
            B = B.next.next;
            if (A == B){
                B = head;
                while (A != B){
                    A = A.next;
                    B = B.next;
                }
                return A;
            }
        }
        return null;
    }
}
