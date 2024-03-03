package com.huohua.feign.hystrix;

import com.huohua.domain.UserAddr;
import com.huohua.feign.OrderMemberFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class OrderMemberFeignHystrix implements OrderMemberFeign {


    /**
     * 查询用户的默认收货地址
     */
    @Override
    public UserAddr getDefaultAddr(String openId) {
        log.error("远程调用查询用户的默认收货地址 失败");
        return null;
    }
}
