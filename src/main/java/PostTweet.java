import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 * Created by jensinamart on 12/8/15.
 */
public class PostTweet {

    protected void postTweet(Twitter twitter){
    //No longer needed. Left in because it's cool.
    try{
        System.out.println(twitter.getScreenName());
            Status status = twitter.updateStatus("TESTING FROM JAVA");
            System.out.println("Successfully updated the status to [" + status.getText() + "].");
        } catch (
    TwitterException te) {
            te.printStackTrace();
            System.exit(-1);
        }

    }
}
