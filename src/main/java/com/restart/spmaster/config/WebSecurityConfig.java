package com.restart.spmaster.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.restart.spmaster.constant.BusinessConstant;
import com.restart.spmaster.service.HrService;
import com.restart.spmaster.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by sang on 2017/12/28.
 */
@Slf4j
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    HrService hrService;
    @Autowired
    CustomMetadataSource metadataSource;
    @Autowired
    UrlAccessDecisionManager urlAccessDecisionManager;
    @Autowired
    AuthenticationAccessDeniedHandler deniedHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(hrService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //不拦截路径（过滤规则）
        web.ignoring().antMatchers( "/static/**", "/manage/relogin/login_p","/open/**","**/swagger-ui.html");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        log.info("开始验证");
        http.authorizeRequests()
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                        o.setSecurityMetadataSource(metadataSource);
                        o.setAccessDecisionManager(urlAccessDecisionManager);
                        return o;
                    }
                })
                .and()
                .formLogin().loginPage("/manage/relogin/login_p")
                .loginProcessingUrl("/manage/relogin/login")
                .usernameParameter("username").passwordParameter("password")
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest req,
                                                        HttpServletResponse resp,
                                                        AuthenticationException e) throws IOException {
                        resp.setContentType("application/json;charset=utf-8");
                        Result r ;
                        if (e instanceof BadCredentialsException ||
                                e instanceof UsernameNotFoundException) {
                            r = new Result(BusinessConstant.REQUEST_FORMAT_ERROR_CODE, "账户名或者密码输入错误!",null);
                        } else if (e instanceof LockedException) {
                            r = new Result(BusinessConstant.REQUEST_FORMAT_ERROR_CODE, "账户被锁定，请联系管理员!",null);
                        } else if (e instanceof CredentialsExpiredException) {
                            r = new Result(BusinessConstant.REQUEST_FORMAT_ERROR_CODE, "密码过期，请联系管理员!",null);
                        } else if (e instanceof AccountExpiredException) {
                            r = new Result(BusinessConstant.REQUEST_FORMAT_ERROR_CODE, "账户过期，请联系管理员!",null);
                        } else if (e instanceof DisabledException) {
                            r = new Result(BusinessConstant.REQUEST_FORMAT_ERROR_CODE, "账户被禁用，请联系管理员!",null);
                        } else {
                            r = new Result(BusinessConstant.REQUEST_FORMAT_ERROR_CODE, "登录失败!",null);
                        }
                        ObjectMapper om = new ObjectMapper();
                        PrintWriter out = resp.getWriter();
                        out.write(om.writeValueAsString(r));
                        out.flush();
                        out.close();
                    }
                })
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest req,
                                                        HttpServletResponse resp,
                                                        Authentication auth) throws IOException {
                        resp.setContentType("application/json;charset=utf-8");
                        Result result = new Result(BusinessConstant.SYSTEM_SUCESS_CODE, "登录成功!",null);
                        ObjectMapper om = new ObjectMapper();
                        PrintWriter out = resp.getWriter();
                        out.write(om.writeValueAsString(result));
                        out.flush();
                        out.close();
                    }
                })
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessHandler(new LogoutSuccessHandler() {
                    @Override
                    public void onLogoutSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication authentication) throws IOException, ServletException {
                        resp.setContentType("application/json;charset=utf-8");
                        Result result = new Result(BusinessConstant.SYSTEM_SUCESS_CODE, "注销成功!",null);
                        ObjectMapper om = new ObjectMapper();
                        PrintWriter out = resp.getWriter();
                        out.write(om.writeValueAsString(result));
                        out.flush();
                        out.close();
                    }
                })
                .permitAll()
                .and().csrf().disable()
                .exceptionHandling().accessDeniedHandler(deniedHandler);

        /*//以下这句就可以控制单个用户只能创建一个session，也就只能在服务器登录一次
        http.sessionManagement().maximumSessions(1).expiredUrl("/login");*/
    }
}
