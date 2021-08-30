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
            @HystrixProperty(name="coreSize",value = "20"), @HystrixProperty(name="maxQueueSize", value="10")
            },
    commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "7000"),
            @HystrixProperty(name= "circuitBreaker.requestVolumeThreshold",value = "5"),
            @HystrixProperty(name= "circuitBreaker.errorThresholdPercentage", value="100"),
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "5000")
    })
    @GetMapping("/urlInput")
    public String urlPage(@RequestParam("URL") String url, Model model) throws InterruptedException {

        sessionService.saveUrl(url, response);
        model.addAttribute("Response", response);
        return "Display";
    }


    public String getFallbackUrlPage(@RequestParam("URL") String url,Model model) {
        return "Error404";
    }
}
