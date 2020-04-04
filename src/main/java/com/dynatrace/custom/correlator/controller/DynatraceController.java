package com.dynatrace.custom.correlator.controller;

import com.dynatrace.custom.correlator.service.Correlator;
import model.DynatraceTag;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class DynatraceController {

    static Logger logger = Logger.getLogger(DynatraceController.class);

    @Autowired
    private Environment env;

    @Autowired
    private HttpServletRequest context;

    @GetMapping("/**")
    public DynatraceTag generateTag() {

        logger.info(String.format("Received %s on '%s' from %s",
                context.getMethod(),
                context.getRequestURL().toString(),
                context.getRemoteAddr()));


        String tag = Correlator.correlate(
                env.getProperty("correlator.hostname"),
                env.getProperty("correlator.port")
        );
        return new DynatraceTag(tag);
    }
}
