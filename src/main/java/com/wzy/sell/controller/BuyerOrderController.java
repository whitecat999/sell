package com.wzy.sell.controller;

import com.wzy.sell.VO.ResultVO;
import com.wzy.sell.converter.OrderForm2OrderDTOConverter;
import com.wzy.sell.dto.OrderDTO;
import com.wzy.sell.enums.ResultEnum;
import com.wzy.sell.exception.SellException;
import com.wzy.sell.form.OrderForm;
import com.wzy.sell.service.OrderService;
import com.wzy.sell.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: sell
 * @description: ${description}
 * @author: WangZiYu
 * @create: 2019-02-13 20:23
 **/
@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {

    @Autowired
    private OrderService orderService;

    // 创建订单
    @PostMapping("/create")
    public ResultVO<Map<String, String>> create(@Valid OrderForm orderForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【创建订单】 参数不正确, orderForm={}", orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO = OrderForm2OrderDTOConverter
                .convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("【创建订单】 购物车不能为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }
        OrderDTO createResult = orderService.create(orderDTO);
        Map<String, String> map = new HashMap<>();
        map.put("orderId", createResult.getOrderId());
        return ResultVOUtil.success(map);
    }
    // 订单列表

    // 订单详细

    // 取消订单
}
