package GitProject;

public class No83 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode();
        ListNode l1tail = l1;
        l1tail.next  = new ListNode(1);
        l1tail = l1tail.next;
        l1tail.next = new ListNode(1);
        l1tail = l1tail.next;
        l1tail.next = new ListNode(2);
        l1tail = l1tail.next;
        l1tail.next = new ListNode(2);
        l1tail = l1tail.next;
        l1tail.next = new ListNode(3);
        l1tail = l1tail.next;
        l1tail.next = new ListNode(3);
        System.out.println(l1.next);
        No83 no83 = new No83();
        ListNode listNode = no83.deleteDuplicates(l1.next);
        System.out.println(listNode);

    }
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode list = new ListNode();
        ListNode dummy = list;
        dummy.next = new ListNode(head.val);
        dummy = dummy.next;
        head = head.next;
        while(head != null){
            if(dummy.val < head.val){
                dummy.next = new ListNode(head.val);
                dummy = dummy.next;
            }
            head = head.next;
        }
        return list.next;

    }

}
