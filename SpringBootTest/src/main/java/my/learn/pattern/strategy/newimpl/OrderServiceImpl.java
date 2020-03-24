package my.learn.pattern.strategy.newimpl;

import my.learn.pattern.strategy.IOrderService;
import my.learn.pattern.strategy.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("newServiceImpl")
public class OrderServiceImpl implements IOrderService {
    @Autowired(required = false)
    OrderContext orderContext;

    @Override
    public String handle(Order order) {
        OrderAbstractImpl orderAbstract = orderContext.getInstance(order.getType());
        if (orderAbstract == null) {
            return "未知订单";
        }
        return orderAbstract.handle(order);
    }
}
