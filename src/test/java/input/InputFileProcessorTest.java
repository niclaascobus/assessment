package input;

import org.junit.Assert;
import org.junit.Test;
import user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InputFileProcessorTest {

    @Test
    public void testInputFileReaderNoFile()   {
        //pass bogus file name and check for null List
        InputFileProcessor inputFileProcessor = new InputFileProcessor();
        List<String> fileLines = inputFileProcessor.readFile("//home/nico/Downloads/AllanGray/tweets.txt");
        Assert.assertNull(fileLines);
    }

    @Test
    public void testBuildUsers()    {
        InputFileProcessor inputFileProcessor = new InputFileProcessor();
        List<String> rawUserData = new ArrayList<>();
        rawUserData.add("Ward follows Alan");
        rawUserData.add("Alan follows Martin");
        rawUserData.add("Ward follows Martin, Alan");
        Map<String, User> users = inputFileProcessor.buildUsers(rawUserData);
        Assert.assertTrue(users.size() == 3);
    }

    @Test
    public void testBuildUsersIncorrectFormat()    {
        InputFileProcessor inputFileProcessor = new InputFileProcessor();
        List<String> rawUserData = new ArrayList<>();
        rawUserData.add("Ward follows Alan");
        rawUserData.add("Alan folows Martin");
        rawUserData.add("Ward follows Martin, Alan");
        Map<String, User> users = inputFileProcessor.buildUsers(rawUserData);
        Assert.assertNull(users);
    }

    @Test
    public void testAssignTweets()    {
        InputFileProcessor inputFileProcessor = new InputFileProcessor();
        List<String> rawUserData = new ArrayList<>();
        rawUserData.add("Ward follows Alan");
        rawUserData.add("Alan follows Martin");
        rawUserData.add("Ward follows Martin, Alan");
        Map<String, User> users = inputFileProcessor.buildUsers(rawUserData);
        Assert.assertTrue(users.size() == 3);

        List<String> tweets = new ArrayList<>();
        tweets.add("Alan> If you have a procedure with 10 parameters, you probably missed some.");
        tweets.add("Ward> There are only two hard things in Computer Science: cache invalidation, naming things and off-by-1 errors.");
        tweets.add("Alan> Random numbers should not be generated with a method chosen at random.");
        boolean success = inputFileProcessor.assignTweets(users, tweets);
        Assert.assertTrue(success);
    }

    @Test
    public void testAssignTweetsIncorrectFormat()    {
        InputFileProcessor inputFileProcessor = new InputFileProcessor();
        List<String> rawUserData = new ArrayList<>();
        rawUserData.add("Ward follows Alan");
        rawUserData.add("Alan follows Martin");
        rawUserData.add("Ward follows Martin, Alan");
        Map<String, User> users = inputFileProcessor.buildUsers(rawUserData);
        Assert.assertTrue(users.size() == 3);

        List<String> tweets = new ArrayList<>();
        tweets.add("Alan> If you have a procedure with 10 parameters, you probably missed some.");
        tweets.add("Ward There are only two hard things in Computer Science: cache invalidation, naming things and off-by-1 errors.");
        tweets.add("Alan> Random numbers should not be generated with a method chosen at random.");
        boolean success = inputFileProcessor.assignTweets(users, tweets);
        Assert.assertFalse(success);
    }
}
