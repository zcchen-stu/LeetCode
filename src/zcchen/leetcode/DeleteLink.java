package zcchen.leetcode;

public class DeleteLink {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 双指针删除链表节点，必须保证前面的游标与后的游标相隔n
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode responseHead = new ListNode(-1, head);
        ListNode curCor = null;
        ListNode headCurCor = responseHead;
        int count = 0;
        while(head != null) {
            if(count == n) {
                break;
            }else {
                curCor = head.next;
            }
            head = head.next;
            count++;
        }

        while(curCor != null) {
            curCor = curCor.next;
            headCurCor = headCurCor.next;
        }
        headCurCor.next = headCurCor.next.next;
        return responseHead.next;
    }

    public static  void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        ListNode result = removeNthFromEnd(head, 2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
