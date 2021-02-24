package com.example.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.UUID;

/**
 * @author issac.hu
 */
@RestController
@RequestMapping
public class ServiceController {

    private String uuid = UUID.randomUUID().toString();

    @RequestMapping
    public String get(HttpServletRequest request) {
        System.out.println("get..." + uuid);
        return request.getServerName() + ":" + request.getServerPort() + ":" + uuid;
    }

    @RequestMapping("/2")
    public String get2(HttpServletRequest request, String name) {
        System.out.println(name);
        System.out.println("get2..." + uuid);
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String header = headerNames.nextElement();
            String value = request.getHeader(header);
            System.out.println("header:" + header + ",value:" + value);
        }
        return request.getServerName() + ":" + request.getServerPort() + ":" + uuid;
    }
}
