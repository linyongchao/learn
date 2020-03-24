package my.learn.pattern.strategy.newimpl;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class OrderProcessor implements BeanFactoryPostProcessor {

    String path = "classpath*:my/learn/pattern/strategy/newimpl/**";

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        Map<String, Class> handlerMap = new HashMap<>();
        try {
            ClassScan classScan = (ClassScan) configurableListableBeanFactory.getBean("classScan");
            classScan.getClassByAnnotation(path, OrderType.class).forEach(c -> {
                String type = ((OrderType) c.getAnnotation(OrderType.class)).value();
                handlerMap.put(type, c);
            });
            OrderContext context = new OrderContext(handlerMap);
            configurableListableBeanFactory.registerSingleton(OrderContext.class.getName(), context);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
