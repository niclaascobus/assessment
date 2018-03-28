package application;

import input.InputFileProcessor;
import user.User;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AssessmentMain {

    public static void main(String[] args)  {
        if(args.length != 2)    {
            System.out.println("Please provide the fully qualified names to the (1) user and (2) tweet files");
            return;
        }
        InputFileProcessor inputFileProcessor = new InputFileProcessor();
        try {
            List<String> usersFromFile = inputFileProcessor.readFile(args[0]);
            List<String> tweets = inputFileProcessor.readFile(args[1]);
            Map<String, User> users = inputFileProcessor.buildUsers(usersFromFile);
            if(users == null)   {
                System.out.println("Could not load users");
                return;
            }
            boolean success = inputFileProcessor.assignTweets(users, tweets);
            if(!success)    {
                System.out.println("Could not assign tweets");
                return;
            }
            Collection<User> allUsers = users.values();
            List<User> sortedUsers = allUsers.stream().sorted((user1, user2) -> user1.getUserName().compareTo(user2.getUserName())).collect(Collectors.toList());
            for(User aUser : sortedUsers)  {
                aUser.tweet();
            }
        } catch (Exception e)   {
            e.printStackTrace();
        }
    }
}
