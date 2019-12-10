package org.fisco.bcos.v2.rpc.methods.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicLong;
import org.fisco.bcos.v2.channel.client.TransactionSucCallback;
import org.fisco.bcos.v2.rpc.methods.response.Response;
import org.fisco.bcos.v2.rpc.service.RpcService;
import org.fisco.bcos.v2.rpc.service.ChannelService;

public class Request<S, T extends Response> {
    private static AtomicLong nextId = new AtomicLong(0);
    private String jsonrpc = "2.0";
    private String method;
    private List<S> params;
    private long id;
    private TransactionSucCallback callback;

    private RpcService rpcService;

    // Unfortunately require an instance of the type too, see
    // http://stackoverflow.com/a/3437930/3211687
    private Class<T> responseType;

    //
    @JsonIgnore private boolean needTransCallback;
    @JsonIgnore private TransactionSucCallback transactionSucCallback;

    public boolean isNeedTransCallback() {
        return needTransCallback;
    }

    public void setNeedTransCallback(boolean needTransCallback) {
        this.needTransCallback = needTransCallback;
    }

    public void setTransactionSucCallback(TransactionSucCallback transactionSucCallback) {
        this.transactionSucCallback = transactionSucCallback;
    }

    public TransactionSucCallback getTransactionSucCallback() {
        return transactionSucCallback;
    }

    public Request() {}

    public Request(String method, List<S> params, RpcService rpcService, Class<T> cls) {
        this.method = method;
        this.params = params;
        this.id = nextId.getAndIncrement();
        this.rpcService = rpcService;
        this.responseType = cls;
    }

    public String getJsonrpc() {
        return jsonrpc;
    }

    public void setJsonrpc(String jsonrpc) {
        this.jsonrpc = jsonrpc;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public List<S> getParams() {
        return params;
    }

    public void setParams(List<S> params) {
        this.params = params;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public T send() throws IOException {
        return rpcService.send(this, responseType);
    }

    public void sendOnly() throws IOException {
        rpcService.sendOnly(this);
    }

    public String sendForReturnString() throws IOException {
        return rpcService.sendSpecial(this);
    }

    public CompletableFuture<T> sendAsync() {
        throw new UnsupportedOperationException(" sendAsync not support. ");
    }

    @JsonIgnore
    public TransactionSucCallback getCallback() {
        return callback;
    }

    public void setCallback(TransactionSucCallback callback) {
        this.callback = callback;
    }
}
