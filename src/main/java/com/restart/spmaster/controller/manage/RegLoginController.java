package com.restart.spmaster.controller.manage;

import com.restart.spmaster.common.BaseManageController;
import com.restart.spmaster.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sang on 2017/12/29.
 */
@RestController("regLoginController")
@RequestMapping("/manage/relogin")
public class RegLoginController extends BaseManageController {
    @RequestMapping("/login_p")
    public Result login() {
        return new Result("9999","尚未登录",null);
    }

    @RequestMapping("/test")
    public Result test() {
        return getSuccessResult("");
    }

    @GetMapping("/employee/advanced/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/employee/basic/hello")
    public String basicHello() {
        return "basicHello";
    }
}
