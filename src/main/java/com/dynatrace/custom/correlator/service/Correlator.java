package com.dynatrace.custom.correlator.service;

import com.dynatrace.oneagent.sdk.OneAgentSDKFactory;
import com.dynatrace.oneagent.sdk.api.OneAgentSDK;
import com.dynatrace.oneagent.sdk.api.OutgoingRemoteCallTracer;
import com.dynatrace.oneagent.sdk.api.enums.ChannelType;
import org.apache.log4j.Logger;

public class Correlator {

    static Logger logger = Logger.getLogger(Correlator.class);
    public static final OneAgentSDK sdk = OneAgentSDKFactory.createInstance();

    public static String correlate(String hostname, String port) {

        OutgoingRemoteCallTracer tracer = sdk.traceOutgoingRemoteCall("core",
                "Core",
                String.format("http://%s:%s/CMM_SERVICES", hostname, port),
                ChannelType.TCP_IP,
                String.format("%s:%s", hostname, port));

        tracer.setProtocolName("RMI/custom");
        tracer.start();

        String tag = tracer.getDynatraceStringTag();

        logger.info(String.format("Created tag '%s' for '%s:%s'", tag, hostname, port));

        tracer.end();
        return tag;
    }
}
