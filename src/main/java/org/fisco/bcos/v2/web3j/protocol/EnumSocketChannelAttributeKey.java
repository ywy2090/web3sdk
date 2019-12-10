package org.fisco.bcos.v2.web3j.protocol;

public enum EnumSocketChannelAttributeKey {
    CHANNEL_PROTOCOL_KEY("CHANNEL_PROTOCOL_KEY"),
    CHANNEL_CONNECTED_KEY("CHANNEL_CONNECTED_KEY");

    private EnumSocketChannelAttributeKey(String key) {
        this.key = key;
    }

    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
