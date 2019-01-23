package com.wzy.sell.VO;

import lombok.Data;

import java.util.List;

/**
 * @program: sell
 * @description: ${description}
 * @author: WangZiYu
 * @create: 2019-01-12 21:22
 **/
@Data
public class ResultVO<T> {

    /** 错误码 */
    private Integer code;

    /** 提示信息*/
    private String msg;

    /** 具体内容 */
    private T data;
}
