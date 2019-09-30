package cn.eventbus.observer;

import cn.eventbus.event.BaseEvent;
import com.google.common.eventbus.Subscribe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ReflectionUtils;

/*
* 抽象观察者，泛型的使用
* */
public abstract class BaseEventObserver<E extends BaseEvent> {

    private static final Logger logger = LoggerFactory.getLogger(BaseEventObserver.class);

    /*
    * 如果这里的BaseEvent是class会报错，但是接口就不会了。需要研究下？？？
    * */
    @Subscribe
    public void execute(BaseEvent event) {
        logger.info("执行之前。。。");
        if (ReflectionUtils.findMethod(this.getClass(), "handler", event.getClass()) != null) {
            this.handler((E)event);
        }

    }
    /*
     * 模板方法
     * */
    public abstract void handler(E event);

}
