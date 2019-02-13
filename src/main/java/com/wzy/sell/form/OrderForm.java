package com.wzy.sell.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @program: sell
 * @description: ${description}
 * @author: WangZiYu
 * @create: 2019-02-13 20:25
 **/
@Data
public class OrderForm {

    /**
     * 买家姓名
     */
    @NotEmpty(message = "姓名必填")
    private String name;

    /**
     * 买家手机号
     */
    @NotEmpty(message = "手机号必填")
    private String phone;

    /**
     * 买家地址
     */
    @NotEmpty(message = "地址和必填")
    private String address;

    /**
     * 买家微信openid
     */
    @NotEmpty(message = "openid必填")
    private String openid;

    /**
     * 购物车商品信息
     */
    @NotEmpty(message = "购物车不能为空")
    private String items;
}
