package com.example.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author issac.hu
 */
@RestController
@RequestMapping
public class ServiceController {

    @RequestMapping
    public String get(HttpServletRequest request) {
        return request.getServerName() + ":" + request.getServerPort();
    }
}
