package my.learn.pattern.strategy.newimpl;

import java.util.Map;

public class OrderContext {
    private Map<String, Class> handlerMap;

    public OrderContext(Map<String, Class> handlerMap) {
        this.handlerMap = handlerMap;
    }

    public OrderAbstractImpl getInstance(String type) {
        Class clazz = handlerMap.get(type);
        if (clazz == null) {
            return null;
        }
        try {
            return (OrderAbstractImpl) clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
