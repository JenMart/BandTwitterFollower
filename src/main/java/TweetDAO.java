import java.util.Date;

/**
 * Created by jensinamart on 12/9/15.
 */
public class TweetDAO {
    //TWTID BIGINT NOT NULL PRIMARY KEY, TWT VARCHAR(140)," +
    //"USER VARCHAR(15) NOT NULL, DATEPOSTED DATETIME NOT NULL
    long id;
    String msg;
    String user;

    public Date getPostDate() {
        return postDate;
    }

    public String getMsg() {
        return msg;
    }

    public String getUser() {
        return user;
    }

    public long getId() {
        return id;
    }

    Date postDate;
}
