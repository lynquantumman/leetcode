/*
TwitterDesign
Design a simplified version of Twitter where users can post tweets, 
follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed.
Your design should support the following methods:

    postTweet(userId, tweetId): Compose a new tweet.
    getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. 
    Each item in the news feed must be posted by users who the user followed or by the user herself.
    Tweets must be ordered from most recent to least recent.
    follow(followerId, followeeId): Follower follows a followee.
    unfollow(followerId, followeeId): Follower unfollows a followee.

*/
import java.util.*;
import java.text.*;
class Twitter {
	public static int USER_NUMBER=0;
	public static Map<Integer, Twitter> twitterContainer = new TreeMap<Integer, Twitter>();//mapping from userId to Twitter
	//以下两个成员变量会在初始化函数中进行初始化
	Map<Integer, Twitter> followees;
	Map<Integer, Tweet> tweets;//这里也用map实现，每一条tweetId对应一条tweet,tweet以类封装，其中含有时间等信息
	int userId;
    /** Initialize your data structure here. */
    public Twitter() {
    	//whom does this twitter followed?
        followees = new TreeMap<Integer, Twitter>();
        userId = USER_NUMBER;

        USER_NUMBER++;
        tweets = new TreeMap<Integer, Tweet>();
        Twitter.twitterContainer.put(userId, this);
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {//add(int index, E element)
    	Tweet twt = new Tweet();
        Twitter.twitterContainer.get(userId).tweets.put(tweetId, twt);//这里应加入时间因素
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
    	// 这里的思路是
    	// 将每个人的tweets合并成一个Map
    	// 将Map变成一个entrySet，然后对entrySet按值进行排序

    	//here we need a tm to mean the tweets' Map
    	Map<Integer, Tweet> tm = new TreeMap<Integer, Tweet>();
        Map<Integer, Twitter> fes = Twitter.twitterContainer.get(userId).followees;
        Set<Integer> fesKeySet = fes.keySet();//followees' set

        for(int followeeId:fesKeySet){
        	Map<Integer, Tweet> ts = Twitter.twitterContainer.get(followeeId).tweets;
        	tm.putAll(ts);//这里应该用多路归并排序，选出10个tweets, 然后停止。
        }

        
        
        ArrayList<Map.Entry<Integer, Tweet>> tmEntryList = 
        	new ArrayList<Map.Entry<Integer, Tweet>>(tm.entrySet());
        //here we need to sort the tmEntrySet
        Collections.sort(tmEntryList, new Comparator<Map.Entry<Integer, Tweet>>(){ 
        	@Override
        	public int compare(Map.Entry<Integer, Tweet> a, Map.Entry<Integer, Tweet> b){
        		return a.getValue().compareTo(b.getValue());
        	}
         });//这里Comparator使用了匿名内部类
        
        Iterator<Map.Entry<Integer, Tweet>> iter = tmEntryList.iterator();

        LinkedList<Integer> nf = new LinkedList<Integer>();
        int count = 0;
        while(iter.hasNext()){
        	if(count==10)
        		break;
        	nf.addFirst(iter.next().getKey());
        	count++;
        }
        return nf;
    }
    
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId){
    	Twitter fe = Twitter.twitterContainer.get(followeeId); 
        Twitter.twitterContainer.get(followerId).followees.put(followeeId, fe);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
    	Integer fwId = followeeId;//这里是装箱操作以便下面的remove
        Twitter.twitterContainer.get(followerId).followees.remove(fwId);
    }

    class Tweet implements Comparable<Tweet>
    {
    	Date d;
    	public Tweet(){//initialization
    		d = new Date();//d itself can be compared.
    	}
    	@Override
    	public int compareTo(Tweet tw){//the comparing method of Tweet
    		return d.compareTo(tw.d);
    	}
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
class TwitterDesign{
	public static void main(String[] args){
		//we use Map to realize the mapping from userId to the Tweeter.
		Twitter zs = new Twitter();//0
		Twitter ls = new Twitter();//1
		Twitter ww = new Twitter();//2
		zs.follow(0,1);
		zs.follow(0,2);
		ls.postTweet(1,0);
		ls.postTweet(1,1);
		ls.postTweet(1,2);
		ww.postTweet(2,5);
		zs.unfollow(0,2);
		System.out.println(zs.getNewsFeed(0));
	}
}