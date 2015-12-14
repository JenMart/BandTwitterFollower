import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.User;

import java.util.List;
import java.util.Scanner;

/**
 * Created by jensinamart on 12/8/15.
 */
public class Friendslist {
    Scanner scanner = new Scanner(System.in);
    protected void addFriend(Twitter twitter){
        dislayFreinds(twitter);

        System.out.println("Enter name of account to be added");
        String input = scanner.next();
                try {
            twitter.createFriendship(input); //add
                    System.out.println(input + " Has been added!");
        } catch (TwitterException e) {
            e.printStackTrace();
        }
    }
    protected void removeFriend(Twitter twitter){
        dislayFreinds(twitter);
        System.out.println("Enter name of account to be removed");
        String input = scanner.next();
        try {
            twitter.destroyFriendship(input); //remove
            System.out.println(input + " Has been removed!");
        } catch (TwitterException e) {
            e.printStackTrace();
        }
    }
    public List dislayFreinds(Twitter twitter){
        try {
            Main.usrs = twitter.getFollowersList(twitter.getId(), -1);
        } catch (TwitterException e) {
            e.printStackTrace();
        }
//        for(User user : Main.usrs){
//            System.out.println(user.getScreenName());
//        }
        return null;
    }
}
