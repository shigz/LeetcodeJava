package shigz.learn.y22.m10.w2.nested;

import java.util.List;

/**
 * Created by 大史 on 2022/10/14
 */
public class NestedList implements NestedInteger {

    private List<NestedInteger> list;

    public NestedList(List<NestedInteger> list) {
        this.list = list;
    }

    @Override
    public boolean isInteger() {
        return false;
    }

    @Override
    public Integer getInteger() {
        return null;
    }

    @Override
    public List<NestedInteger> getList() {
        return list;
    }

}
