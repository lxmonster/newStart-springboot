package com.restart.spmaster.controller.open;

import com.restart.spmaster.common.BaseOpenController;
import com.restart.spmaster.utils.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("testController")
@RequestMapping("/open/test")
public class TestController extends BaseOpenController {

    @RequestMapping("/test")
    public Result test() {
        return getSuccessResult("");
    }
}
