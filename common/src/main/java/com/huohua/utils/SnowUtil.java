package com.huohua.utils;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;

//雪花算法
public class SnowUtil {

    public static Snowflake snowflake = IdUtil.createSnowflake(1, 1);


}
