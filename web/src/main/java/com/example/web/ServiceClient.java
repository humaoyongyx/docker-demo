package com.example.web;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author issac.hu
 */
@FeignClient(contextId = "serviceClient", name = "service", path = "", decode404 = true)
public interface ServiceClient {

    @GetMapping
    String get();
}
