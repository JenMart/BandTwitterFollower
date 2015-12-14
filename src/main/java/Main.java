import twitter4j.*;

import java.util.List;


/**
 * Created by jensinamart on 12/8/15.
 */
//Database called TWEETS. TWTS VARCHAR(255),USERS VARCHAR(255), HASTAG VARCHAR(255), DATEPOSTED DATETIME
public class Main {
    public static List<Status> statuses = null;
    public static List<User> usrs = null;
    public static QueryResult result = null;
    public static DBase dBase;
//    public static ConfigurationBuilder cb = new ConfigurationBuilder();
//    public static TwitterFactory factory = new TwitterFactory(cb.build());
//    public static Twitter twitter = factory.getInstance();

    public static void main(String[] args) {
        StreamGUI streamGUI = new StreamGUI(); //Starts up GUI
        dBase = new DBase();
        dBase.initDB(); //Finds and creates table (if needed)

    }
}
