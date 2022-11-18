package shigz.learn.y22.m10.w2.nested;

import java.util.Iterator;
import java.util.List;

/**
 * Created by 大史 on 2022/10/14
 */
public class NestedIterator  implements Iterator<Integer> {

    Integer val;
    List<NestedInteger> nestedList;
    int index = 0;
    NestedIterator subIterator;
    public NestedIterator(List<NestedInteger> nestedList) {
        this.nestedList = nestedList;
    }

    @Override
    public boolean hasNext() {
        while (val == null && index < nestedList.size()) {
            if (subIterator != null) {
                if (subIterator.hasNext()) {
                    val = subIterator.next();
                } else {
                    subIterator = null;
                    index += 1;
                }
            } else {
                NestedInteger nestedInteger = nestedList.get(index);
                if (nestedInteger.isInteger()) {
                    val = nestedInteger.getInteger();
                    index++;
                } else {
                    subIterator = new NestedIterator(nestedInteger.getList());
                    val = subIterator.next();
                }
            }
        }
        return val != null;
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            Integer result = val;
            val = null;
            return result;
        } else return null;
    }
}
