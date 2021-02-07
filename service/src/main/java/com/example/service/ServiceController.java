package com.example.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
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
        return request.getServerName() + ":" + request.getServerPort() + "" + uuid;
    }
}
