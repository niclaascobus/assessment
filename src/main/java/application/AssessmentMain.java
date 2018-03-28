package application;

import input.InputFileProcessor;
import user.User;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class AssessmentMain {

    public static void main(String[] args)  {
        if(args.length != 2)    {
            System.out.println("Please provide the fully qualified names to the user and tweet files");
            return;
        }
        InputFileProcessor inputFileProcessor = new InputFileProcessor();
        try {
            List<String> usersFromFile = inputFileProcessor.readFile(args[0]);
            List<String> tweets = inputFileProcessor.readFile(args[1]);
            Map<String, User> users = inputFileProcessor.buildUsers(usersFromFile);
            inputFileProcessor.assignTweets(users, tweets);
            Collection<User> allUsers = users.values();
            List<User> sortedUsers = allUsers.stream().sorted((user1, user2) -> user1.getUserName().compareTo(user2.getUserName())).collect(Collectors.toList());
            for(User aUser : sortedUsers)  {
                aUser.tweet();
            }
            System.out.println("Done");
        } catch (Exception e)   {
            e.printStackTrace();
        }
    }
}
