public class No2 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode();
        ListNode l1tail = l1;
        ListNode l2 = new ListNode();
        ListNode l2tail = l2;
        l1tail.next  = new ListNode(2);
        l1tail = l1tail.next;
        l1tail.next = new ListNode(4);
        l1tail = l1tail.next;
        l1tail.next = new ListNode(3);
        l1 = l1.next;



        l2tail.next  = new ListNode(5);
        l2tail = l2tail.next;
        l2tail.next = new ListNode(6);
        l2tail = l2tail.next;
        l2tail.next = new ListNode(4);
        l2 = l2.next;

        ListNode listNode = addTwoNumbers(l1, l2);

        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode tail;
        tail = head;
        int carry = 0;
        while(l1 != null || l2 != null){
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;
            carry = sum / 10;
            sum %= 10;
            tail.next = new ListNode(sum);
            tail = tail.next;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        if(carry != 0){
            tail.next = new ListNode(1);
        }
        return head.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
