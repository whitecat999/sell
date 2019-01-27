package com.wzy.sell.utils;

import java.util.Random;

/**
 * @program: sell
 * @description: ${description}
 * @author: WangZiYu
 * @create: 2019-01-27 17:03
 **/
public class KeyUtil {

    public static synchronized String getUniqueKey() {
        Random random = new Random();
        Integer number = random.nextInt(9000000) + 1000000;
        return System.currentTimeMillis() + String.valueOf(number);
    }

}
