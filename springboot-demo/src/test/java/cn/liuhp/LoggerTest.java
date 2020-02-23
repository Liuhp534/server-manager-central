package cn.liuhp;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @description:
 * @author: liuhp534
 * @create: 2020-02-23 17:27
 */
public class LoggerTest extends BaseJunit {


    private Logger logger = LoggerFactory.getLogger(LoggerTest.class);


    @Test
    public void testLogger() {
        logger.trace("我是trace");
        logger.debug("我是debug");
        logger.info("我是info");
        logger.error("我是error");
    }


}
