package jianzhi;

/**
 * @author 86184
 * @date 2022-11-2022/11/2-18:28
 */
public class fanzhuanlianbiao {
    public static ListNode reverseList(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode qian;
        ListNode hou;
        ListNode temp;

        qian = head;
        hou = head.next;
        while (hou != null) {
            head.next = null;

            temp = hou.next;
            hou.next = qian;

            qian = hou;
            hou = temp;
        }
        return qian;

    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
//        n3.next = n4;
        ListNode temp = n1;
        while(temp!=null){
            System.out.println(temp.val);
            temp = temp.next;
        }
        temp = reverseList(n1);
        while(temp!=null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

