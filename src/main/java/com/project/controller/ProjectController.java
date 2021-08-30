package com.project.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.project.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProjectController {

    private static final String response="Hello All! We are in the response Page.";
    @Autowired
    private SessionService sessionService;

    @GetMapping("/")
    public String getHello(){
        return "URLPage";
    }

    @HystrixCommand(fallbackMethod = "getFallbackUrlPage",
    threadPoolKey = "urlService",
            threadPoolProperties = {
            @HystrixProperty(name="coreSize",value = "40"), @HystrixProperty(name="maxQueueSize", value="20")
            },
    commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000"),
            @HystrixProperty(name= "circuitBreaker.requestVolumeThreshold",value = "6"),
            @HystrixProperty(name= "circuitBreaker.errorThresholdPercentage", value="50"),
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "9000")
    })
    @GetMapping("/urlInput")
    public String urlPage(@RequestParam("URL") String url, Model model){

        sessionService.saveUrl(url, response);
        model.addAttribute("Response", response);
        return "Display";
    }


    public String getFallbackUrlPage(@RequestParam("URL") String url,Model model) {
        return "Error404";
    }
}
