package com.example.elemeapi.interceptor;

import com.alibaba.fastjson.JSON;
import com.example.elemeapi.entity.User;
import com.example.elemeapi.exception.BussinessException;
import com.example.elemeapi.service.UserService;
import com.example.elemeapi.utils.UserThreadLocal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;


/**
 * 登录拦截器
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Map<String,Object> result=new HashMap<>();
        //如果访问的不是Controller直接放行
        if (!(handler instanceof HandlerMethod)){
            return true;
        }
        //请求头中没有token，拦截
        String token = request.getHeader("Authorization");
        if (StringUtils.isEmpty(token)){
            result.put("code",-1);
            result.put("msg","未登录");
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(JSON.toJSONString(result));
            return false;
        }
        //校验token
        try {
            //token校验通过，通过token获取用户信息保存到UserThreadLocal中
            User user = userService.findUserByToken(token);
            UserThreadLocal.put(user);
        }catch (BussinessException e){
            //token校验不合法，拦截
            result.put("code",e.getCode());
            result.put("msg",e.getMessage());
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(JSON.toJSONString(result));
            return false;
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        UserThreadLocal.remove();
    }
}
