/**
 * Created by jensinamart on 12/9/15.
 */
import java.sql.*;
import java.util.LinkedList;
import java.util.Scanner;

public class DBase {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_CONNECTION_URL = "jdbc:mysql://localhost:3306/test";
    static final String USER = "jensinamart"; //TODO replace with your username
    static final String PASSWORD = "password"; //TODO replace with your password

    protected void dBase(){
        Statement statement = null;
        Connection conn = null;
        ResultSet resultSet = null;
        PreparedStatement psInsert = null;
        LinkedList allStatements = new LinkedList();
        try {
            //Instantiate the driver
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Can't instantiate driver class.");
            cnfe.printStackTrace();
            System.exit(-1);
        }
        try {
            conn = DriverManager.getConnection(DB_CONNECTION_URL, USER, PASSWORD);
            statement = conn.createStatement();
            allStatements.add(statement);

            //TWEETS TABLE holds data for tweets, tweet ids, user names and posted dates
            String createTwt = "CREATE TABLE TWEETS(TWTID BIGINT NOT NULL, TWT VARCHAR(140)" +
                    "USERS VARCHAR(15) NOT NULL, DATEPOSTED DATETIME NOT NULL, PRIMARY KEY(TWTID))";
            //HASHTAGS table used to store hashtags and their hashtag ID's
            String createHash = "CREATE TABLE HASHTAGS(HASHID BIGINT NOT NULL, HASHTAGS VHARCHAR(140) NOT NULL, PRIMARY KEY(HASHID))";
            //TWEETHASH is a table that connects the above tables into a many/many relationship
            String createTwtHash = "CREATE TABLE TWEETHASH(ID BIGINT NOT NULL AUTO_INCREMENT, TWITID BIGINT NOT NULL," +
                    " HASHID BIGINT NOT NULL, PRIMARY KEY(ID), FOREIGN KEY(HASHID), FOREIGN KEY(TWITID))";
            try {
                statement.executeUpdate(createTwt);
                statement.executeUpdate(createHash);
                statement.executeUpdate(createTwtHash);
                System.out.println("Created tables");
            } catch (SQLException sqle) {

            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
