package shigz.learn.y22.m9.w3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by 大史 on 2022/9/23
 */
public class FindRepeatedDnaSequences {

    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() >= 10) {
            Set<String> wordSet = new HashSet<>();
            Set<String> resSet = new HashSet<>();
            int index = 0;
            char[] chars = s.toCharArray();
            while (index <= s.length() - 10) {
                String word = new String(chars,index,10);
                if (!wordSet.add(word)) {
                    resSet.add(word);
                }
                index++;
            }
            return new ArrayList<>(resSet);
        } else return new ArrayList<>();
    }

}
