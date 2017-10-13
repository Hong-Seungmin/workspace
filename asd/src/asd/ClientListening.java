package asd;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;

public class ClientListening {
	public ClientListening(int portNumber, String fileName) {
		ServerSocket clientSocket = null; // ��������Ʈ�� ���ε�� ServerSocket ��ü
		FileOutputStream fileOutput = null;
		DataInputStream dataInput = null;
		byte[] buf = null;
		BufferedInputStream bufferdInput = null; // input �ӵ� ����� ����
													// BufferedInputStream
		try {
			clientSocket = new ServerSocket(portNumber);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			dataInput = new DataInputStream(clientSocket.accept().getInputStream()); // �۽�������
																						// �����û��
																						// accept
																						// �޼ҵ忡��
																						// �۽�����
																						// ������
																						// ����
																						// ������ϻ���
			int totalSize = dataInput.readInt(); // ���۹��� ���� ������ ���Ź� ������ ����
			System.out.println(totalSize); // ���� ���� ������ �ܼ����
			buf = new byte[104857600]; // 100MB ������ ������ ���� ���� byteŸ�� �迭
			fileOutput = new FileOutputStream(fileName, false);
			bufferdInput = new BufferedInputStream(dataInput);
			int i = 0; // buf �迭 �ε����� ����

			// ���۹��� ���� ����� 100MB ���� ũ�ٸ� 100MB ������ �迭�� ���� �� ���Ͽ� write �ϰ�
			// ���Ͽ� write�� 100MB��ŭ�� ���� ������� �����ϴ� while��!!!
			while (totalSize > 104857600) {
				while (i < 104857600) {
					buf[i] = (byte) bufferdInput.read();
					i++; // �迭�ε��� �̵�
				} // while(i < 104857600)��
				totalSize -= 104857600; // ���ϻ����� - 100MB
				i = 0; // �迭 �ε��� �ʱ�ȭ
				fileOutput.write(buf); // ���Ͽ� write
			} // while(totalSize > 104857600)��

			// 100MB���� ���ų� ���� ���� ������ Ȥ�� ������ ����� 100MB ���� ���� �� if�� ������ ���� �Ǿ�
			// ������ write ��
			if (totalSize <= 104857600) {
				i = 0; // �迭 �ε��� �ʱ�ȭ
				buf = new byte[totalSize]; // 100MB���� ���ų� �����Ƿ� totalSize�� �迭ũ��
											// �ٽ� ����
				while (i < totalSize) {
					buf[i] = (byte) bufferdInput.read();
					i++; // �迭�ε��� �̵�
				} // while��
				fileOutput.write(buf); // ���Ͽ� write
			} // if��
			fileOutput.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bufferdInput != null)
					bufferdInput.close();
				if (dataInput != null)
					dataInput.close();
				if (fileOutput != null)
					fileOutput.close();
				if (clientSocket != null)
					clientSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} // finally
	}// main
}// ClientListening Ŭ����
