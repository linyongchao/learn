package my.learn.pattern.strategy.newimpl;

import my.learn.pattern.strategy.Order;
import org.springframework.stereotype.Service;

@Service
@OrderType("3")
public class OrderServiceImplType3 extends OrderAbstractImpl {
    @Override
    public String handle(Order order) {
        return "促销订单";
    }
}
