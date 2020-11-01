package NiuKe;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class clearNode {
    public ListNode deleteDuplicates (ListNode head) {
        if(head==null) return head;
        ListNode dump = new ListNode();
        dump.next = head;
        ListNode p = head;
        ListNode pre = dump;
        while (p!=null&&p.next!=null){
            if(p.val == p.next.val){
                while (p.next!=null&&p.val==p.next.val){
                    p=p.next;
                }
                pre.next = p.next;
            }else {
                pre = p;
            }
            p=p.next;
        }
        return dump.next;
    }
}
