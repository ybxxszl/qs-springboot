package com.wjy.chat.socket;

import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * socket连接服务
 * 
 * @author wjy
 * @date 2019年1月27日
 */
public class ConnectServer implements Runnable {

	private List<ConnectServer> connects = new ArrayList<ConnectServer>();

	private Socket socket = null;
	private BufferedReader br = null;
	private PrintWriter pw = null;
	private boolean state = true;
	private String name;

	/**
	 * 创建连接 加入聊天
	 * 
	 * @param socket
	 * @param connects
	 */
	public ConnectServer(Socket socket, List<ConnectServer> connects) {

		this.socket = socket;

		this.connects = connects;

		try {

			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw = new PrintWriter(socket.getOutputStream(), true);

			String msg = br.readLine();

			MsgBean bean = JSONObject.parseObject(msg, MsgBean.class);

			name = bean.getName();

			String content = name + " 加入聊天";

			System.out.println(content);

			connects.add(this);

			show(content);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 读取客户端发送消息，包括退出聊天
	 */
	@Override
	public void run() {

		try {

			String msg = null;

			while (state) {

				msg = br.readLine();

				MsgBean bean = JSONObject.parseObject(msg, MsgBean.class);

				String content = null;

				if (bean.getType() == 3) {

					content = name + " 退出聊天";

					state = false;

					connects.remove(this);

				} else {
					content = name + " 说：" + bean.getContent();
				}

				System.out.println(content);

				show(content);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				br.close();
				pw.close();
				socket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	/**
	 * 将消息发送给其他客户端
	 * 
	 * @param content
	 */
	private void show(String content) {

		for (ConnectServer server : connects) {

			if (name != server.name) {

				server.pw.print(content);
				server.pw.flush();

			}

		}

	}

}
