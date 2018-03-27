package application;

import input.InputFileProcessor;
import user.User;

import java.util.List;
import java.util.Map;

public class AssessmentMain {

    public static void main(String[] args)  {
        InputFileProcessor inputFileProcessor = new InputFileProcessor();
        try {
            List<String> usersFromFile = inputFileProcessor.readFile("/home/nico/Downloads/AllanGray/user.txt");
            List<String> tweets = inputFileProcessor.readFile("/home/nico/Downloads/AllanGray/tweet.txt");
            Map<String, User> users = inputFileProcessor.buildUsers(usersFromFile);
            System.out.println("Done");
        } catch (Exception e)   {
            e.printStackTrace();
        }
    }
}
