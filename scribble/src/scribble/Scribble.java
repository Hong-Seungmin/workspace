package scribble;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Scribble extends JFrame {	
	public Scribble(){

		
		setSize(300,300);
		setTitle("마우스로 그림 그리기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(new MyPanel());

		
		setVisible(true);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scribble s = new Scribble();
	}
}

class Point{
	int x, y;
	int width, height;
}


class MyPanel extends JPanel implements MouseMotionListener{
	private int index = 0;
	private Point[] array = new Point[1000];
	private JTextField textFieldWidth;
	private JTextField textFieldHeight;
	private boolean flag = true;
	
	public MyPanel(){
		textFieldWidth = new JTextField("10");
		textFieldHeight = new JTextField("10");
		
		add(textFieldWidth);
		add(textFieldHeight);
		
		this.addMouseMotionListener(this);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		for(Point p : array){
			if(p != null)
				g.drawRect(p.x, p.y, p.width, p.height);
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		if(index>=1000){
			index=0;
			flag = false;
		}
		
		if(flag){
			array[index] = new Point();
		}
		
		array[index].x = e.getX();
		array[index].y = e.getY();
		array[index].width = Integer.parseInt(textFieldWidth.getText());
		array[index].height = Integer.parseInt(textFieldHeight.getText());
		index++;
		
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}