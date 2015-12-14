import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 * Created by jensinamart on 12/8/15.
 */
public class AuthData { //Holds all auth data
    static String ckey = "rlee33vXmHIlmR5tQljIX0ucD";
    static String csecret = "cUiIFESIXSSin9YJHYwLnVwnHpS64Ytj7csY9yFqshvAlkcaPg";
    static String atoken = "2836017980-DxYDsgHqGMyRIq1yH3Uf3Ar63eYCFhqawJAWGOw";
    static String asecret = "SruNXYjh0BpY4GQhiflXaxbB2XUhrCMslBrmrH2ViULnu";
//    ConfigurationBuilder cb = new ConfigurationBuilder();
//    TwitterFactory factory = new TwitterFactory(cb.build());
//    Twitter twitter = factory.getInstance();
//
//    public Twitter getTwitter() {
//        return twitter;
//    }
//
//    public TwitterFactory getFactory() {
//        return factory;
//    }

    public static String getAsecret() {return asecret;}

    public static String getCkey() {return ckey;}

    public static String getCsecret() {return csecret;}

    public static String getAtoken() { return atoken;}
}
