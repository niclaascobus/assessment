package user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {

    private String userName;
    private Map<String, String> followers;
    private List<String> tweets;

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
                if (followers != null) {
                    for (String follower : followers.keySet()) {
                        System.out.println("@" + follower + ": " + tweet);
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
