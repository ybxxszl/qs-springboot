package com.wjy.chat;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.alibaba.fastjson.JSONObject;
import com.wjy.util.PropertiesUtil;
import com.wjy.util.RandomCodeUtil;

public class SocketClient {

	private static final String HOST = PropertiesUtil.getStringValue("socket.server.host");
	private static final Integer PORT = PropertiesUtil.getIntegerValue("socket.server.port");

	private static final String ID = RandomCodeUtil.getUUID();
	private static final String NAME = "玩家" + RandomCodeUtil.getUUID();

	static Scanner scanner = new Scanner(System.in);

	private Socket socket = null;
	private InputStream is = null;
	private BufferedReader br = null;
	private PrintWriter pw = null;
	private boolean state = true;
	private boolean run = true;

	public SocketClient() {

		try {

			socket = new Socket(HOST, PORT);

			is = socket.getInputStream();
			br = new BufferedReader(new InputStreamReader(is));
			pw = new PrintWriter(socket.getOutputStream(), true);

		} catch (Exception e) {

			run = false;

			if ("Connection refused: connect".equals(e.getMessage())) {
				System.out.println("服务尚未运行");
			} else {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {

		SocketClient client = new SocketClient();

		client.listen();

	}

	public void listen() {

		if (run) {

			Thread t = new Thread(new Runnable() {

				@Override
				public void run() {

					while (state) {

						try {

							byte[] b = new byte[1024];

							int length = is.read(b);

							String msg = new String(b, 0, length);

							System.out.println(msg);

						} catch (Exception e) {

							if ("Connection reset".equals(e.getMessage())) {

								System.out.println("服务已停止");

								System.exit(1);

							} else if ("Socket closed".equals(e.getMessage())) {
								System.out.println("聊天已退出");
							} else {
								e.printStackTrace();
							}

						}

					}

				}

			});

			t.start();

			pw.println(JSONObject.toJSONString(
					new MsgBean(ID, NAME, new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()), 1)));

			System.out.println(NAME + "，输入exit退出");

			while (state) {

				String content = scanner.nextLine();

				if (!"exit".equals(content)) {

					pw.println(JSONObject.toJSONString(new MsgBean(ID, NAME, content,
							new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()), 2)));

				} else {

					pw.println(JSONObject.toJSONString(new MsgBean(ID, NAME, content,
							new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()), 3)));

					state = false;

					try {
						br.close();
						pw.close();
						socket.close();
					} catch (Exception e) {
						e.printStackTrace();
					}

				}

			}

		}

	}

}
