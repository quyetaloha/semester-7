package laptrinhmang;
import java.applet.*;
import java.awt.*;
import java.net.*;
import java.awt.event.*;

public class testURL_NewWindow extends Applet 
implements ActionListener{
   public void init(){
      String link_Text = "google";
      Button b = new Button(link_Text);
      b.addActionListener(this);
      add(b);
   }
   public void actionPerformed(ActionEvent ae){
      Button source = (Button)ae.getSource();
      String link = "http://www."+source.getLabel()+".com";
      try {
         AppletContext a = getAppletContext();
         URL url = new URL(link);
         a.showDocument(url,"_blank");
          System.out.println(link);
      }
      catch (MalformedURLException e){
         System.out.println(e.getMessage());
      }
   }
}