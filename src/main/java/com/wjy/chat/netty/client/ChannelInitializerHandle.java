package com.wjy.chat.netty.client;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.handler.codec.string.StringEncoder;

public class ChannelInitializerHandle extends ChannelInitializer<Channel> {

	@Override
	protected void initChannel(Channel ch) throws Exception {

		StringEncoder stringEncoder = new StringEncoder();

		ch.pipeline().addLast(stringEncoder);

	}

}
