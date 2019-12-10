package org.fisco.bcos.v2.channel.test.contract;

import com.fasterxml.jackson.databind.DeserializationFeature;
import org.fisco.bcos.v2.channel.client.TransactionSucCallback;
import org.fisco.bcos.v2.deserializer.ObjectMapperFactory;
import org.fisco.bcos.v2.rpc.methods.response.TransactionReceipt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PerformanceOkCallback extends TransactionSucCallback {

    private Long startTime = System.currentTimeMillis();

    private PerformanceCollector collector;

    public PerformanceCollector getCollector() {
        return collector;
    }

    public void setCollector(PerformanceCollector collector) {
        this.collector = collector;
    }

    static Logger logger = LoggerFactory.getLogger(PerformanceOkCallback.class);

    PerformanceOkCallback() {
        ObjectMapperFactory.getObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Override
    public void onResponse(TransactionReceipt receipt) {
        Long cost = System.currentTimeMillis() - startTime;

        try {
            collector.onMessage(receipt, cost);
        } catch (Exception e) {
            logger.error("onMessage error: ", e);
        }
    }
}
