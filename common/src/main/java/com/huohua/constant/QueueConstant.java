package com.huohua.constant;

/**
 * 队列的常量
 */
public interface QueueConstant {

    /**
     * 修改库存的队列
     */
    String PROD_CHANGE_QUEUE = "prod.change.queue";

    /**
     * 修改库存的交换机
     */
    String PROD_CHANGE_EX = "prod.change.ex";

    /**
     * 修改库存的路由key
     */
    String PROD_CHANGE_KEY = "prod.change.key";


    /**
     * 发送短信的队列
     */
    String PHONE_SEND_QUEUE = "phone.send.queue";

    /**
     * 发送短信的交换机
     */
    String PHONE_SEND_EX = "phone.send.ex";

    /**
     * 发送短信的路由key
     */
    String PHONE_SEND_KEY = "phone.send.key";


    /**
     * 发送微信公众号的队列
     */
    String WECHAT_SEND_QUEUE = "wechat.send.queue";

    /**
     * 发送微信公众号的交换机
     */
    String WECHAT_SEND_EX = "wechat.send.ex";

    /**
     * 发送微信公众号的路由key
     */
    String WECHAT_SEND_KEY = "wechat.send.key";


    /**
     * 延迟队列
     */
    String ORDER_MS_QUEUE = "order.ms.queue";

    /**
     * 死信交换机
     */
    String ORDER_DEAD_EX = "order.dead.ex";

    /**
     * 死信路由key
     */
    String ORDER_DEAD_KEY = "order.dead.key";

    /**
     * 死信队列
     */
    String ORDER_DEAD_QUEUE = "order.dead.queue";


}
