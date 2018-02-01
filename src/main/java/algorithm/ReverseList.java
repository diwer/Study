package algorithm;

/**
 * @author: wanheming
 * @since: 2018/2/1
 * describe: TODO
 **/

public class ReverseList {

    /**
     * @param head: n
     * @return: The new head of reversed linked list.
     */
    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode tail;
        tail = head;
        head = head.next;
        tail.next = null;
        while (head.next != null) {
            head = head.next;
            next.next = tail;
            tail = next;
            next = head;
        }
        head.next = tail;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode h = head;
        for (int i = 1; i < 3; i++) {
            head.next = new ListNode(i);
            head = head.next;
        }
        head = reverse(h);
        while (head.next != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}