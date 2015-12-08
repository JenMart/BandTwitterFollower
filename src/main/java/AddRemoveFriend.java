import twitter4j.Twitter;
import twitter4j.TwitterException;

import java.util.Scanner;

/**
 * Created by jensinamart on 12/8/15.
 */
public class AddRemoveFriend {
    Scanner scanner = new Scanner(System.in);
    protected void addFriend(Twitter twitter){
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
        System.out.println("Enter name of account to be removed");
        String input = scanner.next();
        try {
            twitter.destroyFriendship(input); //remove
            System.out.println(input + " Has been removed!");
        } catch (TwitterException e) {
            e.printStackTrace();
        }
    }
}
