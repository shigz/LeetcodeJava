package shigz.learn.y22.m9.w3;

import shigz.common.ListNode;

/**
 * Created by 大史 on 2022/9/22
 */
public class GetInterSectionNode {


    //遍历完之后交换位置,则会在相同的地方相交
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode left = headA;
        ListNode right = headB;
        while (left != right) {
            left = left != null? left.next : headB;
            right = right != null? right.next : headA;
        }
        return left;
    }


    //双指针各自走到最后,内存空间占用较多
    public ListNode firstTry(ListNode headA, ListNode headB) {
        ListNode left = headA;
        int countLeft = 0;
        while (left != null) {
            countLeft++;
            left = left.next;
        }
        ListNode right = headB;
        int countRight = 0;
        while (right != null) {
            countRight++;
            right = right.next;
        }
        left = headA;
        right = headB;
        if (countLeft > countRight) {
            for (int i = 0;i < countLeft - countRight;i++) {
                left = left.next;
            }
        } else {
            for (int i = 0;i < countRight - countLeft;i++) {
                right = right.next;
            }
        }
        while (left != null && right != null) {
            if (left == right) return left;
            left = left.next;
            right = right.next;
        }
        return null;
    }

}
