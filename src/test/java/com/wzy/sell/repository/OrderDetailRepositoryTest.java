package com.wzy.sell.repository;

import com.wzy.sell.dataobject.OrderDetail;
import org.hibernate.criterion.Order;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @program: sell
 * @description: ${description}
 * @author: WangZiYu
 * @create: 2019-01-24 21:33
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    private final String OPENID = "12345";

    @Test
    public void saveTest() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("123");
        orderDetail.setOrderId(OPENID);
        orderDetail.setProductIcon("http://xxxxx.jpg");
        orderDetail.setProductQuantity(2);
        orderDetail.setProductName("皮蛋粥");
        orderDetail.setProductPrice(new BigDecimal(1.2));
        orderDetail.setProductId("111111111");

        OrderDetail result = repository.save(orderDetail);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByOrOrderId() {
        List<OrderDetail> result =  repository.findByOrOrderId(OPENID);
        Assert.assertNotEquals(0, result.size());
    }
}