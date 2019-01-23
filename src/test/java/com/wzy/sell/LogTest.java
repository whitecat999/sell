package com.wzy.sell;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @program: sell
 * @description: ${description}
 * @author: WangZiYu
 * @create: 2019-01-10 19:16
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
 // @Data
public class LogTest {

    @Test
    public void test1() {
        log.info("info..........");
        log.debug("debug..........");
        log.error("error..........");
    }
}
