package shigz.learn.y22.m10.w4;

import shigz.common.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by 大史 on 2022/11/1
 */
public class RandomNodeVal {

    private final ListNode head;
    private final Random random;
    private int length;

    public RandomNodeVal(ListNode head) {
        random = new Random();
        this.head = head;
        length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
    }

    public int getRandom() {
        int count = random.nextInt(length);
        ListNode current = head;
        while (count > 0) {
            current = current.next;
            count--;
        }
        return current.val;
    }

}
