package org.fisco.bcos.v2.rpc.service;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import org.fisco.bcos.v2.rpc.methods.request.Request;
import org.fisco.bcos.v2.rpc.methods.response.Response;

/**
 * RPC Services API.
 */

public interface RpcService {

    /**
     *
     * @param request
     * @param responseType
     * @param <T>
     * @return
     * @throws IOException
     */
    <T extends Response> T send(Request request, Class<T> responseType) throws IOException;

    /**
     *
     * @param request
     * @throws IOException
     */
    void sendOnly(Request request) throws IOException;

    /**
     *
     * @param request
     * @return
     * @throws IOException
     */
    String sendSpecial(Request request) throws IOException;

    /**
     *
     * @param request
     * @param responseType
     * @param <T>
     * @return
     * @throws UnsupportedOperationException
     */
    <T extends Response> CompletableFuture<T> sendAsync(Request request, Class<T> responseType) throws UnsupportedOperationException, IOException;

    /**
     * Closes resources used by the service.
     *
     * @throws IOException thrown if a service failed to close all resources
     */
    void close() throws IOException;
}
