package org.fisco.bcos.v2.rpc.service;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import org.fisco.bcos.v2.deserializer.ObjectMapperFactory;
import org.fisco.bcos.v2.rpc.methods.request.Request;

/**
 * @description Base service implementation.
 */
public abstract class AbstractService implements RpcService {

    protected final ObjectMapper objectMapper;

    protected Integer timeout = 0;

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public AbstractService() {
        objectMapper = ObjectMapperFactory.getObjectMapper();
    }
}
