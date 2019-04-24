package com.qingying.controller;

import com.qingying.mapper.CityMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class IndexController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
    @Autowired
    private CityMapper cityMapper;

    @RequestMapping(value = "/api", method = RequestMethod.GET)
    public String api() {
        System.out.println("test");
        //return "redirect:/swagger-ui.html";
        List list = cityMapper.queryList();

        System.out.println("listsize:::::"+list.size());
        logger.info("listsize:::::"+list.size());
        return "aaa";
    }

}
