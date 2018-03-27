package application;

import input.InputFileReader;

public class AssessmentMain {

    public static void main(String[] args)  {
        InputFileReader inputFileReader = new InputFileReader();
        try {
            inputFileReader.readFile("/home/nico/Downloads/AllanGray/user.txt");
            inputFileReader.readFile("/home/nico/Downloads/AllanGray/tweet.txt");
        } catch (Exception e)   {
            e.printStackTrace();
        }
    }
}
