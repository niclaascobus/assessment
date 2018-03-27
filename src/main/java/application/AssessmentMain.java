package application;

import input.InputFileProcessor;

import java.util.List;

public class AssessmentMain {

    public static void main(String[] args)  {
        InputFileProcessor inputFileProcessor = new InputFileProcessor();
        try {
            List<String> users = inputFileProcessor.readFile("/home/nico/Downloads/AllanGray/user.txt");
            List<String> tweets = inputFileProcessor.readFile("/home/nico/Downloads/AllanGray/tweet.txt");
            inputFileProcessor.buildUsers(users);
        } catch (Exception e)   {
            e.printStackTrace();
        }
    }
}
