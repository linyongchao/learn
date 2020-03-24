package my.learn.pattern.strategy.newimpl;

import my.learn.pattern.strategy.Order;
import org.springframework.stereotype.Service;

@Service
@OrderType("2")
public class OrderServiceImplType2 extends OrderAbstractImpl {
    @Override
    public String handle(Order order) {
        return "团购订单";
    }
}
