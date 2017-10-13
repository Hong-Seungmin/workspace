package listViewTest;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class ListItem extends JPanel implements MouseListener{
	private static int cnt=0;
	private JPanel pnIcon;
	private JPanel pnTitle;
	private JPanel pnTime;
	/**
	 * Create the panel.
	 */
	public ListItem() {
		setBackground(Color.WHITE);
		setBorder(new LineBorder(new Color(230, 230, 230), 1, true));
		setLayout(new BorderLayout(0, 0));
		addMouseListener(this);
		
		pnIcon = new JPanel();
		pnIcon.setPreferredSize(new Dimension(100,100));
		pnIcon.setMaximumSize(new Dimension(100, 100));
		pnIcon.setMinimumSize(new Dimension(100, 100));
		pnIcon.setBackground(Color.WHITE);
		add(pnIcon,BorderLayout.WEST);
		pnIcon.setLayout(new BorderLayout(0, 0));
		IconPn b = new IconPn();
		pnIcon.add(b);
		
		pnTitle = new JPanel();
		pnTitle.setBackground(Color.WHITE);
		add(pnTitle,BorderLayout.CENTER);
		pnTitle.setLayout(new BorderLayout(0, 0));
		
		JLabel lbTitle = new JLabel("name:"+cnt++);
		pnTitle.add(lbTitle,BorderLayout.NORTH);
		
		JLabel lbContent = new JLabel("New label");
		pnTitle.add(lbContent,BorderLayout.CENTER);
		
		
		
		pnTime = new JPanel();
		pnTime.setPreferredSize(new Dimension(100, 80));
		pnTime.setMaximumSize(new Dimension(100, 80));
		pnTime.setMinimumSize(new Dimension(100, 80));
		pnTime.setBackground(Color.WHITE);
		add(pnTime,BorderLayout.EAST);
		pnTime.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lbTime = new JLabel("New label");
		pnTime.add(lbTime);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		this.setBackground(new Color(230, 230, 230));
		pnIcon.setBackground(new Color(230, 230, 230));
		pnTime.setBackground(new Color(230, 230, 230));
		pnTitle.setBackground(new Color(230, 230, 230));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		this.setBackground(Color.white);
		pnIcon.setBackground(Color.white);
		pnTime.setBackground(Color.white);
		pnTitle.setBackground(Color.white);
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
