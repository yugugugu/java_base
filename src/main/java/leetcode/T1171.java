package leetcode;

import java.util.HashMap;
import java.util.Map;

public class T1171 {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode headPre = new ListNode();
        headPre.next = head;

        Map<Integer,ListNode> map = new HashMap<>();
        map.put(0,headPre);
        ListNode point = headPre.next;
        int sum = 0;
        while (point != null){
            sum += point.val;
            map.put(sum,point);
            point = point.next;
        }

        point = headPre;
        sum = 0;
        while (point != null){
            sum+=point.val;
            if (map.get(sum) != point ){
                point.next= map.get(sum).next;
            }
            point = point.next;
        }
        for(int key: map.keySet()){
            System.out.println(map.get(key).val);
        }
        return headPre.next;
    }
}
