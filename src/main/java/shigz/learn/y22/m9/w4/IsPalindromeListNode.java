package shigz.learn.y22.m9.w4;

import shigz.common.ListNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by 大史 on 2022/9/30
 */
public class IsPalindromeListNode {

    public boolean isPalindrome(ListNode head) {
        List<Integer> numList = new ArrayList<>();
        ListNode currentNode = head;
        while (currentNode != null) {
            numList.add(currentNode.val);
            currentNode = currentNode.next;
        }
        int left = 0;
        int right = numList.size() - 1;
        while (left < right) {
            if (!numList.get(left).equals(numList.get(right))) return false;
            left++;
            right--;
        }
        return true;
    }

}
