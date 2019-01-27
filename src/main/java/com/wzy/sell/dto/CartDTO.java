package com.wzy.sell.dto;

import lombok.Data;

/**
 * @program: sell
 * @description: ${description}
 * @author: WangZiYu
 * @create: 2019-01-27 18:21
 **/
@Data
public class CartDTO {
    /** 商品id */
    private String productId;
    /** 数量 */
    private  Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
