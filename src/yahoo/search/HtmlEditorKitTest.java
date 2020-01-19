/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yahoo.search;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.concurrent.CountDownLatch;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;

/**
 *
 * @author M Awais
 */
class HtmlEditorKitTest {
    private String htmlString;
    private String plainText;
    private JEditorPane jEditorPane;
    private JScrollPane scrollPane;
    private HTMLEditorKit kit;
    private CountDownLatch countDownLatch;
    
  public void setHtmlString(String htmlString){
      this.htmlString=htmlString;
  }
  private void exicuator(){
      
          SwingUtilities.invokeLater(new Runnable()
          {
            public void run()
            {
              // create jeditorpane
              jEditorPane = new JEditorPane();

              // make it read-only
              jEditorPane.setEditable(true);

              // create a scrollpane; modify its attributes as desired
              scrollPane = new JScrollPane(jEditorPane);

              // add an html editor kit
              kit = new HTMLEditorKit();
              jEditorPane.setEditorKit(kit);


              // create a document, set it on the jeditorpane, then add the html
              Document doc = kit.createDefaultDocument();
              jEditorPane.setDocument(doc);
              jEditorPane.setText(htmlString);
              jEditorPane.selectAll();
              plainText=jEditorPane.getSelectedText();
              System.out.println(plainText);


              // now add it all to a frame
              JFrame j = new JFrame("HtmlEditorKit Test");
              j.getContentPane().add(scrollPane, BorderLayout.CENTER);

              // make it easy to close the application
              j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

              // display the frame
              j.setSize(new Dimension(300,200));

              // pack it, if you prefer
              //j.pack();

              // center the jframe, then make it visible
              j.setLocationRelativeTo(null);
              j.setVisible(false);
              

            }
          });
      
      
  }
  public String getPlainText(){
      exicuator();
      
      
      System.out.println(plainText);
      return plainText;
  }
}

