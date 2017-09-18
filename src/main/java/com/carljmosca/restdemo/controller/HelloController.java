/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carljmosca.restdemo.controller;

import com.carljmosca.restdemo.data.HelloResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author moscac
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    HelloResponse sayHello(HttpServletRequest request,
            @RequestParam(value = "name", required = false, defaultValue = "tomcat") String name) {

        HelloResponse response = new HelloResponse();
        response.setMessage(String.format("Name: %s", name));
        return response;
    }    
}
