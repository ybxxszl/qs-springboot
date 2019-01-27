package com.wjy.chat.netty.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

public class ChannelInitializerHandle extends ChannelInitializer<SocketChannel> {

	@Override
	protected void initChannel(SocketChannel ch) throws Exception {

		ServerHandle handle = new ServerHandle();

		ch.pipeline().addLast(handle);

	}

}
