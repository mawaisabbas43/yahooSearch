
package yahoo.search;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.JLabel;

public class Progress implements Runnable {
     private JButton SearchjButton;
     private JProgressBar  SearchingjProgressBar;
     private JLabel SearchingjLabel;
     private int value;
     
     public Progress(JButton SearchjButton,JProgressBar SearchingjProgressBar,JLabel SearchingjLabel,int value){
         this.SearchjButton=SearchjButton;
         this.SearchingjProgressBar=SearchingjProgressBar;
         this.SearchingjLabel=SearchingjLabel;
         this.value=value;
     }
            
    @Override
    public void run() {
        if(value<=95)
        {
            SearchjButton.disable();
            SearchingjProgressBar.setValue(value);
            SearchingjLabel.setText("Searching...");
        }
        else
        {
            SearchjButton.enable();
            SearchingjProgressBar.setValue(value);
            SearchingjLabel.setText("Searching Completed!");
        }
    }
    
}
