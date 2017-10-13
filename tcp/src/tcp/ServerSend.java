package tcp;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerSend {
	DataOutputStream dataOutput = null;
	Socket socket = null;
	File file = null; // ���Ͽ� ������ ������� File Ŭ����
	DataInputStream dataInput = null;
	BufferedOutputStream bufferedOutput = null; // output �ӵ� ����� ����
												// BufferedOutputStream

	public ServerSend(String ip, int clientPort, String fileName) {
		super();
		try {
			String clientIP = ip;
			file = new File(fileName);
			socket = new Socket(clientIP, clientPort); // �������� IP�� ��Ʈ�� ����
			dataOutput = new DataOutputStream(socket.getOutputStream()); // output
																			// ��ũ��
																			// ����
			dataOutput.writeInt((int) file.length()); // �������� �������� ������ ����
			dataOutput.flush();
			System.out.println((int) file.length()); // �۽� ���� ������ �ܼ����
			int totalSize = (int) file.length();
			byte[] bytes = new byte[104857600]; // 100MB ������ ����Ʈ �迭
			dataInput = new DataInputStream(new FileInputStream(fileName));
			bufferedOutput = new BufferedOutputStream(dataOutput);
			int i = 0; // buf �迭 �ε����� ����

			// ���۹��� ���� ����� 100MB ���� ũ�ٸ� 100MB ������ �迭�� ���� �� ���� ���ۿ� write �ϰ�
			// ���� ���ۿ� write�� 100MB��ŭ�� ���� ������� �����ϴ� while��!!!
			while (totalSize > 104857600) {
				while (i < 104857600) {
					bytes[i] = (byte) dataInput.read();
					i++;
				} // while(i < 104857600)��
				totalSize -= 104857600; // ���ϻ����� - 100MB
				i = 0; // �迭 �ε��� �ʱ�ȭ
				bufferedOutput.write(bytes); // ���� ���ۿ� write
			} // while(totalSize > 104857600)��

			// 100MB���� ���ų� ���� ���� ������ Ȥ�� ������ ����� 100MB ���� ���� �� if�� ������ ���� �Ǿ�
			// ���� ���ۿ� write ��
			if (totalSize <= 104857600) {
				i = 0; // �迭 �ε��� �ʱ�ȭ
				bytes = new byte[totalSize];
				while (i < totalSize) {
					bytes[i] = (byte) dataInput.read();
					i++; // �迭�ε��� �̵�
				} // while��
				bufferedOutput.write(bytes); // ���� ���ۿ� write
			} // if��
			bufferedOutput.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bufferedOutput != null)
					bufferedOutput.close();
				if (dataInput != null)
					dataInput.close();
				if (dataOutput != null)
					dataOutput.close();
				if (socket != null)
					socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} // finally
	}// main
}// ServerSend Ŭ����