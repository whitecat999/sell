package com.wzy.sell.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wzy.sell.dataobject.OrderDetail;
import com.wzy.sell.enums.OrderStatusEnum;
import com.wzy.sell.enums.PayStatusEnum;
import com.wzy.sell.serializer.Date2LongSerilaizer;
import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @program: sell
 * @description: ${description}
 * @author: WangZiYu
 * @create: 2019-01-24 22:08
 **/
@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {
    /** 订单 */
    private String orderId;

    /** 买家姓名 */
    private String buyerName;

    /** 订单 */
    private String buyerPhone;

    /** 买家地址 */
    private String buyerAddress;

    /** 买家微信Openid */
    private String buyerOpenid;

    /** 订单总金额 */
    private BigDecimal orderAmount;

    /** 订单状态, 默认为0新下订单 */
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    /** 支付状态, 默认为0未支付 */
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    /** 创建时间 */
    @JsonSerialize(using = Date2LongSerilaizer.class)
    private Date createTime;

    /** 更新时间 */
    @JsonSerialize(using = Date2LongSerilaizer.class)
    private Date updateTime;

    /** 订单详细 */
    List<OrderDetail> orderDetailList;
}
