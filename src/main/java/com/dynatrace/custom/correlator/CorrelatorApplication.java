package com.dynatrace.custom.correlator;

import com.dynatrace.oneagent.sdk.OneAgentSDKFactory;
import com.dynatrace.oneagent.sdk.api.OneAgentSDK;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CorrelatorApplication {

    public static void main(String[] args) {

        SpringApplication.run(CorrelatorApplication.class, args);
    }

}
