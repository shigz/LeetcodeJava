package shigz.learn.y22.m10.w2;

import java.util.Stack;

/**
 * Created by 大史 on 2022/10/11
 */
public class RemoveDuplicateLetters {

    public String removeDuplicateLetters(String s) {
        int[] charCountArr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charCountArr[s.charAt(i) - 'a']++;
        }
        boolean[] usedArr = new boolean[26];
        Stack<Character> charStack = new Stack<>();
        int index = 0;
        while (index < s.length()) {
            int charIndex = s.charAt(index) - 'a';
            charCountArr[charIndex]--;
            if (!usedArr[charIndex]) {
                while (!charStack.empty() && charStack.peek() > s.charAt(index)) {
                    if (0 == charCountArr[charStack.peek() - 'a']) break;
                    usedArr[charStack.pop() - 'a'] = false;
                }
                usedArr[charIndex] = true;
                charStack.push(s.charAt(index));
            }
            index++;
        }
        StringBuilder sb = new StringBuilder();
        while (!charStack.empty()) {
            sb.append(charStack.pop());
        }
        return sb.reverse().toString();
    }

}
