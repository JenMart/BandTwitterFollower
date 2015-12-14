import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.Scanner;

/**
 * Created by jensinamart on 12/8/15.
 */
public class SearchTweets {

    protected void SearchTwts(Twitter twitter, String findString){
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter search criteria:");
//        String input = scanner.next();

        Query query = new Query(findString);
//        QueryResult result = null;
        try {
            Main.result = twitter.search(query);
        } catch (TwitterException e) {
            e.printStackTrace();
        }
//        System.out.println("Search results for " + input + ":");
//        for (Status status : Main.result.getTweets()) {
//            System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
//        }
    }
}
