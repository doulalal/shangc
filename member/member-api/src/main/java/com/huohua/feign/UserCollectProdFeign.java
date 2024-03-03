package com.huohua.feign;

import com.huohua.es.ProdEs;
import com.huohua.feign.hystrix.UserCollectProdFeignHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "search-service", fallback = UserCollectProdFeignHystrix.class)
public interface UserCollectProdFeign {

    //根据ids查询商品信息
    @PostMapping("/findProdEsByIds")
    List<ProdEs> findProdEsByIds(@RequestBody List<Long> prodIds);
}
