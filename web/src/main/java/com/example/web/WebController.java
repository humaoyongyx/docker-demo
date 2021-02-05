package com.example.web;

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

    @Autowired
    ServiceClient serviceClient;

    @RequestMapping
    public String get(HttpServletRequest request) {
        return request.getServerName() + ":" + request.getServerPort();
    }

    @RequestMapping("/2")
    public String get2(HttpServletRequest request) {
        return serviceClient.get();
    }
}
