package cn.liuhp.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/*
* 需要junit和spring-test包
* */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TrackCounterConfig.class})
public class TrackCounterConfigTest {

    @Autowired
    private BlackDisc blackDisc;

    @Autowired
    private BlackDiscAspect blackDiscAspect;

    /*
    * 测试bean的生成
    * TrackCounterConfig 没有这个注解@EnableAspectJAutoProxy
    *  结果：播放第 1 首歌
        正在准备播放 1
    * */
    @Test
    public void testBean() {
        blackDisc.playSong(1);
        blackDiscAspect.count(1);//aspect切面其实也是一个bean

    }
    /*
     * 测试aop的切面
     * TrackCounterConfig 没有这个注解@EnableAspectJAutoProxy
     * 结果：正在准备播放 1
        播放第 1 首歌
        正在准备播放 1
     * */
    @Test
    public void testAspect() {
        blackDisc.playSong(1);
        blackDiscAspect.count(1);//aspect切面其实也是一个bean
    }

}