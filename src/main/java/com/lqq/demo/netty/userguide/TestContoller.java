package com.lqq.demo.netty.userguide;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName Test
 * @Description TODO
 * @Author 1qq
 * @Date 2019/11/28 14:14
 * @Version 1.0
 **/
@Controller
public class TestContoller {

    @RequestMapping("/init")
    public String test(ModelMap modelMap) {
        return "/templates/html";
    }
}
