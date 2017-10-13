package filetransfer;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Receiver extends Thread{
	ServerSocket servsock=null;
	Socket sock=null;
	File file;
	
	InputStream is = null;
	public Receiver() {
		try {
			servsock=new ServerSocket(1234);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void recv(File file){
		this.file=file;
	}
	
	public void run(){
		
	}

}
