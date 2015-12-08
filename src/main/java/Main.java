import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.List;

/**
 * Created by jensinamart on 12/8/15.
 */
public class Main {
    public static void main(String[] args) {
//        StreamGUI streamGUI = new StreamGUI();
        TimelineFeed timeline = new TimelineFeed();
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(timeline.getCkey())
                .setOAuthConsumerSecret(timeline.getCsecret())
                .setOAuthAccessToken(timeline.getAtoken())
                .setOAuthAccessTokenSecret(timeline.getAsecret());
        TwitterFactory factory = new TwitterFactory(cb.build());
        Twitter twitter = factory.getInstance();



        ////////////////////////////////// How to add to friends
        try {
            twitter.destroyFriendship("@pcgamer");
            System.out.print("removed @pcgamer!");
        } catch (TwitterException e) {
            e.printStackTrace();
        }

        ////////////////////////////////// How to search for something
//        Query query = new Query("potato");
//        QueryResult result = null;
//        try {
//            result = twitter.search(query);
//        } catch (TwitterException e) {
//            e.printStackTrace();
//        }
//        for (Status status : result.getTweets()) {
//            System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
//        }

            ////////////////////////////////// How to view timeline
//        try {
////            Twitter twitter = TwitterFactory.getSingleton();
//            TwitterFactory factory = new TwitterFactory(cb.build());
//            Twitter twitter = factory.getInstance();
//            List<Status> statuses = twitter.getHomeTimeline();
//            System.out.println("Showing home timeline.");
//            for (Status status : statuses) {
//                System.out.println(status.getUser().getName() + ":" +
//                        status.getText());
//            }

            ////////////////////////////////// How to post tweets
//            TwitterFactory factory = new TwitterFactory(cb.build());
//            Twitter twitter = factory.getInstance();
//
//            System.out.println(twitter.getScreenName());
//            Status status = twitter.updateStatus("TESTING FROM JAVA");
//            System.out.println("Successfully updated the status to [" + status.getText() + "].");
//        } catch (TwitterException te) {
//            te.printStackTrace();
//            System.exit(-1);
//        }
    }
}
