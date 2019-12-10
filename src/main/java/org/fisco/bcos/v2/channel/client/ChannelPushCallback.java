package org.fisco.bcos.v2.channel.client;

import org.fisco.bcos.v2.channel.dto.ChannelPush;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class ChannelPushCallback {
    public abstract void onPush(ChannelPush push);

    static Logger logger = LoggerFactory.getLogger(ChannelPushCallback.class);
}
