package leetcode.p2_add_two_numbers;

/*
    https://leetcode.com/problems/add-two-numbers/
 */

import java.util.ArrayList;
import java.util.List;

// Definition for singly-linked list.
class ListNode {
 int val;
 ListNode next;
 ListNode() {}
 ListNode(int val) { this.val = val; }
 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode sumNode = head;

        int overNum = 0;

        while (l1 != null || l2 != null) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int nodesValSum = overNum + l1Val + l2Val;
            overNum = nodesValSum / 10;
            sumNode.next = new ListNode(nodesValSum % 10);
            sumNode = sumNode.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (overNum > 0) {
            sumNode.next = new ListNode(overNum);
        }

        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1Third = new ListNode(3);
        ListNode l1Second = new ListNode(4, l1Third);
        ListNode l1First = new ListNode(2, l1Second);

        ListNode l2Third = new ListNode(4);
        ListNode l2Second = new ListNode(6, l2Third);
        ListNode l2First = new ListNode(5, l2Second);


        ListNode l11First = new ListNode(5);
        ListNode l22First = new ListNode(5);


        ListNode l111Second = new ListNode(8);
        ListNode l111First = new ListNode(1, l111Second);
        ListNode l222First = new ListNode(0);

        Solution solution = new Solution();
        solution.addTwoNumbers(l1First, l2First);
        solution.addTwoNumbers(l11First, l22First);
        solution.addTwoNumbers(l111First, l222First);
    }
}