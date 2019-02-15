package com.wzy.sell.service;

import com.wzy.sell.dto.OrderDTO;

/**
 * @program: sell
 * @description: ${description}
 * @author: WangZiYu
 * @create: 2019-02-15 21:45
 **/
public interface BuyerService {
    // 查询一个订单
    OrderDTO findOrderOne(String openid, String orderId);

    // 取消订单
    OrderDTO cancelOrder(String openid, String orderId);
}
