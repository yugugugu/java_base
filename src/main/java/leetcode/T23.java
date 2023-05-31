package leetcode;

public class T23 {
    //合并k个升序链表
    public ListNode mergeKLists(ListNode[] lists) {
        //使用归并的方式
        return merge(lists,0,lists.length-1);
    }

    private ListNode merge(ListNode[] lists, int begin, int end) {
        if (end -begin <= 1){
            if (end == begin) return lists[begin];
            else {
                return mergeTwoList(lists[begin],lists[end]);
            }
        }

        ListNode leftmMergeHead =  merge(lists,begin,(begin+end)/2);
        ListNode rightMergeHead =  merge(lists,(begin+end)/2+1,end);
        return mergeTwoList(leftmMergeHead,rightMergeHead);
    }

    //合并两个链表，返回合并的链表头
    private ListNode mergeTwoList(ListNode firstList, ListNode secondList) {
        ListNode head = new ListNode();
        ListNode point = head;

        while(firstList != null && secondList !=null){
            if (firstList.val < secondList.val){
                point.next = firstList;
                firstList =firstList.next;
            }else {
                point.next = secondList;
                secondList = secondList.next;
            }
            point = point.next;
            System.out.println(point.val);
        }
        if (firstList != null){
            point.next = firstList;
        }
        if (secondList != null){
            point.next = secondList;
        }
        return head.next;

    }
}
