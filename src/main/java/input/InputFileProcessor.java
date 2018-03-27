package input;

import user.User;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.*;

public class InputFileProcessor {

    public static final String SPACE = " ";
    public static final String FOLLOWS = "follows";
    public static final String COMMA = ",";

    public List<String> readFile(String fullyQualifiedName) throws Exception {
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        List<String> fileLines = new ArrayList<>();
        try {
            fis = new FileInputStream(fullyQualifiedName);
            isr = new InputStreamReader(fis, Charset.forName("US-ASCII"));
            br = new BufferedReader(isr);
            String aLine = br.readLine();
            while (aLine != null)   {
                System.out.println("******* " + aLine);
                if(!aLine.isEmpty()) {
                    fileLines.add(aLine);
                }
                aLine = br.readLine();
            }
        } catch (Exception e)   {
            System.out.println("Error reading user file");
            e.printStackTrace();
            throw e;
        } finally   {
            fis.close();
            isr.close();
            br.close();
        }
        return fileLines;
    }

    public Map<String, User> buildUsers(List<String> userInformation)  {
        Map<String, User> users = new HashMap<>();
        for(String userInfoLine : userInformation)  {
            String follower = userInfoLine.substring(0,userInfoLine.indexOf(FOLLOWS)).trim();

            User followingUser = null;

            if(!users.containsKey(follower))    {
                followingUser = new User(follower);
                users.put(follower, followingUser);
            }
            String beingFollowed = userInfoLine.substring(userInfoLine.indexOf(SPACE, userInfoLine.indexOf(FOLLOWS)), userInfoLine.length()).trim();
            System.out.println("**" + follower + "**" + beingFollowed + "**");


            User followedUser = null;
            StringTokenizer tokenizer = new StringTokenizer(beingFollowed, COMMA);
            while(tokenizer.hasMoreTokens()) {
                String aUserName = tokenizer.nextToken().trim();
                if(users.containsKey(aUserName)) {
                    followedUser = users.get(aUserName);
                }else {
                    followedUser = new User(aUserName);
                    users.put(aUserName, followedUser);
                }
                followedUser.addFollower(follower);
            }



        }
        return users;
    }
}
