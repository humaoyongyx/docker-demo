package com.example.web;

import cn.hutool.http.HttpUtil;
import com.example.web.http.HttpHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @author issac.hu
 */
@RestController
@RequestMapping
public class WebController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebController.class);

    @RequestMapping
    public String get(HttpServletRequest request) {
        LOGGER.info("get...");
        return request.getServerName() + ":" + request.getServerPort();
    }

    @RequestMapping("/3")
    public String get3(HttpServletRequest request) {
        LOGGER.info("get3...");
        //设置nginx路由
        //String result = HttpHelper.client().get("http://localhost/service/");
        String result = HttpHelper.client().get("http://service/");
        return result;
    }

    @RequestMapping("/4")
    public String get4(HttpServletRequest request) {
        LOGGER.info("get4...");
        String result = HttpUtil.get("http://service/");
        return result;
    }

    @RequestMapping("/r/{path}")
    public String getR(HttpServletRequest request, @PathVariable(value = "path", required = false) String path) {
        LOGGER.info("getR...");
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String header = headerNames.nextElement();
            String value = request.getHeader(header);
            System.out.println("header:" + header + ",value:" + value);
        }
        String result = HttpUtil.get("http://service/" + path);
        return result;
    }

}
