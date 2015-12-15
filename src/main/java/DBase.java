/**
 * Created by jensinamart on 12/9/15.
 */
import twitter4j.Status;

import javax.print.attribute.standard.DateTimeAtCompleted;
import java.sql.*;
import java.sql.Date;
import java.util.*;


public class DBase {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_CONNECTION_URL = "jdbc:mysql://localhost:3306/test";
    static final String USER = "jensinamart"; //TODO replace with your username
    static final String PASSWORD = "password"; //TODO replace with your password

    public static List<TweetDAO> tweets = null;
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
    ///////////////////////////////////Returns tweets from table
    public void readTwtTable(){
        Connection conn = null;
        Statement statement = null;
        tweets = new ArrayList<TweetDAO>();
        try {
            String search = "SELECT * FROM TWEETS ";
            conn = createConn();
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(search); //Takes data from table and turns to result set
            while (resultSet.next()){ //breaks up data for Tweet DAO list
//            for (ResultSet results : resultSet){
                TweetDAO tweet = new TweetDAO();
                tweet.id = resultSet.getLong("TWTID");
                System.out.println("pip");
                tweet.msg = resultSet.getString("TWT");
                tweet.user = resultSet.getString("USER");
                //removed date posted from DAO due to unresolvable errors
                //will keep dateposted in DB as a way to organize
//                tweet.postDate = resultSet.getDate("DATEPOSTED");




                tweets.add(tweet);
            }

//            return tweets;
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
//        return null;
    }
    ///////////////////////////////////writes tweets from table
    public void writeTwtTable(){
        Connection conn = null;
        Statement statement = null;
        try {
            conn = createConn();
            statement = conn.createStatement();
            PreparedStatement prep = null;
            String addTweets = "INSERT INTO TWEETS VALUES (?,?,?,?)";
            prep = conn.prepareStatement(addTweets);
            for (Status status : Main.result.getTweets()) {
                if (!checkTwtTable(String.valueOf(status.getId()))){ //checks to see if tweet is on table
                    //If not, writes to TWEETS table
                    prep.setLong(1,status.getId());
                    prep.setString(2,status.getText());
                    prep.setString(3,status.getUser().getScreenName());
                    prep.setString(4, String.valueOf(status.getCreatedAt()));
                    prep.executeUpdate();
//                    conn.commit();

//                    String add = "INSERT INTO TWEETS VALUES (" + status.getId() + "," + status.getText()
//                            + "," + status.getUser() + "," + status.getCreatedAt() + ")";
//                    prep = conn.prepareStatement(add);
//                    System.out.println(add);
//                    statement.executeUpdate(add);
                    System.out.print("yes");
                }
                System.out.print("no");
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
    ///////////////////////////////////Confirm if tweet already exists on table
    public Boolean checkTwtTable(String id){
        Connection conn = null;
        Statement statement = null;
        Boolean tweetExists = false;
        try {
            conn = createConn();
            statement = conn.createStatement();
            //Tries to pull data from table based on info passed from writeTwtTable
            String check = "SELECT TWTID FROM TWEETS WHERE TWTID IN("+ id +")";
            ResultSet resultSet = statement.executeQuery(check);
            //If result set is empty, returns true.
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
