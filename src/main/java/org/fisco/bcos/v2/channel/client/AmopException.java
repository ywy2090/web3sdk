package org.fisco.bcos.v2.channel.client;

public class AmopException extends Exception {

    private String errmsg;

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public AmopException(String string) {

        errmsg = string;
    }
}
