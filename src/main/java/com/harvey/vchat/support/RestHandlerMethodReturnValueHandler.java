package com.harvey.vchat.support;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.MethodParameter;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.harvey.common.core.model.PagingInfo;
import com.harvey.common.core.utils.HttpUtils;

public class RestHandlerMethodReturnValueHandler implements HandlerMethodReturnValueHandler {

    @Override
    public boolean supportsReturnType(MethodParameter returnType) {
        return true;
    }

    @Override
    public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer, NativeWebRequest webRequest) throws Exception {
        mavContainer.setRequestHandled(true);
        HttpServletResponse response = webRequest.getNativeResponse(HttpServletResponse.class);
        if(response.isCommitted()){
        	return;
        }
        if (returnValue != null) {
            HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
            ModelMap map = mavContainer.getDefaultModel();
            for(Entry<String,Object> entry : map.entrySet()){
                if(entry.getValue() instanceof PagingInfo){
                    Map<String,Object> data = new HashMap<String,Object>(2);
                    data.put(entry.getKey(),entry.getValue());
                    data.put("data", returnValue);
                    HttpUtils.outJson(data, request, response);
                    return;
                }
            }
            HttpUtils.outJson(returnValue, request, response);
        }else{
            PrintWriter writer = response.getWriter();
            writer.write("{}");
            writer.flush();
        }
    }

}
