package input;

import user.User;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class InputFileProcessor {

    public static final String SPACE = " ";

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
        StringTokenizer stringTokenizer = null;
        for(String userInfoLine : userInformation)  {
            stringTokenizer = new StringTokenizer(userInfoLine, SPACE);
            /*String userName = stringTokenizer.nextToken();
            String followers = stringTokenizer.nextToken();
            System.out.println("x" + userName + " x " + followers);*/
            while(stringTokenizer.hasMoreTokens())  {
                System.out.println(stringTokenizer.nextToken());
            }
        }
        return null;
    }
}
