package cn.liu.hui.peng;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @description: logtest
 * @author: liuhp534
 * @create: 2019-09-22 20:45
 */
public class LogTest {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(LogTest.class);
        logger.info("Hello World");
    }
}
