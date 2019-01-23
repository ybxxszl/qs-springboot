package com.wjy.socket;

import java.io.OutputStream;
import java.net.Socket;

import com.wjy.util.PropertiesUtil;

public class SocketClient {

	private static final String HOST = PropertiesUtil.getStringValue("socket.server.host");

	private static final Integer PORT = PropertiesUtil.getIntegerValue("socket.server.port");

	private static final String CODING = PropertiesUtil.getStringValue("socket.coding");

	private static final String MESSAGE = "迟来的请求";

	public static void main(String args[]) throws Exception {

		Socket socket = new Socket(HOST, PORT);

		OutputStream os = socket.getOutputStream();

		os.write(MESSAGE.getBytes(CODING));

		System.out.println("send message : " + MESSAGE);

		os.close();
		socket.close();

	}

}
