package cn.liuhp.base.condition;


import cn.liuhp.core.service.impl.ServiceAImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/*
* 自定义condition
* */
public class ServiceBCondition implements Condition {

    private static final Logger logger = LoggerFactory.getLogger(ServiceBCondition.class);
    /*
    *
    * 当classpath中有ServiceCImpl.class时返回true
    * */
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        try {
            if (null != conditionContext.getClassLoader().loadClass("cn.liuhp.core.service.impl.ServiceAImpl")) {
                return true;
            }
        } catch (ClassNotFoundException e) {
            logger.error("ServiceBCondition 加载class异常");
        }

        return false;
    }
}
