import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.Scanner;

/**
 * Created by jensinamart on 12/8/15.
 */
public class SearchTweets {

    protected void SearchTwts(Twitter twitter, String findString){
        //Searched for requested results with the word 'concert' added in.
        Query query = new Query(findString + " concert");
        try {
            Main.result = twitter.search(query);
        } catch (TwitterException e) {
            e.printStackTrace();
        }
    }
}
