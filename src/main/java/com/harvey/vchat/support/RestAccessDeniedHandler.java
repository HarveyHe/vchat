package com.harvey.vchat.support;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.stereotype.Component;

import com.harvey.common.core.context.Context;
import com.harvey.common.core.spring.security.handler.AuthAccessDeniedHandler;
import com.harvey.common.core.utils.HttpUtils;

@Component
public class RestAccessDeniedHandler implements AuthAccessDeniedHandler {

    private AuthenticationTrustResolver authenticationTrustResolver = new AuthenticationTrustResolverImpl();

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        Map<String, String> map = new HashMap<String, String>();
        if (authenticationTrustResolver.isAnonymous(Context.getAuthentication())) {
            // 匿名访问拒绝
            map.put("errors", "请先登录系统");
        } else {
            // 权限不足
            map.put("errors", "你没有权限访问此服务!");
        }
        HttpUtils.outJson(map, request, response);
    }

    @Override
    public int getOrder() {
        return 0;
    }

    @Override
    public boolean isSupportHandler(HttpServletRequest request, AccessDeniedException exception) {
        return request.getRequestURI().endsWith(".json");
    }

}