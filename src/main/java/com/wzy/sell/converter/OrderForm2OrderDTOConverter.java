package com.wzy.sell.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wzy.sell.dataobject.OrderDetail;
import com.wzy.sell.dto.OrderDTO;
import com.wzy.sell.enums.ResultEnum;
import com.wzy.sell.exception.SellException;
import com.wzy.sell.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: sell
 * @description: 验证参数对象转换orderDTO
 * @author: WangZiYu
 * @create: 2019-02-13 20:46
 **/
@Slf4j
public class OrderForm2OrderDTOConverter {

    public static OrderDTO convert(OrderForm orderForm) {
        Gson gson = new Gson();
        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            orderDetailList = gson.fromJson(orderForm.getItems(), new TypeToken<List<OrderDetail>>(){}.getType());
        } catch (Exception e) {
            log.error("【对象装换】 错误, string={}", orderForm.getItems());
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;

    }
}
