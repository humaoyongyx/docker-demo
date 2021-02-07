package com.example.web;

import com.example.web.http.HttpHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author issac.hu
 */
@RestController
@RequestMapping
public class WebController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebController.class);


    @Autowired
    ServiceClient serviceClient;

    @RequestMapping
    public String get(HttpServletRequest request) {
        LOGGER.info("get...");
        return request.getServerName() + ":" + request.getServerPort();
    }

    @RequestMapping("/2")
    public String get2(HttpServletRequest request) {
        LOGGER.info("get2...");
        return serviceClient.get();
    }

    @RequestMapping("/3")
    public String get3(HttpServletRequest request) {
        LOGGER.info("get3...");
        return HttpHelper.client().get("http://service/");
    }
}
