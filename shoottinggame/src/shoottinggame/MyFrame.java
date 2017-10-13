package shoottinggame;

import javax.swing.JFrame;

public class MyFrame extends JFrame {

	public MyFrame() {
		setTitle("My Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new MyPanel());
		setSize(606, 500);
		setVisible(true);
	}

}
