package GitProject;

public class No160 {
    int i = 0;
    public static void main(String[] args) {
        No160 no160 = new No160();
        int[] a = {1,9,1,2,4};
        int[] b = {3,2,4};
        ListNode headA = new ListNode(a[0]);
        ListNode headB = new ListNode(b[0]);
        ListNode dumyA = headA, dumyB = headB;
        ListNode jiao = null;
        for(int i = 1; i < a.length; i++){
            headA.next = new ListNode(a[i]);
            headA = headA.next;
            if(i == 3){
                jiao = headA;
            }
        }
        headB.next = jiao;

        ListNode intersectionNode = no160.getIntersectionNode(dumyA, dumyB);
        System.out.println(intersectionNode.val);
//        while (dumyA != null){
//            System.out.println(dumyA.val);
//            dumyA = dumyA.next;
//        }
    }

    public ListNode getIntersectionNode(ListNode a, ListNode b) {
        ListNode a1, b1;
        a1 = a;
        b1 = b;
        while(a1 != b1){
            i++;
            System.out.println("a1 = " + a1.val + " ,b1 =" + b1.val);
            if(a1.next == null){
                System.out.println("1111111111111");
                a1.next = b;
            }
            if(b1.next == null){
                b1.next = a;
            }
            if(i ==12){
                break;
            }
            a1 = a1.next;
            b1 = b1.next;

        }
        return a1;
    }


    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        // p1 指向 A 链表头结点，p2 指向 B 链表头结点
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            // p1 走一步，如果走到 A 链表末尾，转到 B 链表
            if (p1 == null) p1 = headB;
            else            p1 = p1.next;
            // p2 走一步，如果走到 B 链表末尾，转到 A 链表
            if (p2 == null) p2 = headA;
            else            p2 = p2.next;
        }
        return p1;
    }
}
