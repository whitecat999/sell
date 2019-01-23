package com.wzy.sell.enums;

import lombok.Getter;

/**
 * @program: sell
 * @description: ${description}
 * @author: WangZiYu
 * @create: 2019-01-23 20:58
 **/
@Getter
public enum OrderStatusEnum {
    NEW(0, "新订单"),
    FINSHED(1, "完结"),
    CANCEL(2, "已取消"),
    ;
    private Integer code;
    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
