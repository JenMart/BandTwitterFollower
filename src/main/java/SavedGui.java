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
    List<TweetDAO> savedTweets;

    protected SavedGui(){
        setContentPane(rootPanel);
//        pack();
        setSize(500,500); //setSize(width, length)
        setVisible(true);
//        StreamTextArea.setText("testing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dBase = new DBase();
        tweetDAO = new TweetDAO();
        savedTweets = dBase.readTwtTable();
        //"@" + status.getUser().getName() + ":" + status.getText() + status.getId() +"\n"
        for (TweetDAO status: savedTweets){
            savedTextArea.append("@"+ status.getUser() + ": "  + status.getMsg() + status.postDate + "\n");
        }
//        backButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent actionEvent) {
//                StreamGUI streamGUI = new StreamGUI();
//            }
//        });

    }
}
