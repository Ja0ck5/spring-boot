package com.ja0ck5;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Ja0ck5 on 2017/6/3.
 */
@Controller
public class PageController {

    @RequestMapping(value="/page",method = RequestMethod.GET)
    public String page(){
        return "index";
    }

}
