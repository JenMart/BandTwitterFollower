/**
 * Created by jensinamart on 12/9/15.
 */
import twitter4j.Status;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class DBase {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_CONNECTION_URL = "jdbc:mysql://localhost:3306/test";
    static final String USER = "jensinamart"; //TODO replace with your username
    static final String PASSWORD = "password"; //TODO replace with your password
    private Connection createConn() throws SQLException{
        return DriverManager.getConnection(DB_CONNECTION_URL, USER, PASSWORD);
    }

    public void initDB(){
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
            conn = createConn();
            statement = conn.createStatement();
            String checkForTweetTable = "SELECT COUNT(*) AS table_count FROM information_schema.tables WHERE table_schema = 'test' AND table_name = 'TWEETS' ";
            resultSet = statement.executeQuery(checkForTweetTable);
            resultSet.first();
            int tableCount = resultSet.getInt("table_count");
            if (tableCount == 0) {
                //TWEETS TABLE holds data for tweets, tweet ids, user names and posted dates
                String createTwt = "CREATE TABLE TWEETS(TWTID BIGINT NOT NULL PRIMARY KEY, TWT VARCHAR(140)," +
                        "USER VARCHAR(15) NOT NULL, DATEPOSTED DATETIME NOT NULL)";
                statement.executeUpdate(createTwt);
                System.out.println("Created tables");
            }

//            //HASHTAGS table used to store hashtags and their hashtag ID's
//            String createHash = "CREATE TABLE HASHTAGS(HASHID BIGINT NOT NULL, HASHTAGS VHARCHAR(140) NOT NULL, PRIMARY KEY(HASHID))";
//            statement.executeUpdate(createHash);
//
//            //TWEETHASH is a table that connects the above tables into a many/many relationship
//            String createTwtHash = "CREATE TABLE TWEETHASH(ID BIGINT NOT NULL AUTO_INCREMENT, TWITID BIGINT NOT NULL," +
//                    " HASHID BIGINT NOT NULL, PRIMARY KEY(ID), FOREIGN KEY(HASHID), FOREIGN KEY(TWITID))";
//            statement.executeUpdate(createTwtHash);



//            String prepStatInsert = "INSERT INTO TWEETS VALUES ( ?, ?, ?, ?)", (status.getText());
            //TWTID BIGINT, TWT VARCHAR(140), USERS VARCHAR(15),  DATEPOSTED DATETIME
//            psInsert = conn.prepareStatement(prepStatInsert);
//            allStatements.add(psInsert);
//status.getUser().getScreenName() + ":" + status.getText()
//            for (Status status : Main.result.getTweets()){
//                String add = "INSERT INTO TWEETS VALUES ("+ status.getId() + "," + status.getText()
//                        + "," + status.getUser().getScreenName() + "," + status.getCreatedAt() +")";
//                statement.executeUpdate(add);
//                String prepStatInsert = "INSERT INTO TWEETS VALUES ( ?, ?, ?, ?)";
//                System.out.println(status.getText());
//                psInsert.setInt(status.getText());
//                psInsert.setDate(2, Date.valueOf("2014-04-05"));
//                psInsert.setDouble(3, 5.00);
//                psInsert.executeUpdate();
//            }

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException se) {}
            try {
                conn.close();
            } catch (SQLException se) {}
        }

    }

    public List readTwtTable(){

        Connection conn = null;
        Statement statement = null;
        List<TweetDAO> tweets = new ArrayList<TweetDAO>();
        try {
            String search = "SELECT * FROM TWEETS ";
            conn = createConn();
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(search);
            while (resultSet.next()){
                TweetDAO tweet = new TweetDAO();
                tweet.id = resultSet.getLong("TWTID");
                tweet.msg = resultSet.getString("TWT");
                tweet.user = resultSet.getString("USER");
                tweet.postDate = resultSet.getDate("DATEPOSTED");
                tweets.add(tweet);
            }

            return tweets;
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }finally {
            try {
                statement.close();
            } catch (SQLException se) {}
            try {
                conn.close();
            } catch (SQLException se) {}
        }
        return null;
    }
    public void writeTwtTable(){
        Connection conn = null;
        Statement statement = null;
        try {
            conn = createConn();
            statement = conn.createStatement();
            for (Status status : Main.result.getTweets()) {
                if (checkTwtTable(String.valueOf(status.getId()))){
                    String add = "INSERT INTO TWEETS VALUES (" + status.getId() + "," + status.getText()
                            + "," + status.getUser().getScreenName() + "," + status.getCreatedAt() + ")";
                    statement.executeUpdate(add);
                }
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }finally {
            try {
                statement.close();
            } catch (SQLException se) {}
            try {
                conn.close();
            } catch (SQLException se) {}
        }
    }
    public Boolean checkTwtTable(String id){
        Connection conn = null;
        Statement statement = null;
        Boolean tweetExists = false;
        try {
            conn = createConn();
            statement = conn.createStatement();

            String check = "SELECT TWTID FROM TWEET WHERE TWTID IN("+ id +")";
            ResultSet resultSet = statement.executeQuery(check);
            if(resultSet.next()){
                tweetExists = true;
            }

        }catch (SQLException e){
            System.err.println(e.getMessage());
        }finally {
            try {
                statement.close();
            } catch (SQLException se) {}
            try {
                conn.close();
            } catch (SQLException se) {}
        }
        return tweetExists;
    }

}
