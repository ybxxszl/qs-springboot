package com.wjy.socket;

import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

import com.wjy.util.PropertiesUtil;

public class SocketClient2 {

	private static final String HOST = PropertiesUtil.getStringValue("socket.server.host");

	private static final Integer PORT = PropertiesUtil.getIntegerValue("socket.server.port");

	private static final String CODING = PropertiesUtil.getStringValue("socket.coding");

	@SuppressWarnings("resource")
	public static void main(String args[]) throws Exception {

		Socket socket = new Socket(HOST, PORT);

		OutputStream os = socket.getOutputStream();

		System.out.println("玩家2开始");

		while (true) {

			Scanner scanner = new Scanner(System.in);

			String str = scanner.nextLine();

			if ("exit".equals(str)) {
				break;
			}

			byte[] b1 = str.getBytes(CODING);

			os.write(b1.length >> 8);
			os.write(b1.length);
			os.write(b1);

			os.flush();

			System.out.println("client send message : " + str);

		}

		System.out.println("玩家2结束");

		os.close();
		socket.close();

	}

}
