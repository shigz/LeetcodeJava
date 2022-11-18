package shigz.learn.y22.m10.w2.nested;

import java.util.List;

/**
 * Created by 大史 on 2022/10/14
 */
public class NestedInt implements NestedInteger {

    private Integer num;

    public NestedInt(Integer num) {
        this.num = num;
    }

    @Override
    public boolean isInteger() {
        return true;
    }

    @Override
    public Integer getInteger() {
        return num;
    }

    @Override
    public List<NestedInteger> getList() {
        return null;
    }

}
