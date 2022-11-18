package shigz.learn.y22.m10.w3;

import shigz.common.ListNode;

import java.util.Scanner;

/**
 * Created by 大史 on 2022/10/21
 */
public class SingleListOfK {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int count = in.nextInt();
            ListNode head = new ListNode(in.nextInt());
            ListNode current = head;
            for (int i = 1;i < count;i++) {
                current = add(in.nextInt(),current);
            }
            current = head;
            int k = in.nextInt();
            while (k > 0) {
                current = current.next;
                k--;
            }
            while (current != null) {
                head = head.next;
                current = current.next;
            }
            System.out.println(head.val);
        }
    }

    private static ListNode add(int num,ListNode current) {
        current.next = new ListNode(num);
        return current.next;
    }

}
