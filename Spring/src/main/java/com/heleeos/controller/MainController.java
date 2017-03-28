package com.heleeos.controller;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.heleeos.bean.Result;

@RestController
public class MainController {

    @RequestMapping(value = { "index.html" , "/" })
    public ModelAndView toIndex() {
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }
    
    @RequestMapping(value = "time.html" )
    public ModelAndView toTime() {
        ModelAndView modelAndView = new ModelAndView("time");
        modelAndView.addObject("now", getNow());        
        return modelAndView;
    }
    
    @RequestMapping(value = "time.json")
    public Result getTime() {
        return new Result().setMessage(getNow());
    }
    
    private String getNow(){
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.CHINA)
                                .withZone(ZoneId.systemDefault())
                                .format(Instant.now());
    }
}
