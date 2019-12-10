package org.fisco.bcos.v2.filter;

import java.util.List;
import org.fisco.bcos.v2.rpc.methods.response.Log;
import org.fisco.bcos.v2.txdecode.LogResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceEventLogPushCallback extends EventLogPushCallback {

    private static final Logger logger = LoggerFactory.getLogger(ServiceEventLogPushCallback.class);

    @Override
    public void onPushEventLog(int status, List<LogResult> logs) {
        logger.info(
                " onPushEventLog, params: {}, status: {}, logs: {}",
                getFilter().getParams(),
                status,
                logs);
    }

    @Override
    public LogResult transferLogToLogResult(Log log) {
        LogResult logResult = new LogResult();
        logResult.setLog(log);
        return logResult;
    }
}
