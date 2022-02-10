package com.musinsa.graphql.interceptor;

import io.leangen.graphql.spqr.spring.web.GraphQLController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class TestInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        System.out.println(handlerMethod.getMethod().getDeclaringClass().getSimpleName());
        System.out.println(handlerMethod.getMethod());
        return true;
    }
}
