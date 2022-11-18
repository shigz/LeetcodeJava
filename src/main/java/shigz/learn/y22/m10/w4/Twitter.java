package shigz.learn.y22.m10.w4;

import java.util.*;

/**
 * Created by 大史 on 2022/10/31
 */
public class Twitter {

    //该方案缺陷为未设置仅保留每个用户最新的 10 条推文,且该列表的大小不可控,好处是不需要进行合并
    //用户发 tweet 列表,按发推时间加入队列
    // 每个元素为长度为 2 的数组
    // 第一个值为用户 ID,第二个值为 tweetId
    private final List<int[]> userTweetList = new ArrayList<>();
    //用户关注 Map
    // key 为用户
    // value 为关注用户 Set
    private final Map<Integer, Set<Integer>> followMap = new HashMap<>();

    public Twitter() {

    }

    public void postTweet(int userId, int tweetId) {
        userTweetList.add(new int[]{userId,tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {
        //倒序遍历 tweet 列表,获取最新的自身发布或关注用户发布的 10 条 tweet
        List<Integer> resultList = new ArrayList<>();
        int index = userTweetList.size() - 1;
        while (index >= 0 && resultList.size() < 10) {
            int user = userTweetList.get(index)[0];
            if (userId == user || (followMap.containsKey(userId) && followMap.get(userId).contains(user))) {
                resultList.add(userTweetList.get(index)[1]);
            }
            index--;
        }
        return resultList;
    }

    public void follow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)) {
            //有关注 set,添加到关注 set
            followMap.get(followerId).add(followeeId);
        } else {
            //无关注 set,新建关注 set,添加到关注 set 并添加到用户关注 set map
            Set<Integer> followeeSet = new HashSet<>();
            followeeSet.add(followeeId);
            followMap.put(followerId,followeeSet);
        }
    }

    public void unfollow(int followerId, int followeeId) {
        //从关注列表中移除指定用户
        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }

}
