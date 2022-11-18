package shigz.learn.y22.m10.w2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by 大史 on 2022/10/9
 */
public class RemoveInvalidParentheses {

    private String s;
    private int n;
    private Set<String> cache;
    private List<String> ans;
    private StringBuilder sb;

    public List<String> removeInvalidParentheses(String s_) {
        s = s_;
        int l = 0, r = 0;
        n = s.length();
        cache = new HashSet<>();
        ans = new ArrayList<>();
        sb = new StringBuilder();
        for(int i=0;i<n;i++){
            if(s.charAt(i) == '(')
                l++;
            else if(s.charAt(i) == ')')
                if(l > 0)
                    l--;
                else
                    r++;
        }
        dfs(0, 0, 0, l, r);
        return ans;

    }

    private void dfs(int idx, int cl, int cr, int dl, int dr){
        if(cr > cl || dl < 0 || dr < 0)
            return;
        String key = sb.toString() + "#" + idx;
        if(cache.contains(key))
            return;
        cache.add(key);
        if(idx == n){
            if(dl == 0 && dr == 0)
                ans.add(sb.toString());
            return;
        }
        char c = s.charAt(idx);
        if(c == '(')
            dfs(idx + 1, cl, cr, dl-1,dr);
        else if(c == ')')
            dfs(idx + 1, cl, cr, dl, dr-1);
        sb.append(c);
        dfs(idx+1, c=='('?cl+1:cl, c==')'?cr+1:cr,dl,dr);
        sb.delete(sb.length()-1,sb.length());
    }

}
