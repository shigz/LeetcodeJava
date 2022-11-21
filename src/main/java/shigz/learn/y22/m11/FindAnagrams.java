package shigz.learn.y22.m11;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 大史 on 2022/11/18
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * <p>
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 * 示例 2:
 * <p>
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 * 提示:
 * <p>
 * 1 <= s.length, p.length <= 3 * 104
 * s 和 p 仅包含小写字母
 */
public class FindAnagrams {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> resultList = new ArrayList<>();
        int length = p.length();
        int[] targetCharCountArr = new int[26];
        int[] srcCharCountArr = new int[26];
        //统计目标字符串每个字母的个数
        for (char c : p.toCharArray()) {
            targetCharCountArr[c - 'a']++;
        }
        char[] srcCharArr = s.toCharArray();
        if (s.length() >= length) {
            int index = 0;
            //组成与目标字符串等长的窗口
            while (index < length) {
                srcCharCountArr[srcCharArr[index] - 'a']++;
                index++;
            }
            //首个窗口与模板字符串异位,添加 0 到结果
            if (isSame(targetCharCountArr, srcCharCountArr)) resultList.add(0);
            //逐个索引进行遍历
            while (index < srcCharArr.length) {
                //添加当前索引位置的字符
                srcCharCountArr[srcCharArr[index] - 'a']++;
                int startIndex = index - length;
                //移除当前窗口覆盖不到的字符
                srcCharCountArr[srcCharArr[startIndex] - 'a']--;
                //如果当前窗口与目标字符串异位,添加窗口的开始索引
                if (isSame(targetCharCountArr, srcCharCountArr)) resultList.add(startIndex + 1);
                index++;
            }
        }
        return resultList;
    }

    private boolean isSame(int[] targetCharCountArr, int[] srcCharCountArr) {
        for (int index = 0; index < 26; index++) {
            if (targetCharCountArr[index] != srcCharCountArr[index]) return false;
        }
        return true;
    }

}
