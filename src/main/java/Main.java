import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.List;
import java.util.Scanner;

/**
 * Created by jensinamart on 12/8/15.
 */
public class Main {
    public static void main(String[] args) {
//        StreamGUI streamGUI = new StreamGUI();
        //////////////////////////////////////////Important code
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(AuthData.getCkey())
                .setOAuthConsumerSecret(AuthData.getCsecret())
                .setOAuthAccessToken(AuthData.getAtoken())
                .setOAuthAccessTokenSecret(AuthData.getAsecret());
        TwitterFactory factory = new TwitterFactory(cb.build());
        Twitter twitter = factory.getInstance();
        //////////////////////////////////////////Important code
        TimelineFeed timeLine = new TimelineFeed();
        SearchTweets searchTweets = new SearchTweets();
        PostTweet postTweet = new PostTweet();
        AddRemoveFriend addRemoveFriend = new AddRemoveFriend();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your choice below: ");
        System.out.println("_________________________________ ");
        System.out.println("1. View Timeline \n2. Search for public tweet \n3. Post to your wall" +
                " \n4. Add friend \n5. Remove friend");

        int input = scanner.nextInt();

        switch (input){
            case 1: timeLine.PullTimelines(twitter);
                break;
            case 2: searchTweets.SearchTwts(twitter);
                break;
            case 3: postTweet.postTweet(twitter);
                break;
            case 4: addRemoveFriend.addFriend(twitter);
                break;
            case 5: addRemoveFriend.removeFriend(twitter);
                break;
            default:
                System.out.println("Invalid entry.");
                break;
        }
//        TimelineFeed timeLine = new TimelineFeed();
//        timeLine.PullTimelines(twitter);

        ////////////////////////////////// How to add/remove to friends *
//        try {
//            twitter.destroyFriendship("@pcgamer"); //remove
//            twitter.createFriendship("@pcgamer"); //add
//        } catch (TwitterException e) {
//            e.printStackTrace();
//        }
//
        ////////////////////////////////// How to search for something*
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

            ////////////////////////////////// How to view timeLine*
//        List<Status> statuses = null;
//        try {
//            statuses = twitter.getHomeTimeline();
//        } catch (TwitterException e) {
//            e.printStackTrace();
//        }
//        System.out.println("Showing home timeLine.");
//            for (Status status : statuses) {
//                System.out.println(status.getUser().getName() + ":" +
//                        status.getText());
//            }

            ////////////////////////////////// How to post tweets*
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
