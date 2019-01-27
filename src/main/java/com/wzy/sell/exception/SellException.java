package com.wzy.sell.exception;

import com.wzy.sell.enums.ResultEnum;

/**
 * @program: sell
 * @description: ${description}
 * @author: WangZiYu
 * @create: 2019-01-27 16:40
 **/
public class SellException extends RuntimeException {
    private Integer code;

    public SellException(ResultEnum resultEunm) {
        super(resultEunm.getMessage());

        this.code = resultEunm.getCode();
    }


}
