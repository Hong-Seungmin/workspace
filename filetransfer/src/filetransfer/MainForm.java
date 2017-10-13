package filetransfer;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class MainForm extends JFrame {
	private File file = null;
	
	private JPanel contentPane;
	private JTextField textField1;
	private JTextField textField2;
	private static Receiver recv;
	private static Sender sender;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		recv=new Receiver();
		sender = new Sender();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainForm frame = new MainForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainForm() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField1 = new JTextField();
		textField1.setBounds(67, 39, 225, 21);
		contentPane.add(textField1);
		textField1.setColumns(10);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(46, 247, 277, 14);
		contentPane.add(progressBar);
		
		JButton button1 = new JButton("\uD30C\uC77C\uC120\uD0DD");
		button1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				load();
				textField1.setText(file.getPath());
			}
		});
		button1.setBounds(313, 38, 97, 23);
		contentPane.add(button1);
		
		JButton button2 = new JButton("\uBCF4\uB0B4\uAE30");
		button2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sender.send(file);
				sender.start();
			}
		});
		button2.setBounds(313, 86, 97, 23);
		contentPane.add(button2);
		
		JButton button3 = new JButton("\uBC1B\uAE30");
		button3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				recv.recv(file);
				recv.start();
			}
		});
		button3.setBounds(313, 128, 97, 23);
		contentPane.add(button3);
		
		textField2 = new JTextField();
		textField2.setBounds(176, 129, 116, 21);
		contentPane.add(textField2);
		textField2.setColumns(10);
	}
	
	private void load(){
		JFileChooser fs = new JFileChooser(new File("c:\\"));
		fs.setDialogTitle("∞Ò∂Û~ ∞Ò∂Û~");
		fs.setFileFilter(new FileTypeFilter(".jpg", "¿ÃπÃ¡ˆ ∆ƒ¿œ"));

		int result = fs.showOpenDialog(null);

		if (result == JFileChooser.APPROVE_OPTION) {
			try {
				file = fs.getSelectedFile();
			} catch (Exception e) {
			}
		}
	}
	
	private void send(){
		
	}
	
	private void receive(){
		
	}
}
