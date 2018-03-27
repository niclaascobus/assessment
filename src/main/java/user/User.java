package user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {

    private String userName;
    private Map<String, String> followers;

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Map<String, String> getFollowers() {
        return followers;
    }
}
