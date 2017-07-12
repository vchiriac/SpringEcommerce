package org.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by user on 7/5/17.
 */
@Controller
public class Home {

    @RequestMapping(value = "/")
    public String home() {
        return "test";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "home/index";
    }
}
