package com.huohua.feign.hystrix;

import com.huohua.es.ProdEs;
import com.huohua.feign.UserCollectProdFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class UserCollectProdFeignHystrix implements UserCollectProdFeign {
    @Override
    public List<ProdEs> findProdEsByIds(List<Long> prodIds) {
        log.error("远程根据ids查询商品信息失败{}", prodIds);
        return null;
    }
}
