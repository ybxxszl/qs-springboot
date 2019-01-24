package com.wjy.chatroom.server;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.alibaba.fastjson.JSONObject;
import com.wjy.chatroom.bean.MsgBean;
import com.wjy.util.PropertiesUtil;

public class SocketServer {

	private static final Integer PORT = PropertiesUtil.getIntegerValue("socket.server.port");

	private static final String CODING = PropertiesUtil.getStringValue("socket.coding");

	public static void main(String[] args) {

		try {

			run();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void run() throws Exception {

		ServerSocket server = null;
		InputStream is = null;
		Socket socket = null;

		server = new ServerSocket(PORT);

		System.out.println("聊天室等待中");

		while (true) {

			try {

				socket = server.accept();

				if (socket != null && socket.isBound() && !socket.isClosed() && socket.isConnected()
						&& !socket.isInputShutdown() && !socket.isOutputShutdown()) {
					throw new Exception("socket失效");
				}

				is = socket.getInputStream();

				byte[] b;

				while (true) {

					int first = is.read();

					if (first == -1) {
						break;
					}

					int second = is.read();

					b = new byte[(first << 8) + second];

					is.read(b);

					String msg = new String(b, CODING);

					get(msg);

				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {

				try {
					is.close();
					socket.close();
					server.close();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		}

	}

	private static void get(String msg) {

		MsgBean bean = JSONObject.parseObject(msg, MsgBean.class);

		if (bean.getType() == 1) {

			System.out.println(bean.getTime() + " " + bean.getName() + "进入聊天室");

		} else if (bean.getType() == 2) {

			System.out.println(bean.getTime() + " " + bean.getName() + "退出聊天室");

		} else if (bean.getType() == 3) {

			System.out.println(bean.getTime() + " " + bean.getName() + "说：" + bean.getContent());

		}

	}

}
