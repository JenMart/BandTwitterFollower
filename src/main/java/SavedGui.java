import javax.swing.*;
import java.util.List;

/**
 * Created by jensinamart on 12/13/15.
 */
public class SavedGui extends JFrame {
    private JTextArea textArea1;
    private JPanel rootPanel;
    DBase dBase;
    TweetDAO tweetDAO;
    List<TweetDAO> savedTweets;

    protected SavedGui(){
        setContentPane(rootPanel);
//        pack();
        setSize(500,500); //setSize(width, length)
        setVisible(true);
//        StreamTextArea.setText("testing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dBase = new DBase();
        savedTweets = dBase.readTwtTable();

    }
}
