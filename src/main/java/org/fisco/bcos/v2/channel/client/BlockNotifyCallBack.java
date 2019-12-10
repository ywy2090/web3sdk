package org.fisco.bcos.v2.channel.client;

import java.math.BigInteger;

public interface BlockNotifyCallBack {

    public void onBlockNotify(int groupID, BigInteger blockNumber);
}
