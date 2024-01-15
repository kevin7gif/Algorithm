package com.kevin;

/**
 * 19、 删除链表的倒数第 N 个结点
 *
 * @author kevin
 * @version 1.0
 * @date 2024-01-15 11:21
 */
public class RemoveNthFromEnd {
    /**
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     * <p>
     * 示例1：
     * 输入：head = [1,2,3,4,5], n = 2
     * 输出：[1,2,3,5]
     * <p>
     * 示例2：
     * 输入：head = [1], n = 1
     * 输出：[]
     */

    public class ListNode {
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 定义虚拟头节点
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        // 定义快慢指针来确定倒数第n个结点
        ListNode fast = dummyHead;
        ListNode slow = dummyHead;
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        // 循环到此处，快指针也已经先走了n+1个位置，然后慢指针开始走，循环完之后慢指针刚好走到要删除的前一个位置
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummyHead.next;
    }

}
