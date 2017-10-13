package filetransfer;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Sender extends Thread {
	ServerSocket servsock=null;
	Socket sock=null;
	File file;
	
	OutputStream os = null;
	public Sender() {
		try {
			servsock=new ServerSocket(1234);
			sock = servsock.accept();
			os = sock.getOutputStream();
			os.write();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
	
	public void send(File file){
		this.file=file;
	}

	public void run() {
		
	}

}
