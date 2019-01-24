package com.wzy.sell.service.impl;

import com.wzy.sell.dataobject.OrderDetail;
import com.wzy.sell.dataobject.ProductInfo;
import com.wzy.sell.dto.OrderDTO;
import com.wzy.sell.service.OrderService;
import com.wzy.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @program: sell
 * @description: ${description}
 * @author: WangZiYu
 * @create: 2019-01-24 22:14
 **/
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductService productService;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        // 1. 查询商品 (数量, 价格)
        for (OrderDetail orderDetail: orderDTO.getOrderDetailList()) {
            ProductInfo productInfo = productService.findOne(orderDetail.getProductId());
            if (productInfo == null) {
                // TODO 新建异常并抛出
            }
        }

        // 2. 计算总价

        // 3. 写入订单数据库(orderMaster和orderDetail)

        // 4. 扣库存
        return null;
    }

    @Override
    public OrderDTO findOne(String orderId) {
        return null;
    }

    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public Page<OrderDTO> findList(String buyerOpenid, Pageable pageable) {
        return null;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO paid(OrderDTO orderDTO) {
        return null;
    }
}
