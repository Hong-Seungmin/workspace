package test;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
public class asd extends Canvas{

  public void paint(Graphics g) {

      Toolkit t=Toolkit.getDefaultToolkit();
      Image i=t.getImage("c:\\001.png");
      g.drawImage(i, 120,100,this);
JTextField a = new JTextField();
JPasswordField
  }
      public static void main(String[] args) {
      asd m=new asd();
      JFrame f=new JFrame();
      f.add(m);
      f.setSize(400,400);
      f.setVisible(true);
  }
}
이형근 바보
