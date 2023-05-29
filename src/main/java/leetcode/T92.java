package leetcode;

import java.util.List;

public class T92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode headPre = new ListNode();
        ListNode tailNext = null;
        headPre.next = head;

        ListNode reverseBeginPre = headPre;
        for (int i = 0; i < left-1; i++) {
            reverseBeginPre = reverseBeginPre.next;
        }
        tailNext =headPre;
        for (int i = 0; i < right; i++) {
            tailNext = tailNext.next;
        }
        ListNode temPoint = tailNext.next;
        tailNext.next = null;
        tailNext = temPoint;
        reverseBeginPre.next = reveseList(reverseBeginPre.next);

        while (reverseBeginPre.next != null){
            reverseBeginPre= reverseBeginPre.next;
        }
        reverseBeginPre.next = tailNext;

        return headPre.next;

    }

    private ListNode reveseList(ListNode reverseBegin) {

        ListNode first =  reverseBegin;
        ListNode second = reverseBegin.next;
        first.next = null;
        while (second !=null){
            ListNode tem = second.next;
            second.next = first;
            first = second;
            second = tem;
        }
        return first;
    }
}
