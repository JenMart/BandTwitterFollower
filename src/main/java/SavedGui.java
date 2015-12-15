import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by jensinamart on 12/13/15.
 */
public class SavedGui extends JFrame {
    private JTextArea savedTextArea;
    private JPanel rootPanel;
    private JButton backButton;
    DBase dBase;
    TweetDAO tweetDAO;
    List<TweetDAO> savedTweets = null;

    protected SavedGui(){ //Simple class. Just displays saved tweets.
        setContentPane(rootPanel);
        setSize(500,500); //setSize(width, length)
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dBase = new DBase();
        tweetDAO = new TweetDAO();
//        savedTweets = dBase.readTwtTable();
        dBase.readTwtTable();
        for (TweetDAO status: DBase.tweets){
//            savedTextArea.append("@"+ status.getUser() + ": "  + status.getMsg() + status.postDate + "\n");
            savedTextArea.append("@"+ status.getUser() + ": "  + status.getMsg() +"\n");
        }


    }
}
