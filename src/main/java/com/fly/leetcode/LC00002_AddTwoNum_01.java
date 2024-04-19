package com.fly.leetcode;

/**
 * https://leetcode.com/problems/add-two-numbers/
 * @author fly
 * @create 2024-04-19-23:11
 **/
public class LC00002_AddTwoNum_01 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode result = new LC00002_AddTwoNum_01().addTwoNumbers(l1, l2);
        System.out.println(result);
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int tmp = 0;
        ListNode first = null;
        ListNode tmpNode = null;
        ListNode t1 = l1;
        ListNode t2 = l2;
//        坑点1：tmp !=0
        while (t1 != null || t2 != null || tmp !=0) {
            int l = t1 == null ? 0 : t1.val;
            int r = t2 == null ? 0 : t2.val;
            int total = (l + r + tmp);
            int curVal = total % 10;
            tmp = total / 10;
            t1 = t1 != null ? t1.next : null;
            t2 = t2 != null ? t2.next : null;
            if (first == null) {
//                坑点2：没有tmpNode，导致结果最多两个节点
                first = new ListNode(curVal);
                tmpNode = first;
            } else {
                tmpNode.next = new ListNode(curVal);
                tmpNode = tmpNode.next;
            }
        }
        return first;
    }
}

//Definition for singly-linked list.
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
