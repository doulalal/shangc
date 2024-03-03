package com.huohua.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * token的传递问题
 * 远程调用的拦截
 */
@Configuration
public class OpenFeignInterceptor implements RequestInterceptor {

    /**
     * 在这里做token的传递
     * 1. 浏览器-- A服务 ---B服务
     * 2. mq直接发起远程调用 是没有前置request的
     * 3. 支付宝回调你 有request 但是没有token
     *
     * @param template 发起远程调用的请求
     */
    @Override
    public void apply(RequestTemplate template) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (requestAttributes != null) {
            // 有请求 1. 是我们的前端的请求  2. 可能是其他系统的回调那么有request 但是没有token
            HttpServletRequest request = requestAttributes.getRequest();
            if (!ObjectUtils.isEmpty(request)) {
                String authorization = request.getHeader("Authorization");
                if (!StringUtils.isEmpty(authorization)) {
                    // 往新的请求里面放 做一个传递
                    template.header("Authorization", authorization);
                    return;
                }
            }
        }
        // 都是没有token的 比如mq的自发调用 其他应用的回调
        // 设置一个永久的token 保证他可以正常调用其他服务
        template.header("Authorization", "bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJzY29wZSI6WyJyZWFkIl0sImV4cCI6Mzc4NjU0NTYyNSwianRpIjoiNWI1YmU0NDktZGRiOC00ZWE4LThjMmQtNTg4MzMzNTNjNTA1IiwiY2xpZW50X2lkIjoiY2xpZW50In0.i-Tp-cOQWuLELkMQ04-KP_6LlPkNgS6JLo4xogkldodx647mwWrBU36DHnD_52b9xd35J_L2CooqggZenWpnb8YIHTpjN8tWhIMFTVXUKCKgRy7qK3Xc_wXOo9weW2X6_7kLjiXrS75r-zmOcfXaVwL00gPXPx6coX2W0ZqwlX6p_rpmBoTUZDqwUMUZK4Xsas6LK_pEX9eCnQsvk5DhxFhuDJaBX-EWSdNSkuMhT9ugXIWdj-H00wL4Y6_JR5kdLl78PDhzpNx1OOJSTb7NbasPUf_IyQpX7pOCyTHDZUAD7gLsDxTMvamZ1n-yzC5aSCDDXL-dtQiUZdwusTII7Q");
    }
}






/*public class OpenFeignInterceptor implements RequestInterceptor {


    *//**
     * 在这里做token的传递
     * 1. 浏览器-- A服务 ---B服务
     * 2. mq直接发起远程调用 是没有前置request的
     * 3. 支付宝回调你 有request 但是没有token
     * 发起远程调用的请求
     *//*
    @Override
    public void apply(RequestTemplate template) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        //是从浏览器过来的request,肯定有token的
        // 有请求 1. 是我们的前端的请求  2. 可能是其他系统的回调那么有request 但是没有token
        HttpServletRequest request = requestAttributes.getRequest();
        if (!ObjectUtils.isEmpty(request)) {
            String authorization = request.getHeader("Authorization");
            if (!StringUtils.isEmpty(authorization)) {
                // 往新的请求里面放 做一个传递
                template.header("Authorization", authorization);
            } else {
                //支付宝回调你的有request但是没有token
                // 设置一个永久的token 保证他可以正常调用其他服务
                template.header("Authorization", "bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJzY29wZSI6WyJyZWFkIl0sImV4cCI6Mzc4NjU0NTYyNSwianRpIjoiNWI1YmU0NDktZGRiOC00ZWE4LThjMmQtNTg4MzMzNTNjNTA1IiwiY2xpZW50X2lkIjoiY2xpZW50In0.i-Tp-cOQWuLELkMQ04-KP_6LlPkNgS6JLo4xogkldodx647mwWrBU36DHnD_52b9xd35J_L2CooqggZenWpnb8YIHTpjN8tWhIMFTVXUKCKgRy7qK3Xc_wXOo9weW2X6_7kLjiXrS75r-zmOcfXaVwL00gPXPx6coX2W0ZqwlX6p_rpmBoTUZDqwUMUZK4Xsas6LK_pEX9eCnQsvk5DhxFhuDJaBX-EWSdNSkuMhT9ugXIWdj-H00wL4Y6_JR5kdLl78PDhzpNx1OOJSTb7NbasPUf_IyQpX7pOCyTHDZUAD7gLsDxTMvamZ1n-yzC5aSCDDXL-dtQiUZdwusTII7Q");
            }
        } else {
            // 设置一个永久的token 保证他可以正常调用其他服务
            template.header("Authorization", "bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJzY29wZSI6WyJyZWFkIl0sImV4cCI6Mzc4NjU0NTYyNSwianRpIjoiNWI1YmU0NDktZGRiOC00ZWE4LThjMmQtNTg4MzMzNTNjNTA1IiwiY2xpZW50X2lkIjoiY2xpZW50In0.i-Tp-cOQWuLELkMQ04-KP_6LlPkNgS6JLo4xogkldodx647mwWrBU36DHnD_52b9xd35J_L2CooqggZenWpnb8YIHTpjN8tWhIMFTVXUKCKgRy7qK3Xc_wXOo9weW2X6_7kLjiXrS75r-zmOcfXaVwL00gPXPx6coX2W0ZqwlX6p_rpmBoTUZDqwUMUZK4Xsas6LK_pEX9eCnQsvk5DhxFhuDJaBX-EWSdNSkuMhT9ugXIWdj-H00wL4Y6_JR5kdLl78PDhzpNx1OOJSTb7NbasPUf_IyQpX7pOCyTHDZUAD7gLsDxTMvamZ1n-yzC5aSCDDXL-dtQiUZdwusTII7Q");
        }
    }
}*/
