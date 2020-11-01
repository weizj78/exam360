package NiuKe;

public class ReverseK {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
       // head.next.next.next.next = new ListNode(5);
        head = reverseKGroup(head,2);
        while (head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }
    public static ListNode reverseKGroup (ListNode head, int k) {
        ListNode dump = new ListNode(0);
        dump.next = head;
        ListNode pre = head;//存储链自定义的表头
        ListNode p = head;//开始指向表头
        ListNode temphead = dump;
        ListNode temp;
        ListNode nextTempHead;
        int num = 1;
        while (p!=null) {
            if(num%k==0){
                p = p.next;
                temphead.next = p;
                nextTempHead = pre;
                while (pre!=p){
                    temp = pre.next;
                    pre.next = temphead.next;
                    temphead.next = pre;
                    pre = temp;
                }
                temphead = nextTempHead;
                pre = p;
                num=1;
                continue;
            }
            num++;
            p = p.next;
        }
        return dump.next;
    }
}
