package user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {

    private String userName;
    private Map<String, String> followers;
    private List<String> tweets;
    private Map<String, User> following;

    public User(String userName)    {
        this.userName = userName;
    }

    public void addFollower(String followerUserName)    {
        if(followers == null)   {
            followers = new HashMap<>();
        }
        if(!followers.containsKey(followerUserName)) {
            followers.put(followerUserName, followerUserName);
        }
    }

    public void addFollowing(User user)    {
        if(following == null)   {
            following = new HashMap<>();
        }
        if(!following.containsKey(user.getUserName())) {
            following.put(userName, user);
        }
    }

    public void addTweet(String tweet)  {
        if(tweets == null)  {
            tweets = new ArrayList<>();
        }
        tweets.add(tweet);
    }

    public void tweet() {
        System.out.println(userName);
        if(tweets != null) {
            for (String tweet : tweets) {
                System.out.println("@" + userName + ": " + tweet);
            }
            if (following != null) {
                for (User followingUser : following.values()) {
                    if(followingUser.getTweets() != null && followingUser.getTweets().size() > 0) {
                        for (String userTweet : followingUser.getTweets())
                            System.out.println("@" + followingUser.getUserName() + ": " + userTweet);
                    }
                }
            }
        }
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setFollowers(Map<String, String> followers) {
        this.followers = followers;
    }

    public List<String> getTweets() {
        return tweets;
    }

    public void setTweets(List<String> tweets) {
        this.tweets = tweets;
    }

    public Map<String, String> getFollowers() {
        return followers;

    }
}
